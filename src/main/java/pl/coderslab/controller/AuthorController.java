package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.entity.Author;

import java.util.List;

@Controller
public class AuthorController {
    private final AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @GetMapping("/author/add/{firstName}/{lastName}")
    @ResponseBody
    public String addAuthor(@PathVariable String firstName,
                            @PathVariable String lastName) {

        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        authorDao.create(author);

        return "Created: " + author.getId() + ", Full Name: '" + author.getFullName() + "'";
    }

    @GetMapping("/author/update/{id}/{firstName}/{lastName}")
    @ResponseBody
    public String updateAuthor(@PathVariable Long id,
                               @PathVariable String firstName,
                               @PathVariable String lastName) {
        Author author = this.authorDao.findById(id);
        author.setFirstName(firstName);
        author.setLastName(lastName);
        authorDao.update(author);

        return "Updated: " + author.toString();
    }

    @GetMapping("/author/get/{id}")
    @ResponseBody
    public String getAuthor(@PathVariable Long id) {
        Author author = authorDao.findById(id);

        return author.toString();
    }

    @GetMapping("/author/delete/{id}")
    @ResponseBody
    public String deleteAuthor(@PathVariable Long id) {
        Author author = authorDao.findById(id);
        authorDao.deleteById(id);

        return "Deleted: " + author.getId() + ", Full Name: '" + author.getFullName() + "'";
    }

    // dzień 2
    @GetMapping("/author/list")
    public String getAuthors(Model model) {
        List<Author> authors = this.authorDao.findAll();
        model.addAttribute("authors", authors);

        return "author/list";
    }
}
