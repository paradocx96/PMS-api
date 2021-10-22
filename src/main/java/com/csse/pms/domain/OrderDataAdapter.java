package com.csse.pms.domain;

import org.springframework.http.ResponseEntity;
import java.util.List;

/**
 * @author Chandrasiri S.A.N.L.D.
 *
 * This Interface for Order related implementation
 */

public interface OrderDataAdapter {

    Order purchaseOrder(Order order);

    List<Order> getAllOrders();

    Order getOrderById(String id);

    List<Order> getOrderByStatus(String status);

    List<Order> getOrderBySite(String siteId);

    List<Order> getOrderByProject(String projectId);

    String deleteOrderById(String id);

    String archiveOrder(Order order);

    String updateOrder(Order order);

    String updateOrderStatus(Order order);
}
