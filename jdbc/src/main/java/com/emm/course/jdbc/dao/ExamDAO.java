package com.emm.course.jdbc.dao;

import com.emm.course.jdbc.entity.Exam;
import com.emm.course.jdbc.exception.JDBCException;

import java.sql.*;

public class ExamDAO {

    private final String dbUrl;
    private final String user;
    private final String pwd;

    public ExamDAO(String dbUrl, String user, String pwd) {
        super();
        this.dbUrl = dbUrl;
        this.user = user;
        this.pwd = pwd;
    }

    public int insert(Exam exam){
        String sqlInsert = "INSERT INTO exam (id, title, date,vote, student_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection (dbUrl, user,pwd);
            PreparedStatement preparedStatement = conn.prepareStatement(sqlInsert)){
            preparedStatement.setInt(1, exam.getId());
            preparedStatement.setString(2, exam.getTitle());
            preparedStatement.setDate(3, exam.getDate());
            preparedStatement.setInt(4, exam.getVote());
            preparedStatement.setInt(5, exam.getStudent().getId());
            return preparedStatement.executeUpdate();
        }
        catch (SQLException sqlException) {
            throw new JDBCException("Unable to insert exam", sqlException);
        }
    }


    public int deleteAll(){
        try (Connection conn = DriverManager.getConnection (dbUrl, user,pwd);
            Statement statement = conn.createStatement()){
            return statement.executeUpdate("DELETE exam");
        } catch (SQLException sqlException) {
            throw new JDBCException("Unable to deleteAll exam", sqlException);
        }
    }

}
