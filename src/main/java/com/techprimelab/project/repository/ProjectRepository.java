package com.techprimelab.project.repository;

import com.techprimelab.project.dto.DepartmentCount;
import com.techprimelab.project.dto.ProjectRes;
import com.techprimelab.project.dto.StatusCount;
import com.techprimelab.project.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import java.util.List;

@EnableJpaRepositories
public interface ProjectRepository extends JpaRepository<Project, Integer> {

    @Modifying
    @Query("UPDATE Project p SET p.status = :status WHERE p.id = :id")
    ProjectRes updateProjectById(@Param("id") Integer id, @Param("status") String status);


//    @Query("SELECT p.status AS status, COUNT(p.id) AS count FROM Project p GROUP BY p.status")
//    List<StatusCount> statusCount();
//
//    @Query("SELECT p.department AS department, SUM(CASE WHEN p.status = 'Closed' THEN 1 ELSE 0 END) AS closerCount, COUNT(p.id) AS totalCount FROM Project p GROUP BY p.department")
//    List<DepartmentCount> departmentCount();


//    @Query("SELECT new com.techprimelab.project.dto.StatusCount(p.status, COUNT(p.id)) FROM Project p GROUP BY p.status")
    @Query("SELECT new com.techprimelab.project.dto.StatusCount(" +
            "COUNT(p.id)," +
            "SUM(CASE WHEN p.status = 'Closed' THEN 1 ELSE 0 END)," +
            "SUM(CASE WHEN p.status = 'Running' THEN 1 ELSE 0 END)," +
            "SUM(CASE WHEN p.status = 'Cancelled' THEN 1 ELSE 0 END)," +
            "SUM(CASE WHEN p.endDate < CURDATE() THEN 1 ELSE 0 END)) " +
            "FROM Project p")
    StatusCount statusCount();

    @Query("SELECT new com.techprimelab.project.dto.DepartmentCount(p.department, SUM(CASE WHEN p.status = 'Closed' THEN 1 ELSE 0 END), COUNT(p.id)) FROM Project p GROUP BY p.department")
    List<DepartmentCount> departmentCount();

}