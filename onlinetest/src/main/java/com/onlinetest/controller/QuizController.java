package com.onlinetest.controller;

import java.util.List;

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

import com.onlinetest.entity.exam.Category;
import com.onlinetest.entity.exam.Quiz;
import com.onlinetest.services.QuizService;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {
	@Autowired
	private QuizService quizService;

	// Add Quiz

	@PostMapping("/")
	public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz) {
		return ResponseEntity.ok(this.quizService.addQuiz(quiz));
	}

	// Update Quiz

	@PutMapping("/")
	public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz) {
		return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
	}

	// Get All Quizzes

	@GetMapping("/")
	public ResponseEntity<?> quizes() {
		return ResponseEntity.ok(this.quizService.getQuizes());
	}

	// Get Single Quiz

	@GetMapping("/{quizId}")
	public Quiz getQuiz(@PathVariable("quizId") Long quizId) {
		return this.quizService.getQuiz(quizId);
	}

	// Delete Quiz

	@DeleteMapping("/{quizId}")
	public void deleteQuiz(@PathVariable("quizId") Long quizId) {
		this.quizService.deleteQuiz(quizId);
	}
	
	@GetMapping("/category/{cid}")
	public List<Quiz> getQuizzesOfCategory(@PathVariable("cid") Long cid){
		Category category = new Category();
		category.setCid(cid);
		return this.quizService.getQuizesOfCategory(category);
		
	}
	
	@GetMapping("/active")
	public List<Quiz> getActiveQuizzes(){
		return this.quizService.getActiveQuizes();
	}
	
	@GetMapping("/category/active/{cid}")
	public List<Quiz> getActiveQuizzessByCategory(@PathVariable("cid") Long cid){
		Category category = new Category();
		category.setCid(cid);
		return this.quizService.getActiveQuizzesOfCategory(category);
	}
}
