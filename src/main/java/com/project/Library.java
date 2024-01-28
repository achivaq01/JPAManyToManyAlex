package com.project;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Library", uniqueConstraints = {@UniqueConstraint(columnNames = "id")})
public class Library implements Serializable {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long libraryId;
    @Column(name = "name")
    private String name;
    @Column(name = "city")
    private String city;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "Book_Library",
            joinColumns = {@JoinColumn(referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(referencedColumnName = "id")})
    private Set<Book> books;

    public Library() {
        super();
    }

    public Library(String name, String city) {
        super();
        this.name = name;
        this.city = city;
    }

    public Library(int libraryId, String name, String city, Set<Book> books) {
        super();
        this.libraryId = libraryId;
        this.name = name;
        this.city = city;
        this.books = books;
    }

    public long getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(long libraryId) {
        this.libraryId = libraryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public List<Object[]> queryBooks () {
        long id = this.getLibraryId();
        return Manager.queryTable("SELECT DISTINCT l.* FROM Book_Library lb, Book l WHERE l.id = lb.books_id AND lb.libraries_id = " + id);
    }

    @Override
    public String toString() {
        String books = Manager.tableToString(queryBooks());
        return this.getLibraryId() + ": " + this.getName() + ", " + this.getCity() + ", Books: [" + books + "]";
    }
}
