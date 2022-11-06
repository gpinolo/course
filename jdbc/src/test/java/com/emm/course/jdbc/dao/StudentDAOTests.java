package com.emm.course.jdbc.dao;

import com.emm.course.jdbc.entity.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Classe di test per verificare le operazioni atomiche di inserimento e ricerca nella tabella student
 */
class StudentDAOTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentDAOTests.class);
    private static final String DB_URL = "jdbc:h2:file:./database;DB_CLOSE_DELAY=-1";
    private static final String DB_USER = "test";
    private static final String DB_PWD = "";
    private static final StudentDAO STUDENT_DAO = new StudentDAO(DB_URL, DB_USER, DB_PWD);

    @BeforeAll
    static void clear() {
        LOGGER.info("Invochiamo l'API deleteAll per cancellare tutti i Student");
        STUDENT_DAO.deleteAll();
    }

    @Test
    void insertAndFind() {
        LOGGER.info("Creiamo l'oggetto Student");
        String studentFirstName = "Mario";
        Student student = new Student(1, studentFirstName, "Rossi", "m.rossi@gmail.com");
        LOGGER.info("Invochiamo l'API per inserirlo sul database");
        int insertedStudents = STUDENT_DAO.insert(student);
        LOGGER.info("Student inseriti: {}", insertedStudents);

        LOGGER.info("Estraiamo dal database lo student precedentemente inserito");
        List<Student> allStudent = STUDENT_DAO.findAll();
        assertNotNull(allStudent, "La lista degli Student è inaspettatamente null");
        assertEquals(1, allStudent.size(), "Il numero di Student non è quello previsto");
        Student StudentFromDB = allStudent.get(0);
        assertEquals(studentFirstName, StudentFromDB.getFirstName(), "Il firstNane dello Student non è quello previsto");
        LOGGER.info("Le assertion sono tutte verificate e dimostrano che lo Student è stato correttamente inserito nel database");
    }
}
