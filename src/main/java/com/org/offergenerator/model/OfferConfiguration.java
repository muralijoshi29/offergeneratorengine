/**
 * 
 */
package com.org.offergenerator.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.*;
/**
 * @author BadGateWay
 *
 */
@Document(collection="offer_configuration")
public class OfferConfiguration {

	@Id
	private String id;
	
	private String fieldName;
	
	private String fieldLabel;
	
	private int fieldIndex;
	
	private String alignment;
	
	private String fieldType;
	
	private String fieldValue;
	
	private String templateId;
	
	private String spaceAfter;
	
	


	/**
	 * @return the spaceAfter
	 */
	public String getSpaceAfter() {
		return spaceAfter;
	}

	/**
	 * @param spaceAfter the spaceAfter to set
	 */
	public void setSpaceAfter(String spaceAfter) {
		this.spaceAfter = spaceAfter;
	}

	/**
	 * @return the fieldName
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * @param fieldName the fieldName to set
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	/**
	 * @return the fieldLabel
	 */
	public String getFieldLabel() {
		return fieldLabel;
	}

	/**
	 * @param fieldLabel the fieldLabel to set
	 */
	public void setFieldLabel(String fieldLabel) {
		this.fieldLabel = fieldLabel;
	}

	/**
	 * @return the fieldIndex
	 */
	public int getFieldIndex() {
		return fieldIndex;
	}

	/**
	 * @param fieldIndex the fieldIndex to set
	 */
	public void setFieldIndex(int fieldIndex) {
		this.fieldIndex = fieldIndex;
	}

	/**
	 * @return the alignment
	 */
	public String getAlignment() {
		return alignment;
	}

	/**
	 * @param alignment the alignment to set
	 */
	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}

	/**
	 * @return the fieldType
	 */
	public String getFieldType() {
		return fieldType;
	}

	/**
	 * @param fieldType the fieldType to set
	 */
	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	/**
	 * @return the fieldValue
	 */
	public String getFieldValue() {
		return fieldValue;
	}

	/**
	 * @param fieldValue the fieldValue to set
	 */
	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}

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
	
	/*public String toString() {
		
	}
	*/
	
}
