package pl.coderslab.dao;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class PublisherDao {

    @PersistenceContext
    private EntityManager entityManager;

    // zapis
    public void create(Publisher publisher) {
        entityManager.persist(publisher);
    }

    //    pobieranie po id
    public Publisher findById(Long id) {
        return entityManager.find(Publisher.class, id);
    }
    //    pobieranie po id z książkami
    public Publisher findByIdWithBooks(long id) {
        Publisher publisher = this.entityManager.find(Publisher.class, id);
        Hibernate.initialize(publisher.getBooks());
        return publisher;
    }

    //    edycja encji
    public void update(Publisher publisher) {
        entityManager.merge(publisher);
    }

    //    usuwanie
    public void delete(Publisher publisher) {
        entityManager.remove(entityManager.contains(publisher) ?
                publisher : entityManager.merge(publisher));
    }

    //    usuwanie po id
    public void deleteById(Long id) {
        Publisher publisher = findById(id);
        delete(publisher);
    }

    // dzień 2
    public List<Publisher> findAll() {
        final Query query = this.entityManager.createQuery("SELECT p FROM Publisher p");
        final List<Publisher> publishers = query.getResultList();

        return publishers;
    }
}
