package com.emm.course.jpa.dao;

import com.emm.course.jpa.entity.Student;
import com.emm.course.jpa.entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class TeacherDAO {

    private EntityManager entityManager;

    public TeacherDAO() {
        entityManager = Persistence.createEntityManagerFactory("examplePU").createEntityManager();
    }

    public void createTeacher(Teacher teacher){
        entityManager.getTransaction().begin();
        entityManager.persist(teacher);
        entityManager.getTransaction().commit();
    }

    /*public List<Student> findAll(){
        return entityManager.createNamedQuery("findAllStudent", Student.class).getResultList();
    }*/

}
