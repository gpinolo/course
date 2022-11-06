package com.emm.course.jdbc.dao;

import com.emm.course.jdbc.entity.Student;
import com.emm.course.jdbc.entity.Teacher;
import com.emm.course.jdbc.exception.JDBCException;

import java.sql.*;

public class StudentTeacherDAO {

    private final String dbUrl;
    private final String user;
    private final String pwd;

    public StudentTeacherDAO(String dbUrl, String user, String pwd) {
        super();
        this.dbUrl = dbUrl;
        this.user = user;
        this.pwd = pwd;
    }

    public int link(Student student, Teacher teacher){
        String sqlInsert = "INSERT INTO student_teacher (student_id, teacher_id) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection (dbUrl, user,pwd);
            PreparedStatement preparedStatement = conn.prepareStatement(sqlInsert)){
            preparedStatement.setInt(1, student.getId());
            preparedStatement.setInt(2, teacher.getId());
            return preparedStatement.executeUpdate();
        }
        catch (SQLException sqlException) {
            throw new JDBCException("Unable to execute createStudent api", sqlException);
        }
    }

    public int deleteAll(){
        try (Connection conn = DriverManager.getConnection (dbUrl, user,pwd);
            Statement statement = conn.createStatement()){
            return statement.executeUpdate("delete from student_teacher");
        } catch (SQLException sqlException) {
            throw new JDBCException("Unable to execute delete api", sqlException);
        }
    }
}
