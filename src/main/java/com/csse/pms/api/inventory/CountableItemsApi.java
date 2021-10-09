package com.csse.pms.api.inventory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csse.pms.dal.model.inventory.CountableItemsModel;
import com.csse.pms.domain.inventory.CountableItemsDataAdpater;
import com.csse.pms.dto.inventory.CountableItemDto;
import com.csse.pms.dto.inventory.CountableItemQuantityUpdateDto;

@Service
public class CountableItemsApi {
	
	private CountableItemsDataAdpater countableItemDataAdapter;
	
	@Autowired
	public CountableItemsApi(CountableItemsDataAdpater countableItemDataAdapter) {
		this.countableItemDataAdapter = countableItemDataAdapter;
	}
	
	
	//get all the available countable items
	public List<CountableItemDto> getAllCountableItems(){
		
		//instantiate lists
		List<CountableItemDto> countableItemDtoList = new ArrayList<>();
		List<CountableItemsModel> countableItemModelList = new ArrayList<>();
		
		//assign all items to the list
		countableItemModelList = countableItemDataAdapter.getAll();
		
		for(CountableItemsModel countableItemsModel: countableItemModelList) {
			CountableItemDto countableItemDto = new CountableItemDto();
			
			countableItemDto.setId(countableItemsModel.getId());
			countableItemDto.setName(countableItemsModel.getName());
			countableItemDto.setType(countableItemsModel.getType());
			countableItemDto.setQuantity(countableItemsModel.getQuantity());
			countableItemDto.setMinimumQuantity(countableItemsModel.getMinimumQuantity());
			countableItemDto.setSiteid(countableItemsModel.getSiteid());
			countableItemDto.setSitename(countableItemsModel.getSitename());
			
			countableItemDtoList.add(countableItemDto);
		}
		
		return countableItemDtoList;
	}
	
	//add a new countable item
	public String addNewCountableItem(CountableItemDto countableItemDto) {
		
		//instantiate new model
		CountableItemsModel countableItemsModel = new CountableItemsModel();
		
		//set the attributes
		countableItemsModel.setName(countableItemDto.getName());
		countableItemsModel.setType(countableItemDto.getType());
		countableItemsModel.setQuantity(countableItemDto.getQuantity());
		countableItemsModel.setMinimumQuantity(countableItemDto.getMinimumQuantity());
		countableItemsModel.setSiteid(countableItemDto.getSiteid());
		countableItemsModel.setSitename(countableItemDto.getSitename());
		
		return countableItemDataAdapter.addItem(countableItemsModel);
	}
	
	//get a new countable item by id
	public CountableItemDto getCountableItemById(String id) {
		
		//instantiate DTO and model
		CountableItemDto countableItemDto = new CountableItemDto();
		CountableItemsModel countableItemsModel = new CountableItemsModel();
		
		//get the model by id
		countableItemsModel =  countableItemDataAdapter.getItemById(id);
		
		//set the attributes
		countableItemDto.setId(countableItemsModel.getId());
		countableItemDto.setName(countableItemsModel.getName());
		countableItemDto.setType(countableItemsModel.getType());
		countableItemDto.setQuantity(countableItemsModel.getQuantity());
		countableItemDto.setMinimumQuantity(countableItemsModel.getMinimumQuantity());
		countableItemDto.setSiteid(countableItemsModel.getSiteid());
		countableItemDto.setSitename(countableItemsModel.getSitename());
		
		return countableItemDto;
	}
	
	//get critical countable item list
	public List<CountableItemDto> getCriticalCountableItems(){
		
		//instantiate lists
		List<CountableItemDto> countableItemDtoList = new ArrayList<>();
		List<CountableItemsModel> countableItemsModelsList = new ArrayList<>();
		
		countableItemsModelsList = countableItemDataAdapter.getItemsByType("critical");
		
		//iterate through model list
		for(CountableItemsModel countableItemsModel : countableItemsModelsList) {
			
			//for each
			//instantiate DTO
			CountableItemDto countableItemDto = new CountableItemDto();
			
			//set attributes
			countableItemDto.setId(countableItemsModel.getId());
			countableItemDto.setName(countableItemsModel.getName());
			countableItemDto.setType(countableItemsModel.getType());
			countableItemDto.setQuantity(countableItemsModel.getQuantity());
			countableItemDto.setMinimumQuantity(countableItemsModel.getMinimumQuantity());
			countableItemDto.setSiteid(countableItemsModel.getSiteid());
			countableItemDto.setSitename(countableItemsModel.getSitename());
			
			//add the DTO to the lists
			countableItemDtoList.add(countableItemDto);
			
		}
		
		return countableItemDtoList;
	}
	
	//get non critical countable items
	public List<CountableItemDto> getNonCriticalCountableItems(){
		//instantiate lists
				List<CountableItemDto> countableItemDtoList = new ArrayList<>();
				List<CountableItemsModel> countableItemsModelsList = new ArrayList<>();
				
				countableItemsModelsList = countableItemDataAdapter.getItemsByType("nonCritical");
				
				//iterate through model list
				for(CountableItemsModel countableItemsModel : countableItemsModelsList) {
					
					//for each
					//instantiate DTO
					CountableItemDto countableItemDto = new CountableItemDto();
					
					//set attributes
					countableItemDto.setId(countableItemsModel.getId());
					countableItemDto.setName(countableItemsModel.getName());
					countableItemDto.setType(countableItemsModel.getType());
					countableItemDto.setQuantity(countableItemsModel.getQuantity());
					countableItemDto.setMinimumQuantity(countableItemsModel.getMinimumQuantity());
					countableItemDto.setSiteid(countableItemsModel.getSiteid());
					countableItemDto.setSitename(countableItemsModel.getSitename());
					
					//add the DTO to the lists
					countableItemDtoList.add(countableItemDto);
					
				}
				
				return countableItemDtoList;
	}
	
	//update countable item
	public String updateCountableItem(CountableItemDto countableItemDto) {
		
		CountableItemsModel countableItemsModel = new CountableItemsModel();
		
		//set the attributes
		countableItemsModel.setId(countableItemDto.getId());
		countableItemsModel.setName(countableItemDto.getName());
		countableItemsModel.setType(countableItemDto.getType());
		countableItemsModel.setQuantity(countableItemDto.getQuantity());
		countableItemsModel.setMinimumQuantity(countableItemDto.getMinimumQuantity());
		countableItemsModel.setSiteid(countableItemDto.getSiteid());
		countableItemsModel.setSitename(countableItemDto.getSitename());
		
		return countableItemDataAdapter.updateItem(countableItemsModel);
	}
	
	//delete a countable item
	public String deleteCountableItem(String id) {
		return countableItemDataAdapter.deleteItem(id);
	}
	
	//consume items of a countable item
	public String consumeItem(CountableItemQuantityUpdateDto quantityUpdateDto) {
		
		//get the item for id
		CountableItemsModel countableItemsModel 
		= countableItemDataAdapter.getItemById(quantityUpdateDto.getId());
		
		//get the existing quantity
		int existingQuantity = countableItemsModel.getQuantity();
		
		//deduct quantity from existing quantity
		int newQuantity = existingQuantity - quantityUpdateDto.getQuantity();
		
		//check whether the new quantity is negative
		if(newQuantity < 0) {
			//if negative do not proceed
			System.out.println("Cannot deduct the quantity since result gets below zero");
			return "error";
		}
		else {
			//if negative proceed
			return countableItemDataAdapter.updateQuantity(newQuantity, quantityUpdateDto.getId());
		}
	}
	
	//refill items
	public String replenishItem(CountableItemQuantityUpdateDto quantityUpdateDto) {
		//get the item for id
		CountableItemsModel countableItemsModel 
				= countableItemDataAdapter.getItemById(quantityUpdateDto.getId());
		//get the existing quantity
		int existingQuantity = countableItemsModel.getQuantity();
				
		//add the new  quantity to existing quantity
		int newQuantity = existingQuantity + quantityUpdateDto.getQuantity();
		
		//update the quantity
		return countableItemDataAdapter.updateQuantity(newQuantity, quantityUpdateDto.getId());
		
	}
	
	//get an item by site id
	public List<CountableItemDto> getItemBySiteId(String siteid) {
		
		List<CountableItemsModel> countableItemsModelsList = new ArrayList<>();
		List<CountableItemDto> countableItemDtoList = new ArrayList<>();
		
		countableItemsModelsList = countableItemDataAdapter.getItemsBySiteId(siteid);
		
		//iterate through countable item model list
		for(CountableItemsModel countableItemsModel : countableItemsModelsList) {
			//for each
			//instantiate DTO
			CountableItemDto countableItemDto = new CountableItemDto();
			
			//set attributes
			countableItemDto.setId(countableItemsModel.getId());
			countableItemDto.setName(countableItemsModel.getName());
			countableItemDto.setType(countableItemsModel.getType());
			countableItemDto.setQuantity(countableItemsModel.getQuantity());
			countableItemDto.setMinimumQuantity(countableItemsModel.getMinimumQuantity());
			countableItemDto.setSiteid(countableItemsModel.getSiteid());
			countableItemDto.setSitename(countableItemsModel.getSitename());
			
			//add the DTO to the lists
			countableItemDtoList.add(countableItemDto);
		}
		
		return countableItemDtoList;
	}
}
