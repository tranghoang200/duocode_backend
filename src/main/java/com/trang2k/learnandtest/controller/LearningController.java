package com.trang2k.learnandtest.controller;

import com.trang2k.learnandtest.entities.Answers;
import com.trang2k.learnandtest.entities.Courses;
import com.trang2k.learnandtest.entities.Modules;
import com.trang2k.learnandtest.entities.Questions;
import com.trang2k.learnandtest.service.AnswersService;
import com.trang2k.learnandtest.service.CoursesService;
import com.trang2k.learnandtest.service.ModulesService;
import com.trang2k.learnandtest.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cli")
public class LearningController {

    @Autowired
    private CoursesService coursesService;
    @Autowired
    private QuestionsService questionsService;
    @Autowired
    private AnswersService answersService;
    @Autowired
    private ModulesService modulesService;

    @GetMapping("/courses/get_all")
    public List<Courses> getAllCourse() {
        return coursesService.getAll();
    }

    @GetMapping("/courses/{id}")
    public Courses findCourseById(@PathVariable Integer id) {
        return coursesService.findById(id);
    }

    @GetMapping("/courses/{id}/{level}")
    public List<Questions> findCourseById(@PathVariable Integer id, @PathVariable  Integer level) {
        return coursesService.getRandomQuestionsWithLevel(id, level);
    }

    @GetMapping("/modules/get_all")
    public List<Modules> getAll() {
        return modulesService.getAll();
    }

    @GetMapping("/modules/{id}")
    public Modules findModulesById(@PathVariable Integer id) {
        return modulesService.findModulesById(id);
    }

    @GetMapping("/questions/get_all")
    public List<Questions> getAllQuestion() {
        return questionsService.getAll();
    }

    @GetMapping("/questions/{id}")
    public Questions findQuestionById(@PathVariable Integer id) {
        return questionsService.findQuestionById(id);
    }

    @GetMapping("/answers/get_all")
    public List<Answers> getAllAnswer() {
        return answersService.getAll();
    }

    @GetMapping("/answers/{id}")
    public Answers findAnswerById(@PathVariable Integer id) {
        return answersService.findAnswerById(id);
    }
}
