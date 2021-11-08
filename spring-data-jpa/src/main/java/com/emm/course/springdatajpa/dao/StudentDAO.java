package com.emm.course.springdatajpa.dao;

import com.emm.course.springdatajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDAO extends JpaRepository<Student, Integer> {

    List<Student> findByFirstName(String firstName);

}
