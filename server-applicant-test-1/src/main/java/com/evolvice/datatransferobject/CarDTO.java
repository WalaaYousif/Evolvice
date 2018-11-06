/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * Copyright 2018 Evolvice and/or its affiliates.
 * All rights reserved.
 * Evolvice GmbH is a German software service provider with development hubs in Eastern Europe (Ukraine). The company services the information technology requirements of companies ranging from Fortune 500/DAX 30 to SMEs and startups, counting well-known companies such as Robert Bosch GmbH, Porsche AG, WTS tax consulting AG, etc as its clients..
 * CLASS NAME CarDTO.java
 * @author: Walaa Yousif <A HREF="mailto:[eng.walaa2011"gmail.com]">[Walaa Yousif]</A>
 * @version Revision: 1.1.1.1
 * @package com.evolvice.datatransferobject
 * @see [CarDTO]
 */
package com.evolvice.datatransferobject;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Walaa Yousif
 */

public class CarDTO {

	private String brand;

	private String model;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd hh:mm", timezone = "GMT+02:00")
	private Date yearOfProduction;

	private String details;

	public CarDTO() {
	}

	/**
	 * @param brand
	 * @param model
	 * @param yearOfProduction
	 * @param details
	 */
	public CarDTO(String brand, String model, Date yearOfProduction, String details) {
		super();
		this.brand = brand;
		this.model = model;
		this.yearOfProduction = yearOfProduction;
		this.details = details;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Date getYearOfProduction() {
		return yearOfProduction;
	}

	public void setYearOfProduction(Date yearOfProduction) {
		this.yearOfProduction = yearOfProduction;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
