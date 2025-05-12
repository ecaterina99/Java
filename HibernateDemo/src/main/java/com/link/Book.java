package com.link;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "pageNo")
    private int pageNo;

    @ManyToOne
    @JoinColumn(name = "publisher_id", referencedColumnName = "id")
    @Cascade(CascadeType.ALL)

    private Publisher publisher;

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public Book(int id, String title, int pageNo) {
        this.id = id;
        this.title = title;
        this.pageNo = pageNo;
    }

    public Book(String title, int pageNo) {
        this.title = title;
        this.pageNo = pageNo;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{ " + "id=" + id + ", title=" + title + ", pageNo=" + pageNo + '}';
    }
}
