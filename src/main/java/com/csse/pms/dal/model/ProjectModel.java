package com.csse.pms.dal.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

/**
 * @author Chandrasiri S.A.N.L.D.
 *
 * This Class for Project related implementation
 */

@Document
public class ProjectModel {

    @Id
    private String id;
    private String projectName;
    private String description;
    private double budget;
    private String managerId;
    private String siteId;
    private LocalDateTime createDateTime;

    public ProjectModel() {
    }

    public ProjectModel(String id, String projectName, String description, double budget, String managerId, String siteId, LocalDateTime createDateTime) {
        this.id = id;
        this.projectName = projectName;
        this.description = description;
        this.budget = budget;
        this.managerId = managerId;
        this.siteId = siteId;
        this.createDateTime = createDateTime;
    }

    @Override
    public String toString() {
        return "ProjectModel{" +
                "id='" + id + '\'' +
                ", projectName='" + projectName + '\'' +
                ", description='" + description + '\'' +
                ", budget=" + budget +
                ", managerId='" + managerId + '\'' +
                ", siteId='" + siteId + '\'' +
                ", createDateTime=" + createDateTime +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }
}
