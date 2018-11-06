/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * Copyright 2018 Evolvice and/or its affiliates.
 * All rights reserved.
 * Evolvice GmbH is a German software service provider with development hubs in Eastern Europe (Ukraine). The company services the information technology requirements of companies ranging from Fortune 500/DAX 30 to SMEs and startups, counting well-known companies such as Robert Bosch GmbH, Porsche AG, WTS tax consulting AG, etc as its clients..
 * CLASS NAME DefaultCarService.java
 * @author: Walaa Yousif <A HREF="mailto:[eng.walaa2011"gmail.com]">[Walaa Yousif]</A>
 * @version Revision: 1.1.1.1
 * @package com.evolvice.service.car
 * @see [DefaultCarService]
 */

package com.evolvice.service.car;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.evolvice.constant.Constants;
import com.evolvice.dataaccessobject.CarRepository;
import com.evolvice.datatransferobject.CarDTO;
import com.evolvice.domainobject.Car;

/**
 * @author Walaa Yousif
 */

@Service
@PropertySource(value = { "classpath:application.properties" })
public class DefaultCarService implements CarService {

	@Autowired
	private CarRepository carRepository;

	@Override
	public List<CarDTO> getAllCars() {
		// Get all cars
		List<Car> cars = (List<Car>) carRepository.findAll();
		List<CarDTO> carDTOList = new ArrayList<>();
		// data transfer object from car to carDTO
		cars.forEach(car -> {
			CarDTO carDTO = new CarDTO();
			carDTO.setBrand(car.getBrand());
			carDTO.setModel(car.getModel());
			carDTO.setYearOfProduction(car.getYearOfProduction());
			carDTO.setDetails(car.getDetails());
			carDTOList.add(carDTO);
		});
		// return all cars
		return carDTOList;
	}

	@Override
	public void softDeleteCarById(Long id) {
		// Update column deleted to 1 by recId (don't get any column is deleted = 1) but not deleted the column from database
		carRepository.softDeleteCarById(id, Constants.DELETED);

	}

	@Override
	public void hardDeleteCarById(Long id) {
		// Deleted the column from database by recId
		carRepository.delete(id);
	}

	@Override
	public void updateCarById(CarDTO carDTO, Long id) {
		// Check for carDTO is not empty
		if (carDTO != null && !carDTO.equals(null)) {
			// Update columns (Brand ,Model ,YearOfProduction and Details) by recId where this is column not deleted
			carRepository.updateCarById(carDTO.getBrand(), carDTO.getModel(), carDTO.getYearOfProduction(),
					carDTO.getDetails(), id, Constants.NOT_DELETED);
		}
	}

	@Override
	public void addNewCar(CarDTO carDTO) {
		// Check for carDTO is not empty
		if (carDTO != null && !carDTO.equals(null)) {
			// data transfer object from car to carDTO
			Car car = new Car();
			car.setBrand(carDTO.getBrand());
			car.setModel(carDTO.getModel());
			car.setYearOfProduction(carDTO.getYearOfProduction());
			car.setDetails(carDTO.getDetails());
			car.setDeleted(Constants.NOT_DELETED);
			// Save new car
			carRepository.save(car);
		}
	}
}
