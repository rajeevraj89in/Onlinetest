package com.onlinetest.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinetest.entity.exam.Question;
import com.onlinetest.entity.exam.Quiz;
import com.onlinetest.services.QuestionService;
import com.onlinetest.services.QuizService;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	@Autowired
	private QuizService quizService;

	// Add Question
	
	@PostMapping("/")
	public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
		return ResponseEntity.ok(this.questionService.addQuestion(question));
	}
	
	// Update Question

	@PutMapping("/")
	public ResponseEntity<Question> updateQuestion(@RequestBody Question question) {
		return ResponseEntity.ok(this.questionService.updateQuestion(question));
	}

	// Get all question of any quiz

	@GetMapping("/quiz/{quizId}")
	public ResponseEntity<?> getQuestionOfQuiz(@PathVariable("quizId") Long quizId) {
//		Quiz quiz = new Quiz();
//		quiz.setqId(quizId);
//		Set<Question> questionOfQuiz = this.questionService.getQuestionOfQuiz(quiz);
//		return ResponseEntity.ok(questionOfQuiz);

		Quiz quiz = new Quiz();
		Set<Question> questions = quiz.getQuestions();
		List list = new ArrayList(questions);
		if (list.size() > Integer.parseInt(quiz.getNumberOfQuestions())) {
			list = list.subList(0, Integer.parseInt(quiz.getNumberOfQuestions()));
		}
		Collections.shuffle(list);
		return ResponseEntity.ok(list);
	}

	// Get Single Question

	@GetMapping("/{questionId}")
	public Question getQuestion(@PathVariable("questionId") Long questionId) {
		return this.questionService.getQuestion(questionId);
	}

	// Delete Question

	@DeleteMapping("/{questionId}")
	public void deleteQuestion(@PathVariable("questionId") Long questionId) {
		this.questionService.deleteQuestion(questionId);
	}

}
