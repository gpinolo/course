package com.emm.course.jpa;

import com.emm.course.jpa.dao.StudentDAO;
import com.emm.course.jpa.dao.TeacherDAO;
import com.emm.course.jpa.entity.Exam;
import com.emm.course.jpa.entity.Student;
import com.emm.course.jpa.entity.Teacher;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class JPAAppExecution {

    public static void main(String[] args) {
        Student student = new Student();
        student.setFirstName("Mario");
        student.setLastName("ManyToMany");
        student.setEmail("mario.rossi@gmail.com");

        Exam exam = new Exam();
        exam.setTitle("JPA");
        exam.setDate(new Date());
        exam.setVote(8);

        student.addExam(exam);

        Teacher teacher = new Teacher();
        teacher.setFirstName("Pippo");
        teacher.setLastName("Baudo");
        teacher.setSubject("Analysis");

        new TeacherDAO().createTeacher(teacher);

        student.addTeacher(teacher);

        StudentDAO studentDAO = new StudentDAO();
        studentDAO.createStudent(student);
        List<Student> students = studentDAO.findAll();

        for (Student studentFromDB : students) {
            System.out.println(studentFromDB.toString());
            Set<Teacher> teacher1 = studentFromDB.getTeacher();
            System.out.println();
        }
    }

}
