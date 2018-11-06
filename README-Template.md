# Evolvice

Stores cars

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites
Install the software

```
1)jdk1.8.0_191
2)sts-bundle
3)Oracle Database_windows_11g_R2
4)Toad DBA Suite for Oracle 11.0 Commercial
5)Postman

```

### Installing

Get a development env running

```
DB
1)open file DB.sql and copy the content then past in Toad and run scripts.

application
1)open sts-bundle and import projct server-applicant-test-1
2)right click on the project and select Maven --> Update project and check "Force Update of Snapshots/Releases"
3)right click on the project and select run as--> maven clean
4)right click on the project and select run as--> maven install
5)select project--> clean

```


## Running

Now you can run the project use SpringBoot

run this API on postman
1)http://localhost:8080/car/getAllCars -->Get Mapping
2)http://localhost:8080/car/softDeleteCarById/1 -->Put Mapping
3)http://localhost:8080/car/hardDeleteCarById/2 -->Delete Mapping
4)http://localhost:8080/car/updateCarById?id=3 -->Put Mapping
and put it in body

{
	"brand":"walaa",
	"model":"model",
	"yearOfProduction":"2019/01/01 00:00",
	"details":"details"
}

5)http://localhost:8080/car/addNewCar -->Put Mapping
and put it in body

{
	"brand":"walaa",
	"model":"model",
	"yearOfProduction":"2019/01/01 00:00",
	"details":"details"
}

## Authors

* **Walaa Yousif**