package com.emm.course.jdbc.entity;

import java.util.Set;


public class Student {

    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private Set<Exam> exams;

    public Student() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Exam> getExams() {
        return exams;
    }

    public void setExams(Set<Exam> teachers) {
        this.exams = teachers;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
    }
}
