package com.trang2k.learnandtest.repositories;

import com.trang2k.learnandtest.entities.Modules;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ModulesRepository extends PagingAndSortingRepository<Modules, Integer> {

    List<Modules> findAllByStatus(Integer status);

    Modules findModuleById(Integer id);

    Boolean existsCourseByIdAndStatus(Integer id, Integer status);
}
