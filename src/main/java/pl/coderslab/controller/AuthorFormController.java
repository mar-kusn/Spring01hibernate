package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;

import java.util.List;

@Controller
@RequestMapping("/authorform")
public class AuthorFormController {

    private BookDao bookDao;
    private AuthorDao authorDao;

    public AuthorFormController(BookDao bookDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.authorDao = authorDao;
    }

    @GetMapping("/list")
    public String list() {
        return "author/list";
    }

    @GetMapping("/add")
    public String add(Model m) {
        m.addAttribute("author", new Author());

        return "author/author-add-form";
    }

    @PostMapping("/add")
    public String add(Author author, BindingResult result) {

        if (result.hasErrors()) {
            return "author/author-add-form";
        }
        this.authorDao.create(author);

        return "redirect:list";
    }

    @GetMapping("/edit/{authorId}")
    public String edit(@PathVariable String authorId, Model m) {
        Author author = authorDao.findByIdWithBooks(Long.parseLong(authorId));
        m.addAttribute("author", author);

        return "author/author-edit-form";
    }

    @PostMapping("/edit/{authorId}")
    public String edit(Author author, BindingResult result) {

        if (result.hasErrors()) {
            return "author/author-edit-form";
        }
        this.authorDao.update(author);

        return "redirect:/authorform/list";
    }

    @GetMapping("/delete/{authorId}")
    public String delete(@PathVariable String authorId, Model m) {
        Author author = authorDao.findByIdWithBooks(Long.parseLong(authorId));
        m.addAttribute("author", author);

        return "author/author-delete-form";
    }

    @PostMapping("/delete/{authorId}")
    public String deletePost(@PathVariable String authorId, @RequestParam String deleteBtn) {

        if (deleteBtn.equals("yes")) {
            Author author = authorDao.findByIdWithBooks(Long.parseLong(authorId));
            this.authorDao.delete(author);
        }

        return "redirect:/authorform/list";
    }

    @ModelAttribute("books")
    public List<Book> books() {
        return this.bookDao.findAll();
    }
    @ModelAttribute("authors")
    public List<Author> authors() {
        return this.authorDao.findAll();
    }
}
