package com.emm.course.springdatajpa.entity;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "exam")
public class Exam {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO, generator = "exam_sequence")
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "date")
    private Date date;

    @Column(name= "vote")
    private int vote;

    @ManyToOne
    private Student student;

    public Exam() {

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

    public void setTitle(String firstName) {
        this.title = firstName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", firstName=" + title + ", date=" + date + ", vote=" + vote + "]";
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
