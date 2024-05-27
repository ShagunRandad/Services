package com.exam.portal.service;

import java.util.List;

import com.exam.portal.entity.Question;

public interface QuestionService {

	public Question AddQuestion(Question question);
	
	public Question UpdateQuestion(int id,Question question);
	
	public List<Question> getAllQuestion();
	
	public Question getQuestionById(int id);
	
	public void deleteQuestionById(int id);
}
