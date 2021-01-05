/**
 * 
 */
package com.org.offergenerator.vo;

import java.io.Serializable;
import java.util.Comparator;

/**
 * @author BadGateWay
 *
 */
public class OfferConfigurationVO implements Serializable ,Comparable<OfferConfigurationVO>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7299865811087011184L;
	
	private String fieldName;
	
	private String fieldLabel;
	
	private int fieldIndex;
	
	private String alignment;
	
	private String fieldType;
	
	private String fieldValue;
	
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

	
	public int compareTo(OfferConfigurationVO compareIndex) {
	    
        int index = ((OfferConfigurationVO) compareIndex).getFieldIndex(); 
        
        //ascending order
        return this.fieldIndex - index;
        
        //descending order
        //return compareQuantity - this.quantity;
        
    }	

	public static Comparator<OfferConfigurationVO> OfferConfComparator = new Comparator<OfferConfigurationVO>() {

		public int compare(OfferConfigurationVO conf1, OfferConfigurationVO conf2) {

			Integer index1 = conf1.getFieldIndex();
			Integer index2 = conf2.getFieldIndex();

			// ascending order
			return index1.compareTo(index2);

			// descending order
			// return fruitName2.compareTo(fruitName1);
		}

	};
}
