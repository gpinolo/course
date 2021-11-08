package com.emm.course.jpa.dao;

import com.emm.course.jpa.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class ExamDAO {

    private EntityManager entityManager;

    public ExamDAO() {
        entityManager = Persistence.createEntityManagerFactory("examplePU").createEntityManager();
    }

    public List<Student> findAll(){
        return entityManager.createQuery("Select t from Exam t").getResultList();
    }

}
