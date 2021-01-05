/**
 * 
 */
package com.org.offergenerator.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author BadGateWay
 *
 */
@JsonInclude(Include.NON_NULL)
public class OfferConfigurations {

	private String templateId;
	private List<OfferConfigurationVO> offerConfigurationList;

	
	/**
	 * @return the templateId
	 */
	public String getTemplateId() {
		return templateId;
	}

	/**
	 * @param templateId the templateId to set
	 */
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	/**
	 * @return the offerConfigurationList
	 */
	public List<OfferConfigurationVO> getOfferConfigurationList() {
		return offerConfigurationList;
	}

	/**
	 * @param offerConfigurationList the offerConfigurationList to set
	 */
	public void setOfferConfigurationList(List<OfferConfigurationVO> offerConfigurationList) {
		this.offerConfigurationList = offerConfigurationList;
	}

	
	
	
	
	
}
