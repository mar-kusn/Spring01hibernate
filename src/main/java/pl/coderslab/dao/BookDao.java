package pl.coderslab.dao;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    //    zapis encji
    public void create(Book book) {
        entityManager.persist(book);
    }

    //    pobieranie po id
    public Book findById(Long id) {
        return entityManager.find(Book.class, id);
    }

    //    edycja encji
    public void update(Book book) {
        entityManager.merge(book);
    }

    //    usuwanie
    public void delete(Book book) {
        entityManager.remove(entityManager.contains(book) ?
                book : entityManager.merge(book));
    }

    //    usuwanie po id
    public void deleteById(Long id) {
        Book book = findById(id);
        entityManager.remove(entityManager.contains(book) ?
                book : entityManager.merge(book));
    }

    // Dzień 2
    public List<Book> findAll() {
        final Query query = this.entityManager.createQuery("SELECT b FROM Book b");
        final List<Book> books = query.getResultList();

        return books;
    }

    public List<Book> findByRatingGTE(int rating) {
        final Query query = this.entityManager.createQuery("SELECT b FROM Book b WHERE b.rating >= :toCompare");
        query.setParameter("toCompare", rating);
        final List<Book> books = query.getResultList();

        return books;
    }

    // książki które mają jakiegokwiek wydawcę
    public List<Book> findBookWithAnyPublisher() {
        final Query query = this.entityManager.createQuery("SELECT b FROM Book b JOIN b.publisher");
        final List<Book> books = query.getResultList();

        return books;
    }

    public List<Book> findBookWithPublisher(Publisher pub) {
        final Query query = this.entityManager.createQuery("SELECT b FROM Book b WHERE b.publisher = :publisher");
        query.setParameter("publisher", pub);
        final List<Book> books = query.getResultList();

        return books;
    }

    public List<Book> findBookWithPublisherName(String publisherName) {
        final Query query = this.entityManager.createQuery("SELECT b FROM Book b WHERE b.publisher.name = :pubName");
        query.setParameter("pubName", publisherName);
        final List<Book> books = query.getResultList();

        return books;
    }

    public List<Book> findBookWithAuthor(Author auth) {
        final Query query = this.entityManager.createQuery("SELECT b FROM Book b WHERE :author MEMBER OF b.authors");
        query.setParameter("author", auth);
        final List<Book> books = query.getResultList();

        return books;
    }

    //    pobieranie po id z autorami
    public Book findByIdWithAuthors(long id) {
        Book book = this.entityManager.find(Book.class, id);
        Hibernate.initialize(book.getAuthors());

        return book;
    }
}
