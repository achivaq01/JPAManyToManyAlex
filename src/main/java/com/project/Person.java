package com.project;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Person",
        uniqueConstraints = {@UniqueConstraint(columnNames = "id")})
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long personId;
    @Column(name = "dni")
    private String dni;
    @Column(name = "name")
    private String name;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "Book_Persons",
            joinColumns = {@JoinColumn(referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(referencedColumnName = "id")})
    private Set<Book> books;

    public Person() {
        super();
    }

    public Person(String dni, String name, String phoneNumber) {
        super();
        this.dni = dni;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Person(int personId, String dni, String name, String phoneNumber, Set<Book> books) {
        super();
        this.personId = personId;
        this.dni = dni;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.books = books;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public List<Object[]> queryBooks () {
        long id = this.getPersonId();
        return Manager.queryTable("SELECT DISTINCT l.* FROM Book_Persons lp, Book l WHERE l.id = lp.books_id AND lp.persons_id = " + id);
    }

    @Override
    public String toString() {
        String books = Manager.tableToString(queryBooks());
        return "Person{" +
                "personId=" + personId +
                ", dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' + "books= " + books +
                '}';
    }
}
