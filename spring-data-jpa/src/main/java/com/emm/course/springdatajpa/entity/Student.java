package com.emm.course.springdatajpa.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "student")
@NamedQueries({
    @NamedQuery(name = "findAllStudent", query = "select s from Student s")
})
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "student_sequence")
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    //@OneToMany(mappedBy = "student", cascade = CascadeType.PERSIST)
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "student_id")
    private Set<Exam> exams = new HashSet<>();

    @ManyToMany
    private Set<Teacher> teachers = new HashSet<>();

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

    public void addExams(Exam exam) {
        exam.setStudent(this);
        exams.add(exam);
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void addTeacher(Teacher teacher){
        teacher.addStudent(this);
        teachers.add(teacher);
    }

    public void removeTeacher(Teacher teacher) {
        teachers.remove(teacher);
        teacher.removeStudent(this);
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
    }
}
