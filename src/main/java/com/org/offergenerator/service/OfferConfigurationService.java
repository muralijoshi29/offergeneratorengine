/**
 * 
 */
package com.org.offergenerator.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.org.offergenerator.vo.OfferConfigurations;

/**
 * @author BadGateWay
 *
 */
public interface OfferConfigurationService {
	
	
	
	public OfferConfigurations generateOfferLetter(OfferConfigurations configurationVO, HttpServletResponse response);
	
	public List<OfferConfigurations> getTemplates();
	
	public OfferConfigurations getTemplateById(String templateId);
}
