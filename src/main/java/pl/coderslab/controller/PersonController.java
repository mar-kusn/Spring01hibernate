package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.PersonDao;
import pl.coderslab.dao.PersonDetailsDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Person;
import pl.coderslab.entity.PersonDetails;

@Controller
@RequestMapping("/person")
public class PersonController {
    private final PersonDao personDao;
    private final PersonDetailsDao personDetailsDao;

    public PersonController(PersonDao personDao, PersonDetailsDao personDetailsDao) {
        this.personDao = personDao;
        this.personDetailsDao = personDetailsDao;
    }

    @GetMapping("/add/{login}/{password}/{email}/{firstName}/{lastName}/{city}/{street}/{streetNumber}")
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

    @GetMapping("/update/{id}/{email}/{firstName}/{lastName}/{city}/{street}/{streetNumber}")
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

    @GetMapping("/get/{id}")
    @ResponseBody
    public String getPerson(@PathVariable Long id) {
        Person person = personDao.readById(id);

        return person.toString() + person.getPersonDetails().toString();
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public String deletePerson(@PathVariable Long id) {
        Person person = personDao.readById(id);
        //personDao.delete(person);
        personDetailsDao.delete(person.getPersonDetails());

        return "Deleted: " + person.getId() + ", login: '" + person.getLogin() + "'";
    }

    // Dzień 2 - FORMULARZE
    @GetMapping("/addform")
    public String addForm() {
        return "person/addform";
    }

    @PostMapping("/addform")
    public String addFormPost(@RequestParam String login,
                              @RequestParam String password,
                              @RequestParam String email,
                              Model m) {
        Person person = new Person(login, password, email);
        this.personDao.create(person);
        m.addAttribute(person);

        return "person/details";
    }

    @GetMapping("/addformbind")
    public String addFormBind(Model m) {
        m.addAttribute("person", new Person());

        return "person/addform";
    }
    @PostMapping("/addformbind")
    public String addFormBindPost(Person person,
                                  Model m) {
        this.personDao.create(person);
        m.addAttribute("person", person);

        return "person/details";
    }
}
