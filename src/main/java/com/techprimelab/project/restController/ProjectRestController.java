package com.techprimelab.project.restController;

import com.techprimelab.project.dto.DepartmentCount;
import com.techprimelab.project.dto.ProjectRes;
import com.techprimelab.project.dto.StatusCount;
import com.techprimelab.project.dto.StatusUpdateReq;
import com.techprimelab.project.entity.Project;
import com.techprimelab.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectRestController {

    private final ProjectService projectService;

    @Autowired
    public ProjectRestController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/save")
    public ResponseEntity<Project> save(@RequestBody Project projectReq) {
        return ResponseEntity.ok(projectService.save(projectReq));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Project>> findAll() {
        return ResponseEntity.ok(projectService.findAll());
    }

    @PutMapping("/update-status")
    public ResponseEntity<ProjectRes> update(@RequestBody StatusUpdateReq req) {
        return ResponseEntity.ok(projectService.updateProjectById(req));
    }

    @GetMapping("/status-count")
    public ResponseEntity<StatusCount> statusCount() {
        return ResponseEntity.ok(projectService.getStatusCount());
    }

    @GetMapping("/chart")
    public ResponseEntity<List<DepartmentCount>> chart() {
        return ResponseEntity.ok(projectService.getDepartmentCount());
    }
}
