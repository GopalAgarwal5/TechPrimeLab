package com.techprimelab.project.service;

import com.techprimelab.project.entity.Project;

import java.util.List;

public interface ProjectService {

    Project save(Project project);

    List<Project> findAll();

    Project findById(int id);

    void deleteById(int id);
}
