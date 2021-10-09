package com.csse.pms.dal.repository;

import com.csse.pms.dal.model.ProjectModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author Chandrasiri S.A.N.L.D.
 *
 * This Interface for Project related implementation
 */

@Repository
public interface ProjectRepository extends MongoRepository<ProjectModel, String> {

    List<ProjectModel> findBySiteId(String siteId);

    List<ProjectModel> findByManagerId(String managerId);
}
