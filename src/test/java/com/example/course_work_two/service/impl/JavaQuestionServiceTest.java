package com.example.course_work_two.service.impl;

import com.example.course_work_two.data.Question;
import com.example.course_work_two.exception.IllegalNameOfQuestionOrAnswer;
import com.example.course_work_two.exception.QuestionNotFoundException;
import org.junit.jupiter.api.Test;

import static com.example.course_work_two.service.impl.ConstantsTest.*;
import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    private JavaQuestionService out = new JavaQuestionService();

    @Test
    void shouldAddQuestion() {
        Question expected = new Question(FIRST_QUESTION, FIRST_ANSWER);
        assertEquals(expected, out.add(FIRST_QUESTION, FIRST_ANSWER));
        assertEquals(1, out.getAll().size());
        assertTrue(out.getAll().contains(expected));
    }

    @Test
    void shouldAnswerAndQuestionNotTheSame() {
        assertThrows(IllegalNameOfQuestionOrAnswer.class, () -> out.add(BAD_QUESTION, BAD_ANSWER));
    }

    @Test
    void shouldAddQuestion2() {
        Question expected = new Question(FIRST_QUESTION, FIRST_ANSWER);
        assertEquals(expected, out.add(QUESTION_ANSWER_1));
        assertEquals(1, out.getAll().size());
        assertTrue(out.getAll().contains(expected));
    }

    @Test
    void shouldRemoveQuestion() {
        Question expected = new Question(FIRST_QUESTION, FIRST_ANSWER);
        out.add(expected);
        assertEquals(1, out.getAll().size());
        assertTrue(out.getAll().contains(expected));
        assertEquals(expected, out.remove(QUESTION_ANSWER_1));
        assertEquals(0, out.getAll().size());
    }

    @Test
    void shouldRemoveQuestionNotExist() {
        assertThrows(QuestionNotFoundException.class, () -> out.remove(QUESTION_ANSWER_1));
    }

    @Test
    void shouldGetAll() {
        out.add(QUESTION_ANSWER_1);
        out.add(QUESTION_ANSWER_2);
        out.add(QUESTION_ANSWER_3);
        assertEquals(QUESTIONS, out.getAll());
    }

    @Test
    void shouldGetRandomQuestion() {
        out.add(QUESTION_ANSWER_1);
        assertEquals(QUESTION_ANSWER_1, out.getRandomQuestion());
    }

    @Test
    void shouldListIsEmpty() {
        assertThrows(QuestionNotFoundException.class, () -> out.getRandomQuestion());
    }
}