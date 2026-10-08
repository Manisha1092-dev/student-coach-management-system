-- Create database
CREATE DATABASE springboot_preparation
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE springboot_preparation;

-- Coach table
CREATE TABLE coach (
  id INT NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  specialty VARCHAR(100) DEFAULT NULL,
  experience_years INT DEFAULT 0,
  email VARCHAR(100) UNIQUE,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Student table
CREATE TABLE student (
  id INT NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  email VARCHAR(100) UNIQUE,
  enrollment_date DATE NOT NULL,
  major VARCHAR(100) DEFAULT NULL,
  coach_id INT,
  PRIMARY KEY (id),
  CONSTRAINT fk_coach
    FOREIGN KEY (coach_id) REFERENCES coach(id)
    ON DELETE SET NULL
    ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
