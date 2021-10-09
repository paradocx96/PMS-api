package com.csse.pms.controller;

import com.csse.pms.api.OrderApi;
import com.csse.pms.domain.Order;
import com.csse.pms.dto.OrderDto;
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
 * This Class for Order related implementation
 */

@RestController
@RequestMapping(CommonConstants.ORDER_REQUEST_MAPPING)
@CrossOrigin(origins = CommonConstants.STAR, allowedHeaders = CommonConstants.STAR, exposedHeaders = CommonConstants.STAR)
public class OrderController {

    private OrderApi orderApi;

    @Autowired
    public OrderController(OrderApi orderApi) {
        this.orderApi = orderApi;
    }

    @PostMapping(CommonConstants.POST_MAPPING_PURCHASE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> purchaseOrder(@RequestBody OrderDto orderDto) {
        Order purchase = new Order();

        purchase.setReferenceNo(orderDto.getReferenceNo());
        purchase.setSupplierId(orderDto.getSupplierId());
        purchase.setItemList(orderDto.getItemList());
        purchase.setSiteManagerId(orderDto.getSiteManagerId());
        purchase.setSiteId(orderDto.getSiteId());
        purchase.setProjectId(orderDto.getProjectId());
        purchase.setAmount(orderDto.getAmount());
        purchase.setContactDetails(orderDto.getContactDetails());
        purchase.setComment(orderDto.getComment());
        purchase.setDateTime(LocalDateTime.now());
        purchase.setStatus(orderDto.getStatus());

        return orderApi.purchaseOrder(purchase);
    }

    @GetMapping(CommonConstants.GET_MAPPING_GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Order> getAllOrders() {
        return orderApi.getAllOrders();
    }

    @GetMapping(CommonConstants.GET_MAPPING_GET_BY_ID)
    @ResponseStatus(HttpStatus.OK)
    public Order getOrderById(@PathVariable String id) {
        return orderApi.getOrderById(id);
    }

    @GetMapping(CommonConstants.GET_MAPPING_GET_BY_STATUS)
    @ResponseStatus(HttpStatus.OK)
    public List<Order> getOrderByStatus(@PathVariable String status) {
        return orderApi.getOrderByStatus(status);
    }

    @GetMapping(CommonConstants.GET_MAPPING_GET_BY_SITE_ID)
    @ResponseStatus(HttpStatus.OK)
    public List<Order> getOrderBySite(@PathVariable String id) {
        return orderApi.getOrderBySite(id);
    }

    @GetMapping(CommonConstants.GET_MAPPING_GET_BY_PROJECT_ID)
    @ResponseStatus(HttpStatus.OK)
    public List<Order> getOrderByProject(@PathVariable String id) {
        return orderApi.getOrderByProject(id);
    }

    @DeleteMapping(CommonConstants.DELETE_MAPPING_DELETE_BY_ID)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteOrderById(@PathVariable String id) {
        return orderApi.deleteOrderById(id);
    }

    @PutMapping(CommonConstants.PUT_MAPPING_ARCHIVE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> archiveOrder(@RequestBody OrderDto orderDto) {
        Order order = new Order();
        order.setId(orderDto.getId());
        order.setStatus(orderDto.getStatus());

        return orderApi.archiveOrder(order);
    }

    @PutMapping(CommonConstants.PUT_MAPPING_UPDATE_STATUS)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> updateOrderStatus(@RequestBody OrderDto orderDto) {
        Order order = new Order();
        order.setId(orderDto.getId());
        order.setStatus(orderDto.getStatus());

        return orderApi.updateOrderStatus(order);
    }

    @PutMapping(CommonConstants.PUT_MAPPING_UPDATE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> updateOrder(@RequestBody OrderDto orderDto) {
        Order order = new Order();
        order.setId(orderDto.getId());
        order.setSupplierId(orderDto.getSupplierId());
        order.setItemList(orderDto.getItemList());
        order.setSiteManagerId(orderDto.getSiteManagerId());
        order.setAmount(orderDto.getAmount());
        order.setContactDetails(orderDto.getContactDetails());
        order.setComment(orderDto.getComment());
        order.setDateTime(LocalDateTime.now());
        order.setStatus(orderDto.getStatus());

        return orderApi.updateOrder(order);
    }
}
