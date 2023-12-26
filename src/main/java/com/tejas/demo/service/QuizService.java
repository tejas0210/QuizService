package com.tejas.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.tejas.demo.feign.QuizInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tejas.demo.dao.QuizDao;
import com.tejas.demo.model.QuestionWrapper;
import com.tejas.demo.model.Quiz;
import com.tejas.demo.model.Response;

@Service
public class QuizService {
	
	@Autowired
	QuizDao quizDao;

	@Autowired
	QuizInterface quizInterface;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		List<Integer> questions = quizInterface.getQuestionsForQuiz(category,numQ).getBody();
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestionIds(questions);
		quizDao.save(quiz);
		return new ResponseEntity<>("Success",HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		Quiz quiz = quizDao.findById(id).get();
		List<Integer> questionsIds = quiz.getQuestionIds();
		ResponseEntity<List<QuestionWrapper>> questions = quizInterface.getQuestionsFromId(questionsIds);
		return questions;
				
	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
		ResponseEntity<Integer> score = quizInterface.getScore(responses);
		return score;
	}

	
	
	

}
