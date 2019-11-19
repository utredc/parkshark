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

ALTER TABLE "DIVISION"
    ADD CONSTRAINT "DIVISION_fk1" FOREIGN KEY ("PARENT_DIVISION_ID") REFERENCES "DIVISION" ("ID");

ALTER TABLE "PARKING_LOT"
    ADD CONSTRAINT "PARKING_LOT_fk0" FOREIGN KEY ("DIVISION_ID") REFERENCES "DIVISION" ("ID");

ALTER TABLE "PARKING_LOT"
    ADD CONSTRAINT "PARKING_LOT_fk1" FOREIGN KEY ("CONTACT_PERSON_ID") REFERENCES "CONTACT_PERSON" ("ID");

CREATE SEQUENCE DIVISION_SEQ;

CREATE SEQUENCE MEMBER_SEQ;

CREATE SEQUENCE PARKING_LOT_SEQ;

CREATE SEQUENCE CONTACT_PERSON_SEQ;

INSERT INTO CITY (CITY_ID, POSTAL_CODE, NAME)
VALUES (1, '1000', 'Brussel');

INSERT INTO CONTACT_PERSON (ID, FIRST_NAME, LAST_NAME, EMAIL, STREET_NAME, STREET_NUMBER, CITY_ID,MOBILE_NR, PHONE_NR)
VALUES (1, 'Jimmy', 'VanPimperzele', 'jimmy@pimperzele.com', 'pimperzelestraat', '25a', 1, '02/53.32.32', '052/254.36.36');

INSERT INTO DIVISION (ID, NAME, ORIGINAL_NAME, DIRECTOR_NAME, PARENT_DIVISION_ID)
values (1,'Division One', null, 'The one', null)


