package com.csse.pms.controller.inventory;

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

import com.csse.pms.api.inventory.UncountableItemsApi;
import com.csse.pms.dto.inventory.UncountableItemAmountUpdateDto;
import com.csse.pms.dto.inventory.UncountableItemDto;
import com.csse.pms.util.CommonConstants;

@RestController
@RequestMapping(CommonConstants.UNCOUNTABLE_ITEMS_BASE_PATH)
@CrossOrigin(origins = CommonConstants.STAR, allowedHeaders = CommonConstants.STAR, exposedHeaders = CommonConstants.STAR)
public class UncountableItemsController {
	
	private UncountableItemsApi uncountableItemsApi;
	
	@Autowired
	UncountableItemsController(UncountableItemsApi uncountableItemsApi){
		this.uncountableItemsApi = uncountableItemsApi;
	}
	
	@GetMapping("getAllUncountableItems")
	public List<UncountableItemDto> getAllUncountableItems(){
		return uncountableItemsApi.getAllUncountableItems();
	}
	
	@PostMapping("addUncountableItem")
	public String addUncountableItem(@RequestBody UncountableItemDto uncountableItemDto) {
		return uncountableItemsApi.addUncountableItem(uncountableItemDto);
	}
	
	@GetMapping("getUncountableItemById/{id}")
	public UncountableItemDto getUncountableItemById(@PathVariable String id) {
		return uncountableItemsApi.getUncountableItemById(id);
	}
	
	@GetMapping("getCriticalUncountableItems")
	public List<UncountableItemDto> getCriticalUncountableItems(){
		return uncountableItemsApi.getCriticalUncountableItems();
	}
	
	@GetMapping("getNonCriticalUncountableItems")
	public List<UncountableItemDto> getNonCriticalUncountableItems(){
		return uncountableItemsApi.getNonCriticalUncountableItems();
	}
	
	@PutMapping("updateUncountableItem")
	public String updateUncountableItem(@RequestBody UncountableItemDto uncountableItemDto) {
		return uncountableItemsApi.updateUncountableItem(uncountableItemDto);
	}
	
	@DeleteMapping("deleteUncountableItem/{id}")
	public String deleteUncountableItem(@PathVariable String id) {
		return uncountableItemsApi.deleteUncountableItem(id);
	}
	
	@PutMapping("consumeItem")
	public String consumeItem(@RequestBody UncountableItemAmountUpdateDto amountUpdateDto) {
		return uncountableItemsApi.consumeItem(amountUpdateDto);
	}
	
	@PutMapping("replenishItem")
	public String replenishItem(@RequestBody UncountableItemAmountUpdateDto amountUpdateDto) {
		return uncountableItemsApi.replenishItem(amountUpdateDto); 
	}
	
	@GetMapping("getUncountableItemsBySite/{site}")
	public List<UncountableItemDto> getUncountableItemsBySite(@PathVariable String site){
		return uncountableItemsApi.getUncountableItemsBySite(site);
	}

}
