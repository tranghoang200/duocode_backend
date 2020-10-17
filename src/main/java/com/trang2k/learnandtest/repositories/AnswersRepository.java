package com.trang2k.learnandtest.repositories;

import com.trang2k.learnandtest.entities.Answers;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswersRepository extends PagingAndSortingRepository<Answers, Integer> {
    List<Answers> findAllByStatus(Integer status);

    Answers findAnswersById(Integer id);

    Boolean existsCourseByIdAndStatus(Integer id, Integer status);
}
