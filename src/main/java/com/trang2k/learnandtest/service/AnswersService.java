package com.trang2k.learnandtest.service;

import com.trang2k.learnandtest.entities.Answers;
import com.trang2k.learnandtest.entities.Courses;
import com.trang2k.learnandtest.repositories.AnswersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswersService {
    @Autowired
    private AnswersRepository answersRepository;

    public List<Answers> getAll() {
        return answersRepository.findAllByStatus(1);
    }

    public Answers findAnswerById(Integer id) {
        return answersRepository.findAnswersById(id);
    }

    public Boolean existsById(Integer id) {
        return answersRepository.existsById(id);
    }

    public Boolean existsCourseByIdAndStatus(Integer id, Integer status) {
        return answersRepository.existsCourseByIdAndStatus(id, status);
    }

    public Answers save(Answers answer) {
        return answersRepository.save(answer);
    }

    public void update(Answers answer) {
        answersRepository.save(answer);
    }

    public void delete(Answers answer) {
        answersRepository.delete(answer);
    }
}
