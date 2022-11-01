package com.emm.course.jdbc;

import com.emm.course.jdbc.dao.ExamDAO;
import com.emm.course.jdbc.dao.StudentDAO;
import com.emm.course.jdbc.dao.TeacherDAO;
import com.emm.course.jdbc.entity.Exam;
import com.emm.course.jdbc.entity.Student;
import com.emm.course.jdbc.entity.Teacher;

import java.sql.Date;
import java.util.List;

public class JDBCAppExecution {

    private static final String DB_URL = "jdbc:h2:file:./jdbc/jdbc;DB_CLOSE_DELAY=-1";
    private static final String DB_USER = "test";
    private static final String DB_PWD = "";
    private static final StudentDAO STUDENT_DAO =new StudentDAO(DB_URL, DB_USER, DB_PWD);
    private static final ExamDAO EXAM_DAO = new ExamDAO(DB_URL, DB_USER, DB_PWD);
    private static final TeacherDAO TEACHER_DAO = new TeacherDAO(DB_URL, DB_USER, DB_PWD);

    static{
        clearDB();
    }

    public static void main(String[] args){

        Student student = createStudent();
        int insertedStudents = STUDENT_DAO.insert(student);
        System.out.println("Inserted students: " + insertedStudents);

        Exam exam = createExam(student);
        int insertedExams = EXAM_DAO.insert(exam);
        System.out.println("Inserted exams: " + insertedExams);

        Teacher teacher = createTeacher();
        int insertedTeachers = TEACHER_DAO.insert(teacher);
        System.out.println("Inserted teachers: " + insertedTeachers);

        List<Student> students = STUDENT_DAO.findAll();
        students.forEach(studentFromDB -> System.out.println(studentFromDB.toString()));
    }

    private static Teacher createTeacher() {
        Teacher teacher = new Teacher();
        teacher.setId(1);
        teacher.setFirstName("Jhon");
        teacher.setLastName("Keating");
        teacher.setSubject("JDBC");
        return teacher;
    }

    private static Exam createExam(Student student) {
        Exam exam = new Exam();
        exam.setDate(new Date(System.currentTimeMillis()));
        exam.setTitle("JDBC");
        exam.setVote(30);
        exam.setStudent(student);
        return exam;
    }

    private static Student createStudent() {
        Student student = new Student();
        student.setId(1);
        student.setFirstName("Mario");
        student.setLastName("Rossi");
        student.setEmail("mario.rossi@gmail.com");
        return student;
    }

    private static void clearDB() {
        EXAM_DAO.deleteAll();
        STUDENT_DAO.deleteAll();
        TEACHER_DAO.deleteAll();
    }

}
