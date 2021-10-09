package com.csse.pms.api;

import com.csse.pms.domain.Project;
import com.csse.pms.domain.ProjectDataAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author Chandrasiri S.A.N.L.D.
 *
 * This Class for Project related implementation
 */

@Service
public class ProjectApi {

    private final ProjectDataAdapter projectDataAdapter;

    @Autowired
    public ProjectApi(ProjectDataAdapter projectDataAdapter) {
        this.projectDataAdapter = projectDataAdapter;
    }

    /**
     * This Method gets parameter as project object.
     * Then call create project method in Adapter.
     *
     * @param project - Relevant project object from Controller.
     * @return ResponseEntity<?> - Customized message will be return.
     * @see #createProject(Project)
     */
    public ResponseEntity<?> createProject(Project project) {
        return projectDataAdapter.createProject(project);
    }

    /**
     * This Method call get all project method in Adapter.
     *
     * @return List<Project> - All founded Projects will be return as project list object.
     * @see #getAllProjects()
     */
    public List<Project> getAllProjects() {
        return projectDataAdapter.getAllProjects();
    }

    /**
     * This Method gets parameter as string project-id.
     * Then call get project by id method in Adapter.
     *
     * @param id - Relevant Project id from Controller.
     * @return Project - Founded project will be return as Project object.
     * @see #getProjectById(String)
     */
    public Project getProjectById(String id) {
        return projectDataAdapter.getProjectById(id);
    }

    /**
     * This Method gets parameter as string siteId.
     * Then call get project by site id method in Adapter.
     *
     * @param siteId - Relevant project site-id from Controller.
     * @return List<Project> - Founded project will be return as project list object.
     * @see #getProjectBySite(String)
     */
    public List<Project> getProjectBySite(String siteId) {
        return projectDataAdapter.getProjectBySite(siteId);
    }

    /**
     * This Method gets parameter as string managerId.
     * Then call get project by managerId method in Adapter.
     *
     * @param managerId - Relevant project managerId from Controller.
     * @return List<Project> - Founded project will be return as project list object.
     * @see #getProjectBySite(String)
     */
    public List<Project> getProjectByManagerId(String managerId) {
        return projectDataAdapter.getProjectByManagerId(managerId);
    }

    /**
     * This Method gets parameter as string project-id.
     * Then call delete project by id method in Adapter.
     *
     * @param id - Relevant project-id from Controller.
     * @return ResponseEntity<?> - Customized message will be return.
     * @see #deleteProjectById(String)
     */
    public ResponseEntity<?> deleteProjectById(String id) {
        return projectDataAdapter.deleteProjectById(id);
    }

    /**
     * This Method gets parameter as project object.
     * Then call the update project method in Adapter.
     *
     * @param project - Relevant project object from Controller.
     * @return ResponseEntity<?> - Customized message will be return.
     * @see #updateProject(Project)
     */
    public ResponseEntity<?> updateProject(Project project) {
        return projectDataAdapter.updateProject(project);
    }
}
