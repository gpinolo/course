package com.emm.course.jdbc.dao;

import com.emm.course.jdbc.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {


    public void createStudent(Student student) throws SQLException {
        Connection conn = DriverManager.getConnection ("jdbc:h2:tcp://localhost/C:/Users/gdecesare/dev/EMM/course/jpa/test;DB_CLOSE_DELAY=-1", "test","");
        PreparedStatement preparedStatement = conn.prepareStatement("insert into student (\"ID\",\"FIRST_NAME\", \"LAST_NAME\",\"EMAIL\") values (?, ?, ?, ?)");
        preparedStatement.setInt(1, student.getId());
        preparedStatement.setString(2, student.getFirstName());
        preparedStatement.setString(3, student.getLastName());
        preparedStatement.setString(4, student.getEmail());
        preparedStatement.executeUpdate();
    }

    public List<Student> findAll() throws SQLException {
        Connection conn = DriverManager.getConnection ("jdbc:h2:tcp://localhost/C:/Users/gdecesare/dev/EMM/course/jpa/test;DB_CLOSE_DELAY=-1", "test","");
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from student");
        List<Student> students = new ArrayList<>();
        while (resultSet.next()){
            Student student = new Student();
            student.setId(resultSet.getInt("id"));
            student.setFirstName(resultSet.getString("first_name"));
            student.setLastName(resultSet.getString("last_name"));
            student.setEmail(resultSet.getString("email"));
            students.add(student);
        }
        return students;
    }

}
