package com.emm.course.jdbc;

import com.emm.course.jdbc.dao.StudentDAO;
import com.emm.course.jdbc.entity.Exam;
import com.emm.course.jdbc.entity.Student;

import java.sql.*;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class JDBCAppExecution {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Student student = new Student();
        student.setFirstName("MarioJDBC");
        student.setLastName("Rossi");
        student.setEmail("mario.rossi@gmail.com");

        StudentDAO studentDAO = new StudentDAO();
        studentDAO.createStudent(student);

        List<Student> students = studentDAO.findAll();
        students.forEach(studentFromDB -> System.out.println(studentFromDB.toString()));


    }

}
