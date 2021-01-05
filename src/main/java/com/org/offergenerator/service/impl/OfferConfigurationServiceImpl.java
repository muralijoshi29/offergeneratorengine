/**
 * 
 */
package com.org.offergenerator.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.offergenerator.model.OfferConfiguration;
import com.org.offergenerator.repository.OfferConfigurationRepository;
import com.org.offergenerator.service.OfferConfigurationService;
import com.org.offergenerator.vo.OfferConfigurationVO;
import com.org.offergenerator.vo.OfferConfigurations;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import java.awt.Color;
import java.io.IOException;
/**
 * @author BadGateWay
 *
 */
@Service
public class OfferConfigurationServiceImpl implements OfferConfigurationService{

	@Autowired
	private OfferConfigurationRepository offerConfigurationRepository;
	
	public OfferConfigurations getTemplateById(String templateId) {
		OfferConfigurations offerConfigurations = new OfferConfigurations();
		List<OfferConfiguration> configurationList = offerConfigurationRepository.findByTemplateId(templateId);
		if(null != offerConfigurations) {
			offerConfigurations.setTemplateId(configurationList.get(0).getTemplateId());
			List<OfferConfigurationVO> offerConfigurationList = new ArrayList<>();
			configurationList.forEach(config -> {
				OfferConfigurationVO configurationVO = new OfferConfigurationVO();
				configurationVO.setAlignment(config.getAlignment());
				configurationVO.setFieldIndex(config.getFieldIndex());
				configurationVO.setFieldLabel(config.getFieldLabel());
				configurationVO.setFieldName(config.getFieldName());
				configurationVO.setFieldType(config.getFieldType());
				configurationVO.setFieldValue(config.getFieldValue());
				configurationVO.setSpaceAfter(config.getSpaceAfter());
				offerConfigurationList.add(configurationVO);
			});
			offerConfigurations.setOfferConfigurationList(offerConfigurationList);
		}
		
		return offerConfigurations;
	}
	
	public List<OfferConfigurations> getTemplates() {
		List<OfferConfiguration> configurationList = offerConfigurationRepository.findAll();
		List<OfferConfigurations> offerConfigurations = new ArrayList<>();
		if(null != configurationList) {
			List<OfferConfiguration> distinctConfigurationList = configurationList.stream()
					.filter(distinctByKey(p -> p.getTemplateId())).collect(Collectors.toList());
			if(null != distinctConfigurationList) {
				distinctConfigurationList.forEach(distinctElement -> {
					OfferConfigurations configuration = new OfferConfigurations();
					configuration.setTemplateId(distinctElement.getTemplateId());
					offerConfigurations.add(configuration);
				});
			}
		}
		return offerConfigurations;
	}
	
    //Utility function
    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) 
    {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
	
	public OfferConfigurations generateOfferLetter(OfferConfigurations configurationVO,HttpServletResponse response) {
		if (null != configurationVO && null != configurationVO.getOfferConfigurationList()
				&& !configurationVO.getOfferConfigurationList().isEmpty()) {
			List<OfferConfiguration> offerConfigurations = offerConfigurationRepository.findByTemplateId(configurationVO.getTemplateId());
			if(null != offerConfigurations && !offerConfigurations.isEmpty()) {
				offerConfigurationRepository.deleteAll(offerConfigurations);
			}
			List<OfferConfiguration> offerConfigList = new ArrayList<>();
			configurationVO.getOfferConfigurationList().forEach(offerConfigurationVO -> {
				OfferConfiguration offerConfig = new OfferConfiguration();
				offerConfig.setAlignment(offerConfigurationVO.getAlignment());
				offerConfig.setFieldIndex(offerConfigurationVO.getFieldIndex());
				offerConfig.setFieldLabel(offerConfigurationVO.getFieldLabel());
				offerConfig.setFieldName(offerConfigurationVO.getFieldName());
				offerConfig.setFieldType(offerConfigurationVO.getFieldType());
				offerConfig.setFieldValue(offerConfigurationVO.getFieldValue());
				offerConfig.setSpaceAfter(offerConfigurationVO.getSpaceAfter());
				offerConfig.setTemplateId(configurationVO.getTemplateId());
				offerConfigList.add(offerConfig);
			});
			offerConfigurationRepository.saveAll(offerConfigList);
		}
		try {
			export(response,configurationVO);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	   
    public void export(HttpServletResponse response, OfferConfigurations configurationVO) throws DocumentException, IOException {
    	List<OfferConfigurationVO> conList = configurationVO.getOfferConfigurationList();
    	
    	Collections.sort(conList);
    	
    	Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();
        
        //Title Font
        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        titleFont.setSize(18);
        titleFont.setColor(Color.BLUE);
        
        //Bold Font
        Font boldFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        boldFont.setSize(10);
        boldFont.setColor(Color.BLACK);
         
        Paragraph p = new Paragraph("OFFER LETTER", titleFont);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
        
    	conList.forEach(conf-> {
			Font textFont = FontFactory.getFont(FontFactory.COURIER);
			textFont.setSize(10);
			textFont.setColor(Color.BLACK);
			Paragraph p1 = new Paragraph();
		    if(null != conf.getFieldLabel() && !conf.getFieldLabel().isEmpty()) {
		    	Chunk fieldLabel = new Chunk(conf.getFieldLabel() + " : ",boldFont);
		    	p1.add(fieldLabel);
		    	
		    }
		    Chunk fieldContent = new Chunk(conf.getFieldValue(),textFont);
	    	p1.add(fieldContent);
	    	
    		if(conf.getAlignment().equalsIgnoreCase("Left")) {
    			p1.setAlignment(Paragraph.ALIGN_LEFT);
    		}else if(conf.getAlignment().equalsIgnoreCase("Right")) {
    			p1.setAlignment(Paragraph.ALIGN_RIGHT);
    		}else if(conf.getAlignment().equalsIgnoreCase("Center")) {
    			p1.setAlignment(Paragraph.ALIGN_CENTER);
    		}else {
    			p1.setAlignment(Paragraph.ALIGN_LEFT);
    		}
			if (null != conf.getSpaceAfter() && !conf.getSpaceAfter().isEmpty()
					&& conf.getSpaceAfter().equalsIgnoreCase("Y")) {
				p1.setSpacingAfter(15.0f);
			}
            document.add(p1);
    	});
         
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f});
        table.setSpacingBefore(10);
      
         
        document.close();
         
    }

	
}
