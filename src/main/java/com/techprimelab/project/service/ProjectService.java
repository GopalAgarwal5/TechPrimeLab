package com.techprimelab.project.service;

import com.techprimelab.project.dto.DepartmentCount;
import com.techprimelab.project.dto.ProjectRes;
import com.techprimelab.project.dto.StatusCount;
import com.techprimelab.project.dto.StatusUpdateReq;
import com.techprimelab.project.entity.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {

    Project save(Project project);

    List<Project> findAll();

    Optional<Project> findById(int id);

    void deleteById(int id);

    StatusCount getStatusCount();

    List<DepartmentCount> getDepartmentCount();

    ProjectRes updateProjectById(StatusUpdateReq req);

}
