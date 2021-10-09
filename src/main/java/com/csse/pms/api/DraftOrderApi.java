package com.csse.pms.api;

import com.csse.pms.domain.DraftOrder;
import com.csse.pms.domain.DraftOrderDataAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author Chandrasiri S.A.N.L.D.
 *
 * This Class for Draft Order related implementation
 */

@Service
public class DraftOrderApi {

    private final DraftOrderDataAdapter draftOrderDataAdapter;

    @Autowired
    public DraftOrderApi(DraftOrderDataAdapter draftOrderDataAdapter) {
        this.draftOrderDataAdapter = draftOrderDataAdapter;
    }

    /**
     * This Method gets parameter as draft Order object.
     * Then call purchase draft order method in Adapter.
     *
     * @param draftOrder - Relevant draft Order object from Controller.
     * @return ResponseEntity<?> - Customized message will be return.
     * @see #saveDraftOrder(DraftOrder)
     */
    public ResponseEntity<?> saveDraftOrder(DraftOrder draftOrder) {
        return draftOrderDataAdapter.saveDraftOrder(draftOrder);
    }

    /**
     * This Method call get all draft order method in Adapter.
     *
     * @return List<DraftOrder> - All founded draft orders will be return as draft order list object.
     * @see #getAllDraftOrders()
     */
    public List<DraftOrder> getAllDraftOrders() {
        return draftOrderDataAdapter.getAllDraftOrders();
    }

    /**
     * This Method gets parameter as string order-id.
     * Then call get draft order by id method in Adapter.
     *
     * @param id - Relevant draft Order id from Controller.
     * @return Order - Founded draft order will be return as order object.
     * @see #getDraftOrderById(String)
     */
    public DraftOrder getDraftOrderById(String id) {
        return draftOrderDataAdapter.getDraftOrderById(id);
    }

    /**
     * This Method gets parameter as string site-id.
     * Then call get draft order by site id method in Adapter.
     *
     * @param siteId - Relevant draft Order site-id from Controller.
     * @return List<DraftOrder> - Founded order will be return as draft order list object.
     * @see #getDraftOrderBySite(String)
     */
    public List<DraftOrder> getDraftOrderBySite(String siteId) {
        return draftOrderDataAdapter.getDraftOrderBySite(siteId);
    }

    /**
     * This Method gets parameter as string project-id.
     * Then call get order by project id method in Adapter.
     *
     * @param projectId - Relevant draft Order project-id from Controller.
     * @return List<DraftOrder> - Founded order will be return as draft order list object.
     * @see #getDraftOrderByProject(String)
     */
    public List<DraftOrder> getDraftOrderByProject(String projectId) {
        return draftOrderDataAdapter.getDraftOrderByProject(projectId);
    }

    /**
     * This Method gets parameter as string draft-order-id.
     * Then call delete draft order by id method in Adapter.
     *
     * @param id - Relevant draft-order-id from Controller.
     * @return ResponseEntity<?> - Customized message will be return.
     * @see #deleteDraftOrderById(String)
     */
    public ResponseEntity<?> deleteDraftOrderById(String id) {
        return draftOrderDataAdapter.deleteDraftOrderById(id);
    }

    /**
     * This Method gets parameter as draft order object.
     * Then call the update draft order method in Adapter.
     *
     * @param draftOrder - Relevant draft Order object from Controller.
     * @return ResponseEntity<?> - Customized message will be return.
     * @see #updateDraftOrder(DraftOrder)
     */
    public ResponseEntity<?> updateDraftOrder(DraftOrder draftOrder) {
        return draftOrderDataAdapter.updateDraftOrder(draftOrder);
    }
}
