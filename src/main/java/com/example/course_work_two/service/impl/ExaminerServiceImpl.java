package com.example.course_work_two.service.impl;

import com.example.course_work_two.data.Question;
import com.example.course_work_two.exception.NumberOfRequestsExceededException;
import com.example.course_work_two.service.ExaminerService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ExaminerServiceImpl implements ExaminerService {
    private final Random random = new Random();
    private final JavaQuestionService questionService;

    public ExaminerServiceImpl(JavaQuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> examQuestions = new HashSet<>();
        if (amount > questionService.getAll().size() || amount <= 0) {
            throw new NumberOfRequestsExceededException("Неверное количество запросов");
        }
        while (examQuestions.size() < amount) {
            examQuestions.add(questionService.getRandomQuestion());
        }
        return examQuestions;
    }
}
