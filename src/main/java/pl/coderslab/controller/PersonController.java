package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.PersonDao;
import pl.coderslab.dao.PersonDetailsDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Person;
import pl.coderslab.entity.PersonDetails;

@Controller
public class PersonController {
    private final PersonDao personDao;
    private final PersonDetailsDao personDetailsDao;

    public PersonController(PersonDao personDao, PersonDetailsDao personDetailsDao) {
        this.personDao = personDao;
        this.personDetailsDao = personDetailsDao;
    }

    @GetMapping("/person/add/{login}/{password}/{email}/{firstName}/{lastName}/{city}/{street}/{streetNumber}")
    @ResponseBody
    public String addPersonWithDetails(@PathVariable String login, @PathVariable String password,
                            @PathVariable String email, @PathVariable String firstName,
                            @PathVariable String lastName, @PathVariable String city,
                            @PathVariable String street, @PathVariable int streetNumber) {

        Person person = new Person();
        PersonDetails personDetails = new PersonDetails();
        person.setLogin(login);
        person.setPassword(password);
        person.setEmail(email);
        personDetails.setFirstName(firstName);
        personDetails.setLastName(lastName);
        personDetails.setCity(city);
        personDetails.setStreet(street);
        personDetails.setStreetNumber(streetNumber);
        person.setPersonDetails(personDetails);
        personDetails.setPerson(person);
        personDetailsDao.create(personDetails);
        //personDao.create(person);

//        return "Created: " + person.getId() + ", Full Name: '" + person.getPersonDetails().getFullName() + "'" +
//                "Full Address: '" + person.getPersonDetails().getFullAddress() + "'";
        return "Created: " + person.toString() + person.getPersonDetails().toString();
    }

    @GetMapping("/person/update/{id}/{email}/{firstName}/{lastName}/{city}/{street}/{streetNumber}")
    @ResponseBody
    public String updatePerson(@PathVariable Long id,
                               @PathVariable String email, @PathVariable String firstName,
                               @PathVariable String lastName, @PathVariable String city,
                               @PathVariable String street, @PathVariable int streetNumber) {
        Person person = this.personDao.readById(id);
        PersonDetails personDetails = person.getPersonDetails();
        person.setEmail(email);
        personDetails.setFirstName(firstName);
        personDetails.setLastName(lastName);
        personDetails.setCity(city);
        personDetails.setStreet(street);
        personDetails.setStreetNumber(streetNumber);
        person.setPersonDetails(personDetails);
        personDetailsDao.update(personDetails);
        personDao.update(person);

        return "Updated: " + person.toString() + " " + personDetails.toString();
    }

    @GetMapping("/person/get/{id}")
    @ResponseBody
    public String getPerson(@PathVariable Long id) {
        Person person = personDao.readById(id);

        return person.toString() + person.getPersonDetails().toString();
    }

    @GetMapping("/person/delete/{id}")
    @ResponseBody
    public String deletePerson(@PathVariable Long id) {
        Person person = personDao.readById(id);
        //personDao.delete(person);
        personDetailsDao.delete(person.getPersonDetails());

        return "Deleted: " + person.getId() + ", login: '" + person.getLogin() + "'";
    }
}
