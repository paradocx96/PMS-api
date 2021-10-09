package com.csse.pms.api.inventory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csse.pms.dal.model.inventory.UncountableItemsModel;
import com.csse.pms.domain.inventory.UncountableItemsDataAdapter;
import com.csse.pms.dto.inventory.UncountableItemAmountUpdateDto;
import com.csse.pms.dto.inventory.UncountableItemDto;

@Service
public class UncountableItemsApi {
	
	private UncountableItemsDataAdapter uncountableItemDataAdapter;
	
	@Autowired
	public UncountableItemsApi(UncountableItemsDataAdapter uncountableItemDataAdapter) {
		this.uncountableItemDataAdapter = uncountableItemDataAdapter;
	}
	
	//get all the available uncountable items
	public List<UncountableItemDto> getAllUncountableItems(){
		
		List<UncountableItemDto> uncountableItemDtoList = new ArrayList<>();
		List<UncountableItemsModel> uncountableItemsModelsList = new ArrayList<>();
		
		uncountableItemsModelsList = uncountableItemDataAdapter.getAll();
		
		for(UncountableItemsModel uncountableItemsModel : uncountableItemsModelsList) {
			UncountableItemDto uncountableItemDto = new UncountableItemDto();
			
			uncountableItemDto.setId(uncountableItemsModel.getId());
			uncountableItemDto.setName(uncountableItemsModel.getName());
			uncountableItemDto.setType(uncountableItemsModel.getType());
			uncountableItemDto.setAmount(uncountableItemsModel.getAmount());
			uncountableItemDto.setUnit(uncountableItemsModel.getUnit());
			uncountableItemDto.setMinimumAmount(uncountableItemsModel.getMinimumAmount());
			uncountableItemDto.setSiteid(uncountableItemsModel.getSiteid());
			uncountableItemDto.setSitename(uncountableItemsModel.getSitename());
			
			//add the DTO to the list
			uncountableItemDtoList.add(uncountableItemDto);
		}
		
		//return the DTO list
		return uncountableItemDtoList;
	}
	
	//add a new uncountable item
	public String addUncountableItem(UncountableItemDto uncountableItemDto) {
		
		//instantiate the model
		UncountableItemsModel uncountableItemsModel = new UncountableItemsModel();
		
		//set the attributes to the model
		uncountableItemsModel.setName(uncountableItemDto.getName());
		uncountableItemsModel.setType(uncountableItemDto.getType());
		uncountableItemsModel.setAmount(uncountableItemDto.getAmount());
		uncountableItemsModel.setUnit(uncountableItemDto.getUnit());
		uncountableItemsModel.setMinimumAmount(uncountableItemDto.getMinimumAmount());
		uncountableItemsModel.setSiteid(uncountableItemDto.getSiteid());
		uncountableItemsModel.setSitename(uncountableItemDto.getSitename());
		
		return uncountableItemDataAdapter.addItem(uncountableItemsModel);
	}
	
	//get an uncountable item by id
	public UncountableItemDto getUncountableItemById(String id) {
		
		UncountableItemDto uncountableItemDto = new UncountableItemDto();
		UncountableItemsModel uncountableItemsModel = new UncountableItemsModel();
		
		//get model by id
		uncountableItemsModel = uncountableItemDataAdapter.getItemById(id);
		
		//set the attributes
		uncountableItemDto.setId(uncountableItemsModel.getId());
		uncountableItemDto.setName(uncountableItemsModel.getName());
		uncountableItemDto.setType(uncountableItemsModel.getType());
		uncountableItemDto.setAmount(uncountableItemsModel.getAmount());
		uncountableItemDto.setUnit(uncountableItemsModel.getUnit());
		uncountableItemDto.setMinimumAmount(uncountableItemsModel.getMinimumAmount());
		uncountableItemDto.setSiteid(uncountableItemsModel.getSiteid());
		uncountableItemDto.setSitename(uncountableItemsModel.getSitename());
		
		return uncountableItemDto;
	}
	
	//get critical countable item list
	public List<UncountableItemDto> getCriticalUncountableItems(){
		
		List<UncountableItemDto> uncountableItemDtoList = new ArrayList<>();
		List<UncountableItemsModel> uncountableItemsModelsList = new ArrayList<>();
		
		uncountableItemsModelsList = uncountableItemDataAdapter.getItemsByType("critical");
		
		for(UncountableItemsModel uncountableItemsModel : uncountableItemsModelsList) {
			UncountableItemDto uncountableItemDto = new UncountableItemDto();
			
			uncountableItemDto.setId(uncountableItemsModel.getId());
			uncountableItemDto.setName(uncountableItemsModel.getName());
			uncountableItemDto.setType(uncountableItemsModel.getType());
			uncountableItemDto.setAmount(uncountableItemsModel.getAmount());
			uncountableItemDto.setUnit(uncountableItemsModel.getUnit());
			uncountableItemDto.setMinimumAmount(uncountableItemsModel.getMinimumAmount());
			uncountableItemDto.setSiteid(uncountableItemsModel.getSiteid());
			uncountableItemDto.setSitename(uncountableItemsModel.getSitename());
			
			//add the DTO to the list
			uncountableItemDtoList.add(uncountableItemDto);
		}
		
		return uncountableItemDtoList;
	}
	
	//get non critical uncountable items
	public List<UncountableItemDto> getNonCriticalUncountableItems(){
		List<UncountableItemDto> uncountableItemDtoList = new ArrayList<>();
		List<UncountableItemsModel> uncountableItemsModelsList = new ArrayList<>();
		
		uncountableItemsModelsList = uncountableItemDataAdapter.getItemsByType("nonCritical");
		
		for(UncountableItemsModel uncountableItemsModel : uncountableItemsModelsList) {
			UncountableItemDto uncountableItemDto = new UncountableItemDto();
			
			uncountableItemDto.setId(uncountableItemsModel.getId());
			uncountableItemDto.setName(uncountableItemsModel.getName());
			uncountableItemDto.setType(uncountableItemsModel.getType());
			uncountableItemDto.setAmount(uncountableItemsModel.getAmount());
			uncountableItemDto.setUnit(uncountableItemsModel.getUnit());
			uncountableItemDto.setMinimumAmount(uncountableItemsModel.getMinimumAmount());
			uncountableItemDto.setSiteid(uncountableItemsModel.getSiteid());
			uncountableItemDto.setSitename(uncountableItemsModel.getSitename());
			
			//add the DTO to the list
			uncountableItemDtoList.add(uncountableItemDto);
		}
		
		return uncountableItemDtoList;
	}
	
	//update uncountable item
	public String updateUncountableItem(UncountableItemDto uncountableItemDto) {
		
		UncountableItemsModel uncountableItemsModel = new UncountableItemsModel();
		
		//set the attributes to the model
		uncountableItemsModel.setId(uncountableItemDto.getId());
		uncountableItemsModel.setName(uncountableItemDto.getName());
		uncountableItemsModel.setType(uncountableItemDto.getType());
		uncountableItemsModel.setAmount(uncountableItemDto.getAmount());
		uncountableItemsModel.setUnit(uncountableItemDto.getUnit());
		uncountableItemsModel.setMinimumAmount(uncountableItemDto.getMinimumAmount());
		uncountableItemsModel.setSiteid(uncountableItemDto.getSiteid());
		uncountableItemsModel.setSitename(uncountableItemDto.getSitename());
		
		return uncountableItemDataAdapter.updateItem(uncountableItemsModel);
	}
	
	//delete an uncountable item
	public String deleteUncountableItem(String id) {
		return uncountableItemDataAdapter.deleteItem(id);
	}
	
	//consume an uncountable item
	public String consumeItem(UncountableItemAmountUpdateDto amountUpdateDto) {
		
		UncountableItemsModel uncountableItemsModel = 
				uncountableItemDataAdapter.getItemById(amountUpdateDto.getId());
		
		//get the current amount
		double existingAmount = uncountableItemsModel.getAmount();
		
		//deduct the amount from existing amount
		double newAmount = existingAmount - amountUpdateDto.getAmount();
		
		if(newAmount < 0) {
			System.out.println("Cannot deduct the amount since result gets below zero");
			return "error";
		}
		else {
			return uncountableItemDataAdapter.updateAmount(newAmount, amountUpdateDto.getId());
		}
	}
	
	//replenish an uncountable item
	public String replenishItem(UncountableItemAmountUpdateDto amountUpdateDto) {
		
		UncountableItemsModel uncountableItemsModel = 
				uncountableItemDataAdapter.getItemById(amountUpdateDto.getId());
		
		//get the current amount
		double existingAmount = uncountableItemsModel.getAmount();
		
		//deduct the amount from existing amount
		double newAmount = existingAmount + amountUpdateDto.getAmount();
		
		return uncountableItemDataAdapter.updateAmount(newAmount, amountUpdateDto.getId());
	}
	
	//get an item by site id
	public List<UncountableItemDto> getUncountableItemsBySite(String site){
		
		List<UncountableItemDto> uncountableItemDtoList = new ArrayList<>();
		List<UncountableItemsModel> uncountableItemsModelsList = new ArrayList<>();
		
		uncountableItemsModelsList = uncountableItemDataAdapter.getItemsBySiteId(site);
		
		for(UncountableItemsModel uncountableItemsModel : uncountableItemsModelsList) {
			UncountableItemDto uncountableItemDto = new UncountableItemDto();
			
			uncountableItemDto.setId(uncountableItemsModel.getId());
			uncountableItemDto.setName(uncountableItemsModel.getName());
			uncountableItemDto.setType(uncountableItemsModel.getType());
			uncountableItemDto.setAmount(uncountableItemsModel.getAmount());
			uncountableItemDto.setUnit(uncountableItemsModel.getUnit());
			uncountableItemDto.setMinimumAmount(uncountableItemsModel.getMinimumAmount());
			uncountableItemDto.setSiteid(uncountableItemsModel.getSiteid());
			uncountableItemDto.setSitename(uncountableItemsModel.getSitename());
			
			//add the DTO to the list
			uncountableItemDtoList.add(uncountableItemDto);
		}
		
		return uncountableItemDtoList;
		
	}

}
