package com.emm.course.jdbc.dao;

import com.emm.course.jdbc.entity.Student;
import com.emm.course.jdbc.exception.JDBCException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private String dbUrl;
    private String user;
    private String pwd;

    public StudentDAO(String dbUrl, String user, String pwd) {
        super();
        this.dbUrl = dbUrl;
        this.user = user;
        this.pwd = pwd;
    }

    public int create(Student student){
        String sqlInsert = "insert into student (\"ID\",\"FIRST_NAME\", \"LAST_NAME\",\"EMAIL\") values (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection (dbUrl, user,pwd);
            PreparedStatement preparedStatement = conn.prepareStatement(sqlInsert)){
            preparedStatement.setInt(1, student.getId());
            preparedStatement.setString(2, student.getFirstName());
            preparedStatement.setString(3, student.getLastName());
            preparedStatement.setString(4, student.getEmail());
            return preparedStatement.executeUpdate();
        }
        catch (SQLException sqlException) {
            throw new JDBCException("Unable to execute createStudent api", sqlException);
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
            return statement.executeUpdate("delete from student");
        } catch (SQLException sqlException) {
            throw new JDBCException("Unable to execute delete api", sqlException);
        }
    }

}
