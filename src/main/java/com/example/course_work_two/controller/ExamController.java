package com.example.course_work_two.controller;

import com.example.course_work_two.data.Question;
import com.example.course_work_two.service.ExaminerService;
import com.example.course_work_two.service.impl.ExaminerServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {
    ExaminerService examinerService;

    //уточнить запись
    @GetMapping(path = "/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount) {
        return examinerService.getQuestions(amount);
    }

}