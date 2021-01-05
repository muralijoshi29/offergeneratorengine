/**
 * 
 */
package com.org.offergenerator.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.offergenerator.vo.OfferConfigurations;
import com.org.offergeneratorengine.OfferEngineFacadeService;

/**
 * @author BadGateWay
 *
 */
@RestController
@RequestMapping(path = "/offer")
public class OfferConfigurationController {
	
/*	@Autowired
	private OfferConfigurationService offerConfigurationService;*/
	
	@Autowired
	private OfferEngineFacadeService offerEngineFacadeService;
	
	
	@GetMapping("/templates")
	public List<OfferConfigurations> getTemplates() {
		return offerEngineFacadeService.getTemplates();
	}
	

	@GetMapping("/template/{templateId}")
	public OfferConfigurations getTemplateById(@PathVariable String templateId) {
		return offerEngineFacadeService.getTemplateById(templateId);
	}
	
	@PostMapping("/generate-offer")
	public void generateOfferLetter(HttpServletResponse response , @RequestBody OfferConfigurations configurationVO) {
		
		response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
        
		offerEngineFacadeService.generateOfferLetter(configurationVO,response);
	}
}
