package com.exam.portal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.portal.entity.Question;

public interface QuestionReposistory  extends JpaRepository<Question, Integer>{

}
