package org.pdsr.json;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.pdsr.master.model.case_identifiers;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class biodata_json implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private String biodata_uuid;
	private case_identifiers case_uuid;

	private Integer biodata_sex;

	private Date biodata_mdob;

	private Integer biodata_mage;

	private Integer biodata_medu;

	private String biodata_maddress;

	private String biodata_location;
	

	private Integer biodata_residency;
	

	private String biodata_contact;

	private Integer biodata_work;
	
	private Integer biodata_marital;
	
	private Integer biodata_religion;

	private Integer biodata_ethnic;
		

	private Integer data_complete;

	private String biodata_json;

	public String getBiodata_uuid() {
		return biodata_uuid;
	}

	public void setBiodata_uuid(String biodata_uuid) {
		this.biodata_uuid = biodata_uuid;
	}

	public case_identifiers getCase_uuid() {
		return case_uuid;
	}

	public void setCase_uuid(case_identifiers case_uuid) {
		this.case_uuid = case_uuid;
	}

	public Integer getBiodata_sex() {
		return biodata_sex;
	}

	public void setBiodata_sex(Integer biodata_sex) {
		this.biodata_sex = biodata_sex;
	}

	public Date getBiodata_mdob() {
		return biodata_mdob;
	}

	public void setBiodata_mdob(Date biodata_mdob) {
		this.biodata_mdob = biodata_mdob;
	}

	public Integer getBiodata_mage() {
		return biodata_mage;
	}

	public void setBiodata_mage(Integer biodata_mage) {
		this.biodata_mage = biodata_mage;
	}

	public Integer getBiodata_medu() {
		return biodata_medu;
	}

	public void setBiodata_medu(Integer biodata_medu) {
		this.biodata_medu = biodata_medu;
	}

	public String getBiodata_maddress() {
		return biodata_maddress;
	}

	public void setBiodata_maddress(String biodata_maddress) {
		this.biodata_maddress = biodata_maddress;
	}

	public String getBiodata_location() {
		return biodata_location;
	}

	public void setBiodata_location(String biodata_location) {
		this.biodata_location = biodata_location;
	}

	public Integer getBiodata_residency() {
		return biodata_residency;
	}

	public void setBiodata_residency(Integer biodata_residency) {
		this.biodata_residency = biodata_residency;
	}

	public String getBiodata_contact() {
		return biodata_contact;
	}

	public void setBiodata_contact(String biodata_contact) {
		this.biodata_contact = biodata_contact;
	}

	public Integer getBiodata_work() {
		return biodata_work;
	}

	public void setBiodata_work(Integer biodata_work) {
		this.biodata_work = biodata_work;
	}

	public Integer getBiodata_marital() {
		return biodata_marital;
	}

	public void setBiodata_marital(Integer biodata_marital) {
		this.biodata_marital = biodata_marital;
	}

	public Integer getBiodata_religion() {
		return biodata_religion;
	}

	public void setBiodata_religion(Integer biodata_religion) {
		this.biodata_religion = biodata_religion;
	}

	public Integer getBiodata_ethnic() {
		return biodata_ethnic;
	}

	public void setBiodata_ethnic(Integer biodata_ethnic) {
		this.biodata_ethnic = biodata_ethnic;
	}

	public Integer getData_complete() {
		return data_complete;
	}

	public void setData_complete(Integer data_complete) {
		this.data_complete = data_complete;
	}

	public String getBiodata_json() {
		return biodata_json;
	}

	public void setBiodata_json(String biodata_json) {
		this.biodata_json = biodata_json;
	}

	

	
}
