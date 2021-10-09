package com.csse.pms.controller;

import com.csse.pms.api.ProjectApi;
import com.csse.pms.domain.Project;
import com.csse.pms.dto.ProjectDto;
import com.csse.pms.util.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Chandrasiri S.A.N.L.D.
 *
 * This Class for Project related implementation
 */

@RestController
@RequestMapping(CommonConstants.PROJECT_REQUEST_MAPPING)
@CrossOrigin(origins = CommonConstants.STAR, allowedHeaders = CommonConstants.STAR, exposedHeaders = CommonConstants.STAR)
public class ProjectController {

    private ProjectApi projectApi;

    @Autowired
    public ProjectController(ProjectApi projectApi) {
        this.projectApi = projectApi;
    }

    @PostMapping(CommonConstants.POST_MAPPING_SAVE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createProject(@RequestBody ProjectDto projectDto) {
        Project project = new Project();

        project.setProjectName(projectDto.getProjectName());
        project.setDescription(projectDto.getDescription());
        project.setBudget(projectDto.getBudget());
        project.setManagerId(projectDto.getManagerId());
        project.setSiteId(projectDto.getSiteId());
        project.setCreateDateTime(LocalDateTime.now());

        return projectApi.createProject(project);
    }

    @GetMapping(CommonConstants.GET_MAPPING_GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Project> getAllProjects() {
        return projectApi.getAllProjects();
    }

    @GetMapping(CommonConstants.GET_MAPPING_GET_BY_ID)
    @ResponseStatus(HttpStatus.OK)
    public Project getProjectById(@PathVariable String id) {
        return projectApi.getProjectById(id);
    }

    @GetMapping(CommonConstants.GET_MAPPING_GET_BY_SITE_ID)
    @ResponseStatus(HttpStatus.OK)
    public List<Project> getProjectBySite(@PathVariable String id) {
        return projectApi.getProjectBySite(id);
    }

    @GetMapping(CommonConstants.GET_MAPPING_GET_BY_MANAGER_ID)
    @ResponseStatus(HttpStatus.OK)
    public List<Project> getProjectByManagerId(@PathVariable String id) {
        return projectApi.getProjectByManagerId(id);
    }

    @DeleteMapping(CommonConstants.DELETE_MAPPING_DELETE_BY_ID)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteProjectById(@PathVariable String id) {
        return projectApi.deleteProjectById(id);
    }

    @PutMapping(CommonConstants.PUT_MAPPING_UPDATE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> updateProject(@RequestBody ProjectDto projectDto) {
        Project project = new Project();

        project.setId(projectDto.getId());
        project.setProjectName(projectDto.getProjectName());
        project.setDescription(projectDto.getDescription());
        project.setBudget(projectDto.getBudget());
        project.setManagerId(projectDto.getManagerId());
        project.setSiteId(projectDto.getSiteId());
        project.setCreateDateTime(LocalDateTime.now());

        return projectApi.updateProject(project);
    }
}
