create user EVOLVICE identified by admin;

GRANT create session TO evolvice;

GRANT create table TO evolvice;

GRANT create view TO evolvice;

GRANT create any trigger TO evolvice;

GRANT create any procedure TO evolvice;

GRANT create sequence TO evolvice;

GRANT create synonym TO evolvice;

CREATE TABLE EVOLVICE.car
(
  rec_id           INTEGER                      NOT NULL,
  brand            VARCHAR2(50),
  model            VARCHAR2(50),
  year_production  DATE,
  details          VARCHAR2(150),
  deleted INTEGER
);


ALTER TABLE EVOLVICE.car ADD (
  CONSTRAINT rec_id_pk
  PRIMARY KEY
  (rec_id)
  ENABLE VALIDATE);

CREATE SEQUENCE EVOLVICE.car_seq
START WITH 1
INCREMENT BY 1
MINVALUE 1
MAXVALUE 999999999999999999
CACHE 2
NOCYCLE 
NOORDER ;


INSERT INTO EVOLVICE.car (rec_id, brand, model,year_production, details, deleted)
VALUES (1, 'BMW', 'X1 xDrive28i',(TO_DATE('12/12/2017', 'dd/mm/yyyy')), '2.0-liter BMW TwinPower Turbo inline 4-cylinder, xDrive, intelligent all-wheel drive',0);

INSERT INTO EVOLVICE.car (rec_id, brand, model,year_production, details, deleted)
VALUES (2, 'Mercedes', 'C 300 Sedan',(TO_DATE('01/01/2019', 'dd/mm/yyyy')), 'Acclaimed for its sporting soul, impeccably detailed cabin and class-leading innovation, the C 300 is even sportier, richer and more advanced for 2019',0);

INSERT INTO EVOLVICE.car (rec_id, brand, model,year_production, details, deleted)
VALUES (3, 'Fait', 'Sedan',(TO_DATE('01/10/2016', 'dd/mm/yyyy')), 'innovation, the even sportier, richer and more advanced for 2016',0);

INSERT INTO EVOLVICE.car (rec_id, brand, model,year_production, details, deleted)
VALUES (4, 'BMW', 'X2',(TO_DATE('12/10/2019', 'dd/mm/yyyy')), ' all-wheel drive',0);

