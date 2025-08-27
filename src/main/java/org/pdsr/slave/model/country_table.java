package org.pdsr.slave.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class country_table implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	@Size(min = 1, max = 80)
	private String country_uuid;

	@NotNull
	@Column(unique = true)
	@Size(min=1, max = 80)
	private String country_name;
	
	public String getCountry_uuid() {
		return country_uuid;
	}

	public void setCountry_uuid(String country_uuid) {
		this.country_uuid = country_uuid;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country_uuid == null) ? 0 : country_uuid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		country_table other = (country_table) obj;
		if (country_uuid == null) {
			if (other.country_uuid != null)
				return false;
		} else if (!country_uuid.equals(other.country_uuid))
			return false;
		return true;
	}
	
	

}
