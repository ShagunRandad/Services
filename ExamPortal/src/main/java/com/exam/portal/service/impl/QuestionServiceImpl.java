package com.exam.portal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.exam.portal.Exception.UserDefineException;
import com.exam.portal.Repository.QuestionReposistory;
import com.exam.portal.entity.Question;
import com.exam.portal.service.QuestionService;

public class QuestionServiceImpl implements QuestionService {
	
	@Autowired 
	QuestionReposistory questionReposistry;

	@Override
	public Question AddQuestion(Question question) {
		return questionReposistry.save(question);
	}

	@Override
	public Question UpdateQuestion(int id, Question question) {
		questionReposistry.findById(id).orElseThrow(()-> new UserDefineException("No User found"));
		return questionReposistry.save(question);
	}

	@Override
	public List<Question> getAllQuestion() {
		return questionReposistry.findAll();
	}

	@Override
	public Question getQuestionById(int id) {
		Question quetion =questionReposistry.findById(id).orElseThrow(()-> new UserDefineException("No User found"));
		return quetion;
	}

	@Override
	public void deleteQuestionById(int id) {
	questionReposistry.findById(id).orElseThrow(()-> new UserDefineException("No User found"));
	questionReposistry.deleteById(id);
	}

}
