package com.project;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Book",
        uniqueConstraints = {@UniqueConstraint(columnNames = "id")})
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long bookId;
    @Column(name = "name")
    private String name;
    @Column(name = "publishingHouse")
    private String publishingHouse;
    @Column(name = "id_author")
    private long id_author;
    @ManyToMany(mappedBy = "books")
    private Set<Library> libraries;
    @ManyToMany(mappedBy = "books")
    private Set<Person> persons;

    public Book() {
        super();
    }

    public Book(String name, String publishingHouse) {
        super();
        this.name = name;
        this.publishingHouse = publishingHouse;
    }

    public Book(int bookId, String name, String publishingHouse, int id_author, Set<Library> libraries, Set<Person> person) {
        super();
        this.bookId = bookId;
        this.name = name;
        this.publishingHouse = publishingHouse;
        this.id_author = id_author;
        this.libraries = libraries;
        this.persons = person;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public long getId_author() {
        return id_author;
    }

    public void setId_author(long id_author) {
        this.id_author = id_author;
    }

    public Set<Library> getLibraries() {
        return libraries;
    }

    public void setLibraries(Set<Library> libraries) {
        this.libraries = libraries;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }

    @Override
    public String toString() {
        return bookId + ": " + name + ", "+ publishingHouse;
    }

}
