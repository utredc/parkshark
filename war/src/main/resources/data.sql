INSERT INTO CITY (CITY_ID, POSTAL_CODE, NAME) VALUES
        (1, '1000', 'Brussel'),
        (2, '3200', 'Aarschot'),
        (3, '3000', 'Leuven'),
        (4, '2000', 'Antwerpen'),
        (5, '9000', 'Gent'),
        (6, '9220', 'Hamme');

INSERT INTO CONTACT_PERSON (ID, FIRST_NAME, LAST_NAME, EMAIL, STREET_NAME, STREET_NUMBER, CITY_ID, MOBILE_NR, PHONE_NR) VALUES
    (CONTACT_PERSON_SEQ.nextval, 'Jimmy', 'VanPimperzele', 'jimmy@pimperzele.com', 'pimperzelestraat', '25a', 1, '02/53.32.32','052/254.36.36'),
    (CONTACT_PERSON_SEQ.nextval, 'Jimmy2', 'VanPimperzele', 'jimmy@pimperzele.com', 'pimperzelestraat', '25a', 2, '02/53.32.32','052/254.36.36'),
    (CONTACT_PERSON_SEQ.nextval, 'Jimmy3', 'VanPimperzele', 'jimmy@pimperzele.com', 'pimperzelestraat', '25a', 3, '02/53.32.32','052/254.36.36'),
    (CONTACT_PERSON_SEQ.nextval, 'Jimmy4', 'VanPimperzele', 'jimmy@pimperzele.com', 'pimperzelestraat', '25a', 4, '02/53.32.32','052/254.36.36'),
    (CONTACT_PERSON_SEQ.nextval, 'Jimmy5', 'VanPimperzele', 'jimmy@pimperzele.com', 'pimperzelestraat', '25a', 5, '02/53.32.32','052/254.36.36');

INSERT INTO DIVISION (ID, NAME, ORIGINAL_NAME, DIRECTOR_NAME, PARENT_DIVISION_ID) values
    (DIVISION_SEQ.nextval, 'Division One', null, 'The one', null);
    INSERT INTO DIVISION (ID, NAME, ORIGINAL_NAME, DIRECTOR_NAME, PARENT_DIVISION_ID) values
    (DIVISION_SEQ.nextval, 'Division two', null, 'The  other one', null);
INSERT INTO DIVISION (ID, NAME, ORIGINAL_NAME, DIRECTOR_NAME, PARENT_DIVISION_ID) values
    (DIVISION_SEQ.nextval, 'Division three', null, 'The one who listen', 1);
    INSERT INTO DIVISION (ID, NAME, ORIGINAL_NAME, DIRECTOR_NAME, PARENT_DIVISION_ID) values
    (DIVISION_SEQ.nextval, 'Division four', 'other name', 'The one', 1);
    INSERT INTO DIVISION (ID, NAME, ORIGINAL_NAME, DIRECTOR_NAME, PARENT_DIVISION_ID) values
    (DIVISION_SEQ.nextval, 'Division five', null, 'The one', null);
INSERT INTO DIVISION (ID, NAME, ORIGINAL_NAME, DIRECTOR_NAME, PARENT_DIVISION_ID) values
    (DIVISION_SEQ.nextval, 'Division six', null, 'The one', 4);
    INSERT INTO DIVISION (ID, NAME, ORIGINAL_NAME, DIRECTOR_NAME, PARENT_DIVISION_ID) values
    (DIVISION_SEQ.nextval, 'Division seven', null, 'The one',3);
    INSERT INTO DIVISION (ID, NAME, ORIGINAL_NAME, DIRECTOR_NAME, PARENT_DIVISION_ID) values
    (DIVISION_SEQ.nextval, 'Division eight', null, 'The one', null);
    INSERT INTO DIVISION (ID, NAME, ORIGINAL_NAME, DIRECTOR_NAME, PARENT_DIVISION_ID) values
    (DIVISION_SEQ.nextval, 'Division nine', null, 'The one', null);
    INSERT INTO DIVISION (ID, NAME, ORIGINAL_NAME, DIRECTOR_NAME, PARENT_DIVISION_ID) values
    (DIVISION_SEQ.nextval, 'Division ten', null, 'The one', null);

INSERT INTO PARKING_LOT (ID, DIVISION_ID, NAME, MAX_CAPACITY, CONTACT_PERSON_ID, STREET_NAME, STREET_NUMBER, CITY_ID, CATEGORY, PRICE_PER_HOUR,AMOUNT_OF_CARS_PARKED) VALUES
    (PARKING_LOT_SEQ.nextval, 1, 'parkinglot1', 300, 1, 'street' , '5',2 , 'ABOVE_GROUND_BUILDING', 3.5,100),
    (PARKING_LOT_SEQ.nextval, 1, 'parkinglot2', 300, 1, 'street' , '5',5 , 'ABOVE_GROUND_BUILDING', 3.5,100),
    (PARKING_LOT_SEQ.nextval, 3, 'parkinglot3', 300, 2, 'street' , '5',2 , 'ABOVE_GROUND_BUILDING', 2,100),
    (PARKING_LOT_SEQ.nextval, 3, 'parkinglot4', 300, 4, 'street' , '5',1 , 'ABOVE_GROUND_BUILDING', 2.5,100),
    (PARKING_LOT_SEQ.nextval, 3, 'parkinglot5', 300, 1, 'street' , '5',3 , 'ABOVE_GROUND_BUILDING', 4,100),
    (PARKING_LOT_SEQ.nextval, 3, 'parkinglot6', 300, 2, 'street' , '5',4 , 'ABOVE_GROUND_BUILDING', 3.5,100),
    (PARKING_LOT_SEQ.nextval, 2, 'parkinglot7', 300, 5, 'street' , '5',6 , 'ABOVE_GROUND_BUILDING', 3.5,100),
    (PARKING_LOT_SEQ.nextval, 2, 'parkinglot8', 300, 3, 'street' , '5',6 , 'ABOVE_GROUND_BUILDING', 3.5,100),
    (PARKING_LOT_SEQ.nextval, 2, 'fullParking', 100, 1, 'street' , '5',6 , 'ABOVE_GROUND_BUILDING', 3.5,100);

INSERT INTO MEMBER (ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NR, STREET_NAME, STREET_NUMBER, CITY_ID, REGISTRATION_DATE, LICENSE_PLATE_NR, LICENSE_ISSUING_COUNTRY, MEMBER_LEVEL) values
    (MEMBER_SEQ.nextval, 'BRONZE', 'last', 'something@hhhh.com', 'phone', 'street' , 'number', 2 , parsedatetime('17-09-2012 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'), 'license', 'Lcountry','BRONZE'),
    (MEMBER_SEQ.nextval, 'BRONZE', 'last', 'something@hhhh.com', 'phone', 'street' , 'number', 2 , parsedatetime('17-09-2012 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'), 'license', 'Lcountry','BRONZE'),
    (MEMBER_SEQ.nextval, 'BRONZE', 'last', 'something@hhhh.com', 'phone', 'street' , 'number', 2 , parsedatetime('17-09-2012 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'), 'license', 'Lcountry','BRONZE'),
    (MEMBER_SEQ.nextval, 'SILVER', 'last', 'something@hhhh.com', 'phone', 'street' , 'number', 2 , parsedatetime('17-09-2012 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'), 'license', 'Lcountry','SILVER'),
    (MEMBER_SEQ.nextval, 'SILVER', 'last', 'something@hhhh.com', 'phone', 'street' , 'number', 2 , parsedatetime('17-09-2012 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'), 'license', 'Lcountry','SILVER'),
    (MEMBER_SEQ.nextval, 'SILVER', 'last', 'something@hhhh.com', 'phone', 'street' , 'number', 2 , parsedatetime('17-09-2012 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'), 'license', 'Lcountry','SILVER'),
    (MEMBER_SEQ.nextval, 'SILVER', 'last', 'something@hhhh.com', 'phone', 'street' , 'number', 2 , parsedatetime('17-09-2012 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'), 'license', 'Lcountry','SILVER'),
    (MEMBER_SEQ.nextval, 'GOLD', 'last', 'something@hhhh.com', 'phone', 'street' , 'number', 2 , parsedatetime('17-09-2012 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'), 'license', 'Lcountry','GOLD'),
    (MEMBER_SEQ.nextval, 'GOLD', 'last', 'something@hhhh.com', 'phone', 'street' , 'number', 2 , parsedatetime('17-09-2012 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'), 'license', 'Lcountry','GOLD'),
    (MEMBER_SEQ.nextval, 'GOLD', 'last', 'something@hhhh.com', 'phone', 'street' , 'number', 2 , parsedatetime('17-09-2012 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'), 'license', 'Lcountry','GOLD');

INSERT INTO PARKING_ALLOCATION (ID, MEMBER_ID, LICENSE_PLATE, PARKING_LOT_ID, START_TIME, STATUS, STOP_TIME) values
    (PARKING_ALLOCATION_SEQ.nextval, 2, 'plate', 4, parsedatetime('17-09-2012 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'),'INVOICED' ,parsedatetime('17-09-2012 20:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS')),
    (PARKING_ALLOCATION_SEQ.nextval, 2, 'plate', 5, parsedatetime('17-09-2012 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'),'INVOICED' ,parsedatetime('17-09-2012 20:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS')),
    (PARKING_ALLOCATION_SEQ.nextval, 2, 'plate', 6, parsedatetime('17-09-2012 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'),'INVOICED' ,parsedatetime('17-09-2012 20:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS')),
    (PARKING_ALLOCATION_SEQ.nextval, 2, 'plate', 4, parsedatetime('17-09-2012 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'),'ACTIVE' ,NULL),
    (PARKING_ALLOCATION_SEQ.nextval, 2, 'plate', 4, parsedatetime('17-09-2012 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'),'ACTIVE' ,NULL),
    (PARKING_ALLOCATION_SEQ.nextval, 2, 'plate', 4, parsedatetime('17-09-2012 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'),'ACTIVE' ,NULL),
    (PARKING_ALLOCATION_SEQ.nextval, 2, 'plate', 4, parsedatetime('17-09-2012 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'),'STOPPED' ,parsedatetime('17-09-2012 20:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS')),
    (PARKING_ALLOCATION_SEQ.nextval, 2, 'plate', 4, parsedatetime('17-09-2012 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'),'STOPPED' ,parsedatetime('17-09-2012 20:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS')),
    (PARKING_ALLOCATION_SEQ.nextval, 2, 'plate', 4, parsedatetime('17-09-2012 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'),'STOPPED' ,parsedatetime('17-09-2012 20:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'));

INSERT INTO INVOICE (ID, MEMBER_ID, START_DATE, EXPIRE_DATE, PAYMENT_DATE, STATUS) values
    (INVOICE_SEQ.nextval,2,parsedatetime('17-09-2014 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'),parsedatetime('17-10-2014 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'),null, 'OPEN');

INSERT INTO INVOICE_ITEM (ID, INVOICE_ID, PARKING_ALLOCATION_ID, PRICE) VALUES
    (INVOICE_ITEM_SEQ.nextval,1,1,3.0),
    (INVOICE_ITEM_SEQ.nextval,1,2,7.0),
    (INVOICE_ITEM_SEQ.nextval,1,3,4.0);
