package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    //    metodę wyszukującą książki dla zadanego tytułu
    List<Book> readByTitle(String title);
    List<Book> readByTitleContainingIgnoreCase(String title);

    //    metodę wyszukującą książki dla zadanej kategorii
    List<Book> readByCategory(Category category);
    List<Book> readByCategoryIn(List<Category> categories);

    //    metodę wyszukującą książki dla zadanego id kategorii
    List<Book> readByCategoryId(Long id);
    List<Book> readByCategoryName(String name);
}
