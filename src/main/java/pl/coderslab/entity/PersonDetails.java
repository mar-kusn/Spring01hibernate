package pl.coderslab.entity;

import javax.persistence.*;

@Entity
@Table(name = "person_details")
public class PersonDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private int streetNumber;
    private String street;
    private String city;
    @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private Person person;

    public PersonDetails() {
    }

    public PersonDetails(String firstName, String lastName, int streetNumber, String street, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetNumber = streetNumber;
        this.street = street;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public PersonDetails setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public PersonDetails setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public PersonDetails setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public PersonDetails setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public PersonDetails setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getCity() {
        return city;
    }

    public PersonDetails setCity(String city) {
        this.city = city;
        return this;
    }

    public Person getPerson() {
        return person;
    }

    public PersonDetails setPerson(Person person) {
        this.person = person;
        return this;
    }

    public String getFullName() {
        return this.getFirstName() + " " + this.getLastName();
    }

    public String getFullAddress() {
        return this.getCity() + ", " + this.getStreet() + " " + this.getStreetNumber();
    }

    @Override
    public String toString() {
        return "PersonDetails{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", streetNumber=" + streetNumber +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
