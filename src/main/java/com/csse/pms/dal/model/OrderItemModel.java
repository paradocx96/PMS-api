package com.csse.pms.dal.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Chandrasiri S.A.N.L.D.
 *
 * This Class for Order related implementation
 */

@Document
public class OrderItemModel {

    private String itemId;
    private String itemName;
    private int itemCount;

    public OrderItemModel() {
    }

    public OrderItemModel(String itemId, String itemName, int itemCount) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemCount = itemCount;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }
}
