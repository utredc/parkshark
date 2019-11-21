CREATE TABLE "DIVISION"
(
    "ID"                 NUMBER        NOT NULL,
    "NAME"               VARCHAR2(255) NOT NULL,
    "ORIGINAL_NAME"      VARCHAR2(255),
    "DIRECTOR_NAME"      VARCHAR2(255) NOT NULL,
    "PARENT_DIVISION_ID" NUMBER,
    constraint DIVISION_PK PRIMARY KEY ("ID")
);

CREATE TABLE "PARKING_LOT"
(
    "ID"                    NUMBER        NOT NULL,
    "DIVISION_ID"           NUMBER        NOT NULL,
    "NAME"                  VARCHAR2(255) NOT NULL,
    "MAX_CAPACITY"          NUMBER        NOT NULL,
    "CONTACT_PERSON_ID"     NUMBER        NOT NULL,
    "STREET_NAME"           VARCHAR2(255) NOT NULL,
    "STREET_NUMBER"         VARCHAR2(255) NOT NULL,
    "CITY_ID"               NUMBER        NOT NULL,
    "CATEGORY"              VARCHAR2(255) NOT NULL,
    "PRICE_PER_HOUR"        NUMBER        NOT NULL,
    "AMOUNT_OF_CARS_PARKED" NUMBER        NOT NULL,
    constraint PARKING_LOT_PK PRIMARY KEY ("ID")
);

CREATE TABLE "CONTACT_PERSON"
(
    "ID"            NUMBER        NOT NULL,
    "FIRST_NAME"    VARCHAR2(255) NOT NULL,
    "LAST_NAME"     VARCHAR2(255) NOT NULL,
    "EMAIL"         VARCHAR2(255) NOT NULL,
    "STREET_NAME"   VARCHAR2(255) NOT NULL,
    "STREET_NUMBER" VARCHAR2(255) NOT NULL,
    "CITY_ID"       NUMBER        NOT NULL,
    "MOBILE_NR"     VARCHAR2(255),
    "PHONE_NR"      VARCHAR2(255),
    constraint CONTACT_PERSON_PK PRIMARY KEY ("ID")
);

CREATE TABLE "MEMBER"
(
    "ID"                      NUMBER        NOT NULL,
    "FIRST_NAME"              VARCHAR2(255) NOT NULL,
    "LAST_NAME"               VARCHAR2(255) NOT NULL,
    "EMAIL"                   VARCHAR2(255) NOT NULL,
    "PHONE_NR"                VARCHAR2(255) NOT NULL,
    "STREET_NAME"             VARCHAR2(255) NOT NULL,
    "STREET_NUMBER"           VARCHAR2(255) NOT NULL,
    "CITY_ID"                 NUMBER        NOT NULL,
    "REGISTRATION_DATE"       DATE          NOT NULL,
    "LICENSE_PLATE_NR"        VARCHAR2(255) NOT NULL,
    "LICENSE_ISSUING_COUNTRY" VARCHAR2(255) NOT NULL,
    "MEMBER_LEVEL"            VARCHAR2(255) NOT NULL,
    constraint MEMBER_PK PRIMARY KEY ("ID")
);

CREATE TABLE "CITY"
(
    "CITY_ID"     NUMBER        NOT NULL,
    "POSTAL_CODE" VARCHAR2(255) NOT NULL,
    "NAME"        VARCHAR2(255) NOT NULL,
    constraint CITY_PK PRIMARY KEY ("CITY_ID")
);

CREATE TABLE "PARKING_ALLOCATION"
(
    "ID"             NUMBER       NOT NULL,
    "MEMBER_ID"      NUMBER       NOT NULL,
    "LICENSE_PLATE"  VARCHAR2(20) NOT NULL,
    "PARKING_LOT_ID" NUMBER       NOT NULL,
    "START_TIME"     TIMESTAMP    NOT NULL,
    "STOP_TIME"      TIMESTAMP,
    "STATUS"         VARCHAR2(20) NOT NULL,
    CONSTRAINT PARKING_ALLOCATION_PK PRIMARY KEY ("ID")
);

create table INVOICE
(
    ID number PRIMARY KEY ,
    MEMBER_ID number,
    START_DATE TIMESTAMP,
    EXPIRE_DATE TIMESTAMP,
    PAYMENT_DATE TIMESTAMP,
    STATUS VARCHAR2(20)
);

CREATE TABLE INVOICE_ITEM
(
    ID NUMBER PRIMARY KEY,
    INVOICE_ID NUMBER,
    PARKING_ALLOCATION_ID NUMBER,
    PRICE NUMBER
);

ALTER TABLE "DIVISION"
    ADD CONSTRAINT "DIVISION_fk1"
    FOREIGN KEY ("PARENT_DIVISION_ID")
    REFERENCES "DIVISION" ("ID");

ALTER TABLE "PARKING_LOT"
    ADD CONSTRAINT "PARKING_LOT_fk0"
    FOREIGN KEY ("DIVISION_ID")
    REFERENCES "DIVISION" ("ID");

ALTER TABLE "PARKING_LOT"
    ADD CONSTRAINT "PARKING_LOT_fk1"
    FOREIGN KEY ("CONTACT_PERSON_ID")
    REFERENCES "CONTACT_PERSON" ("ID");

ALTER TABLE "PARKING_ALLOCATION"
    ADD CONSTRAINT "PARKING_ALLOCATION_fk0"
    FOREIGN KEY ("MEMBER_ID")
    REFERENCES "MEMBER" ("ID");

ALTER TABLE "PARKING_ALLOCATION"
    ADD CONSTRAINT "PARKING_ALLOCATION_fk1"
    FOREIGN KEY ("PARKING_LOT_ID")
    REFERENCES "PARKING_LOT" ("ID");

ALTER TABLE "INVOICE"
    ADD CONSTRAINT "INVOICE_FK0"
    FOREIGN KEY ("MEMBER_ID")
    REFERENCES "MEMBER" ("ID");

ALTER TABLE "INVOICE_ITEM"
    ADD CONSTRAINT "INVOICE_ITEM_fk0"
    FOREIGN KEY ("INVOICE_ID")
    REFERENCES "INVOICE" ("ID");

ALTER TABLE "INVOICE_ITEM"
    ADD CONSTRAINT "INVOICE_ITEM_fk1"
    FOREIGN KEY ("PARKING_ALLOCATION_ID")
    REFERENCES "PARKING_ALLOCATION" ("ID");

CREATE SEQUENCE DIVISION_SEQ;

CREATE SEQUENCE MEMBER_SEQ;

CREATE SEQUENCE PARKING_LOT_SEQ;

CREATE SEQUENCE CONTACT_PERSON_SEQ;

CREATE SEQUENCE CITY_SEQ;

CREATE SEQUENCE PARKING_ALLOCATION_SEQ;

CREATE SEQUENCE INVOICE_SEQ;

CREATE SEQUENCE INVOICE_ITEM_SEQ;