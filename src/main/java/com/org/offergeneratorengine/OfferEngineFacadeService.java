/**
 * 
 */
package com.org.offergeneratorengine;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.offergenerator.service.OfferConfigurationService;
import com.org.offergenerator.vo.OfferConfigurations;

/**
 * @author 7000018390
 *
 */
@Service
public class OfferEngineFacadeService {

	@Autowired
	private OfferConfigurationService offerConfigurationService;
	
	public OfferConfigurations generateOfferLetter(OfferConfigurations configurationVO,HttpServletResponse response) {
		return offerConfigurationService.generateOfferLetter(configurationVO, response);
	}
	
	public List<OfferConfigurations> getTemplates() {
		return offerConfigurationService.getTemplates();
	}
	
	public OfferConfigurations getTemplateById(String templateId) {
		return offerConfigurationService.getTemplateById(templateId);
	}
}
