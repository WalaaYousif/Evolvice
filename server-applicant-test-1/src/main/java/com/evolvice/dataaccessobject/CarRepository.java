/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * Copyright 2018 Evolvice and/or its affiliates.
 * All rights reserved.
 * Evolvice GmbH is a German software service provider with development hubs in Eastern Europe (Ukraine). The company services the information technology requirements of companies ranging from Fortune 500/DAX 30 to SMEs and startups, counting well-known companies such as Robert Bosch GmbH, Porsche AG, WTS tax consulting AG, etc as its clients..
 * CLASS NAME CarRepository.java
 * @author: Walaa Yousif <A HREF="mailto:[eng.walaa2011"gmail.com]">[Walaa Yousif]</A>
 * @version Revision: 1.1.1.1
 * @package com.evolvice.dataaccessobject
 * @see [CarRepository]
 */

package com.evolvice.dataaccessobject;

import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.evolvice.domainobject.Car;

/**
 * @author Walaa Yousif
 */

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {

	@Modifying
	@Transactional
	@Query("Update Car c set c.deleted =:deleted where c.recId =:id")
	void softDeleteCarById(@Param("id") Long id, @Param("deleted") Long deleted);

	@Modifying
	@Transactional
	@Query("Update Car c set c.brand =:brand , c.model =:model , c.yearOfProduction =:yearOfProduction , c.details =:details where c.recId =:id and c.deleted =:notDeleted ")
	void updateCarById(@Param("brand") String brand, @Param("model") String model,
			@Param("yearOfProduction") Date yearOfProduction, @Param("details") String details, @Param("id") Long id,
			@Param("notDeleted") Long notDeleted);
}
