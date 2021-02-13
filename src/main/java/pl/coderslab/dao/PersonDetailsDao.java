package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Person;
import pl.coderslab.entity.PersonDetails;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class PersonDetailsDao {

    @PersistenceContext
    private EntityManager entityManager;

    //    zapis encji
    public void create(PersonDetails personDetails) {
        this.entityManager.persist(personDetails);
    }

    //    edycja encji
    public void update(PersonDetails personDetails) {
        this.entityManager.merge(personDetails);
    }

    //    pobieranie po id
    public PersonDetails readById(long id) {
        return this.entityManager.find(PersonDetails.class, id);
    }

    //    usuwanie po id
    public void delete(PersonDetails personDetails) {
        this.entityManager.remove(entityManager.contains(personDetails) ?
                personDetails : entityManager.merge(personDetails));
    }

}
