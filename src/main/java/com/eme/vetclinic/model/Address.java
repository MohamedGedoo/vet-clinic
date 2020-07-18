package com.eme.vetclinic.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @Embeddable object representing Address.
 *
 * @author Mohamed Gad
 */


@Embeddable
public class Address {

	@Column(name = "postcode")
	private String postcode;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "country")
	private String country;

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
