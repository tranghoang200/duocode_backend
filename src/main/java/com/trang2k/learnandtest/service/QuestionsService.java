package com.trang2k.learnandtest.service;

import com.trang2k.learnandtest.entities.Courses;
import com.trang2k.learnandtest.entities.Questions;
import com.trang2k.learnandtest.repositories.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionsService {

    @Autowired
    private QuestionsRepository questionsRepository;

    public List<Questions> getAll() {
        return questionsRepository.findAllByStatus(1);
    }

    public Questions findQuestionById(Integer id) {
        return questionsRepository.findQuestionById(id);
    }

    public List<Questions> findQuestionsByLevel(Integer level) {
        return questionsRepository.findQuestionsByLevel(level);
    }

    public Boolean existsById(Integer id) {
        return questionsRepository.existsById(id);
    }

    public Boolean existsCourseByIdAndStatus(Integer id, Integer status) {
        return questionsRepository.existsCourseByIdAndStatus(id, status);
    }

    public Questions save(Questions question) {
        return questionsRepository.save(question);
    }

    public void update(Questions question) {
        questionsRepository.save(question);
    }

    public void delete(Questions question) {
        questionsRepository.delete(question);
    }
}
