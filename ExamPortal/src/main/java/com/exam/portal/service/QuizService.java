package com.exam.portal.service;

import java.util.List;

import com.exam.portal.entity.Quiz;

public interface QuizService {

	
	public Quiz AddQuiz(Quiz quiz);
	
	public Quiz UpdateQuiz(int id,Quiz quiz);
	
	public List<Quiz> getAllQuiz();
	
	public Quiz getQuizById(int quizId);
	
	public void deleteQuizById(int quizId);
	
}
