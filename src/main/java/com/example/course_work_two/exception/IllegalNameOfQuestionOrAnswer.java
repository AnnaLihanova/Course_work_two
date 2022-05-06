package com.example.course_work_two.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IllegalNameOfQuestionOrAnswer extends RuntimeException{
        public IllegalNameOfQuestionOrAnswer (String massage) {
            super(massage);
        }
}
