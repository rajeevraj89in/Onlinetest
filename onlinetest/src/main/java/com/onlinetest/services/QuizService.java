package com.onlinetest.services;

import java.util.Set;

import com.onlinetest.entity.exam.Quiz;

public interface QuizService {

	public Quiz addQuiz(Quiz quiz);

	public Quiz updateQuiz(Quiz quiz);

	public Set<Quiz> getQuizes();

	public Quiz getQuiz(Long quizId);

	public void deleteQuiz(Long quizId);
}
