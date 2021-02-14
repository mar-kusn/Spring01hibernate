package pl.coderslab.entity;

import java.util.List;

public class Student {
    String firstName;
    String lastName;
    String gender;
    String country;
    String notes;
    boolean mailingList;
    List<String> programmingSkills;
    List<String> hobbies;

    public Student() {
    }

    public Student(String firstName, String lastName, String gender, String country,
                   String notes, boolean mailingList, List<String> programmingSkills,
                   List<String> hobbies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.country = country;
        this.notes = notes;
        this.mailingList = mailingList;
        this.programmingSkills = programmingSkills;
        this.hobbies = hobbies;
    }

    public String getFirstName() {
        return firstName;
    }

    public Student setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Student setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public Student setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Student setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getNotes() {
        return notes;
    }

    public Student setNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public boolean isMailingList() {
        return mailingList;
    }

    public Student setMailingList(boolean mailingList) {
        this.mailingList = mailingList;
        return this;
    }

    public List<String> getProgrammingSkills() {
        return programmingSkills;
    }

    public Student setProgrammingSkills(List<String> programmingSkills) {
        this.programmingSkills = programmingSkills;
        return this;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public Student setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
        return this;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", country='" + country + '\'' +
                ", notes='" + notes + '\'' +
                ", mailingList=" + mailingList +
                ", programmingSkills=" + programmingSkills +
                ", hobbies=" + hobbies +
                '}';
    }
}

