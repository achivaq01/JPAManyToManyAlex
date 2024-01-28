package com.project;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Author",
        uniqueConstraints = {@UniqueConstraint(columnNames = "id")})
public class Author implements Serializable {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long authorId;
    @Column(name = "name")
    private String name;
    @OneToMany
    @JoinColumn(name = "authorId")
    private Set<Book> books;

    public Author() {
        super();
    }

    public Author(String name) {
        this.name = name;
    }

    public Author(int authorId, String name, Set<Book> books) {
        this.authorId = authorId;
        this.name = name;
        this.books = books;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public List<Object[]> queryBooks () {
        long id = this.getAuthorId();
        return Manager.queryTable("SELECT DISTINCT l.* FROM Book l WHERE l.authorId = " + id);
    }

    @Override
    public String toString() {
        String books = Manager.tableToString(queryBooks());
        return "Author{" +
                "authorId=" + authorId +
                ", name='" + name + '\'' + "books= " + books +
                '}';
    }
}
