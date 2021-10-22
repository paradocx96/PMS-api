package com.csse.pms.api;

import com.csse.pms.domain.DraftOrder;
import com.csse.pms.domain.DraftOrderDataAdapter;
import com.csse.pms.util.TestCommonConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DraftOrderApiTest {

    private final DraftOrderDataAdapter adapter;
    DraftOrder createOrder;
    DraftOrder updateOrder;
    DraftOrder getByIdResult;
    String creatId;
    String updateResult;
    String deleteResult;

    @Autowired
    DraftOrderApiTest(DraftOrderDataAdapter adapter) {
        this.adapter = adapter;
        createOrder = new DraftOrder();
        updateOrder = new DraftOrder();
        getByIdResult = new DraftOrder();
        creatId = "";
        updateResult = "";
        deleteResult = "";
    }

    @Test
    @Order(1)
    void createModifyDeleteDraftOrder() throws JsonProcessingException {
        // TODO: Create Draft Order
        List itemList = new ObjectMapper().readValue(TestCommonConstants.ORDER_ITEM_LIST, List.class);
        createOrder.setSupplierId(TestCommonConstants.SUPPLIER_ID);
        createOrder.setItemList(itemList);
        createOrder.setSiteManagerId(TestCommonConstants.SITE_MANAGER_ID);
        createOrder.setSiteId(TestCommonConstants.SITE_ID);
        createOrder.setProjectId(TestCommonConstants.PROJECT_ID);
        createOrder.setAmount(TestCommonConstants.BUDGET);
        createOrder.setContactDetails(TestCommonConstants.CONTACT);
        createOrder.setComment(TestCommonConstants.COMMENT);
        createOrder.setDateTime(LocalDateTime.now());
        createOrder.setStatus(TestCommonConstants.STATUS);
        creatId = adapter.saveDraftOrder(createOrder);
        assertNotNull(creatId);

        // TODO: Get Draft Order by id
        getByIdResult = adapter.getDraftOrderById(creatId);
        assertEquals(TestCommonConstants.SUPPLIER_ID, getByIdResult.getSupplierId());
        assertEquals(TestCommonConstants.SITE_MANAGER_ID, getByIdResult.getSiteManagerId());
        assertEquals(TestCommonConstants.SITE_ID, getByIdResult.getSiteId());
        assertEquals(TestCommonConstants.PROJECT_ID, getByIdResult.getProjectId());
        assertEquals(TestCommonConstants.BUDGET, getByIdResult.getAmount());
        assertEquals(TestCommonConstants.CONTACT, getByIdResult.getContactDetails());
        assertEquals(TestCommonConstants.COMMENT, getByIdResult.getComment());
        assertEquals(TestCommonConstants.STATUS, getByIdResult.getStatus());

        // TODO: Update Draft Order
        List itemList_two = new ObjectMapper().readValue(TestCommonConstants.ORDER_ITEM_LIST_TWO, List.class);
        updateOrder.setId(creatId);
        updateOrder.setSupplierId(TestCommonConstants.SUPPLIER_ID_TWO);
        updateOrder.setItemList(itemList_two);
        updateOrder.setSiteManagerId(TestCommonConstants.SITE_MANAGER_ID_TWO);
        updateOrder.setAmount(TestCommonConstants.BUDGET_TWO);
        updateOrder.setContactDetails(TestCommonConstants.CONTACT_TWO);
        updateOrder.setComment(TestCommonConstants.COMMENT_TWO);
        updateOrder.setDateTime(LocalDateTime.now());
        updateOrder.setStatus(TestCommonConstants.STATUS_TWO);
        updateResult = adapter.updateDraftOrder(updateOrder);
        assertEquals(updateResult, TestCommonConstants.ORDER_DRAFT_STATUS_UPDATE);

        // TODO: Delete Draft Order
        deleteResult = adapter.deleteDraftOrderById(creatId);
        assertEquals(deleteResult, TestCommonConstants.ORDER_DRAFT_STATUS_DELETE);
    }

    @Test
    @Order(2)
    void getAllDraftOrders() {
        List<DraftOrder> result = adapter.getAllDraftOrders();
        assertTrue(result.size() > 0);
    }
}