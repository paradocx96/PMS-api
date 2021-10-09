package com.csse.pms.dal.repository;

import com.csse.pms.dal.model.DraftOrderModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author Chandrasiri S.A.N.L.D.
 *
 * This Interface for Draft Order related implementation
 */

@Repository
public interface DraftOrderRepository extends MongoRepository<DraftOrderModel,String> {

    List<DraftOrderModel> findBySiteId(String siteId);

    List<DraftOrderModel> findByProjectId(String projectId);
}
