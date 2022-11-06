package com.emm.course.jdbc.dao;

import com.emm.course.jdbc.entity.Student;
import com.emm.course.jdbc.entity.Teacher;
import com.emm.course.jdbc.exception.JDBCException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private final String dbUrl;
    private final String user;
    private final String pwd;

    public StudentDAO(String dbUrl, String user, String pwd) {
        super();
        this.dbUrl = dbUrl;
        this.user = user;
        this.pwd = pwd;
    }

    public int insert(Student student){
        String sqlInsert = "INSERT INTO student (id, first_name, last_name, email) VALUES (?, ?, ?, ?)";
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
                Student student = new Student(resultSet.getInt("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("email"));
                students.add(student);
            }
            return students;
        } catch (SQLException sqlException) {
            throw new JDBCException("Unable to execute findAll api", sqlException);
        }
    }

    public List<Student> findStudentsByTeacher(Teacher teacher) {
        try (Connection conn = DriverManager.getConnection (dbUrl, user,pwd);
             PreparedStatement preparedStatement = conn.prepareStatement("select a.* from student a, student_teacher b where a.id=b.student_id and b.teacher_id = ?")){
            List<Student> students = new ArrayList<>();
            preparedStatement.setInt(1, teacher.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Student student = new Student(resultSet.getInt("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("email"));
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
