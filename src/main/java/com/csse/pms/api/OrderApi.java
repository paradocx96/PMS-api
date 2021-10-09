package com.csse.pms.api;

import com.csse.pms.domain.Order;
import com.csse.pms.domain.OrderDataAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author Chandrasiri S.A.N.L.D.
 *
 * This Class for Order related implementation
 */

@Service
public class OrderApi {

    private final OrderDataAdapter orderDataAdapter;

    @Autowired
    public OrderApi(OrderDataAdapter orderDataAdapter) {
        this.orderDataAdapter = orderDataAdapter;
    }

    /**
     * This Method gets parameter as Order object.
     * Then call purchase order method in Adapter.
     *
     * @param order - Relevant Order object from Controller.
     * @return ResponseEntity<?> - Customized message will be return.
     * @see #purchaseOrder(Order)
     */
    public ResponseEntity<?> purchaseOrder(Order order) {
        return orderDataAdapter.purchaseOrder(order);
    }

    /**
     * This Method call get all order method in Adapter.
     *
     * @return List<Order> - All founded orders will be return as order list object.
     * @see #getAllOrders()
     */
    public List<Order> getAllOrders() {
        return orderDataAdapter.getAllOrders();
    }

    /**
     * This Method gets parameter as string order-id.
     * Then call get order by id method in Adapter.
     *
     * @param id - Relevant Order id from Controller.
     * @return Order - Founded order will be return as order object.
     * @see #getOrderById(String)
     */
    public Order getOrderById(String id) {
        return orderDataAdapter.getOrderById(id);
    }

    /**
     * This Method gets parameter as string status.
     * Then call get order by status method in Adapter.
     *
     * @param status - Relevant Order status from Controller.
     * @return List<Order> - Founded order will be return as order list object.
     * @see #getOrderByStatus(String)
     */
    public List<Order> getOrderByStatus(String status) {
        return orderDataAdapter.getOrderByStatus(status);
    }

    /**
     * This Method gets parameter as string site-id.
     * Then call get order by site id method in Adapter.
     *
     * @param siteId - Relevant Order site-id from Controller.
     * @return List<Order> - Founded order will be return as order list object.
     * @see #getOrderBySite(String)
     */
    public List<Order> getOrderBySite(String siteId) {
        return orderDataAdapter.getOrderBySite(siteId);
    }

    /**
     * This Method gets parameter as string project-id.
     * Then call get order by project id method in Adapter.
     *
     * @param projectId - Relevant Order project-id from Controller.
     * @return List<Order> - Founded order will be return as order list object.
     * @see #getOrderByProject(String)
     */
    public List<Order> getOrderByProject(String projectId) {
        return orderDataAdapter.getOrderByProject(projectId);
    }

    /**
     * This Method gets parameter as string order-id.
     * Then call delete order by id method in Adapter.
     *
     * @param id - Relevant Order-id from Controller.
     * @return ResponseEntity<?> - Customized message will be return.
     * @see #deleteOrderById(String)
     */
    public ResponseEntity<?> deleteOrderById(String id) {
        return orderDataAdapter.deleteOrderById(id);
    }

    /**
     * This Method gets parameter as order object.
     * Then call the archive order method in Adapter.
     *
     * @param order - Relevant Order object from Controller.
     * @return ResponseEntity<?> - Customized message will be return.
     * @see #archiveOrder(Order)
     */
    public ResponseEntity<?> archiveOrder(Order order) {
        return orderDataAdapter.archiveOrder(order);
    }

    /**
     * This Method gets parameter as order object.
     * Then call the update order method in Adapter.
     *
     * @param order - Relevant Order object from Controller.
     * @return ResponseEntity<?> - Customized message will be return.
     * @see #updateOrder(Order)
     */
    public ResponseEntity<?> updateOrder(Order order) {
        return orderDataAdapter.updateOrder(order);
    }

    /**
     * This Method gets parameter as order object.
     * Then call the update order status method in Adapter.
     *
     * @param order - Relevant Order object from Controller.
     * @return ResponseEntity<?> - Customized message will be return.
     * @see #updateOrderStatus(Order)
     */
    public ResponseEntity<?> updateOrderStatus(Order order) {
        return orderDataAdapter.updateOrderStatus(order);
    }
}
