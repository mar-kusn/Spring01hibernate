package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Book;

import java.util.List;

@Controller
public class BookController {

    private final BookDao bookDao;

    // Wstrzykujemy Dao.
    public BookController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    //    zapis encji
    @GetMapping("/book/add/{title}/{rating}/{description}")
    @ResponseBody
    public String addBook(@PathVariable String title,
                          @PathVariable int rating,
                          @PathVariable String description) {

        // Tworzymy obiekt i wypełniamy jego właściwości.
        Book book = new Book();
        book.setTitle(title);
        book.setRating(rating);
        book.setDescription(description);

        // Wywołujemy zdefiniowaną przez nas metodę saveBook
        bookDao.create(book);

        return "Created: " + book.getId() + ", Title: '" + book.getTitle() + "', Rating: '" +
                book.getRating() + "', Description: '" + book.getDescription() + "', Publisher: ";
    }

    //    edycja encji
    @GetMapping("/book/update/{id}/{rating}")
    @ResponseBody
    public String updateBook(@PathVariable Long id,
                             @PathVariable int rating) {
        Book book = bookDao.findById(id);
        book.setRating(rating);

        bookDao.update(book);

        return "Updated: " + book.toString();
    }

    //    pobieranie
    @GetMapping("/book/get/{id}")
    @ResponseBody
    public String getBook(@PathVariable Long id) {
        Book book = bookDao.findById(id);

        return book.toString();
    }

    //    usuwanie
    @GetMapping("/book/delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable Long id) {
        Book book = bookDao.findById(id);
        bookDao.deleteById(id);

        return "Deleted: " + book.getId() + ", Title: '" + book.getTitle() + "', Rating: '" +
                book.getRating() + "', Description: '" + book.getDescription() + "'";
    }

}
