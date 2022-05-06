package com.example.course_work_two.service.impl;

import com.example.course_work_two.exception.NumberOfRequestsExceededException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.course_work_two.service.impl.ConstantsTest.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl out;

    @Test
    void shouldGetQuestions() {
        when(questionService.getAll()).thenReturn(QUESTIONS_1);
        when(questionService.getRandomQuestion()).thenReturn(QUESTION_ANSWER_1);
        assertEquals(QUESTIONS_1, out.getQuestions(1));
    }
    @Test
    void shouldGetQuestionsWhenNumberOfRequestsExceeded() {
        when(questionService.getAll()).thenReturn(QUESTIONS_1);
        assertThrows(NumberOfRequestsExceededException.class, () -> out.getQuestions(3));
    }
}