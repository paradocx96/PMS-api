package com.csse.pms.api;

import com.csse.pms.domain.DeliveryLog;
import com.csse.pms.domain.DeliveryLogDataAdapter;
import com.csse.pms.util.TestCommonConstants;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DeliveryLogApiTest {
    private final DeliveryLogDataAdapter adapter;

    @Autowired
    DeliveryLogApiTest(DeliveryLogDataAdapter adapter) {
        this.adapter = adapter;
    }

    @Test
    @Order(1)
    void createModifyDeleteDeliveryLog() {
        DeliveryLog deliveryLog = new DeliveryLog();

        // Creating Delivery Log
        deliveryLog.setReferenceNo(TestCommonConstants.REFERENCE_NO);
        deliveryLog.setSiteManagerId(TestCommonConstants.SITE_MANAGER_ID);
        deliveryLog.setRemark(TestCommonConstants.REMARK);
        deliveryLog.setStatus(TestCommonConstants.STATUS);
        DeliveryLog result = adapter.createDeliveryLog(deliveryLog);

        // Get Delivery Log By ID
        DeliveryLog expected = adapter.getDeliveryLogById(result.getId());
        assertEquals(expected.getId(), result.getId());
        assertEquals(expected.getReferenceNo(), result.getReferenceNo());
        assertEquals(expected.getSiteManagerId(), result.getSiteManagerId());
        assertEquals(expected.getRemark(), result.getRemark());
        assertEquals(expected.getStatus(), result.getStatus());

        // Update Delivery Log
        deliveryLog.setId(result.getId());
        deliveryLog.setReferenceNo(TestCommonConstants.REFERENCE_NO_TWO);
        deliveryLog.setSiteManagerId(TestCommonConstants.SITE_MANAGER_ID_TWO);
        deliveryLog.setRemark(TestCommonConstants.REMARK_TWO);
        deliveryLog.setStatus(TestCommonConstants.STATUS_TWO);
        String result2 = adapter.updateDeliveryLog(deliveryLog);
        assertEquals(TestCommonConstants.DELIVERY_STATUS_UPDATE, result2);

        // Delete Delivery Log
        String result3 = adapter.deleteDeliveryLogById(result.getId());
        assertEquals(TestCommonConstants.DELIVERY_STATUS_DELETE, result3);
    }

    @Test()
    @Order(2)
    void getAllDeliveryLogs() {
        List<DeliveryLog> result = adapter.getAllDeliveryLogs();
        assertTrue(result.size() > 1);
    }
}