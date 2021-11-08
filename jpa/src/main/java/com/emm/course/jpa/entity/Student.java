package com.emm.course.jpa.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
//@Table(name = "student")
@NamedQueries({
    @NamedQuery(name = "findAllStudent", query = "select s from Student s")
})
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "id")
    private int id;

    //@Column(name = "first_name")
    private String firstName;

    //@Column(name = "last_name")
    private String lastName;

    //@Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "student", cascade = CascadeType.PERSIST)
    private Set<Exam> exams = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "student_teacher",
        joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "teacher_id", referencedColumnName = "id"))
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

    public void addExam(Exam exam) {
        this.exams.add(exam);
        exam.setStudent(this);
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", exams=" + exams.size() +  "]";
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
        teacher.addStudent(this);
    }

    public Set<Teacher> getTeacher() {
        return teachers;
    }
}
