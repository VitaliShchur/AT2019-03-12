-- MySQL Workbench Forward Engineering
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `vshchur`;

-- -----------------------------------------------------
-- Schema vshchur
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `vshchur`;


-- -----------------------------------------------------
-- Table `vshchur`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vshchur`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(16) NOT NULL,
  `email` VARCHAR(255) NULL,
  `password` VARCHAR(32) NOT NULL,
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `vshchur`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vshchur`.`category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC));


-- -----------------------------------------------------
-- Table `vshchur`.`variable`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vshchur`.`variable` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `text` VARCHAR(45) NULL,
  `user_id` INT NOT NULL,
  `category_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_variable_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `vshchur`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_variable_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `vshchur`.`category` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Data for table `vshchur`.`user`
-- -----------------------------------------------------

INSERT INTO `vshchur`.`user` (`id`, `username`, `email`, `password`, `create_time`) VALUES (1, 'default', 'def@mail.ru', 'qwerty', DEFAULT);
INSERT INTO `vshchur`.`user` (`id`, `username`, `email`, `password`, `create_time`) VALUES (2, 'user', 'user@mail.ru', 'asdfgh', DEFAULT);
INSERT INTO `vshchur`.`user` (`id`, `username`, `email`, `password`, `create_time`) VALUES (3, 'admin', 'admin@google.com', 'zxcvbn', DEFAULT);



-- -----------------------------------------------------
-- Data for table `vshchur`.`category`
-- -----------------------------------------------------

INSERT INTO `vshchur`.`category` (`id`, `name`) VALUES (1, 'SCALAR');
INSERT INTO `vshchur`.`category` (`id`, `name`) VALUES (2, 'VECTOR');
INSERT INTO `vshchur`.`category` (`id`, `name`) VALUES (3, 'MATRIX');



-- -----------------------------------------------------
-- Data for table `vshchur`.`variable`
-- -----------------------------------------------------

INSERT INTO `vshchur`.`variable` (`id`, `name`, `text`, `user_id`, `category_id`) VALUES (1, 'A', '111', 1, 1);


