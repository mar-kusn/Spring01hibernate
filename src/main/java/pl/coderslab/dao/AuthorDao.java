package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class AuthorDao {

    @PersistenceContext
    private EntityManager entityManager;

    // zapis
    public void create(Author author) {
        entityManager.persist(author);
    }

    //    pobieranie po id
    public Author findById(Long id) {
        return entityManager.find(Author.class, id);
    }

    //    edycja encji
    public void update(Author author) {
        entityManager.merge(author);
    }

    //    usuwanie
    public void delete(Author author) {
        entityManager.remove(entityManager.contains(author) ?
                author : entityManager.merge(author));
    }

    //    usuwanie po id
    public void deleteById(Long id) {
        Author author = findById(id);
        delete(author);
    }
}
