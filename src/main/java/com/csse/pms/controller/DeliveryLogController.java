package com.csse.pms.controller;

import com.csse.pms.api.DeliveryLogApi;
import com.csse.pms.domain.DeliveryLog;
import com.csse.pms.dto.DeliveryLogDto;
import com.csse.pms.util.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author Chandrasiri S.A.N.L.D.
 *
 * This Class for Delivery Log related implementation
 */

@RestController
@RequestMapping(CommonConstants.DELIVERY_REQUEST_MAPPING)
@CrossOrigin(origins = CommonConstants.STAR, allowedHeaders = CommonConstants.STAR, exposedHeaders = CommonConstants.STAR)
public class DeliveryLogController {

    private DeliveryLogApi deliveryLogApi;

    @Autowired
    public DeliveryLogController(DeliveryLogApi deliveryLogApi) {
        this.deliveryLogApi = deliveryLogApi;
    }

    @PostMapping(CommonConstants.POST_MAPPING_SAVE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createDeliveryLog(@RequestBody DeliveryLogDto deliveryLogDto) {
        DeliveryLog deliveryLog = new DeliveryLog();

        deliveryLog.setReferenceNo(deliveryLogDto.getReferenceNo());
        deliveryLog.setSiteManagerId(deliveryLogDto.getSiteManagerId());
        deliveryLog.setRemark(deliveryLogDto.getRemark());
        deliveryLog.setStatus(deliveryLogDto.getStatus());

        return deliveryLogApi.createDeliveryLog(deliveryLog);
    }

    @GetMapping(CommonConstants.GET_MAPPING_GET)
    @ResponseStatus(HttpStatus.OK)
    public List<DeliveryLog> getAllDeliveryLogs() {
        return deliveryLogApi.getAllDeliveryLogs();
    }

    @GetMapping(CommonConstants.GET_MAPPING_GET_BY_ID)
    @ResponseStatus(HttpStatus.OK)
    public DeliveryLog getDeliveryLogById(@PathVariable String id) {
        return deliveryLogApi.getDeliveryLogById(id);
    }

    @GetMapping(CommonConstants.GET_MAPPING_GET_BY_REFERENCE_NO)
    @ResponseStatus(HttpStatus.OK)
    public List<DeliveryLog> getDeliveryLogByReferenceNo(@PathVariable String referenceNo) {
        return deliveryLogApi.getDeliveryLogByReferenceNo(referenceNo);
    }

    @DeleteMapping(CommonConstants.DELETE_MAPPING_DELETE_BY_ID)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteDeliveryLogById(@PathVariable String id) {
        return deliveryLogApi.deleteDeliveryLogById(id);
    }

    @PutMapping(CommonConstants.PUT_MAPPING_UPDATE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> updateDeliveryLog(@RequestBody DeliveryLogDto deliveryLogDto) {
        DeliveryLog deliveryLog = new DeliveryLog();

        deliveryLog.setId(deliveryLogDto.getId());
        deliveryLog.setReferenceNo(deliveryLogDto.getReferenceNo());
        deliveryLog.setSiteManagerId(deliveryLogDto.getSiteManagerId());
        deliveryLog.setRemark(deliveryLogDto.getRemark());
        deliveryLog.setStatus(deliveryLogDto.getStatus());

        return deliveryLogApi.updateDeliveryLog(deliveryLog);
    }
}
