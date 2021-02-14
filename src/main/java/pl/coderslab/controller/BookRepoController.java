package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;
import pl.coderslab.repository.BookRepository;
import pl.coderslab.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/bookrepo")
public class BookRepoController {

    private BookRepository bookRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public BookRepoController(BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }

    // dzień 3
    @GetMapping("/listbytitle/{title}")
    public String getBooksByTitle(@PathVariable String title,
                                  Model model) {
        List<Book> books = this.bookRepository.readByTitle(title);
        model.addAttribute("books", books);

        return "book/list";
    }

    @GetMapping("/listbytitlecontaining/{title}")
    public String getBooksByTitleContaining(@PathVariable String title,
                                            Model model) {
        List<Book> books = this.bookRepository.readByTitleContainingIgnoreCase(title);
        model.addAttribute("books", books);

        return "book/list";
    }

    @GetMapping("/listbycategoryid/{categoryId}")
    public String getBooksByCategoryId(@PathVariable long categoryId,
                                       Model model) {
        List<Book> books = this.bookRepository.readByCategoryId(categoryId);
        model.addAttribute("books", books);

        return "book/list";
    }

    @GetMapping("/listbycategory/{title}")
    public String getBooksByCategory(@PathVariable long categoryId,
                                     Model model) {
        Category category = this.categoryRepository.getOne(categoryId);
        List<Book> books = this.bookRepository.readByCategory(category);
        model.addAttribute("books", books);

        return "book/list";
    }

    @GetMapping("/listbycategoryids/{categoryId}")
    public String getBooksByCategoryIds(@PathVariable long[] categoryId,
                                        Model model) {
        List<Category> categories = new ArrayList<>();

        for (long id : categoryId) {
            categories.add(this.categoryRepository.getOne(id));
        }


        List<Book> books = this.bookRepository.readByCategoryIn(categories);
        model.addAttribute("books", books);

        return "book/list";
    }

    @GetMapping("/listbycategoryname/{name}")
    public String getBooksByCategoryByName(@PathVariable String name,
                                           Model model) {

        List<Book> books = this.bookRepository.readByCategoryName(name);
        model.addAttribute("books", books);

        return "book/list";
    }

}
