package com.emm.course.jpa.dao;

import com.emm.course.jpa.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class StudentDAO {

    private EntityManager entityManager;

    public StudentDAO() {
        entityManager = Persistence.createEntityManagerFactory("examplePU").createEntityManager();
    }

    public void createStudent(Student student){
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
    }

    public List<Student> findAll(){
        return entityManager.createNamedQuery("findAllStudent", Student.class).getResultList();
    }

}
