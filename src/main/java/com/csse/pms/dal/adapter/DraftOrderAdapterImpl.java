package com.csse.pms.dal.adapter;

import com.csse.pms.dal.model.DraftOrderModel;
import com.csse.pms.dal.repository.DraftOrderRepository;
import com.csse.pms.domain.DraftOrder;
import com.csse.pms.domain.DraftOrderDataAdapter;
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
 * This Class for Draft Order related implementation
 */

@Component
public class DraftOrderAdapterImpl implements DraftOrderDataAdapter {

    /**
     * Initialize Logger
     */
    public static final Logger LOGGER = Logger.getLogger(DraftOrderAdapterImpl.class.getName());

    private final DraftOrderRepository repository;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public DraftOrderAdapterImpl(DraftOrderRepository repository, MongoTemplate mongoTemplate) {
        this.repository = repository;
        this.mongoTemplate = mongoTemplate;
    }

    /**
     * This Method gets parameter as draft Order object and assign to new draft order model object.
     * Then draft order model object save in draft order collection in MongoDB Cluster database.
     *
     * @param draftOrder - draft Order object from draftOrderApi class.
     * @return ResponseEntity<?> - Customized message will be return.
     * @throws Exception - Common Exception to be handled.
     * @see #saveDraftOrder(DraftOrder)
     */
    @Override
    public ResponseEntity<?> saveDraftOrder(DraftOrder draftOrder) {

        DraftOrderModel draftOrderModel = new DraftOrderModel();

        try {
            draftOrderModel.setSupplierId(draftOrder.getSupplierId());
            draftOrderModel.setItemList(draftOrder.getItemList());
            draftOrderModel.setSiteManagerId(draftOrder.getSiteManagerId());
            draftOrderModel.setSiteId(draftOrder.getSiteId());
            draftOrderModel.setProjectId(draftOrder.getProjectId());
            draftOrderModel.setAmount(draftOrder.getAmount());
            draftOrderModel.setContactDetails(draftOrder.getContactDetails());
            draftOrderModel.setComment(draftOrder.getComment());
            draftOrderModel.setStatus(draftOrder.getStatus());
            draftOrderModel.setDateTime(draftOrder.getDateTime());

            draftOrderModel = repository.save(draftOrderModel);
            LOGGER.log(Level.INFO, draftOrderModel.toString());

            return ResponseEntity.ok(new MessageResponseDto(CommonConstants.ORDER_SAVE_SUCCESSFULLY));
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            return ResponseEntity.ok(new MessageResponseDto(CommonConstants.ORDER_SAVE_ERROR));
        }
    }

    /**
     * This Method gets all draft orders saved in draft order collection in MongoDB Cluster database.
     * Then assign to draft order model list object.
     * Then using for loop assign to draft order list object.
     *
     * @return List<DraftOrder> - All founded draft orders will be return as draft order list object.
     * @throws Exception - Common Exception to be handled.
     * @see #getAllDraftOrders()
     */
    @Override
    public List<DraftOrder> getAllDraftOrders() {
        List<DraftOrder> draftOrders = new ArrayList<>();

        try {
            List<DraftOrderModel> draftOrderModels = repository.findAll();

            for (DraftOrderModel draftOrderModel : draftOrderModels) {
                DraftOrder draftOrder = new DraftOrder();

                draftOrder.setId(draftOrderModel.getId());
                draftOrder.setSupplierId(draftOrderModel.getSupplierId());
                draftOrder.setItemList(draftOrderModel.getItemList());
                draftOrder.setSiteManagerId(draftOrderModel.getSiteManagerId());
                draftOrder.setSiteId(draftOrderModel.getSiteId());
                draftOrder.setProjectId(draftOrderModel.getProjectId());
                draftOrder.setAmount(draftOrderModel.getAmount());
                draftOrder.setContactDetails(draftOrderModel.getContactDetails());
                draftOrder.setComment(draftOrderModel.getComment());
                draftOrder.setStatus(draftOrderModel.getStatus());
                draftOrder.setDateTime(draftOrderModel.getDateTime());

                draftOrders.add(draftOrder);
            }
            return draftOrders;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            return draftOrders;
        }
    }

    /**
     * This Method gets parameter as String id.
     * Then find the draft order using the id of draft order saved in draft order collection in MongoDB Cluster database.
     * Then founded draft order assign to draft order model object.
     * Then using for loop assign to draft order object.
     *
     * @param id - Relevant draft Order id from draftOrderApi class.
     * @return DraftOrder - Founded draft order will be return as draft order object.
     * @throws NoSuchElementException - If method cannot find the relevant draft order from database this will throw.
     * @see #getDraftOrderById(String)
     */
    @Override
    public DraftOrder getDraftOrderById(String id) {
        DraftOrderModel draftOrderModel;
        DraftOrder draftOrder = new DraftOrder();

        try {
            draftOrderModel = repository.findById(id).get();

            draftOrder.setId(draftOrderModel.getId());
            draftOrder.setSupplierId(draftOrderModel.getSupplierId());
            draftOrder.setItemList(draftOrderModel.getItemList());
            draftOrder.setSiteManagerId(draftOrderModel.getSiteManagerId());
            draftOrder.setSiteId(draftOrderModel.getSiteId());
            draftOrder.setProjectId(draftOrderModel.getProjectId());
            draftOrder.setAmount(draftOrderModel.getAmount());
            draftOrder.setContactDetails(draftOrderModel.getContactDetails());
            draftOrder.setComment(draftOrderModel.getComment());
            draftOrder.setStatus(draftOrderModel.getStatus());
            draftOrder.setDateTime(draftOrderModel.getDateTime());

            return draftOrder;
        } catch (NoSuchElementException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            return draftOrder;
        }
    }

    /**
     * This Method gets parameter as String site-id.
     * Then find the draft orders using the site-id of draft order saved in draft order collection in MongoDB Cluster database.
     * Then founded draft orders assign to draft order model list object.
     * Then using for loop assign to draft order list object.
     *
     * @param siteId - Relevant draft Order site-id from draftOrderApi class.
     * @return List<DraftOrder> - Founded draft order will be return as draft order list object.
     * @throws Exception - If method cannot find the relevant draft orders from database this will throw.
     * @see #getDraftOrderBySite(String)
     */
    @Override
    public List<DraftOrder> getDraftOrderBySite(String siteId) {
        List<DraftOrder> draftOrders = new ArrayList<>();

        try {
            List<DraftOrderModel> draftOrderModels = repository.findBySiteId(siteId);

            for (DraftOrderModel draftOrderModel : draftOrderModels) {
                DraftOrder draftOrder = new DraftOrder();

                draftOrder.setId(draftOrderModel.getId());
                draftOrder.setSupplierId(draftOrderModel.getSupplierId());
                draftOrder.setItemList(draftOrderModel.getItemList());
                draftOrder.setSiteManagerId(draftOrderModel.getSiteManagerId());
                draftOrder.setSiteId(draftOrderModel.getSiteId());
                draftOrder.setProjectId(draftOrderModel.getProjectId());
                draftOrder.setAmount(draftOrderModel.getAmount());
                draftOrder.setContactDetails(draftOrderModel.getContactDetails());
                draftOrder.setComment(draftOrderModel.getComment());
                draftOrder.setStatus(draftOrderModel.getStatus());
                draftOrder.setDateTime(draftOrderModel.getDateTime());

                draftOrders.add(draftOrder);
            }
            return draftOrders;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            return draftOrders;
        }
    }

    /**
     * This Method gets parameter as String project-id.
     * Then find the draft orders using the project-id of draft order saved in draft order collection in MongoDB Cluster database.
     * Then founded draft orders assign to draft order model list object.
     * Then using for loop assign to draft order list object.
     *
     * @param projectId - Relevant draft Order project-id from draftOrderApi class.
     * @return List<DraftOrder> - Founded draft order will be return as draft order list object.
     * @throws Exception - If method cannot find the relevant draft orders from database this will throw.
     * @see #getDraftOrderByProject(String)
     */
    @Override
    public List<DraftOrder> getDraftOrderByProject(String projectId) {
        List<DraftOrder> draftOrders = new ArrayList<>();

        try {
            List<DraftOrderModel> draftOrderModels = repository.findByProjectId(projectId);

            for (DraftOrderModel draftOrderModel : draftOrderModels) {
                DraftOrder draftOrder = new DraftOrder();

                draftOrder.setId(draftOrderModel.getId());
                draftOrder.setSupplierId(draftOrderModel.getSupplierId());
                draftOrder.setItemList(draftOrderModel.getItemList());
                draftOrder.setSiteManagerId(draftOrderModel.getSiteManagerId());
                draftOrder.setSiteId(draftOrderModel.getSiteId());
                draftOrder.setProjectId(draftOrderModel.getProjectId());
                draftOrder.setAmount(draftOrderModel.getAmount());
                draftOrder.setContactDetails(draftOrderModel.getContactDetails());
                draftOrder.setComment(draftOrderModel.getComment());
                draftOrder.setStatus(draftOrderModel.getStatus());
                draftOrder.setDateTime(draftOrderModel.getDateTime());

                draftOrders.add(draftOrder);
            }
            return draftOrders;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            return draftOrders;
        }
    }

    /**
     * This Method gets parameter as String draft order id.
     * Then find the draft order using the id of draft order saved in draft order collection in MongoDB Cluster database.
     * Then delete draft order using id saved in draft order collection in MongoDB Cluster database.
     *
     * @param id - Relevant Draft Order id from DraftOrderApi class.
     * @return ResponseEntity<?> - Customized message will be return.
     * @throws NoSuchElementException - If method cannot find the relevant Draft orders or delete draft order from database this will throw.
     * @see #deleteDraftOrderById(String)
     */
    @Override
    public ResponseEntity<?> deleteDraftOrderById(String id) {
        DraftOrderModel draftOrderModel = null;

        try {
            draftOrderModel = repository.findById(id).get();
            if (draftOrderModel != null) {
                repository.deleteById(id);
                return ResponseEntity.ok(new MessageResponseDto(CommonConstants.ORDER_DRAFT_DELETE_SUCCESSFULLY));
            } else {
                return ResponseEntity.ok(new MessageResponseDto(CommonConstants.ORDER_DOES_NOT_EXIST));
            }
        } catch (NoSuchElementException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            return ResponseEntity.ok(new MessageResponseDto(CommonConstants.ORDER_DRAFT_DELETE_ERROR));
        }
    }

    /**
     * This Method gets parameter as draft order object.
     * Then find the draft order using the id of draft order saved in draft order collection in MongoDB Cluster database.
     * Then update draft order using id saved in draft order collection in MongoDB Cluster database.
     *
     * @param draftOrder - Relevant Draft Order object from DraftOrderApi class.
     * @return ResponseEntity<?> - Customized message will be return.
     * @throws Exception - If method cannot find the relevant draft orders from database this will throw.
     * @see #updateDraftOrder(DraftOrder)
     */
    @Override
    public ResponseEntity<?> updateDraftOrder(DraftOrder draftOrder) {
        try {
            DraftOrderModel draftOrderModel = mongoTemplate.findAndModify(
                    Query.query(Criteria.where(CommonConstants.ID).is(draftOrder.getId())),
                    new Update()
                            .set(CommonConstants.SUPPLIER_ID, draftOrder.getSupplierId())
                            .set(CommonConstants.ITEM_LIST, draftOrder.getItemList())
                            .set(CommonConstants.SITE_MANAGER_ID, draftOrder.getSiteManagerId())
                            .set(CommonConstants.AMOUNT, draftOrder.getAmount())
                            .set(CommonConstants.CONTACT_DETAILS, draftOrder.getContactDetails())
                            .set(CommonConstants.COMMENT, draftOrder.getComment())
                            .set(CommonConstants.STATUS, draftOrder.getStatus())
                            .set(CommonConstants.DATE_TIME, draftOrder.getDateTime()),
                    DraftOrderModel.class
            );
            if (draftOrderModel != null) {
                return ResponseEntity.ok(new MessageResponseDto(CommonConstants.ORDER_DRAFT_UPDATE_SUCCESSFULLY));
            } else {
                return ResponseEntity.ok(new MessageResponseDto(CommonConstants.ORDER_DOES_NOT_EXIST));
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            return ResponseEntity.ok(new MessageResponseDto(CommonConstants.ORDER_DRAFT_UPDATE_ERROR));
        }
    }
}
