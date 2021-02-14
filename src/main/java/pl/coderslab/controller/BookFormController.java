package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import java.util.List;

@Controller
@RequestMapping("/bookform")
public class BookFormController {

    private BookDao bookDao;
    private PublisherDao publisherDao;
    private AuthorDao authorDao;

    public BookFormController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
    }

    @GetMapping("/list")
    public String list() {
        return "book/list";
    }

    @GetMapping("/add")
    public String add(Model m) {
        m.addAttribute("book", new Book());

        return "book/book-add-form";
    }

    @PostMapping("/add")
    public String add( Book book, BindingResult result) {

        if (result.hasErrors()) {
            return "book/book-add-form";
        }
        this.bookDao.create(book);

        return "redirect:list";
    }

    @GetMapping("/edit/{bookId}")
    public String edit(@PathVariable String bookId, Model m) {
        Book book = bookDao.findByIdWithAuthors(Long.parseLong(bookId));
        m.addAttribute("book", book);

        return "book/book-edit-form";
    }

    @PostMapping("/edit/{bookId}")
    public String edit( Book book, BindingResult result) {

        if (result.hasErrors()) {
            return "book/book-edit-form";
        }
        this.bookDao.update(book);

        return "redirect:/bookform/list";
    }

    @GetMapping("/delete/{bookId}")
    public String delete(@PathVariable String bookId,  Model m) {
        Book book = bookDao.findByIdWithAuthors(Long.parseLong(bookId));
        m.addAttribute("book", book);

        return "book/book-delete-form";
    }

    @PostMapping("/delete/{bookId}")
    public String deletePost(@PathVariable String bookId, @RequestParam String deleteBtn) {

        if (deleteBtn.equals("yes")) {
            Book book = bookDao.findByIdWithAuthors(Long.parseLong(bookId));
            this.bookDao.delete(book);
        }

        return "redirect:/bookform/list";
    }



    @ModelAttribute("publishers")
    public List<Publisher> publishers() {
        return this.publisherDao.findAll();
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