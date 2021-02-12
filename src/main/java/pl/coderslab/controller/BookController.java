package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

@Controller
public class BookController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;

    // Wstrzykujemy Dao.
    public BookController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
    }

    //    zapis encji
    @GetMapping("/book/add/{title}/{rating}/{description}")
    @ResponseBody
    public String addBook(@PathVariable String title,
                          @PathVariable int rating,
                          @PathVariable String description,
                          @RequestParam long publisherId) {

        Publisher publisher = this.publisherDao.findById(publisherId);
        // Tworzymy obiekt i wypełniamy jego właściwości.
        Book book = new Book();
        book.setTitle(title);
        book.setRating(rating);
        book.setDescription(description);
        book.setPublisher(publisher);

        // Wywołujemy zdefiniowaną przez nas metodę saveBook
        bookDao.create(book);

        return "Created: " + book.getId() + ", Title: '" + book.getTitle() + "', Rating: '" +
                book.getRating() + "', Description: '" + book.getDescription() + "', Publisher: " + book.getPublisher() + "'";
    }

    @GetMapping("/book/addwa/{title}/{rating}/{description}")
    @ResponseBody
    public String addBookWithAuthor(@PathVariable String title,
                                    @PathVariable int rating,
                                    @PathVariable String description,
                                    @RequestParam long publisherId) {
        Publisher publisher = this.publisherDao.findById(publisherId);
        Author author1 = this.authorDao.findById(1L);
        Author author2 = this.authorDao.findById(2L);

        Book book = new Book();
        book.setTitle(title);
        book.setRating(rating);
        book.setDescription(description);
        book.setPublisher(publisher);
        book.getAuthors().add(author1);
        book.getAuthors().add(author2);

        this.bookDao.create(book);

        return "Created: " + book.getId() + ", Title: '" + book.getTitle() + "', Rating: '" +
                book.getRating() + "', Description: '" + book.getDescription()+"', Publisher: " + book.getPublisher() + "' " +
                "Authors: " + book.getAuthors().toString() +"'";
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
