package com.emm.course.jdbc.entity;

import java.sql.Date;

public class Exam {

    private int id;

    private String title;

    private Date date;

    private int vote;

    private Student student;

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
