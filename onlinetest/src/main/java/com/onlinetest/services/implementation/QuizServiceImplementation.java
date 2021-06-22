package com.onlinetest.services.implementation;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinetest.entity.exam.Quiz;
import com.onlinetest.repository.QuizRepository;
import com.onlinetest.services.QuizService;

@Service
public class QuizServiceImplementation implements QuizService {

	@Autowired
	private QuizRepository quizRepository;

	@Override
	public Quiz addQuiz(Quiz quiz) {
		return this.quizRepository.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		return this.quizRepository.save(quiz);
	}

	@Override
	public Set<Quiz> getQuizes() {
		return new LinkedHashSet<>(this.quizRepository.findAll());
	}

	@Override
	public Quiz getQuiz(Long quizId) {
		return this.quizRepository.findById(quizId).get();
	}

	@Override
	public void deleteQuiz(Long quizId) {
		Quiz quiz = new Quiz();
		quiz.setqId(quizId);
		this.quizRepository.delete(quiz);
	}

}
