package com.example.Entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Questions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int questionId;
    private String q1;
    private String q2;

    @ManyToMany             // don't use mappedBy in the owning side
    @JoinTable(                 // JoinTable is used in the owning side
    name = "question_answer",
    joinColumns = @JoinColumn(name = "question_id")
    , inverseJoinColumns = @JoinColumn(name = "answer_id"))

    private List<Answers> answers;

    public List<Answers> getAnswers() {
        return answers;
    }
    public void setAnswers(List<Answers> answers) {
        this.answers = answers;
    }

    public int getQuestionId() {
        return questionId;
    }
    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }
    public String getQ1() {
        return q1;
    }
    public void setQ1(String q1) {
        this.q1 = q1;
    }
    public String getQ2() {
        return q2;
    }
    public void setQ2(String q2) {
        this.q2 = q2;
    }


    @Override
    public String toString() {
        return "Questions [questionId=" + questionId + ", q1=" + q1 + ", q2=" + q2 + ", answers=" + answers + "]";
    }

}

