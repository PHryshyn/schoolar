CREATE TABLE shedule (
  shedule_id INT(11) AUTO_INCREMENT,
  discipline_id VARCHAR(45) NOT NULL,
  PRIMARY KEY (`shedule_id`) )
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


CREATE  TABLE user (
  id INT(11) NOT NULL AUTO_INCREMENT,
  username VARCHAR(45) NOT NULL ,
  password VARCHAR(60) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1 ,
  first_name VARCHAR(45) NOT NULL,
  last_name VARCHAR(45) NOT NULL,
  email VARCHAR(45),
  adress VARCHAR(45),
  full_name_p1 VARCHAR(45),
  full_name_p2 VARCHAR(45),
  phone INT(20),
  shedule_id INT(11),
  PRIMARY KEY (id),
  INDEX `fk_shedule_user` (`shedule_id` ASC) ,
  CONSTRAINT `fk_shedule_user`
  FOREIGN KEY (`shedule_id` )
  REFERENCES `marius`.`shedule`(`schedule_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;
