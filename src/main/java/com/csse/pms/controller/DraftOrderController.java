package com.csse.pms.controller;

import com.csse.pms.api.DraftOrderApi;
import com.csse.pms.domain.DraftOrder;
import com.csse.pms.dto.DraftOrderDto;
import com.csse.pms.util.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Chandrasiri S.A.N.L.D.
 *
 * This Class for Draft Order related implementation
 */

@RestController
@RequestMapping(CommonConstants.DRAFT_ORDER_REQUEST_MAPPING)
@CrossOrigin(origins = CommonConstants.STAR, allowedHeaders = CommonConstants.STAR, exposedHeaders = CommonConstants.STAR)
public class DraftOrderController {

    private DraftOrderApi draftOrderApi;

    @Autowired
    public DraftOrderController(DraftOrderApi draftOrderApi) {
        this.draftOrderApi = draftOrderApi;
    }

    @PostMapping(CommonConstants.POST_MAPPING_SAVE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> saveDraftOrder(@RequestBody DraftOrderDto draftOrderDto) {
        DraftOrder draftOrder = new DraftOrder();

        draftOrder.setSupplierId(draftOrderDto.getSupplierId());
        draftOrder.setItemList(draftOrderDto.getItemList());
        draftOrder.setSiteManagerId(draftOrderDto.getSiteManagerId());
        draftOrder.setSiteId(draftOrderDto.getSiteId());
        draftOrder.setProjectId(draftOrderDto.getProjectId());
        draftOrder.setAmount(draftOrderDto.getAmount());
        draftOrder.setContactDetails(draftOrderDto.getContactDetails());
        draftOrder.setComment(draftOrderDto.getComment());
        draftOrder.setStatus(draftOrderDto.getStatus());
        draftOrder.setDateTime(LocalDateTime.now());

        return draftOrderApi.saveDraftOrder(draftOrder);
    }

    @GetMapping(CommonConstants.GET_MAPPING_GET)
    @ResponseStatus(HttpStatus.OK)
    public List<DraftOrder> getAllDraftOrders() {
        return draftOrderApi.getAllDraftOrders();
    }

    @GetMapping(CommonConstants.GET_MAPPING_GET_BY_ID)
    @ResponseStatus(HttpStatus.OK)
    public DraftOrder getDraftOrderById(@PathVariable String id) {
        return draftOrderApi.getDraftOrderById(id);
    }

    @GetMapping(CommonConstants.GET_MAPPING_GET_BY_SITE_ID)
    @ResponseStatus(HttpStatus.OK)
    public List<DraftOrder> getDraftOrderBySite(@PathVariable String id) {
        return draftOrderApi.getDraftOrderBySite(id);
    }

    @GetMapping(CommonConstants.GET_MAPPING_GET_BY_PROJECT_ID)
    @ResponseStatus(HttpStatus.OK)
    public List<DraftOrder> getDraftOrderByProject(@PathVariable String id) {
        return draftOrderApi.getDraftOrderByProject(id);
    }

    @DeleteMapping(CommonConstants.DELETE_MAPPING_DELETE_BY_ID)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteDraftOrderById(@PathVariable String id) {
        return draftOrderApi.deleteDraftOrderById(id);
    }

    @PutMapping(CommonConstants.PUT_MAPPING_UPDATE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> updateDraftOrder(@RequestBody DraftOrderDto draftOrderDto) {
        DraftOrder draftOrder = new DraftOrder();

        draftOrder.setId(draftOrderDto.getId());
        draftOrder.setSupplierId(draftOrderDto.getSupplierId());
        draftOrder.setItemList(draftOrderDto.getItemList());
        draftOrder.setSiteManagerId(draftOrderDto.getSiteManagerId());
        draftOrder.setAmount(draftOrderDto.getAmount());
        draftOrder.setContactDetails(draftOrderDto.getContactDetails());
        draftOrder.setComment(draftOrderDto.getComment());
        draftOrder.setStatus(draftOrderDto.getStatus());
        draftOrder.setDateTime(LocalDateTime.now());

        return draftOrderApi.updateDraftOrder(draftOrder);
    }
}
