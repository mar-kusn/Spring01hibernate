package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }

    //    edycja encji
    public void update(Book book) {
        entityManager.merge(book);
    }

    //    usuwanie po id
    public void delete(Book book) {
        entityManager.remove(entityManager.contains(book) ?
                book : entityManager.merge(book));
    }
}
