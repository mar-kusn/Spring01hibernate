package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
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

    // day 4
    //    metodę wyszukującą książki dla zadanego tytułu.
    @Query("SELECT b FROM Book b WHERE b.title=?1")
    List<Book> readCustomByTitle(String title);

    //    metodę wyszukującą książki dla zadanej kategorii
    @Query("SELECT b FROM Book b WHERE b.category=?1")
    List<Book> readCustomByCategorye(Category catToFind);

    @Modifying
    @Transactional
    @Query("DELETE FROM Book b WHERE b.title LIKE ?1%")
    int misterKillerDoYourJob(String firstLetter);

    //    Listę książek dla których rating jest pomiędzy zadanymi parametrami np. między 3 a 5.
    @Query("SELECT b FROM Book b WHERE b.rating BETWEEN 3 AND 5")
    List<Book> readCustomRating3To5();

    //    Listę książek dla zadanego wydawcy.
    @Query("SELECT b FROM Book b WHERE b.publisher IS NULL")
    List<Book> readCustomWithoutPublisher();

    //    Pierwszą książkę z zadanej kategorii, z sortowaniem po tytule.
    @Query("SELECT b FROM Book b WHERE b.category.name LIKE ?1 ORDER BY b.title")
    List<Book> readCustomByCategoryNameSortByTitle(String categoryName);

    //    Pierwszą książkę z zadanej kategorii, z sortowaniem po tytule.
    @Query(value = "SELECT * FROM books b " +
            "INNER JOIN categories c on b.category_id = c.id " +
            "WHERE c.name LIKE ?1 ORDER BY b.title LIMIT 1;", nativeQuery = true)
    List<Book> readCustomByCategoryNameSortByTitleNative(String categoryName);

}
