package com.vishvendra.MyTodo.Model;

import javax.persistence.*;


@Entity
@Table(name = "todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "description")
    private String description;
    @Column(name = "tillDate")
    private String tillDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getTillDate() {
        return tillDate;
    }

    public void setTillDate(String tillDate) {
        this.tillDate = tillDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
