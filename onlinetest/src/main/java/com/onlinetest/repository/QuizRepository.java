package com.onlinetest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinetest.entity.exam.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long>{

}
