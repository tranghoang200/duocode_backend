package com.trang2k.learnandtest.repositories;

import com.trang2k.learnandtest.entities.Courses;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursesRepository extends PagingAndSortingRepository<Courses, Integer> {
    List<Courses> findAllByStatus(Integer status);

    Courses findCoursesById(Integer id);

    Boolean existsCourseByIdAndStatus(Integer id, Integer status);
}

