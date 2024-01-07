package org.grostarin.springboot.demorest.domain;

import javax.persistence.*;

// New domain: BannedBook (Same information as Book)

@Entity
public class BannedBook {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    private String author;    

    public BannedBook() {
        super();
    }

    public BannedBook(String title, String author) {
        super();
        this.title = title;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Banned Book [id=" + id + ", title=" + title + ", author=" + author + "]";
    }
}