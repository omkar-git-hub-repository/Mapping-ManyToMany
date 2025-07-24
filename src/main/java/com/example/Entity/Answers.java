package com.example.Entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Answers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int answerId;
    private String answer;

    @ManyToMany(mappedBy = "answers")
    
    private List<Questions> questions;
    public List<Questions> getQuestions() {
        return questions;
    }
    public void setQuestions(List<Questions> questions) {
        this.questions = questions;
    }


    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswerT() {
        return answer;
    }

    public void setAnswerT(String answerT) {
        this.answer = answerT;
    }

    @Override
    public String toString() {
        return "Answers [answerId=" + answerId + ", answer=" + answer + "]";
    }

}
