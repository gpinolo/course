package com.emm.course.jdbc.dao;

import com.emm.course.jdbc.entity.Exam;
import com.emm.course.jdbc.exception.JDBCException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
            preparedStatement.setInt(5, exam.getStudentId());
            return preparedStatement.executeUpdate();
        }
        catch (SQLException sqlException) {
            throw new JDBCException("Unable to insert exam", sqlException);
        }
    }

    public List<Exam> findExamByStudentId(int studentId) {
        try (Connection conn = DriverManager.getConnection (dbUrl, user,pwd);
             PreparedStatement preparedStatement = conn.prepareStatement("select * from exam where student_id = ?")){
            preparedStatement.setInt(1, studentId);
            List<Exam> examList = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Exam exam = new Exam(resultSet.getInt("id"),
                    resultSet.getString("title"),
                    resultSet.getDate("date"),
                    resultSet.getInt("vote"),
                    studentId);
                examList.add(exam);
            }
            return examList;
        } catch (SQLException sqlException) {
            throw new JDBCException("Unable to execute findAll api", sqlException);
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
