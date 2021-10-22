package com.csse.pms.api;

import com.csse.pms.domain.Order;
import com.csse.pms.domain.OrderDataAdapter;
import com.csse.pms.util.TestCommonConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderApiTest {
    private final OrderDataAdapter adapter;
    Order purchase;
    Order updateOrder;
    Order archiveOrder;
    Order createResult;
    Order getByIdResult;
    String updateResult;
    String archiveResult;
    String deleteResult;

    @Autowired
    OrderApiTest(OrderDataAdapter adapter) {
        this.adapter = adapter;
        purchase = new Order();
        updateOrder = new Order();
        archiveOrder = new Order();
        createResult = new Order();
        getByIdResult = new Order();
        updateResult = "";
        archiveResult = "";
        deleteResult = "";
    }

    @Test
    @org.junit.jupiter.api.Order(1)
    void createModifyDeleteOrder() throws JsonProcessingException {

        // Create Order
        List itemList = new ObjectMapper().readValue(TestCommonConstants.ORDER_ITEM_LIST, List.class);
        purchase.setReferenceNo(TestCommonConstants.REFERENCE_NO);
        purchase.setSupplierId(TestCommonConstants.SUPPLIER_ID);
        purchase.setItemList(itemList);
        purchase.setSiteManagerId(TestCommonConstants.SITE_MANAGER_ID);
        purchase.setSiteId(TestCommonConstants.SITE_ID);
        purchase.setProjectId(TestCommonConstants.PROJECT_ID);
        purchase.setAmount(TestCommonConstants.BUDGET);
        purchase.setContactDetails(TestCommonConstants.CONTACT);
        purchase.setComment(TestCommonConstants.COMMENT);
        purchase.setDateTime(LocalDateTime.now());
        purchase.setStatus(TestCommonConstants.STATUS);
        createResult = adapter.purchaseOrder(purchase);
        assertNotNull(createResult);

        // Order get by id
        getByIdResult = adapter.getOrderById(createResult.getId());
        assertEquals(createResult.getReferenceNo(), getByIdResult.getReferenceNo());
        assertEquals(createResult.getSupplierId(), getByIdResult.getSupplierId());
        assertEquals(createResult.getSiteManagerId(), getByIdResult.getSiteManagerId());
        assertEquals(createResult.getSiteId(), getByIdResult.getSiteId());
        assertEquals(createResult.getProjectId(), getByIdResult.getProjectId());
        assertEquals(createResult.getAmount(), getByIdResult.getAmount());
        assertEquals(createResult.getContactDetails(), getByIdResult.getContactDetails());
        assertEquals(createResult.getComment(), getByIdResult.getComment());
        assertEquals(createResult.getDateTime(), getByIdResult.getDateTime());
        assertEquals(createResult.getStatus(), getByIdResult.getStatus());

        // Update Order
        List itemListUpdate = new ObjectMapper().readValue(TestCommonConstants.ORDER_ITEM_LIST_TWO, List.class);
        updateOrder.setId(createResult.getId());
        updateOrder.setSupplierId(TestCommonConstants.SUPPLIER_ID_TWO);
        updateOrder.setItemList(itemListUpdate);
        updateOrder.setSiteManagerId(TestCommonConstants.SITE_MANAGER_ID_TWO);
        updateOrder.setAmount(TestCommonConstants.BUDGET_TWO);
        updateOrder.setContactDetails(TestCommonConstants.CONTACT_TWO);
        updateOrder.setComment(TestCommonConstants.COMMENT_TWO);
        updateOrder.setDateTime(LocalDateTime.now());
        updateOrder.setStatus(TestCommonConstants.STATUS_TWO);
        updateResult = adapter.updateOrder(updateOrder);
        assertEquals(updateResult, TestCommonConstants.ORDER_STATUS_UPDATE);

        // Archive Order
        archiveOrder.setId(createResult.getId());
        archiveOrder.setStatus(TestCommonConstants.ARCHIVE_STATUS);
        archiveResult = adapter.archiveOrder(archiveOrder);
        assertEquals(archiveResult, TestCommonConstants.ORDER_STATUS_ARCHIVE);

        // Delete Order
        deleteResult = adapter.deleteOrderById(createResult.getId());
        assertEquals(deleteResult, TestCommonConstants.ORDER_STATUS_DELETE);
    }

    @Test
    @org.junit.jupiter.api.Order(2)
    void getAllOrders() {
        List<Order> result = adapter.getAllOrders();
        assertTrue(result.size() > 1);
    }

    @Test
    @org.junit.jupiter.api.Order(3)
    void getOrderByStatus() {
        //Approved
        List<Order> approvedResult = adapter.getOrderByStatus(TestCommonConstants.APPROVED_STATUS);
        assertTrue(approvedResult.size() > 1);
    }
}