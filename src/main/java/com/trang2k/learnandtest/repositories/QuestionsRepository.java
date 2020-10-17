package com.trang2k.learnandtest.repositories;

import com.trang2k.learnandtest.entities.Courses;
import com.trang2k.learnandtest.entities.Questions;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionsRepository extends PagingAndSortingRepository<Questions, Integer> {

    List<Questions> findAllByStatus(Integer status);

    Questions findQuestionById(Integer id);

    Boolean existsCourseByIdAndStatus(Integer id, Integer status);

    List<Questions> findQuestionsByLevel(Integer level);


}
