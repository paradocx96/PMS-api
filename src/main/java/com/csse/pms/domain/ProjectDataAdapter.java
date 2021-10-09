package com.csse.pms.domain;

import org.springframework.http.ResponseEntity;
import java.util.List;

/**
 * @author Chandrasiri S.A.N.L.D.
 *
 * This Interface for Project related implementation
 */

public interface ProjectDataAdapter {

    ResponseEntity<?> createProject(Project project);

    List<Project> getAllProjects();

    Project getProjectById(String id);

    List<Project> getProjectBySite(String siteId);

    List<Project> getProjectByManagerId(String managerId);

    ResponseEntity<?> deleteProjectById(String id);

    ResponseEntity<?> updateProject(Project project);
}
