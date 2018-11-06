/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * Copyright 2018 Evolvice and/or its affiliates.
 * All rights reserved.
 * Evolvice GmbH is a German software service provider with development hubs in Eastern Europe (Ukraine). The company services the information technology requirements of companies ranging from Fortune 500/DAX 30 to SMEs and startups, counting well-known companies such as Robert Bosch GmbH, Porsche AG, WTS tax consulting AG, etc as its clients..
 * CLASS NAME CarController.java
 * @author: Walaa Yousif <A HREF="mailto:[eng.walaa2011"gmail.com]">[Walaa Yousif]</A>
 * @version Revision: 1.1.1.1
 * @package com.evolvice.controller
 * @see [CarController]
 */

package com.evolvice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.evolvice.datatransferobject.CarDTO;
import com.evolvice.service.car.CarService;

import io.swagger.annotations.ApiOperation;

/**
 * @author Walaa Yousif
 *
 *         All operations with a car will be routed by this controller.
 *         <p/>
 */
@RestController
@RequestMapping("car")
public class CarController {

	@Autowired
	private CarService carService;

	@GetMapping("/getAllCars")
	@PreAuthorize("hasAuthority('Car_Access')")
	@ApiOperation(value = "get all Cars", tags = {
			"Car" }, notes = "<br/>To get all cars <URL>http://localhost:8080/car/getAllCars", response = CarDTO.class, responseContainer = "List")
	public ResponseEntity<?> getAllCars() throws NotFoundException {
		try {
			return new ResponseEntity<List<CarDTO>>(carService.getAllCars(), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/softDeleteCarById/{id}")
	@PreAuthorize("hasAuthority('Car_Access')")
	@ApiOperation(value = "Update column deleted to 1 by recId (don't get any column is deleted = 1) but not deleted the column from database", tags = {
			"Car" }, notes = "<br/>Update column deleted to 1 <URL>http://localhost:8080/car/softDeleteCarById/{id}", response = ResponseEntity.class)
	public ResponseEntity<?> softDeleteCarById(@PathVariable Long id) throws NotFoundException {
		try {
			carService.softDeleteCarById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/hardDeleteCarById/{id}")
	@PreAuthorize("hasAuthority('Car_Access')")
	@ApiOperation(value = "Deleted the column from database by recId", tags = {
			"Car" }, notes = "<br/>Deleted the column from database by recId <URL>http://localhost:8080/car/hardDeleteCarById/{id}", response = ResponseEntity.class)
	public ResponseEntity<?> hardDeleteCarById(@PathVariable Long id) {
		try {
			carService.hardDeleteCarById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/updateCarById")
	@PreAuthorize("hasAuthority('Car_Access')")
	@ApiOperation(value = "Update columns (Brand ,Model ,YearOfProduction and Details) by recId where this is column not deleted", tags = {
			"Car" }, notes = "Update columns (Brand ,Model ,YearOfProduction and Details) by recId where this is column not deleted  <URL>http://localhost:8080/car/updateCarById?id=", response = ResponseEntity.class)
	public ResponseEntity<?> updateCarById(@RequestParam(name = "id", required = true) Long id,
			@RequestBody CarDTO carRequest) throws NotFoundException {
		try {
			carService.updateCarById(carRequest, id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/addNewCar")
	@PreAuthorize("hasAuthority('Car_Access')")
	@ApiOperation(value = "Save new car", tags = {
			"Car" }, notes = "Save new car <URL>http://localhost:8080/car/addNewCar", response = ResponseEntity.class)
	public ResponseEntity<?> addNewCar(@RequestBody CarDTO carRequest) throws NotFoundException {
		try {
			carService.addNewCar(carRequest);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
