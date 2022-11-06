package com.emm.course.jdbc.entity;

import java.sql.Date;

public class Exam {

    private int id;

    private String title;

    private Date date;

    private int vote;

    private int studentId;

    public Exam(int id, String title, Date date, int vote, int studentId) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.vote = vote;
        this.studentId = studentId;
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

    public int getStudentId() {
        return studentId;
    }

    public void setStudent(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Exam [id=" + id + ", title=" + title + ", date=" + date + ", vote=" + vote+ ", studentId=" + studentId + "]";
    }
}
