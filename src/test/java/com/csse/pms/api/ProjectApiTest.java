package com.csse.pms.api;

import com.csse.pms.domain.Project;
import com.csse.pms.domain.ProjectDataAdapter;
import com.csse.pms.util.TestCommonConstants;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProjectApiTest {
    private final ProjectDataAdapter adapter;
    private Project project;
    private Project projectUpdate;
    private Project resultCreate;
    private Project resultGetByID;
    private String deleteResult;
    private String updateResult;

    @Autowired
    ProjectApiTest(ProjectDataAdapter adapter) {
        this.adapter = adapter;
        project = new Project();
        projectUpdate = new Project();
        resultCreate = new Project();
        resultGetByID = new Project();
        deleteResult = "";
        updateResult = "";
    }

    @Test
    @Order(1)
    void createModifyDeleteProject() {
        // Create Project
        project.setProjectName(TestCommonConstants.PROJECT_NAME);
        project.setDescription(TestCommonConstants.DESCRIPTION);
        project.setBudget(TestCommonConstants.BUDGET);
        project.setManagerId(TestCommonConstants.MANAGER_ID);
        project.setSiteId(TestCommonConstants.SITE_ID);
        project.setCreateDateTime(LocalDateTime.now());
        resultCreate = adapter.createProject(project);

        // Get Project By id
        resultGetByID = adapter.getProjectById(resultCreate.getId());
        assertEquals(resultCreate.getProjectName(), resultGetByID.getProjectName());
        assertEquals(resultCreate.getDescription(), resultGetByID.getDescription());
        assertEquals(resultCreate.getBudget(), resultGetByID.getBudget());
        assertEquals(resultCreate.getManagerId(), resultGetByID.getManagerId());
        assertEquals(resultCreate.getSiteId(), resultGetByID.getSiteId());

        // Update Project
        projectUpdate.setId(resultCreate.getId());
        projectUpdate.setProjectName(TestCommonConstants.PROJECT_NAME_TWO);
        projectUpdate.setDescription(TestCommonConstants.DESCRIPTION_TWO);
        projectUpdate.setBudget(TestCommonConstants.BUDGET_TWO);
        projectUpdate.setManagerId(TestCommonConstants.MANAGER_ID_TWO);
        projectUpdate.setSiteId(TestCommonConstants.SITE_ID_TWO);
        projectUpdate.setCreateDateTime(LocalDateTime.now());
        updateResult = adapter.updateProject(projectUpdate);
        assertEquals(updateResult, TestCommonConstants.PROJECT_STATUS_UPDATE);

        // Delete Project
        deleteResult = adapter.deleteProjectById(resultCreate.getId());
        assertEquals(deleteResult, TestCommonConstants.PROJECT_STATUS_DELETE);
    }

    @Test
    @Order(2)
    void getAllProjects() {
        List<Project> result2 = adapter.getAllProjects();
        assertTrue(result2.size() > 2);
    }
}