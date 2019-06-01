
-- Schema udalyou
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `udalyou` ;

-- -----------------------------------------------------
-- Schema udalyou
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `udalyou` ;

-- -----------------------------------------------------
-- Table `udalyou`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `udalyou`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `username` NVARCHAR(16) NOT NULL COMMENT '',
  `email` VARCHAR(255) NULL COMMENT '',
  `password` VARCHAR(32) NOT NULL COMMENT '',
  `create_time` TIMESTAMP(6) NULL COMMENT '',
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `udalyou`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `udalyou`.`category` (
  `id` INT NOT NULL COMMENT '',
  `name` VARCHAR(255) NOT NULL COMMENT '',
  PRIMARY KEY (`id`) );


-- -----------------------------------------------------
-- Table `udalyou`.`veriable`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `udalyou`.`veriable` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `text` VARCHAR(45) NULL,
  `user_id` INT NOT NULL,
  `category_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_veriable_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `udalyou`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_veriable_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `udalyou`.`category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



INSERT INTO `udalyou`.`user` (`id`, `username`, `email`, `password`, `create_time`) VALUES (1, 'default', 'default@tut.by', '12345', '20190502');
INSERT INTO `udalyou`.`user` (`id`, `username`, `email`, `password`, `create_time`) VALUES (2, 'user', 'user@mail.ru', '65432', '20190502');
INSERT INTO `udalyou`.`user` (`id`, `username`, `email`, `password`, `create_time`) VALUES (3, 'admin', 'admin@gmail.ru', '789645', '20190502');




-- -----------------------------------------------------
-- Data for table `udalyou`.`category`
-- -----------------------------------------------------

INSERT INTO `udalyou`.`category` (`id`, `name`) VALUES (1, 'SCALAR');
INSERT INTO `udalyou`.`category` (`id`, `name`) VALUES (2, 'VECTOR');
INSERT INTO `udalyou`.`category` (`id`, `name`) VALUES (3, 'MATRIX');


-- -----------------------------------------------------
-- Data for table `udalyou`.`veriable`
-- -----------------------------------------------------
INSERT INTO `udalyou`.`veriable` (`id`, `name`, `text`, `user_id`, `category_id`) VALUES (1, 'aaa', '111', 1, 1);



