package com.example.course_work_two.controller;

import com.example.course_work_two.data.Question;
import com.example.course_work_two.service.QuestionService;
import com.example.course_work_two.service.impl.JavaQuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class JavaQuestionController {

    QuestionService service;

    public JavaQuestionController(QuestionService service) {
        this.service = service;
    }

    @GetMapping(path = "/java/add")
    public Question addQuestion(@RequestParam("question") String question,
                                @RequestParam("answer") String answer) {
        return service.add(question, answer);
    }
    @GetMapping(path = "/java/remove")
    public Question removeQuestion(@RequestParam("question") String question,
                                @RequestParam("answer") String answer) {
        Question removeQuestion = new Question(question, answer);
        return service.remove(removeQuestion);
    }

    @GetMapping(path = "/java")
    public Collection<Question> getAllQuestions() {
        return service.getAll();
    }

}
