package com.trang2k.learnandtest.service;

import com.trang2k.learnandtest.entities.Modules;
import com.trang2k.learnandtest.repositories.ModulesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModulesService {
    @Autowired
    private ModulesRepository modulesRepository;

    public List<Modules> getAll() {
        return modulesRepository.findAllByStatus(1);
    }

    public Modules findModulesById(Integer id) {
        return modulesRepository.findModuleById(id);
    }

    public Boolean existsById(Integer id) {
        return modulesRepository.existsById(id);
    }

    public Boolean existsCourseByIdAndStatus(Integer id, Integer status) {
        return modulesRepository.existsCourseByIdAndStatus(id, status);
    }

    public Modules save(Modules module) {
        return modulesRepository.save(module);
    }

    public void update(Modules module) {
        modulesRepository.save(module);
    }

    public void delete(Modules module) {
        modulesRepository.delete(module);
    }
}
