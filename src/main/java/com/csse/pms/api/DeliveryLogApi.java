package com.csse.pms.api;

import com.csse.pms.domain.DeliveryLog;
import com.csse.pms.domain.DeliveryLogDataAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author Chandrasiri S.A.N.L.D.
 *
 * This Class for Delivery Log related implementation
 */

@Service
public class DeliveryLogApi {

    private final DeliveryLogDataAdapter deliveryLogDataAdapter;

    @Autowired
    public DeliveryLogApi(DeliveryLogDataAdapter deliveryLogDataAdapter) {
        this.deliveryLogDataAdapter = deliveryLogDataAdapter;
    }

    /**
     * This Method gets parameter as deliveryLog object.
     * Then call create deliveryLog method in Adapter.
     *
     * @param deliveryLog - Relevant deliveryLog object from Controller.
     * @return ResponseEntity<?> - Customized message will be return.
     * @see #createDeliveryLog(DeliveryLog)
     */
    public ResponseEntity<?> createDeliveryLog(DeliveryLog deliveryLog) {
        return deliveryLogDataAdapter.createDeliveryLog(deliveryLog);
    }

    /**
     * This Method call get all deliveryLog method in Adapter.
     *
     * @return List<DeliveryLog> - All founded deliveryLogs will be return as deliveryLog list object.
     * @see #getAllDeliveryLogs()
     */
    public List<DeliveryLog> getAllDeliveryLogs() {
        return deliveryLogDataAdapter.getAllDeliveryLogs();
    }

    /**
     * This Method gets parameter as string deliveryLog-id.
     * Then call get deliveryLog by id method in Adapter.
     *
     * @param id - Relevant deliveryLog id from Controller.
     * @return DeliveryLog - Founded deliveryLog will be return as deliveryLog object.
     * @see #getDeliveryLogById(String)
     */
    public DeliveryLog getDeliveryLogById(String id) {
        return deliveryLogDataAdapter.getDeliveryLogById(id);
    }

    /**
     * This Method gets parameter as string referenceNo.
     * Then call get deliveryLog by referenceNo method in Adapter.
     *
     * @param referenceNo - Relevant deliveryLog referenceNo from Controller.
     * @return List<DeliveryLog> - Founded deliveryLog will be return as deliveryLog list object.
     * @see #getDeliveryLogByReferenceNo(String)
     */
    public List<DeliveryLog> getDeliveryLogByReferenceNo(String referenceNo) {
        return deliveryLogDataAdapter.getDeliveryLogByReferenceNo(referenceNo);
    }

    /**
     * This Method gets parameter as string deliveryLog-id.
     * Then call delete deliveryLog by id method in Adapter.
     *
     * @param id - Relevant deliveryLog-id from Controller.
     * @return ResponseEntity<?> - Customized message will be return.
     * @see #deleteDeliveryLogById(String)
     */
    public ResponseEntity<?> deleteDeliveryLogById(String id) {
        return deliveryLogDataAdapter.deleteDeliveryLogById(id);
    }

    /**
     * This Method gets parameter as deliveryLog object.
     * Then call the update deliveryLog method in Adapter.
     *
     * @param deliveryLog - Relevant deliveryLog object from Controller.
     * @return ResponseEntity<?> - Customized message will be return.
     * @see #updateDeliveryLog(DeliveryLog)
     */
    public ResponseEntity<?> updateDeliveryLog(DeliveryLog deliveryLog) {
        return deliveryLogDataAdapter.updateDeliveryLog(deliveryLog);
    }
}
