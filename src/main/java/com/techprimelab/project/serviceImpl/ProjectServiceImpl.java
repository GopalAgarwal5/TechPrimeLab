package com.techprimelab.project.serviceImpl;

import com.techprimelab.project.dto.DepartmentCount;
import com.techprimelab.project.dto.ProjectRes;
import com.techprimelab.project.dto.StatusCount;
import com.techprimelab.project.dto.StatusUpdateReq;
import com.techprimelab.project.entity.Project;
import com.techprimelab.project.repository.ProjectRepository;
import com.techprimelab.project.service.ProjectService;
import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Optional<Project> findById(int id) {
        return projectRepository.findById(id);
    }

    @Override
    public void deleteById(int id) {
        projectRepository.deleteById(id);
    }

    @Override
    public StatusCount getStatusCount() {
        return projectRepository.statusCount();
    }

    @Override
    public List<DepartmentCount> getDepartmentCount() {
        return projectRepository.departmentCount();
    }

    @Override
    public ProjectRes updateProjectById(StatusUpdateReq req) {
        return projectRepository.updateProjectById(req.getId(), req.getStatus());
    }
}
