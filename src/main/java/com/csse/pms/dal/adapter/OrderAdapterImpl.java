package com.csse.pms.dal.adapter;

import com.csse.pms.dal.model.OrderModel;
import com.csse.pms.dal.repository.OrderRepository;
import com.csse.pms.domain.Order;
import com.csse.pms.domain.OrderDataAdapter;
import com.csse.pms.dto.MessageResponseDto;
import com.csse.pms.util.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Chandrasiri S.A.N.L.D.
 *
 * This Class for Order related implementation
 */

@Component
public class OrderAdapterImpl implements OrderDataAdapter {

    /**
     * Initialize Logger
     */
    public static final Logger LOGGER = Logger.getLogger(OrderAdapterImpl.class.getName());

    private final OrderRepository repository;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public OrderAdapterImpl(OrderRepository repository, MongoTemplate mongoTemplate) {
        this.repository = repository;
        this.mongoTemplate = mongoTemplate;
    }

    /**
     * This Method gets parameter as Order object and assign to new order-model object.
     * Then order model object save in order collection in MongoDB Cluster database.
     *
     * @param order - Order object from OrderApi class.
     * @return ResponseEntity<?> - Customized message will be return.
     * @throws Exception - Common Exception to be handled.
     * @see #purchaseOrder(Order)
     */
    @Override
    public ResponseEntity<?> purchaseOrder(Order order) {

        OrderModel orderModel = new OrderModel();

        try {
            orderModel.setReferenceNo(order.getReferenceNo());
            orderModel.setSupplierId(order.getSupplierId());
            orderModel.setItemList(order.getItemList());
            orderModel.setSiteManagerId(order.getSiteManagerId());
            orderModel.setSiteId(order.getSiteId());
            orderModel.setProjectId(order.getProjectId());
            orderModel.setAmount(order.getAmount());
            orderModel.setContactDetails(order.getContactDetails());
            orderModel.setComment(order.getComment());
            orderModel.setDateTime(order.getDateTime());
            orderModel.setStatus(order.getStatus());

            orderModel = repository.save(orderModel);
            LOGGER.log(Level.INFO, orderModel.toString());

            return ResponseEntity.ok(new MessageResponseDto(CommonConstants.ORDER_PURCHASE_SUCCESSFULLY));
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            return ResponseEntity.ok(new MessageResponseDto(CommonConstants.ORDER_PURCHASE_ERROR));
        }
    }

    /**
     * This Method gets all orders saved in order collection in MongoDB Cluster database.
     * Then assign to order model list object.
     * Then using for loop assign to order list object.
     *
     * @return List<Order> - All founded orders will be return as order list object.
     * @throws Exception - Common Exception to be handled.
     * @see #getAllOrders()
     */
    @Override
    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();

        try {
            List<OrderModel> orderModels = repository.findAll();

            for (OrderModel orderModel : orderModels) {
                Order order = new Order();

                order.setId(orderModel.getId());
                order.setReferenceNo(orderModel.getReferenceNo());
                order.setSupplierId(orderModel.getSupplierId());
                order.setItemList(orderModel.getItemList());
                order.setSiteManagerId(orderModel.getSiteManagerId());
                order.setSiteId(orderModel.getSiteId());
                order.setProjectId(orderModel.getProjectId());
                order.setAmount(orderModel.getAmount());
                order.setContactDetails(orderModel.getContactDetails());
                order.setComment(orderModel.getComment());
                order.setDateTime(orderModel.getDateTime());
                order.setStatus(orderModel.getStatus());

                orders.add(order);
            }
            return orders;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            return orders;
        }
    }

    /**
     * This Method gets parameter as String id.
     * Then find the order using the id of order saved in order collection in MongoDB Cluster database.
     * Then founded order assign to order model object.
     * Then using for loop assign to order object.
     *
     * @param id - Relevant Order id from OrderApi class.
     * @return Order - Founded order will be return as order object.
     * @throws NoSuchElementException - If method cannot find the relevant order from database this will throw.
     * @see #getOrderById(String)
     */
    @Override
    public Order getOrderById(String id) {
        OrderModel orderModel;
        Order order = new Order();

        try {
            orderModel = repository.findById(id).get();

            order.setId(orderModel.getId());
            order.setReferenceNo(orderModel.getReferenceNo());
            order.setSupplierId(orderModel.getSupplierId());
            order.setItemList(orderModel.getItemList());
            order.setSiteManagerId(orderModel.getSiteManagerId());
            order.setSiteId(orderModel.getSiteId());
            order.setProjectId(orderModel.getProjectId());
            order.setAmount(orderModel.getAmount());
            order.setContactDetails(orderModel.getContactDetails());
            order.setComment(orderModel.getComment());
            order.setDateTime(orderModel.getDateTime());
            order.setStatus(orderModel.getStatus());

            return order;
        } catch (NoSuchElementException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            return order;
        }
    }

    /**
     * This Method gets parameter as String status.
     * Then find the orders using the status of order saved in order collection in MongoDB Cluster database.
     * Then founded orders assign to order model list object.
     * Then using for loop assign to order list object.
     *
     * @param status - Relevant Order status from OrderApi class.
     * @return List<Order> - Founded order will be return as order list object.
     * @throws Exception - If method cannot find the relevant orders from database this will throw.
     * @see #getOrderByStatus(String)
     */
    @Override
    public List<Order> getOrderByStatus(String status) {
        List<Order> orders = new ArrayList<>();

        try {
            List<OrderModel> orderModels = repository.findByStatus(status);

            for (OrderModel orderModel : orderModels) {
                Order order = new Order();

                order.setId(orderModel.getId());
                order.setReferenceNo(orderModel.getReferenceNo());
                order.setSupplierId(orderModel.getSupplierId());
                order.setItemList(orderModel.getItemList());
                order.setSiteManagerId(orderModel.getSiteManagerId());
                order.setSiteId(orderModel.getSiteId());
                order.setProjectId(orderModel.getProjectId());
                order.setAmount(orderModel.getAmount());
                order.setContactDetails(orderModel.getContactDetails());
                order.setComment(orderModel.getComment());
                order.setDateTime(orderModel.getDateTime());
                order.setStatus(orderModel.getStatus());

                orders.add(order);
            }
            return orders;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            return orders;
        }
    }

    /**
     * This Method gets parameter as String site-id.
     * Then find the orders using the site-id of order saved in order collection in MongoDB Cluster database.
     * Then founded orders assign to order model list object.
     * Then using for loop assign to order list object.
     *
     * @param siteId - Relevant Order site-id from OrderApi class.
     * @return List<Order> - Founded order will be return as order list object.
     * @throws Exception - If method cannot find the relevant orders from database this will throw.
     * @see #getOrderBySite(String)
     */
    @Override
    public List<Order> getOrderBySite(String siteId) {
        List<Order> orders = new ArrayList<>();

        try {
            List<OrderModel> orderModels = repository.findBySiteId(siteId);

            for (OrderModel orderModel : orderModels) {
                Order order = new Order();

                order.setId(orderModel.getId());
                order.setReferenceNo(orderModel.getReferenceNo());
                order.setSupplierId(orderModel.getSupplierId());
                order.setItemList(orderModel.getItemList());
                order.setSiteManagerId(orderModel.getSiteManagerId());
                order.setSiteId(orderModel.getSiteId());
                order.setProjectId(orderModel.getProjectId());
                order.setAmount(orderModel.getAmount());
                order.setContactDetails(orderModel.getContactDetails());
                order.setComment(orderModel.getComment());
                order.setDateTime(orderModel.getDateTime());
                order.setStatus(orderModel.getStatus());

                orders.add(order);
            }
            return orders;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            return orders;
        }
    }

    /**
     * This Method gets parameter as String project-id.
     * Then find the orders using the project-id of order saved in order collection in MongoDB Cluster database.
     * Then founded orders assign to order model list object.
     * Then using for loop assign to order list object.
     *
     * @param projectId - Relevant Order project-id from OrderApi class.
     * @return List<Order> - Founded order will be return as order list object.
     * @throws Exception - If method cannot find the relevant orders from database this will throw.
     * @see #getOrderByProject(String)
     */
    @Override
    public List<Order> getOrderByProject(String projectId) {
        List<Order> orders = new ArrayList<>();

        try {
            List<OrderModel> orderModels = repository.findByProjectId(projectId);

            for (OrderModel orderModel : orderModels) {
                Order order = new Order();

                order.setId(orderModel.getId());
                order.setReferenceNo(orderModel.getReferenceNo());
                order.setSupplierId(orderModel.getSupplierId());
                order.setItemList(orderModel.getItemList());
                order.setSiteManagerId(orderModel.getSiteManagerId());
                order.setSiteId(orderModel.getSiteId());
                order.setProjectId(orderModel.getProjectId());
                order.setAmount(orderModel.getAmount());
                order.setContactDetails(orderModel.getContactDetails());
                order.setComment(orderModel.getComment());
                order.setDateTime(orderModel.getDateTime());
                order.setStatus(orderModel.getStatus());

                orders.add(order);
            }
            return orders;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            return orders;
        }
    }

    /**
     * This Method gets parameter as String order id.
     * Then find the order using the id of order saved in order collection in MongoDB Cluster database.
     * Then delete order using id saved in order collection in MongoDB Cluster database.
     *
     * @param id - Relevant Order id from OrderApi class.
     * @return ResponseEntity<?> - Customized message will be return.
     * @throws NoSuchElementException - If method cannot find the relevant orders or delete order from database this will throw.
     * @see #deleteOrderById(String)
     */
    @Override
    public ResponseEntity<?> deleteOrderById(String id) {
        OrderModel orderModel = null;

        try {
            orderModel = repository.findById(id).get();
            if (orderModel != null) {
                repository.deleteById(id);
                return ResponseEntity.ok(new MessageResponseDto(CommonConstants.ORDER_DELETE_SUCCESSFULLY));
            } else {
                return ResponseEntity.ok(new MessageResponseDto(CommonConstants.ORDER_DOES_NOT_EXIST));
            }
        } catch (NoSuchElementException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            return ResponseEntity.ok(new MessageResponseDto(CommonConstants.ORDER_DELETE_ERROR));
        }
    }

    /**
     * This Method gets parameter as order object.
     * Then find the order using the id of order saved in order collection in MongoDB Cluster database.
     * Then update order status using id saved in order collection in MongoDB Cluster database.
     *
     * @param order - Relevant Order object from OrderApi class.
     * @return ResponseEntity<?> - Customized message will be return.
     * @throws Exception - If method cannot find the relevant orders from database this will throw.
     * @see #archiveOrder(Order)
     */
    @Override
    public ResponseEntity<?> archiveOrder(Order order) {
        try {
            OrderModel orderModel = mongoTemplate.findAndModify(
                    Query.query(Criteria.where(CommonConstants.ID).is(order.getId())),
                    new Update().set(CommonConstants.STATUS, order.getStatus()),
                    OrderModel.class
            );

            if (orderModel != null) {
                return ResponseEntity.ok(new MessageResponseDto(CommonConstants.ORDER_ARCHIVE_SUCCESSFULLY));
            } else {
                return ResponseEntity.ok(new MessageResponseDto(CommonConstants.ORDER_DOES_NOT_EXIST));
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            return ResponseEntity.ok(new MessageResponseDto(CommonConstants.ORDER_ARCHIVE_ERROR));
        }
    }

    /**
     * This Method gets parameter as order object.
     * Then find the order using the id of order saved in order collection in MongoDB Cluster database.
     * Then update order using id saved in order collection in MongoDB Cluster database.
     *
     * @param order - Relevant Order object from OrderApi class.
     * @return ResponseEntity<?> - Customized message will be return.
     * @throws Exception - If method cannot find the relevant orders from database this will throw.
     * @see #updateOrder(Order)
     */
    @Override
    public ResponseEntity<?> updateOrder(Order order) {
        try {
            OrderModel orderModel = mongoTemplate.findAndModify(
                    Query.query(Criteria.where(CommonConstants.ID).is(order.getId())),
                    new Update()
                            .set(CommonConstants.SUPPLIER_ID, order.getSupplierId())
                            .set(CommonConstants.ITEM_LIST, order.getItemList())
                            .set(CommonConstants.SITE_MANAGER_ID, order.getSiteManagerId())
                            .set(CommonConstants.AMOUNT, order.getAmount())
                            .set(CommonConstants.CONTACT_DETAILS, order.getContactDetails())
                            .set(CommonConstants.COMMENT, order.getComment())
                            .set(CommonConstants.DATE_TIME, order.getDateTime())
                            .set(CommonConstants.STATUS, order.getStatus()),
                    OrderModel.class
            );

            if (orderModel != null) {
                return ResponseEntity.ok(new MessageResponseDto(CommonConstants.ORDER_UPDATE_SUCCESSFULLY));
            } else {
                return ResponseEntity.ok(new MessageResponseDto(CommonConstants.ORDER_DOES_NOT_EXIST));
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            return ResponseEntity.ok(new MessageResponseDto(CommonConstants.ORDER_UPDATE_ERROR));
        }
    }

    /**
     * This Method gets parameter as order object.
     * Then find the order using the id of order saved in order collection in MongoDB Cluster database.
     * Then update order status using id saved in order collection in MongoDB Cluster database.
     *
     * @param order - Relevant Order object from OrderApi class.
     * @return ResponseEntity<?> - Customized message will be return.
     * @throws Exception - If method cannot find the relevant orders from database this will throw.
     * @see #updateOrderStatus(Order)
     */
    @Override
    public ResponseEntity<?> updateOrderStatus(Order order) {
        try {
            OrderModel orderModel = mongoTemplate.findAndModify(
                    Query.query(Criteria.where(CommonConstants.ID).is(order.getId())),
                    new Update().set(CommonConstants.STATUS, order.getStatus()),
                    OrderModel.class
            );

            if (orderModel != null) {
                return ResponseEntity.ok(new MessageResponseDto(CommonConstants.ORDER_STATUS_UPDATE_SUCCESSFULLY));
            } else {
                return ResponseEntity.ok(new MessageResponseDto(CommonConstants.ORDER_DOES_NOT_EXIST));
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            return ResponseEntity.ok(new MessageResponseDto(CommonConstants.ORDER_STATUS_UPDATE_ERROR));
        }
    }
}
