
-- -----------------------------------------------------
-- Schema agrinkevich
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `agrinkevich`;

-- -----------------------------------------------------
-- Schema agrinkevich
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `agrinkevich`;

-- -----------------------------------------------------
-- Table `agrinkevich`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `agrinkevich`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(16) NOT NULL,
  `email` VARCHAR(255) NULL,
  `password` VARCHAR(32) NOT NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `agrinkevich`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `agrinkevich`.`category` (
  `id` INT NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `agrinkevich`.`variable`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `agrinkevich`.`variable` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `text` VARCHAR(45) NULL,
  `category_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_variable_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `agrinkevich`.`category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_variable_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `agrinkevich`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Data for table `agrinkevich`.`user`
-- -----------------------------------------------------

INSERT INTO `agrinkevich`.`user` (`id`, `username`, `email`, `password`, `create_time`) VALUES (1, 'default', 'default@mail.com', 'qwerty', '2019-04-25');
INSERT INTO `agrinkevich`.`user` (`id`, `username`, `email`, `password`, `create_time`) VALUES (2, 'user', 'user@gmail.com', 'testqwe', '2019-04-25');
INSERT INTO `agrinkevich`.`user` (`id`, `username`, `email`, `password`, `create_time`) VALUES (3, 'admin', 'admin@gmail.com', 'adminqwe', '2019-04-25');



-- -----------------------------------------------------
-- Data for table `agrinkevich`.`category`
-- -----------------------------------------------------

INSERT INTO `agrinkevich`.`category` (`id`, `name`) VALUES (1, 'SCALAR');
INSERT INTO `agrinkevich`.`category` (`id`, `name`) VALUES (2, 'VECTOR');
INSERT INTO `agrinkevich`.`category` (`id`, `name`) VALUES (3, 'MATRIX');



-- -----------------------------------------------------
-- Data for table `agrinkevich`.`variable`
-- -----------------------------------------------------

INSERT INTO `agrinkevich`.`variable` (`id`, `name`, `text`, `category_id`, `user_id`) VALUES (1, 'A', '111', 1, 1);


