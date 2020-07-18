DROP TABLE pet_types IF EXISTS;
DROP TABLE owners IF EXISTS;
DROP TABLE pets IF EXISTS;
DROP TABLE clinic IF EXISTS;
DROP TABLE doctor IF EXISTS;
DROP TABLE doctor_clinic IF EXISTS;
DROP TABLE visit IF EXISTS;



CREATE TABLE pet_types (
    id     INTEGER IDENTITY PRIMARY KEY,
    name   VARCHAR(80)
);

CREATE TABLE owners (
    id           INT AUTO_INCREMENT  PRIMARY KEY,
    owner_name   VARCHAR(100),
    gender       VARCHAR(80),
    postcode     VARCHAR(20),
    street       VARCHAR(20),
    city         VARCHAR(20),
    country      VARCHAR(20),
    email        VARCHAR(80),
    phone        VARCHAR(20)
);

CREATE TABLE pets (
    id          INT AUTO_INCREMENT  PRIMARY KEY,
    name         VARCHAR(30),
    birth_date   DATE,
    photo        BLOB,
    weight       VARCHAR(30),
    gender       VARCHAR(80),
    type_id      INTEGER NOT NULL,
    owner_id     INTEGER NOT NULL,
    FOREIGN KEY ( type_id )
        REFERENCES pet_types ( id ),
    FOREIGN KEY ( owner_id )
        REFERENCES owners ( id )
);

CREATE TABLE clinic (
    id         INT AUTO_INCREMENT  PRIMARY KEY,
    name       VARCHAR(100),
    email      VARCHAR(80),
    phone      VARCHAR(20),
    postcode   VARCHAR(20),
    street     VARCHAR(20),
    city       VARCHAR(20),
    country    VARCHAR(20),
    facebook   VARCHAR(20),
    instgram   VARCHAR(20),
    twitter    VARCHAR(20)
);

CREATE TABLE doctor (
    id      INT AUTO_INCREMENT  PRIMARY KEY,
    name    VARCHAR(30),
    photo   BLOB,
    bio     VARCHAR(500)
);

CREATE TABLE doctor_clinic (
    id           INT AUTO_INCREMENT  PRIMARY KEY,
    doctor_id   INTEGER NOT NULL,
    clinic_id   INTEGER NOT NULL,
    PRIMARY KEY ( id ),
    FOREIGN KEY ( doctor_id )
        REFERENCES doctor ( id ),
    FOREIGN KEY ( clinic_id )
        REFERENCES clinic ( id )
);


CREATE UNIQUE INDEX ux_doctor_for_clinic ON
    doctor_clinic (
        doctor_id
    );

CREATE TABLE visit (
    id         INT AUTO_INCREMENT  PRIMARY KEY,
    doctor_id    INTEGER NOT NULL,
    clinic_id    INTEGER NOT NULL,
    pet_id       INTEGER NOT NULL,
    visit_date   DATE,
    FOREIGN KEY ( doctor_id )
        REFERENCES doctor ( id ),
    FOREIGN KEY ( clinic_id )
        REFERENCES clinic ( id ),
    FOREIGN KEY ( pet_id )
        REFERENCES pets ( id )
);
