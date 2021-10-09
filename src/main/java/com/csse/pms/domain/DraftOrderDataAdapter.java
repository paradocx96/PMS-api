package com.csse.pms.domain;

import org.springframework.http.ResponseEntity;
import java.util.List;

/**
 * @author Chandrasiri S.A.N.L.D.
 *
 * This Interface for Draft Order related implementation
 */

public interface DraftOrderDataAdapter {

    ResponseEntity<?> saveDraftOrder(DraftOrder draftOrder);

    List<DraftOrder> getAllDraftOrders();

    DraftOrder getDraftOrderById(String id);

    List<DraftOrder> getDraftOrderBySite(String siteId);

    List<DraftOrder> getDraftOrderByProject(String projectId);

    ResponseEntity<?> deleteDraftOrderById(String id);

    ResponseEntity<?> updateDraftOrder(DraftOrder draftOrder);
}
