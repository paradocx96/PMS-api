package com.csse.pms.domain;

import org.springframework.http.ResponseEntity;
import java.util.List;

/**
 * @author Chandrasiri S.A.N.L.D.
 *
 * This Interface for Delivery Log related implementation
 */

public interface DeliveryLogDataAdapter {

    ResponseEntity<?> createDeliveryLog(DeliveryLog deliveryLog);

    List<DeliveryLog> getAllDeliveryLogs();

    DeliveryLog getDeliveryLogById(String id);

    List<DeliveryLog> getDeliveryLogByReferenceNo(String referenceNo);

    ResponseEntity<?> deleteDeliveryLogById(String id);

    ResponseEntity<?> updateDeliveryLog(DeliveryLog deliveryLog);
}
