package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Author;
import pl.coderslab.repository.AuthorRepository;

import java.util.List;


@Controller
@RequestMapping("/authorrepo")
public class AuthorRepoController {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorRepoController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/readbycustomemailstartby/{email}")
    public String getAuthorByCustomEmailStartBy(@PathVariable String email, Model model) {
        List<Author> authors = this.authorRepository.readByCustomEmailStartBy(email);
        model.addAttribute("authors", authors);

        return "author/list";
    }

    @GetMapping("/readbycustompeselstartby/{pesel}")
    public String getAuthorByCustomPeselStartBy(@PathVariable String pesel, Model model) {
        List<Author> authors = this.authorRepository.readByCustomPeselStartBy(pesel);
        model.addAttribute("authors", authors);

        return "author/list";
    }
}
