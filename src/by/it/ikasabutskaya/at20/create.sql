-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ikasabutskaya
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `ikasabutskaya` ;

-- -----------------------------------------------------
-- Schema ikasabutskaya
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ikasabutskaya` DEFAULT CHARACTER SET utf8 ;
USE `ikasabutskaya` ;

-- -----------------------------------------------------
-- Table `ikasabutskaya`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ikasabutskaya`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(16) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(32) NOT NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ikasabutskaya`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ikasabutskaya`.`category` (
  `id` INT NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ikasabutskaya`.`variable`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ikasabutskaya`.`variable` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `text` VARCHAR(45) NULL,
  `category_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_variable_category1_idx` (`category_id` ASC) VISIBLE,
  INDEX `fk_variable_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_variable_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `ikasabutskaya`.`category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_variable_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `ikasabutskaya`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `ikasabutskaya`.`user`
-- -----------------------------------------------------
START TRANSACTION;
USE `ikasabutskaya`;
INSERT INTO `ikasabutskaya`.`user` (`id`, `username`, `email`, `password`, `create_time`) VALUES (DEFAULT, 'default', 'default@mail.com', 'qwerty', '2019-05-29');
INSERT INTO `ikasabutskaya`.`user` (`id`, `username`, `email`, `password`, `create_time`) VALUES (DEFAULT, 'user', 'user@gmail.com', 'asdfgh', '2019-05-29');
INSERT INTO `ikasabutskaya`.`user` (`id`, `username`, `email`, `password`, `create_time`) VALUES (DEFAULT, 'admin', 'admin@domain.com', 'zxcvbn', '2019-05-29');

COMMIT;


-- -----------------------------------------------------
-- Data for table `ikasabutskaya`.`category`
-- -----------------------------------------------------
START TRANSACTION;
USE `ikasabutskaya`;
INSERT INTO `ikasabutskaya`.`category` (`id`, `name`) VALUES (1, 'SCALAR');
INSERT INTO `ikasabutskaya`.`category` (`id`, `name`) VALUES (2, 'VECTOR');
INSERT INTO `ikasabutskaya`.`category` (`id`, `name`) VALUES (3, 'MATRIX');

COMMIT;


-- -----------------------------------------------------
-- Data for table `ikasabutskaya`.`variable`
-- -----------------------------------------------------
START TRANSACTION;
USE `ikasabutskaya`;
INSERT INTO `ikasabutskaya`.`variable` (`id`, `name`, `text`, `category_id`, `user_id`) VALUES (1, 'A', '111', 1, 1);

COMMIT;

