package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/publisherform")
public class PublisherFormController {

    private PublisherDao publisherDao;
    private BookDao bookDao;

    public PublisherFormController(PublisherDao publisherDao, BookDao bookDao) {
        this.publisherDao = publisherDao;
        this.bookDao = bookDao;
    }

    @GetMapping("/list")
    public String list() {

        return "publisher/list";
    }

    @GetMapping("/add")
    public String add(Model m) {
        m.addAttribute("publisher", new Publisher());

        return "publisher/publisher-add-form";
    }

    @PostMapping("/add")
    public String add(@Valid Publisher publisher, BindingResult result) {

        if (result.hasErrors()) {
            return "publisher/publisher-add-form";
        }
        this.publisherDao.create(publisher);

        return "redirect:list";
    }

    @GetMapping("/edit/{pubId}")
    public String edit(@PathVariable String pubId, Model m) {
        Publisher publisher = publisherDao.findByIdWithBooks(Long.parseLong(pubId));
        m.addAttribute("publisher", publisher);

        return "publisher/publisher-edit-form";
    }

    @PostMapping("/edit/{apubId}")
    public String edit(@Valid Publisher publisher, BindingResult result) {

        if (result.hasErrors()) {
            return "publisher/publisher-edit-form";
        }
        this.publisherDao.update(publisher);

        return "redirect:/publisherform/list";
    }

    @GetMapping("/delete/{pubId}")
    public String delete(@PathVariable String pubId, Model m) {
        Publisher publisher = publisherDao.findById(Long.parseLong(pubId));
        m.addAttribute("publisher", publisher);

        return "publisher/publisher-delete-form";
    }

    @PostMapping("/delete/{pubId}")
    public String deletePost(@PathVariable String pubId, @RequestParam String deleteBtn) {

        if (deleteBtn.equals("yes")) {
            Publisher publisher = publisherDao.findById(Long.parseLong(pubId));
            this.publisherDao.delete(publisher);
        }

        return "redirect:/publisherform/list";
    }

    @ModelAttribute("books")
    public List<Book> books() {
        return this.bookDao.findAll();
    }

    @ModelAttribute("publishers")
    public List<Publisher> publishers() {
        return this.publisherDao.findAll();
    }
}
