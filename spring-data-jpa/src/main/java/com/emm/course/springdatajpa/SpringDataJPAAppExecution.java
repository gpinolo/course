package com.emm.course.springdatajpa;

import com.emm.course.springdatajpa.dao.ExamDAO;
import com.emm.course.springdatajpa.dao.StudentDAO;
import com.emm.course.springdatajpa.entity.Exam;
import com.emm.course.springdatajpa.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;


import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class SpringDataJPAAppExecution {

    public static void main(String[] args) {
        Student student = new Student();
        //student.setId(10);
        student.setFirstName("Mario");
        student.setLastName("Nero");
        student.setEmail("mario.rossi@gmail.com");

        Exam exam = new Exam();
        exam.setId(10);
        exam.setTitle("JPA2");
        exam.setDate(new Date());
        exam.setVote(8);

        student.addExams(exam);

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");


        StudentDAO studentDAO = applicationContext.getBean(StudentDAO.class);
        studentDAO.save(student);
        //studentDAO.flush();
        List<Student> students = studentDAO.findByFirstName("Mario");
        students.forEach(studentFromDB -> System.out.println(studentFromDB.toString()));

        //List<Student> students = studentDAO.findAll();
       // students.forEach(studentFromDB -> System.out.println(studentFromDB.toString()));
        /*ExamDAO examDAO = applicationContext.getBean(ExamDAO.class);
        List<Exam> exams = examDAO.findAll();
        exams.forEach( examFromDB -> {
            System.out.println("student from exam " + examFromDB.getStudent());
        });*/

    }

}
