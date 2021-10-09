package com.csse.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csse.pms.api.SiteApi;
import com.csse.pms.dto.SiteDto;
import com.csse.pms.util.CommonConstants;

@RestController
@RequestMapping(CommonConstants.SITE_BASE_PATH)
@CrossOrigin(origins = CommonConstants.STAR, allowedHeaders = CommonConstants.STAR, exposedHeaders = CommonConstants.STAR)
public class SiteController {
	
	private SiteApi siteApi;
	
	@Autowired
	public SiteController(SiteApi siteApi) {
		this.siteApi = siteApi;
	}
	
	//get all sites
	@GetMapping("getAllSites")
	public List<SiteDto> getAllSites(){
		return siteApi.getAllSites();
	}
	
	//add a site
	@PostMapping("addSite")
	public String addSite(@RequestBody SiteDto siteDto) {
		return siteApi.addSite(siteDto);
	}
	
	//get a site by id
	@GetMapping("getSiteById/{id}")
	public SiteDto getSiteById(@PathVariable String id) {
		return siteApi.getSiteById(id);
	}
	
	//delete a site by id
	@DeleteMapping("deleteSite/{id}")
	public String deleteSite(@PathVariable String id) {
		return siteApi.deleteSite(id);
	}
	
	//update a site
	@PutMapping("updateSite")
	public String updateSite(@RequestBody SiteDto siteDto) {
		return siteApi.updateSite(siteDto);
	}

}
