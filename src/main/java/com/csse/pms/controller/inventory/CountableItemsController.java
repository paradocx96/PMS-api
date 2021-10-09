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

import com.csse.pms.api.inventory.CountableItemsApi;
import com.csse.pms.dto.inventory.CountableItemDto;
import com.csse.pms.dto.inventory.CountableItemQuantityUpdateDto;
import com.csse.pms.util.CommonConstants;

@RestController
@RequestMapping(CommonConstants.COUNTABLE_ITEMS_BASE_PATH)
@CrossOrigin(origins = CommonConstants.STAR, allowedHeaders = CommonConstants.STAR, exposedHeaders = CommonConstants.STAR)
public class CountableItemsController {
	
	private CountableItemsApi countableItemsApi;
	
	@Autowired
	public CountableItemsController(CountableItemsApi countableItemsApi) {
		this.countableItemsApi = countableItemsApi;
	}
	
	@GetMapping("getAllCountableItems")
	public List<CountableItemDto> getAllCountableItems(){
		return countableItemsApi.getAllCountableItems();
	}
	
	@PostMapping("addCountableItem")
	public String addNewCountableItem(@RequestBody CountableItemDto countableItemDto) {
		return countableItemsApi.addNewCountableItem(countableItemDto);
	}
	
	@GetMapping("getCountableItemById/{id}")
	public CountableItemDto getCountableItemById(@PathVariable String id) {
		return countableItemsApi.getCountableItemById(id);
	}
	
	@GetMapping("getCriticalCountableItems")
	public List<CountableItemDto> getCriticalCountableItems(){
		return countableItemsApi.getCriticalCountableItems();
	}
	
	@GetMapping("getNoncriticalCountableItems")
	public List<CountableItemDto> getNoncriticalCountableItems(){
		return countableItemsApi.getNonCriticalCountableItems();
	}
	
	@PutMapping("updateCountableItem")
	public String updateCountableItem(@RequestBody CountableItemDto countableItemDto) {
		return countableItemsApi.updateCountableItem(countableItemDto);
	}
	
	@DeleteMapping("deleteCountableItem/{id}")
	public String deleteCountableItem(@PathVariable String id) {
		return countableItemsApi.deleteCountableItem(id);
	}
	
	@PutMapping("consumeItem")
	public String consumeItem(@RequestBody CountableItemQuantityUpdateDto quantityUpdateDto) {
		return countableItemsApi.consumeItem(quantityUpdateDto);
	}
	
	@PutMapping("replenishItem")
	public String replenishItem(@RequestBody CountableItemQuantityUpdateDto quantityUpdateDto) {
		return countableItemsApi.replenishItem(quantityUpdateDto);
	}
	
	@GetMapping("getItemBySiteId/{siteId}")
	public List<CountableItemDto> getItemBySiteId(@PathVariable String siteid) {
		return countableItemsApi.getItemBySiteId(siteid);
	}
	
	

}
