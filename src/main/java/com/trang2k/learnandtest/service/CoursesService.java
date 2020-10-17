package com.trang2k.learnandtest.service;

import com.trang2k.learnandtest.entities.Courses;
import com.trang2k.learnandtest.entities.Questions;
import com.trang2k.learnandtest.repositories.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CoursesService {

    @Autowired
    private CoursesRepository coursesRepository;

    public List<Courses> getAll() {
        return coursesRepository.findAllByStatus(1);
    }

    public Courses findById(Integer id) {
        return coursesRepository.findCoursesById(id);
    }

    public List<Questions> getRandomQuestions(Integer id) {
        Courses courses = findById(id);
        List<Questions> list = courses.getQuestionsById();
        List<Questions> randomList = new ArrayList<>();
        SecureRandom rand = new SecureRandom();
        for (int i = 0; i < Math.min(10, list.size()); i++) {
            randomList.add( list.remove( rand.nextInt( list.size() ) ));
        }

        return randomList;
    }

    public List<Questions> getRandomQuestionsWithLevel(Integer id, Integer level) {
        Courses courses = findById(id);
        List<Questions> list = courses.getQuestionsById();
        CollectionUtils.filter(list, q -> ((Questions) q).getLevel() == level);
        List<Questions> randomList = new ArrayList<>();
        SecureRandom rand = new SecureRandom();
        for (int i = 0; i < Math.min(10, list.size()); i++) {
            randomList.add( list.remove( rand.nextInt( list.size() ) ));
        }

        return randomList;
    }

    public Boolean existsById(Integer id) {
        return coursesRepository.existsById(id);
    }

    public Boolean existsCourseByIdAndStatus(Integer id, Integer status) {
        return coursesRepository.existsCourseByIdAndStatus(id, status);
    }

    public Courses save(Courses course) {
        return coursesRepository.save(course);
    }

    public void update(Courses course) {
        coursesRepository.save(course);
    }

    public void delete(Courses course) {
        coursesRepository.delete(course);
    }
}
