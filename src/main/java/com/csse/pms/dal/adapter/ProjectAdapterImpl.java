package com.csse.pms.dal.adapter;

import com.csse.pms.dal.model.ProjectModel;
import com.csse.pms.dal.repository.ProjectRepository;
import com.csse.pms.domain.Project;
import com.csse.pms.domain.ProjectDataAdapter;
import com.csse.pms.dto.MessageResponseDto;
import com.csse.pms.util.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Chandrasiri S.A.N.L.D.
 *
 * This Class for Project related implementation
 */

@Component
public class ProjectAdapterImpl implements ProjectDataAdapter {

    /**
     * Initialize Logger
     */
    public static final Logger LOGGER = Logger.getLogger(ProjectAdapterImpl.class.getName());

    private final ProjectRepository repository;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public ProjectAdapterImpl(ProjectRepository repository, MongoTemplate mongoTemplate) {
        this.repository = repository;
        this.mongoTemplate = mongoTemplate;
    }

    /**
     * This Method gets parameter as project object and assign to new project-model object.
     * Then project model object save in project collection in MongoDB Cluster database.
     *
     * @param project - project object from ProjectApi class.
     * @return ResponseEntity<?> - Customized message will be return.
     * @throws Exception - Common Exception to be handled.
     * @see #createProject(Project)
     */
    @Override
    public ResponseEntity<?> createProject(Project project) {
        ProjectModel projectModel = new ProjectModel();

        try {
            projectModel.setProjectName(project.getProjectName());
            projectModel.setDescription(project.getDescription());
            projectModel.setBudget(project.getBudget());
            projectModel.setManagerId(project.getManagerId());
            projectModel.setSiteId(project.getSiteId());
            projectModel.setCreateDateTime(project.getCreateDateTime());

            projectModel = repository.save(projectModel);
            LOGGER.log(Level.INFO, projectModel.toString());

            return ResponseEntity.ok(new MessageResponseDto(CommonConstants.PROJECT_CREATE_SUCCESSFULLY));
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            return ResponseEntity.ok(new MessageResponseDto(CommonConstants.PROJECT_CREATE_ERROR));
        }
    }

    /**
     * This Method gets all projects saved in project collection in MongoDB Cluster database.
     * Then assign to project model list object.
     * Then using for loop assign to project list object.
     *
     * @return List<Project> - All founded projects will be return as project list object.
     * @throws Exception - Common Exception to be handled.
     * @see #getAllProjects()
     */
    @Override
    public List<Project> getAllProjects() {
        List<Project> projects = new ArrayList<>();

        try {
            List<ProjectModel> projectModels = repository.findAll();

            for (ProjectModel projectModel : projectModels) {
                Project project = new Project();

                project.setId(projectModel.getId());
                project.setProjectName(projectModel.getProjectName());
                project.setDescription(projectModel.getDescription());
                project.setBudget(projectModel.getBudget());
                project.setManagerId(projectModel.getManagerId());
                project.setSiteId(projectModel.getSiteId());
                project.setCreateDateTime(projectModel.getCreateDateTime());

                projects.add(project);
            }
            return projects;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            return projects;
        }
    }

    /**
     * This Method gets parameter as String id.
     * Then find the project using the id of project saved in project collection in MongoDB Cluster database.
     * Then founded project assign to project model object.
     * Then using for loop assign to project object.
     *
     * @param id - Relevant project id from ProjectApi class.
     * @return Project - Founded project will be return as project object.
     * @throws NoSuchElementException - If method cannot find the relevant project from database this will throw.
     * @see #getProjectById(String)
     */
    @Override
    public Project getProjectById(String id) {
        ProjectModel projectModel;
        Project project = new Project();

        try {
            projectModel = repository.findById(id).get();

            project.setId(projectModel.getId());
            project.setProjectName(projectModel.getProjectName());
            project.setDescription(projectModel.getDescription());
            project.setBudget(projectModel.getBudget());
            project.setManagerId(projectModel.getManagerId());
            project.setSiteId(projectModel.getSiteId());
            project.setCreateDateTime(projectModel.getCreateDateTime());

            return project;
        } catch (NoSuchElementException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            return project;
        }
    }

    /**
     * This Method gets parameter as String site-id.
     * Then find the project using the site-id of project saved in project collection in MongoDB Cluster database.
     * Then founded project assign to project model list object.
     * Then using for loop assign to project list object.
     *
     * @param siteId - Relevant project site-id from ProjectApi class.
     * @return List<Project> - Founded projects will be return as project list object.
     * @throws Exception - If method cannot find the relevant project from database this will throw.
     * @see #getProjectBySite(String)
     */
    @Override
    public List<Project> getProjectBySite(String siteId) {
        List<Project> projects = new ArrayList<>();

        try {
            List<ProjectModel> projectModels = repository.findBySiteId(siteId);

            for (ProjectModel projectModel : projectModels) {
                Project project = new Project();

                project.setId(projectModel.getId());
                project.setProjectName(projectModel.getProjectName());
                project.setDescription(projectModel.getDescription());
                project.setBudget(projectModel.getBudget());
                project.setManagerId(projectModel.getManagerId());
                project.setSiteId(projectModel.getSiteId());
                project.setCreateDateTime(projectModel.getCreateDateTime());

                projects.add(project);
            }
            return projects;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            return projects;
        }
    }

    /**
     * This Method gets parameter as String manager-id.
     * Then find the project using the manager-id of project saved in project collection in MongoDB Cluster database.
     * Then founded project assign to project model list object.
     * Then using for loop assign to project list object.
     *
     * @param managerId - Relevant project manager-id from ProjectApi class.
     * @return List<Project> - Founded projects will be return as project list object.
     * @throws Exception - If method cannot find the relevant project from database this will throw.
     * @see #getProjectByManagerId(String)
     */
    @Override
    public List<Project> getProjectByManagerId(String managerId) {
        List<Project> projects = new ArrayList<>();

        try {
            List<ProjectModel> projectModels = repository.findByManagerId(managerId);

            for (ProjectModel projectModel : projectModels) {
                Project project = new Project();

                project.setId(projectModel.getId());
                project.setProjectName(projectModel.getProjectName());
                project.setDescription(projectModel.getDescription());
                project.setBudget(projectModel.getBudget());
                project.setManagerId(projectModel.getManagerId());
                project.setSiteId(projectModel.getSiteId());
                project.setCreateDateTime(projectModel.getCreateDateTime());

                projects.add(project);
            }
            return projects;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            return projects;
        }
    }

    /**
     * This Method gets parameter as String project id.
     * Then find the project using the id of project saved in project collection in MongoDB Cluster database.
     * Then delete project using id saved in project collection in MongoDB Cluster database.
     *
     * @param id - Relevant project id from ProjectApi class.
     * @return ResponseEntity<?> - Customized message will be return.
     * @throws NoSuchElementException - If method cannot find the relevant projects or delete project
     *                                from database this will throw.
     * @see #deleteProjectById(String)
     */
    @Override
    public ResponseEntity<?> deleteProjectById(String id) {
        ProjectModel projectModel = null;

        try {
            projectModel = repository.findById(id).get();
            if (projectModel != null) {
                repository.deleteById(id);
                return ResponseEntity.ok(new MessageResponseDto(CommonConstants.PROJECT_DELETE_SUCCESSFULLY));
            } else {
                return ResponseEntity.ok(new MessageResponseDto(CommonConstants.PROJECT_DOES_NOT_EXIST));
            }
        } catch (NoSuchElementException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            return ResponseEntity.ok(new MessageResponseDto(CommonConstants.PROJECT_DELETE_ERROR));
        }
    }

    /**
     * This Method gets parameter as project object.
     * Then find the project using the id of project saved in project collection in MongoDB Cluster database.
     * Then update project using id saved in project collection in MongoDB Cluster database.
     *
     * @param project - Relevant project object from ProjectApi class.
     * @return ResponseEntity<?> - Customized message will be return.
     * @throws Exception - If method cannot find the relevant project from database this will throw.
     * @see #updateProject(Project)
     */
    @Override
    public ResponseEntity<?> updateProject(Project project) {
        try {
            ProjectModel projectModel = mongoTemplate.findAndModify(
                    Query.query(Criteria.where(CommonConstants.ID).is(project.getId())),
                    new Update()
                            .set(CommonConstants.PROJECT_NAME, project.getProjectName())
                            .set(CommonConstants.DESCRIPTION, project.getDescription())
                            .set(CommonConstants.BUDGET, project.getBudget())
                            .set(CommonConstants.MANAGER_ID, project.getManagerId())
                            .set(CommonConstants.SITE_ID, project.getSiteId())
                            .set(CommonConstants.CREATE_DATE_TIME, project.getCreateDateTime()),
                    ProjectModel.class
            );

            if (projectModel != null) {
                return ResponseEntity.ok(new MessageResponseDto(CommonConstants.PROJECT_UPDATE_SUCCESSFULLY));
            } else {
                return ResponseEntity.ok(new MessageResponseDto(CommonConstants.PROJECT_DOES_NOT_EXIST));
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            return ResponseEntity.ok(new MessageResponseDto(CommonConstants.PROJECT_UPDATE_ERROR));
        }
    }
}
