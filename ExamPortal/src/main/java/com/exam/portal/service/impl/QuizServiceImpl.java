package com.exam.portal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.exam.portal.Exception.UserDefineException;
import com.exam.portal.Repository.QuizReposistory;
import com.exam.portal.entity.Quiz;
import com.exam.portal.service.QuizService;

public class QuizServiceImpl implements QuizService{

	@Autowired
	QuizReposistory quizReposistory;
	@Override
	public Quiz AddQuiz(Quiz quiz) {
		if(quiz != null) {
		quizReposistory.save(quiz);
		return quiz;
		}
		return null;
	}

	@Override
	public Quiz UpdateQuiz(int id,Quiz quiz) {
		quizReposistory.findById(id).orElseThrow(()-> new UserDefineException("No User Found"));
		quizReposistory.save(quiz);
		return quizReposistory.save(quiz);
	}

	@Override
	public List<Quiz> getAllQuiz() {
		return quizReposistory.findAll();
	}

	@Override
	public Quiz getQuizById(int quizId) {
		return quizReposistory.findById(quizId).orElseThrow(()-> new UserDefineException("No User Found"));
	}

	@Override
	public void deleteQuizById(int quizId) {
		quizReposistory.findById(quizId).orElseThrow(()-> new UserDefineException("No User Found"));
		quizReposistory.deleteById(quizId);
	}

}
