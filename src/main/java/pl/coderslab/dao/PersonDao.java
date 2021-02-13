package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class PersonDao {

    @PersistenceContext
    private EntityManager entityManager;

    //    zapis encji
    public void create(Person person) {
        this.entityManager.persist(person);
    }

    //    edycja encji
    public void update(Person person) {
        this.entityManager.merge(person);
    }

    //    pobieranie po id
    public Person readById(long id) {
        return this.entityManager.find(Person.class, id);
    }

    //    usuwanie po id
    public void delete(Person person) {
        this.entityManager.remove(entityManager.contains(person) ?
                person : entityManager.merge(person));
    }

}
