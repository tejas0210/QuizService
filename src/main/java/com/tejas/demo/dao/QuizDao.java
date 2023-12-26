package com.tejas.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejas.demo.model.Quiz;

@Repository
public interface QuizDao extends JpaRepository<Quiz,Integer>{

}
