package com.csse.pms.dal.adapter;

import com.csse.pms.dal.model.DeliveryLogModel;
import com.csse.pms.dal.repository.DeliveryLogRepository;
import com.csse.pms.domain.DeliveryLog;
import com.csse.pms.domain.DeliveryLogDataAdapter;
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
 * This Class for Delivery Log related implementation
 */

@Component
public class DeliveryLogAdapterImpl implements DeliveryLogDataAdapter {

    /**
     * Initialize Logger
     */
    public static final Logger LOGGER = Logger.getLogger(DeliveryLogAdapterImpl.class.getName());

    private final DeliveryLogRepository repository;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public DeliveryLogAdapterImpl(DeliveryLogRepository repository, MongoTemplate mongoTemplate) {
        this.repository = repository;
        this.mongoTemplate = mongoTemplate;
    }

    /**
     * This Method gets parameter as deliveryLog object and assign to new deliveryLog-model object.
     * Then deliveryLog model object save in deliveryLog collection in MongoDB Cluster database.
     *
     * @param deliveryLog - deliveryLog object from DeliveryLogApi class.
     * @return ResponseEntity<?> - Customized message will be return.
     * @throws Exception - Common Exception to be handled.
     * @see #createDeliveryLog(DeliveryLog)
     */
    @Override
    public ResponseEntity<?> createDeliveryLog(DeliveryLog deliveryLog) {

        DeliveryLogModel deliveryLogModel = new DeliveryLogModel();

        try {
            deliveryLogModel.setReferenceNo(deliveryLog.getReferenceNo());
            deliveryLogModel.setSiteManagerId(deliveryLog.getSiteManagerId());
            deliveryLogModel.setRemark(deliveryLog.getRemark());
            deliveryLogModel.setStatus(deliveryLog.getStatus());

            deliveryLogModel = repository.save(deliveryLogModel);
            LOGGER.log(Level.INFO, deliveryLogModel.toString());

            return ResponseEntity.ok(new MessageResponseDto(CommonConstants.DELIVERY_STATUS_SAVE_SUCCESSFULLY));
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            return ResponseEntity.ok(new MessageResponseDto(CommonConstants.DELIVERY_STATUS_SAVE_ERROR));
        }
    }

    /**
     * This Method gets all deliveryLog saved in deliveryLog collection in MongoDB Cluster database.
     * Then assign to deliveryLog model list object.
     * Then using for loop assign to deliveryLog list object.
     *
     * @return List<DeliveryLog> - All founded deliveryLogs will be return as deliveryLog list object.
     * @throws Exception - Common Exception to be handled.
     * @see #getAllDeliveryLogs()
     */
    @Override
    public List<DeliveryLog> getAllDeliveryLogs() {
        List<DeliveryLog> deliveryLogs = new ArrayList<>();

        try {
            List<DeliveryLogModel> deliveryLogModels = repository.findAll();

            for (DeliveryLogModel deliveryLogModel : deliveryLogModels) {
                DeliveryLog deliveryLog = new DeliveryLog();

                deliveryLog.setId(deliveryLogModel.getId());
                deliveryLog.setReferenceNo(deliveryLogModel.getReferenceNo());
                deliveryLog.setSiteManagerId(deliveryLogModel.getSiteManagerId());
                deliveryLog.setRemark(deliveryLogModel.getRemark());
                deliveryLog.setStatus(deliveryLogModel.getStatus());

                deliveryLogs.add(deliveryLog);
            }
            return deliveryLogs;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            return deliveryLogs;
        }
    }

    /**
     * This Method gets parameter as String id.
     * Then find the deliveryLog using the id of deliveryLog saved in deliveryLog collection
     * in MongoDB Cluster database.
     * Then founded deliveryLog assign to deliveryLog model object.
     * Then using for loop assign to deliveryLog object.
     *
     * @param id - Relevant deliveryLog id from DeliveryLogApi class.
     * @return DeliveryLog - Founded deliveryLog will be return as deliveryLog object.
     * @throws NoSuchElementException - If method cannot find the relevant deliveryLog from database this will throw.
     * @see #getDeliveryLogById(String)
     */
    @Override
    public DeliveryLog getDeliveryLogById(String id) {
        DeliveryLogModel deliveryLogModel;
        DeliveryLog deliveryLog = new DeliveryLog();

        try {
            deliveryLogModel = repository.findById(id).get();

            deliveryLog.setId(deliveryLogModel.getId());
            deliveryLog.setReferenceNo(deliveryLogModel.getReferenceNo());
            deliveryLog.setSiteManagerId(deliveryLogModel.getSiteManagerId());
            deliveryLog.setRemark(deliveryLogModel.getRemark());
            deliveryLog.setStatus(deliveryLogModel.getStatus());

            return deliveryLog;
        } catch (NoSuchElementException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            return deliveryLog;
        }
    }

    /**
     * This Method gets parameter as String referenceNo.
     * Then find the deliveryLog using the referenceNo of deliveryLog saved in deliveryLog collection
     * in MongoDB Cluster database.
     * Then founded deliveryLog assign to deliveryLog model list object.
     * Then using for loop assign to deliveryLog list object.
     *
     * @param referenceNo - Relevant deliveryLog referenceNo from DeliveryLogApi class.
     * @return List<DeliveryLog> - Founded deliveryLog will be return as deliveryLog list object.
     * @throws Exception - If method cannot find the relevant deliveryLogs from database this will throw.
     * @see #getDeliveryLogByReferenceNo(String)
     */
    @Override
    public List<DeliveryLog> getDeliveryLogByReferenceNo(String referenceNo) {
        List<DeliveryLog> deliveryLogs = new ArrayList<>();

        try {
            List<DeliveryLogModel> deliveryLogModels = repository.findByReferenceNo(referenceNo);

            for (DeliveryLogModel deliveryLogModel : deliveryLogModels) {
                DeliveryLog deliveryLog = new DeliveryLog();

                deliveryLog.setId(deliveryLogModel.getId());
                deliveryLog.setReferenceNo(deliveryLogModel.getReferenceNo());
                deliveryLog.setSiteManagerId(deliveryLogModel.getSiteManagerId());
                deliveryLog.setRemark(deliveryLogModel.getRemark());
                deliveryLog.setStatus(deliveryLogModel.getStatus());

                deliveryLogs.add(deliveryLog);
            }
            return deliveryLogs;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            return deliveryLogs;
        }
    }

    /**
     * This Method gets parameter as String deliveryLog id.
     * Then find the deliveryLog using the id of deliveryLog saved in deliveryLog collection
     * in MongoDB Cluster database.
     * Then delete deliveryLog using id saved in deliveryLog collection in MongoDB Cluster database.
     *
     * @param id - Relevant deliveryLog id from DeliveryLogApi class.
     * @return ResponseEntity<?> - Customized message will be return.
     * @throws NoSuchElementException - If method cannot find the relevant deliveryLog or
     *                                delete deliveryLog from database this will throw.
     * @see #deleteDeliveryLogById(String)
     */
    @Override
    public ResponseEntity<?> deleteDeliveryLogById(String id) {
        DeliveryLogModel deliveryLogModel = null;

        try {
            deliveryLogModel = repository.findById(id).get();
            if (deliveryLogModel != null) {
                repository.deleteById(id);
                return ResponseEntity.ok(new MessageResponseDto(CommonConstants.DELIVERY_STATUS_DELETE_SUCCESSFULLY));
            } else {
                return ResponseEntity.ok(new MessageResponseDto(CommonConstants.DELIVERY_STATUS_DOES_NOT_EXIST));
            }
        } catch (NoSuchElementException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            return ResponseEntity.ok(new MessageResponseDto(CommonConstants.DELIVERY_STATUS_DELETE_ERROR));
        }
    }

    /**
     * This Method gets parameter as deliveryLog object.
     * Then find the deliveryLog using the id of deliveryLog saved in deliveryLog collection
     * in MongoDB Cluster database.
     * Then update deliveryLog using id saved in deliveryLog collection in MongoDB Cluster database.
     *
     * @param deliveryLog - Relevant deliveryLog object from DeliveryLogApi class.
     * @return ResponseEntity<?> - Customized message will be return.
     * @throws Exception - If method cannot find the relevant deliveryLog from database this will throw.
     * @see #updateDeliveryLog(DeliveryLog)
     */
    @Override
    public ResponseEntity<?> updateDeliveryLog(DeliveryLog deliveryLog) {
        try {
            DeliveryLogModel deliveryLogModel = mongoTemplate.findAndModify(
                    Query.query(Criteria.where(CommonConstants.ID).is(deliveryLog.getId())),
                    new Update()
                            .set(CommonConstants.REFERENCE_NO, deliveryLog.getReferenceNo())
                            .set(CommonConstants.SITE_MANAGER_ID, deliveryLog.getSiteManagerId())
                            .set(CommonConstants.REMARK, deliveryLog.getRemark())
                            .set(CommonConstants.STATUS, deliveryLog.getStatus()),
                    DeliveryLogModel.class
            );

            if (deliveryLogModel != null) {
                return ResponseEntity.ok(new MessageResponseDto(CommonConstants.DELIVERY_STATUS_UPDATE_SUCCESSFULLY));
            } else {
                return ResponseEntity.ok(new MessageResponseDto(CommonConstants.DELIVERY_STATUS_DOES_NOT_EXIST));
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            return ResponseEntity.ok(new MessageResponseDto(CommonConstants.DELIVERY_STATUS_UPDATE_ERROR));
        }
    }
}
