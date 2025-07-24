package com.example.app;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.example.Entity.Answers;
import com.example.Entity.Questions;
import com.example.Utility.HibernateUtility;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // Create and save Questions
        Questions question1 = new Questions();
        question1.setQ1("Where do you live?");

        Questions question2 = new Questions();
        question2.setQ1("What is your Current Location?");

        Answers answer1 = new Answers();
        answer1.setAnswerT("New York");

        Answers answer2 = new Answers();
        answer2.setAnswerT("California");

        
        List<Answers> aList = Arrays.asList(answer1, answer2);
        
        question1.setAnswers(aList);
        question2.setAnswers(aList);
        
        session.persist(question1);
        session.persist(question2);
        
        session.persist(answer1);
        session.persist(answer2);
        // Establishing Many-to-Many relationship
        

        transaction.commit();
        session.close();
        
    }
}