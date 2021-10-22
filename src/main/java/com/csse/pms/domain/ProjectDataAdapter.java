package com.csse.pms.domain;

import org.springframework.http.ResponseEntity;
import java.util.List;

/**
 * @author Chandrasiri S.A.N.L.D.
 *
 * This Interface for Project related implementation
 */

public interface ProjectDataAdapter {

    Project createProject(Project project);

    List<Project> getAllProjects();

    Project getProjectById(String id);

    List<Project> getProjectBySite(String siteId);

    List<Project> getProjectByManagerId(String managerId);

    String deleteProjectById(String id);

    String updateProject(Project project);
}
