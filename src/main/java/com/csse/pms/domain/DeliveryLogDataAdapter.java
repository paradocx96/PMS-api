package com.csse.pms.domain;

import org.springframework.http.ResponseEntity;
import java.util.List;

/**
 * @author Chandrasiri S.A.N.L.D.
 *
 * This Interface for Delivery Log related implementation
 */

public interface DeliveryLogDataAdapter {

    DeliveryLog createDeliveryLog(DeliveryLog deliveryLog);

    List<DeliveryLog> getAllDeliveryLogs();

    DeliveryLog getDeliveryLogById(String id);

    List<DeliveryLog> getDeliveryLogByReferenceNo(String referenceNo);

    String deleteDeliveryLogById(String id);

    String updateDeliveryLog(DeliveryLog deliveryLog);
}
