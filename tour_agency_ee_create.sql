-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema tour_agency_ee
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema tour_agency_ee
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tour_agency_ee` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `tour_agency_ee` ;

-- -----------------------------------------------------
-- Table `tour_agency_ee`.`account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tour_agency_ee`.`account` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(255) NULL DEFAULT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  `first_name` VARCHAR(2048) NULL DEFAULT NULL,
  `last_name` VARCHAR(255) NULL DEFAULT NULL,
  `role` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UKgex1lmaqpg0ir5g1f5eftyaa1` (`login` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `tour_agency_ee`.`tour`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tour_agency_ee`.`tour` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `price` INT NOT NULL,
  `tour_type` VARCHAR(255) NULL DEFAULT NULL,
  `people_amount` INT NOT NULL,
  `stars` INT NOT NULL,
  `is_hot` BIT(1) NOT NULL,
  `img` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `tour_agency_ee`.`tour_order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tour_agency_ee`.`tour_order` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NULL DEFAULT NULL,
  `tour_id` INT NULL DEFAULT NULL,
  `tickets_quantity` INT NULL DEFAULT NULL,
  `status` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK31np5r7cqxmaodl8tx09x244p` (`user_id` ASC) VISIBLE,
  INDEX `FK3kgc5yg2gcv2r4xxftprjk0q8` (`tour_id` ASC) VISIBLE,
  CONSTRAINT `FK31np5r7cqxmaodl8tx09x244p`
    FOREIGN KEY (`user_id`)
    REFERENCES `tour_agency_ee`.`account` (`id`),
  CONSTRAINT `FK3kgc5yg2gcv2r4xxftprjk0q8`
    FOREIGN KEY (`tour_id`)
    REFERENCES `tour_agency_ee`.`tour` (`id`)
    ON DELETE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
