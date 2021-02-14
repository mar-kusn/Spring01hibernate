package pl.coderslab.entity;

import org.hibernate.validator.constraints.pl.NIP;
import org.hibernate.validator.constraints.pl.REGON;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "publishers")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @OneToMany(mappedBy = "publisher")
    private List<Book> books = new ArrayList<>();
    @NIP
    private String nip;
    @REGON
    private String regon;

    public Publisher() {
    }

    public Long getId() {
        return id;
    }

    public Publisher setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Publisher setName(String name) {
        this.name = name;
        return this;
    }

    public List<Book> getBooks() {
        return books;
    }

    public Publisher setBooks(List<Book> books) {
        this.books = books;
        return this;
    }

    public String getNip() {
        return nip;
    }

    public Publisher setNip(String nip) {
        this.nip = nip;
        return this;
    }

    public String getRegon() {
        return regon;
    }

    public Publisher setRegon(String regon) {
        this.regon = regon;
        return this;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
