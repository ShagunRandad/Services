package com.exam.portal.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.portal.entity.Quiz;

public interface QuizReposistory extends JpaRepository<Quiz, Integer>{

	
	public Quiz AddQuiz(Quiz quiz);
	
	public Quiz UpdateQuiz(int id,Quiz quiz);
	
	public List<Quiz> getAllQuiz();
	
	public Quiz getQuizById(int quizId);
	
	public void deleteQuizById(int quizId);
	
}
