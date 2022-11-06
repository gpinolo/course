package com.emm.course.jdbc.dao;

import com.emm.course.jdbc.entity.Teacher;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe di test per verificare le operazioni atomiche di inserimento e ricerca nella tabella teacher
 */
class TeacherDAOTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(TeacherDAOTests.class);
    private static final String DB_URL = "jdbc:h2:file:./database;DB_CLOSE_DELAY=-1";
    private static final String DB_USER = "test";
    private static final String DB_PWD = "";
    private static final TeacherDAO TEACHER_DAO = new TeacherDAO(DB_URL, DB_USER, DB_PWD);

    @BeforeAll
    static void clear() {
        LOGGER.info("Invochiamo l'API deleteAll per cancellare tutti i teacher");
        TEACHER_DAO.deleteAll();
    }

    @Test
    void insertAndFind() {
        LOGGER.info("Creiamo l'oggetto Teacher");
        String teacherFirstName = "Jhon";
        Teacher teacher = new Teacher(1, teacherFirstName, "Keating", "JDBC");
        LOGGER.info("Invochiamo l'API per inserirlo sul database");
        int insertedTeachers = TEACHER_DAO.insert(teacher);
        LOGGER.info("Teacher inseriti: {}", insertedTeachers);

        LOGGER.info("Estraiamo dal database il teacher precedentemente inserito");
        List<Teacher> allTeacher = TEACHER_DAO.findAll();
        assertNotNull(allTeacher);
        assertEquals(1, allTeacher.size(), "Il numero di teacher non è quello previsto");
        Teacher teacherFromDB = allTeacher.get(0);
        assertEquals(teacherFirstName, teacherFromDB.getFirstName(), "Il firstNane del teacher non è quello previsto");
        LOGGER.info("Le assertion sono tutte verificate e dimostrano che il teacher è stato correttamente inserito nel database");
    }
}
