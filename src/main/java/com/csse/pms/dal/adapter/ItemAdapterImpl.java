package com.csse.pms.dal.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


import com.csse.pms.dal.model.ItemModel;
import com.csse.pms.dal.repository.ItemReposirtory;
import com.csse.pms.domain.Item;
import com.csse.pms.domain.ItemDataAdapter;
import com.csse.pms.dto.ItemMessageResponseDto;
import com.csse.pms.dto.MessageResponseDto;
import com.csse.pms.util.CommonConstants;

/**
 * 
 * @author Malwatta H.G.- IT19240848
 * 
 * This class handle all items related methods
 * - @see #addItem(Item) - add items 
 * - @see #updateSingleItem(Item) - edit items
 * - @see #getItemByItemID(String) - view items
 * - @see #deleteByItemID(String) - delete items 
 * 
 *
 */

@Component
public class ItemAdapterImpl implements ItemDataAdapter {

	 /**
     * Initialize Logger
     */
    public static final Logger LOGGER = Logger.getLogger(ItemAdapterImpl.class.getName());



	@Autowired
	private ItemReposirtory itemReposirtory;

	@Override
	public ResponseEntity<?> addItem(Item item) {

		ItemModel itemObj = new ItemModel( item.getSupplierID(),
											item.getName(),
											item.getQuantity(),
											item.getPrice()
										 );
		itemReposirtory.save(itemObj);

		return ResponseEntity.ok(new ItemMessageResponseDto(CommonConstants.SUPPLIER_ADD_ITEM_SUCCESS_MSG));
	}

	@Override
	public List<Item> getItemBySupplierID(String id) {

		List<ItemModel> items;
		List<Item> item = new ArrayList<>();

		try {

			items = itemReposirtory.findBySupplierID(id);

			for(ItemModel itemModel: items) {

				Item itemObj = new Item();

				itemObj.setId(itemModel.getId());
				itemObj.setSupplierID(itemModel.getSupplierID());
				itemObj.setName(itemModel.getName());
				itemObj.setQuantity(itemModel.getQuantity());
				itemObj.setPrice(itemModel.getPrice());

				item.add(itemObj);

			}

		} catch (Exception e) {
			 LOGGER.log(Level.SEVERE, e.getMessage());
		}


		return item;
	}

	@Override
	public ResponseEntity<?> deleteByItemID(String id) {

		ItemModel itemModel= null;

		try {

			itemModel = itemReposirtory.findById(id).get();

			if(itemModel != null) {
				itemReposirtory.deleteById(id);

				return ResponseEntity.ok(new ItemMessageResponseDto(CommonConstants.SUPPLIER_DELETE_ITEM_SUCCESS_MSG));
			}else {
				return ResponseEntity.ok(new ItemMessageResponseDto(CommonConstants.SUPPLIER_DELETE_ITEM_NOT_EXIST_ERROR_MSG));
			}

		} catch (Exception e) {
			 LOGGER.log(Level.SEVERE, e.getMessage());
			return ResponseEntity.ok(new ItemMessageResponseDto(CommonConstants.SUPPLIER_DELETE_ITEM_ERROR_MSG));
		}



	}

	@Override
	public Item getById(String id) {
		ItemModel itemModel;
		Item itemObj = new Item();

		try{
			itemModel = itemReposirtory.findById(id).get();

            itemObj.setId(itemModel.getId());
            itemObj.setSupplierID(itemModel.getSupplierID());
            itemObj.setName(itemModel.getName());
            itemObj.setQuantity(itemModel.getQuantity());
            itemObj.setPrice(itemModel.getPrice());

			return itemObj;
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
			return itemObj;
		}
	}

	@Override
	public ResponseEntity<?> updateSingleItem(Item item) {
		
		try {
			
			ItemModel itemModelObj = itemReposirtory.findById(item.getId()).get();
			
			if(itemModelObj != null) {
				itemModelObj.setName(item.getName());
				itemModelObj.setQuantity(item.getQuantity());
				itemModelObj.setPrice(item.getPrice());
				
				itemReposirtory.save(itemModelObj);
				
				return ResponseEntity.ok(new MessageResponseDto(CommonConstants.ITEM_UPDATE_SUCCESSFULLY) );
			}else {
				return ResponseEntity.ok(new MessageResponseDto(CommonConstants.ITEM_DOESNT_EXITS) );
			}
			
		} catch (Exception e) {
			 LOGGER.log(Level.SEVERE, e.getMessage());
			 return ResponseEntity.ok(new MessageResponseDto(CommonConstants.ITEM_UPDATE_ERROR) );
		}
		
	}

	@Override
	public Item getItemByItemID(String id) {
		
		Item itemObj = new Item();
		
		try {
			
				ItemModel items = itemReposirtory.findById(id).get();
				
				itemObj.setId(items.getId());
				itemObj.setSupplierID(items.getSupplierID());
				itemObj.setName(items.getName());
				itemObj.setQuantity(items.getQuantity());
				itemObj.setPrice(items.getPrice());
				
			
		} catch (Exception e) {
			 LOGGER.log(Level.SEVERE, e.getMessage());

		}
		
		return itemObj;
		
	}

}
