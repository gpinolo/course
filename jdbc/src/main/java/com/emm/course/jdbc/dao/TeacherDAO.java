package com.emm.course.jdbc.dao;

import com.emm.course.jdbc.entity.Student;
import com.emm.course.jdbc.entity.Teacher;
import com.emm.course.jdbc.exception.JDBCException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAO {

    private final String dbUrl;
    private final String user;
    private final String pwd;

    public TeacherDAO(String dbUrl, String user, String pwd) {
        super();
        this.dbUrl = dbUrl;
        this.user = user;
        this.pwd = pwd;
    }

    public int insert(Teacher teacher){
        String sqlInsert = "INSERT INTO teacher (id, first_name, last_name, subject) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection (dbUrl, user,pwd);
            PreparedStatement preparedStatement = conn.prepareStatement(sqlInsert)){
            preparedStatement.setInt(1, teacher.getId());
            preparedStatement.setString(2, teacher.getFirstName());
            preparedStatement.setString(3, teacher.getLastName());
            preparedStatement.setString(4, teacher.getSubject());
            return preparedStatement.executeUpdate();
        }
        catch (SQLException sqlException) {
            throw new JDBCException("Unable to execute create api", sqlException);
        }
    }

    public List<Student> findAll() {
        try (Connection conn = DriverManager.getConnection (dbUrl, user,pwd);
            Statement statement = conn.createStatement()){
            List<Student> students = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery("select * from student");
            while (resultSet.next()){
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setLastName(resultSet.getString("last_name"));
                student.setEmail(resultSet.getString("email"));
                students.add(student);
            }
            return students;
        } catch (SQLException sqlException) {
            throw new JDBCException("Unable to execute findAll api", sqlException);
        }
    }

    public int deleteAll(){
        try (Connection conn = DriverManager.getConnection (dbUrl, user,pwd);
            Statement statement = conn.createStatement()){
            return statement.executeUpdate("DELETE teacher");
        } catch (SQLException sqlException) {
            throw new JDBCException("Unable to execute delete api", sqlException);
        }
    }

}
