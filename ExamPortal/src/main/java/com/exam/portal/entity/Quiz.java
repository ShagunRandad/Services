package com.exam.portal.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="quiz_master")
@Entity
public class Quiz {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int qId;
    private boolean isActive=false;
    private String title;
	private String decription;
	private int maxMarks;
	private int numberOfQuestions;
	private int cid;
	
	@ManyToOne(fetch = FetchType.EAGER)
	Category category;
	
	@OneToMany(mappedBy = "quiz",fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Question> queList=new ArrayList<Question>();
 
}
