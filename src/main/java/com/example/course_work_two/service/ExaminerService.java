package com.example.course_work_two.service;

import com.example.course_work_two.data.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}
