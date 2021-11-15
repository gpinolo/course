package com.emm.course.jdbc;

import com.emm.course.jdbc.dao.StudentDAO;
import com.emm.course.jdbc.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class JDBCTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(JDBCTests.class);

    @BeforeEach
    void clearDB() {
        LOGGER.info("Invochiamo l'API deleteAll per cancellare tutti gli student presenti sul database");
        new StudentDAO("jdbc:h2:file:./jdbc", "jdbc", "").deleteAll();
    }

    @Test
    void createStudentTest() {
        String studentFirstName = "MarioJDBC";
        LOGGER.info("Creiamo l'oggetto Student con firstName {}", studentFirstName);
        Student student = new Student();
        student.setFirstName("MarioJDBC");
        student.setLastName("Rossi");
        student.setEmail("mario.rossi@gmail.com");

        StudentDAO studentDAO = new StudentDAO(
            "jdbc:h2:file:./jdbc", "jdbc", "");
        LOGGER.info("Invochiamo l'API create per inserirlo sul database");
        studentDAO.create(student);
        LOGGER.info("Invochiamo l'API findAll per leggere tutti gli studenti presenti sul database");
        List<Student> allStudentInDB = studentDAO.findAll();
        LOGGER.info("Verifichiamo che lo student precedentemente inserito è presente sul database");
        assertNotNull(allStudentInDB, "No student found");
        assertEquals(1, allStudentInDB.size(), "Unexpected number of student found");
        Student studentFromDB = allStudentInDB.get(0);
        assertEquals(studentFirstName, studentFromDB.getFirstName(), "Unexpected student first name");
    }

}
