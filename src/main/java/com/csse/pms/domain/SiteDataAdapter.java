package com.csse.pms.domain;


import com.csse.pms.dal.model.SiteModel;

import java.util.List;

public interface SiteDataAdapter {

    String createSite(SiteModel site);

    List<SiteModel> getAllSites();

    SiteModel getSiteById(String id);

    String deleteSiteById(String id);

    String updateSite(SiteModel site);
}
