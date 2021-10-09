package com.csse.pms.dal.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class SiteModel {

    @Id
    private String id;
    private String siteName;
    private String location;
    private String siteManager;

    public SiteModel() {
    }

    public SiteModel(String id, String siteName, String location, String siteManager) {
        this.id = id;
        this.siteName = siteName;
        this.location = location;
        this.siteManager = siteManager;
    }

    @Override
    public String toString() {
        return "SiteModel{" +
                "id='" + id + '\'' +
                ", siteName='" + siteName + '\'' +
                ", location='" + location + '\'' +
                ", siteManager='" + siteManager + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSiteManager() {
        return siteManager;
    }

    public void setSiteManager(String siteManager) {
        this.siteManager = siteManager;
    }
}
