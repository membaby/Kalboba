CREATE DATABASE Petfecto;

USE Petfecto;

-- The general user account
-- T: When inserting a new record, verification record is added.
-- Backend logic: To verify something, update verified = true and delete the verification record only.
CREATE TABLE user_account (
	id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(40) UNIQUE NOT NULL,
    user_class ENUM('Admin', 'Manager', 'Staff', 'Adopter') NOT NULL,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    password_hash VARCHAR(255) NOT NULL, -- Requires backend hashing and length-validation
    email VARCHAR(255) UNIQUE,
    phone_no VARCHAR(15),
    address VARCHAR(200),
    verified BOOL NOT NULL DEFAULT FALSE,
    gender ENUM('M', 'F') NOT NULL,
    birthdate DATE NOT NULL,
    PRIMARY KEY (id)
);
ALTER TABLE user_account AUTO_INCREMENT = 100;

-- I: on account_id
-- T: When entry is deleted, the corrsponding verified bit in the account record is checked,
--    if it is verified, the corresponding user class is created, otherwise, account record is deleted.
-- Permissions: No insertion (only by account creation trigger).
CREATE TABLE verification (
	account_id INT NOT NULL,
    time_stamp TIMESTAMP NOT NULL DEFAULT (CURRENT_TIMESTAMP + INTERVAL 24 HOUR),
    otp VARCHAR(10) NOT NULL,
    PRIMARY KEY (account_id, time_stamp),
    FOREIGN KEY (account_id) REFERENCES user_account(id)
);

-- I: on account_id
CREATE TABLE notification (
	account_id INT NOT NULL,
    viewed BOOL NOT NULL DEFAULT FALSE,
    time_stamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    message VARCHAR(255) NOT NULL,
    FOREIGN KEY (account_id) REFERENCES user_account(id)
);

-- T: If id exists in any other user class, reject insert
-- Permissions: No insertion (only by verification trigger)
-- Backend: OTP must only be sent to admins not the person himself
CREATE TABLE sys_admin (
	id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id) REFERENCES user_account(id)
);

-- T: If id exists in any other user class, reject insert
-- Permissions: No insertion (only by verification trigger)
CREATE TABLE manager (
	id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id) REFERENCES user_account(id)
);

-- T: If id exists in any other user class, reject insert
-- Permissions: No insertion (only by verification trigger)
CREATE TABLE staff (
	id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id) REFERENCES user_account(id)
);

-- T: If id exists in any other user class, reject insert
-- Permissions: No insertion (only by verification trigger)
CREATE TABLE adopter (
	id INT NOT NULL,
    about VARCHAR(500),
    PRIMARY KEY (id),
    FOREIGN KEY (id) REFERENCES user_account(id)
);

CREATE TABLE shelter (
	id INT NOT NULL AUTO_INCREMENT,
    shelter_name VARCHAR(70) NOT NULL,
    location VARCHAR(200) NOT NULL,
    phone_no VARCHAR(15) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);
ALTER TABLE shelter AUTO_INCREMENT = 100;

-- I: on shelter_id (would probably want to know the manager from the shelter_id).
CREATE TABLE manages (
	manager_id INT NOT NULL,
    shelter_id INT NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE,
    PRIMARY KEY (manager_id, shelter_id),
    FOREIGN KEY (manager_id) REFERENCES manager(id),
    FOREIGN KEY (shelter_id) REFERENCES shelter(id)
);

-- I: on shelter_id (same reason as above)
CREATE TABLE works_at (
	staff_id INT NOT NULL,
    shelter_id INT NOT NULL,
    staff_role VARCHAR(100) NOT NULL DEFAULT 'No specific role yet.',
    start_date DATE NOT NULL,
    end_date DATE,
    PRIMARY KEY (staff_id, shelter_id),
    FOREIGN KEY (staff_id) REFERENCES staff(id),
    FOREIGN KEY (shelter_id) REFERENCES shelter(id)
);

CREATE TABLE species (
	species VARCHAR(50) NOT NULL,
    PRIMARY KEY (species)
);

CREATE TABLE breed (
	species VARCHAR(50) NOT NULL,
    breed VARCHAR(70) NOT NULL,
    PRIMARY KEY (species, breed),
    FOREIGN KEY (species) REFERENCES species(species)
);

-- I: on id
CREATE TABLE pet (
	id INT NOT NULL AUTO_INCREMENT,
	pet_name VARCHAR(100) NOT NULL DEFAULT 'Unnamed',
    species VARCHAR(50) NOT NULL,
    breed VARCHAR(70) NOT NULL,
    color VARCHAR(50) NOT NULL,
    age_years SMALLINT UNSIGNED NOT NULL,
    age_months SMALLINT UNSIGNED NOT NULL,
    appearance VARCHAR(250) NOT NULL DEFAULT 'This pet\'s appearance has no description yet!',
    behavior VARCHAR(250) NOT NULL DEFAULT 'This pet\'s behavior has no description yet!',
    gender ENUM('M','F','U') NOT NULL,
    health VARCHAR(250) NOT NULL DEFAULT 'This pet\'s health status has no description yet!',
    fertility ENUM('fertile', 'infertile', 'spayed_neutered', 'unknown') NOT NULL DEFAULT 'unknown',
    adopted BOOL NOT NULL DEFAULT FALSE,
    PRIMARY KEY (id),
    FOREIGN KEY (species, breed) REFERENCES breed(species, breed)
);
ALTER TABLE pet AUTO_INCREMENT = 100;

CREATE TABLE doc_type (
	type_no INT NOT NULL AUTO_INCREMENT,
    type_name VARCHAR(70) NOT NULL UNIQUE,
    PRIMARY KEY (type_no)
);

-- I: on pet_id (documents are associated with a pet)
CREATE TABLE pet_doc (
	entry_id INT NOT NULL AUTO_INCREMENT,
	pet_id INT NOT NULL,
    doctype INT NOT NULL,
    document MEDIUMBLOB NOT NULL,
    PRIMARY KEY (entry_id),
    FOREIGN KEY (pet_id) REFERENCES pet(id),
    FOREIGN KEY (doctype) REFERENCES doc_type(type_no)
);
ALTER TABLE pet_doc AUTO_INCREMENT = 100;

-- I: on shelter_id (staff query to view their shelter's pets)
-- T: Inserting a record into this table deletes records with same pet_id in adopted_by 
--    and sets this pet's adoption status to false.
-- Note 1: This table can have the same pet given to the same shelter twice (e.g. owner didn't want it).
-- Note 2: This table keeps a history of shelters the animal has been to with the sheltering period.
CREATE TABLE sheltered_at (
	pet_id INT NOT NULL,
    shelter_id INT NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE,
    reason_for_availability VARCHAR(200) NOT NULL DEFAULT 'Undocumented',
    PRIMARY KEY (pet_id, shelter_id, start_date),
    FOREIGN KEY (pet_id) REFERENCES pet(id),
    FOREIGN KEY (shelter_id) REFERENCES shelter(id)
);

-- I: on shelter_id
-- T: On updating status to Accepted (completed) or Rejected, record is moved to closed table.
CREATE TABLE adoption_application_open (
	pet_id INT NOT NULL,
    adopter_id INT NOT NULL,
    shelter_id INT NOT NULL,
    time_stamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    app_status ENUM('Unopened', 'UnderReview', 'Rejected', 'Accepted_Open', 'Accepted_Completed') NOT NULL DEFAULT 'Unopened',
    first_pet BOOL NOT NULL, -- Required field
    children_ages VARCHAR(500) NOT NULL, -- Required field
    place_for_pet VARCHAR(500) NOT NULL, -- Required field
    tolerance VARCHAR(500) NOT NULL, -- Required field
    adopters_time VARCHAR(500) NOT NULL, -- Required field
    PRIMARY KEY (pet_id, adopter_id, shelter_id),
    FOREIGN KEY (pet_id) REFERENCES pet(id),
    FOREIGN KEY (adopter_id) REFERENCES adopter(id),
    FOREIGN KEY (shelter_id) REFERENCES shelter(id)
);

-- I: on shelter_id
-- Permissions: No insertion (done by the open adoption application triggers)
CREATE TABLE adoption_application_closed (
	pet_id INT NOT NULL,
    adopter_id INT NOT NULL,
    shelter_id INT NOT NULL,
    time_stamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    app_status ENUM('Rejected', 'Accepted_Completed') NOT NULL,
    first_pet BOOL NOT NULL, -- Required field
    children_ages VARCHAR(500) NOT NULL, -- Required field
    place_for_pet VARCHAR(500) NOT NULL, -- Required field
    tolerance VARCHAR(500) NOT NULL, -- Required field
    adopters_time VARCHAR(500) NOT NULL, -- Required field
    PRIMARY KEY (pet_id, adopter_id, shelter_id),
    FOREIGN KEY (pet_id) REFERENCES pet(id),
    FOREIGN KEY (adopter_id) REFERENCES adopter(id),
    FOREIGN KEY (shelter_id) REFERENCES shelter(id)
);

-- I: on pet_id
-- T: Whenever inserting a record here, find the record in sheltered_at table which has matching
--    pet_id and null end_date and set end_date to current date.
--    Also, set the pet adoption status to true, and if it is already true, reject operation.
CREATE TABLE adopted_by (
	pet_id INT NOT NULL,
    adopter_id INT NOT NULL,
    PRIMARY KEY (pet_id, adopter_id),
    FOREIGN KEY (pet_id) REFERENCES pet(id),
    FOREIGN KEY (adopter_id) REFERENCES adopter(id)
);
