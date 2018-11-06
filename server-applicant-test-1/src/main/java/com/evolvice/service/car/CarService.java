/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * Copyright 2018 Evolvice and/or its affiliates.
 * All rights reserved.
 * Evolvice GmbH is a German software service provider with development hubs in Eastern Europe (Ukraine). The company services the information technology requirements of companies ranging from Fortune 500/DAX 30 to SMEs and startups, counting well-known companies such as Robert Bosch GmbH, Porsche AG, WTS tax consulting AG, etc as its clients..
 * CLASS NAME CarService.java
 * @author: Walaa Yousif <A HREF="mailto:[eng.walaa2011"gmail.com]">[Walaa Yousif]</A>
 * @version Revision: 1.1.1.1
 * @package com.evolvice.service.car
 * @see [CarService]
 */

package com.evolvice.service.car;

import java.util.List;

import com.evolvice.datatransferobject.CarDTO;

/**
 * @author Walaa Yousif
 */

public interface CarService {

	public List<CarDTO> getAllCars();

	public void softDeleteCarById(Long id);

	public void hardDeleteCarById(Long id);

	public void updateCarById(CarDTO carRequest, Long id);

	public void addNewCar(CarDTO carRequest);
}
