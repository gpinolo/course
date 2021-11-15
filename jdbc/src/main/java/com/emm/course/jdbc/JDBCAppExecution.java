package com.emm.course.jdbc;

import com.emm.course.jdbc.dao.StudentDAO;
import com.emm.course.jdbc.entity.Student;

import java.sql.*;
import java.util.List;

public class JDBCAppExecution {

    public static void main(String[] args){

        Student student = new Student();
        student.setFirstName("MarioJDBC");
        student.setLastName("Rossi");
        student.setEmail("mario.rossi@gmail.com");

        StudentDAO studentDAO = new StudentDAO(
            "jdbc:h2:tcp://localhost/C:/Users/gdecesare/dev/EMM/course/jpa/test;DB_CLOSE_DELAY=-1", "test", "");
        studentDAO.create(student);

        List<Student> students = studentDAO.findAll();
        students.forEach(studentFromDB -> System.out.println(studentFromDB.toString()));


    }

}
