package com.emm.course.springdatajpa.dao;

import com.emm.course.springdatajpa.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface ExamDAO extends JpaRepository<Exam, Integer> {

}
