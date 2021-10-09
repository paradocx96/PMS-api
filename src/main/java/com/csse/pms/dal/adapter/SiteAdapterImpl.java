package com.csse.pms.dal.adapter;

import java.util.List;
//import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.csse.pms.dal.model.SiteModel;
import com.csse.pms.dal.repository.SiteRepository;
import com.csse.pms.domain.SiteDataAdapter;

@Component
public class SiteAdapterImpl implements SiteDataAdapter {
	
	//public static final Logger LOGGER = Logger.getLogger(SiteAdapterImpl.class.getName());
	
	private SiteRepository siteRepository;
	//private final MongoTemplate mongoTemplate;
	
	@Autowired
	public SiteAdapterImpl(SiteRepository siteRepository) {
		this.siteRepository = siteRepository;
		//this.mongoTemplate = mongoTemplate;
	}

	/*
	 * Method for creating a site Takes in Site object and saves it in MongoDB
	 * @param - Site object
	 * @return  - String - id of new site
	 * @throws - common exception
	 */
	@Override
	public String createSite(SiteModel site) {
		return siteRepository.save(site).getId();
	}

	
	/*
	 * Method for getting a list of sites 
	 * @return -  List of sites
	 * 
	 */
	@Override
	public List<SiteModel> getAllSites() {
		return siteRepository.findAll();
	}

	/*
	 * Method for getting a site by id
	 * @return -  SiteModel
	 * 
	 */
	@Override
	public SiteModel getSiteById(String id) {
		return siteRepository.findById(id).get();
	}

	/*
	 * Delete a site by given id
	 * 
	 * @return - deleted site id
	 */
	@Override
	public String deleteSiteById(String id) {
		siteRepository.deleteById(id);
		return id;
	}

	/*
	 * Update a given site
	 * 
	 * @return - updated site id
	 */
	@Override
	public String updateSite(SiteModel site) {
		return siteRepository.save(site).getId();
	}

	
	
	

}
