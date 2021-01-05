/**
 * 
 */
package com.org.offergenerator.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.org.offergenerator.model.OfferConfiguration;

/**
 * @author BadGateWay
 *
 */
@Repository
public interface OfferConfigurationRepository extends MongoRepository<OfferConfiguration, String>{

	public List<OfferConfiguration> findByTemplateId(String templateId);
	
}
