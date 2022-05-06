package com.example.course_work_two.service.impl;

import com.example.course_work_two.data.Question;

import java.util.Collection;
import java.util.Set;

public class ConstantsTest {
    public static final String FIRST_QUESTION = "question 1";
    public static final String SECOND_QUESTION = "question 2";
    public static final String THIRD_QUESTION = "question 3";
    public static final String BAD_QUESTION = "question";

    public static final String FIRST_ANSWER = "answer 1";
    public static final String SECOND_ANSWER = "answer 2";
    public static final String THIRD_ANSWER = "answer 3";
    public static final String BAD_ANSWER = "question";

    public static final Question QUESTION_ANSWER_1 = new Question(FIRST_QUESTION, FIRST_ANSWER);
    public static final Question QUESTION_ANSWER_2 = new Question(SECOND_QUESTION, SECOND_ANSWER);
    public static final Question QUESTION_ANSWER_3 = new Question(THIRD_QUESTION, THIRD_ANSWER);
    public static final Question QUESTION_ANSWER_BAD = new Question(BAD_QUESTION, BAD_ANSWER);

    public static final Set<Question> QUESTIONS = Set.of(QUESTION_ANSWER_1, QUESTION_ANSWER_2, QUESTION_ANSWER_3);
    public static final Collection<Question> QUESTIONS_1 = Set.of(QUESTION_ANSWER_1);

}
