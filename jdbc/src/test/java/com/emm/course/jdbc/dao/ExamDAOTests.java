package com.emm.course.jdbc.dao;

import com.emm.course.jdbc.entity.Exam;
import com.emm.course.jdbc.entity.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe di test per verificare le operazioni di inserimento e ricerca nella tabella exam: siccome questa tabella
 * è in relazione many to one verso la tabella student, tali operazioni coinvolgeranno anche tale tabella
 */
class ExamDAOTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExamDAOTests.class);
    private static final String DB_URL = "jdbc:h2:file:./database;DB_CLOSE_DELAY=-1";
    private static final String DB_USER = "test";
    private static final String DB_PWD = "";
    private static final ExamDAO EXAM_DAO = new ExamDAO(DB_URL, DB_USER, DB_PWD);
    private static final StudentDAO STUDENT_DAO = new StudentDAO(DB_URL, DB_USER, DB_PWD);

    @BeforeAll
    static void clear() {
        LOGGER.info("Invochiamo l'API per cancellare tutti gli Exam");
        EXAM_DAO.deleteAll();
        LOGGER.info("Una volta eliminati gli Exam possiamo eliminare anche gli Student");
        STUDENT_DAO.deleteAll();
    }

    @Test
    void insert() {
        LOGGER.info("Creiamo l'oggetto Student");
        int studentId = 1;
        Student student = new Student(studentId, "Mario", "Rossi", "m.rossi@gmail.com");
        LOGGER.info("Invochiamo l'API per inserirlo sul database");
        STUDENT_DAO.insert(student);

        LOGGER.info("Creiamo l'oggetto Exam referenziandolo allo Student creato in precedenza");
        String title = "JDBC";
        Exam exam = new Exam(1, title, new Date(System.currentTimeMillis()), 30, studentId);
        LOGGER.info("Invochiamo l'API per inserirlo sul database");
        int insertedExams = EXAM_DAO.insert(exam);
        LOGGER.info("Exam inseriti: {}", insertedExams);

        List<Exam> examByStudentId = EXAM_DAO.findExamByStudentId(studentId);
        assertNotNull(examByStudentId, "La lista degli esami è inaspettatamente null");
        assertEquals(1, examByStudentId.size(), "Il numero degli esami non è quello previsto");
        Exam examFromDB = examByStudentId.get(0);
        assertEquals(title, examFromDB.getTitle(), "Il titolo dell'esame non è quello previsto");
        LOGGER.info("Le assertion sono tutte verificate e dimostrano che l' Exam è stato correttamente inserito nel database");
    }
}
