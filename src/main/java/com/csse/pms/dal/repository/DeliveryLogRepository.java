package com.csse.pms.dal.repository;

import com.csse.pms.dal.model.DeliveryLogModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author Chandrasiri S.A.N.L.D.
 *
 * This Interface for Delivery Log related implementation
 */

@Repository
public interface DeliveryLogRepository extends MongoRepository<DeliveryLogModel,String> {

    List<DeliveryLogModel> findByReferenceNo(String referenceNo);
}
