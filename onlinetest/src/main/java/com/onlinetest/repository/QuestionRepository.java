package com.onlinetest.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinetest.entity.exam.Question;
import com.onlinetest.entity.exam.Quiz;

public interface QuestionRepository extends JpaRepository<Question, Long> {

	Set<Question> findByQuiz(Quiz quiz);

}
