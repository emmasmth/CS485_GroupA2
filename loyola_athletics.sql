CREATE TABLE `loyola_athletics`.`equipment` (
  `idequipment` INT NOT NULL AUTO_INCREMENT,
  `brand` VARCHAR(100) NOT NULL,
  `color` VARCHAR(100) NOT NULL,
  `description` VARCHAR(250) NOT NULL,
  PRIMARY KEY (`idequipment`),
  UNIQUE INDEX `idequipment_UNIQUE` (`idequipment` ASC) VISIBLE);
