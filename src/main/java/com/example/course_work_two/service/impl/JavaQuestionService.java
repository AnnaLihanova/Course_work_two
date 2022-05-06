package com.example.course_work_two.service.impl;

import com.example.course_work_two.data.Question;
import com.example.course_work_two.exception.IllegalNameOfQuestionOrAnswer;
import com.example.course_work_two.exception.QuestionNotFoundException;
import com.example.course_work_two.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions = new HashSet<>();
    private final Random random = new Random();

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        if (question.equals(answer)) {
            throw new IllegalNameOfQuestionOrAnswer("Вопрос и ответ совпадают");
        }
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.contains(question)) {
            throw new QuestionNotFoundException("Question not found");
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.size() == 0) {
            throw new QuestionNotFoundException("List is empty");
        }
        int i = random.nextInt(questions.size());
        return List.copyOf(questions).get(i);
    }
}
