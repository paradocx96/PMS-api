package com.csse.pms.dal.repository;

import com.csse.pms.dal.model.SiteModel;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteRepository extends MongoRepository<SiteModel, String> {
	List<SiteModel> findBySiteName(String siteName);
	List<SiteModel> findBySiteManager(String siteManager);
	List<SiteModel> findByLocation(String location);
}
