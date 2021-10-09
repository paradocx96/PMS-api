package com.csse.pms.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csse.pms.dal.model.SiteModel;
import com.csse.pms.domain.SiteDataAdapter;
import com.csse.pms.dto.SiteDto;

@Service
public class SiteApi {
	
	private SiteDataAdapter siteDataAdapter;
	
	@Autowired
	public SiteApi(SiteDataAdapter siteDataAdapter) {
		this.siteDataAdapter = siteDataAdapter;
	}
	
	//Method for adding a site
	public String addSite(SiteDto siteDto) {
		
		//instantiate site model
		SiteModel siteModel = new SiteModel();
		
		siteModel.setSiteName(siteDto.getSiteName());
		siteModel.setLocation(siteDto.getLocation());
		siteModel.setSiteManager(siteDto.getSiteManager());
		
		//add the site and return the newly created site id
		return siteDataAdapter.createSite(siteModel);
	}
	
	//Method for getting all sites
	public List<SiteDto> getAllSites(){
		
		//instantiate lists of site models and DTOs
		List<SiteDto> siteDtoList = new ArrayList<>();
		List<SiteModel> siteModelList = new ArrayList<>();
		
		siteModelList = siteDataAdapter.getAllSites();
		
		for(SiteModel siteModel : siteModelList) {
			
			//instantiate site DTO
			SiteDto siteDto = new SiteDto();
			
			//set attributes
			siteDto.setId(siteModel.getId());
			siteDto.setLocation(siteModel.getLocation());
			siteDto.setSiteName(siteModel.getSiteName());
			siteDto.setSiteManager(siteModel.getSiteManager());
			
			siteDtoList.add(siteDto);
		}
		
		//return DTO list
		return siteDtoList;
	}
	
	//get a site by id
	public SiteDto getSiteById(String siteId) {
		
		//instantiate new site model and site DTO
		SiteModel siteModel = new SiteModel();
		SiteDto siteDto = new SiteDto();
		
		siteModel = siteDataAdapter.getSiteById(siteId);
		
		siteDto.setId(siteModel.getId());
		siteDto.setLocation(siteModel.getLocation());
		siteDto.setSiteName(siteModel.getSiteName());
		siteDto.setSiteManager(siteModel.getSiteManager());
		
		return siteDto;
	}
	
	//delete a site based on the id
	public String deleteSite(String id) {
		return siteDataAdapter.deleteSiteById(id);
	}
	
	//update a site 
	public String updateSite(SiteDto siteDto) {
		
		//instantiate site model
		SiteModel siteModel =  new SiteModel();
		
		//set attributes
		siteModel.setId(siteDto.getId());
		siteModel.setSiteName(siteDto.getSiteName());
		siteModel.setLocation(siteDto.getLocation());
		siteModel.setSiteManager(siteDto.getSiteManager());
		
		return siteDataAdapter.updateSite(siteModel);
	}

}
