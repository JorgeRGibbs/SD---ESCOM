-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema clk
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema clk
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `clk` DEFAULT CHARACTER SET utf8 ;
USE `clk` ;

-- -----------------------------------------------------
-- Table `clk`.`HoraCentral`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clk`.`HoraCentral` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `hPrev` VARCHAR(45) NULL,
  `hRef` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clk`.`HoraEquipos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clk`.`HoraEquipos` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `hEquipo` VARCHAR(45) NULL,
  `aEquipo` VARCHAR(45) NULL,
  `ralentizar` VARCHAR(45) NULL,
  `IDEquipo` INT NULL,
  `IDSincr` INT NULL,
  `Equipos_ID` INT NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clk`.`Equipos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clk`.`Equipos` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `IP` VARCHAR(45) NULL,
  `Nombre` VARCHAR(45) NULL,
  `Latencia` VARCHAR(45) NULL,
  `HoraEquipos_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Equipos_HoraEquipos1_idx` (`HoraEquipos_ID` ASC) VISIBLE,
  CONSTRAINT `fk_Equipos_HoraEquipos1`
    FOREIGN KEY (`HoraEquipos_ID`)
    REFERENCES `clk`.`HoraEquipos` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clk`.`HoraCentral_has_HoraEquipos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clk`.`HoraCentral_has_HoraEquipos` (
  `HoraCentral_ID` INT NOT NULL ,
  `HoraEquipos_ID` INT NOT NULL ,
  PRIMARY KEY (`HoraCentral_ID`, `HoraEquipos_ID`),
  INDEX `fk_HoraCentral_has_HoraEquipos_HoraEquipos1_idx` (`HoraEquipos_ID` ASC) VISIBLE,
  INDEX `fk_HoraCentral_has_HoraEquipos_HoraCentral1_idx` (`HoraCentral_ID` ASC) VISIBLE,
  CONSTRAINT `fk_HoraCentral_has_HoraEquipos_HoraCentral1`
    FOREIGN KEY (`HoraCentral_ID`)
    REFERENCES `clk`.`HoraCentral` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_HoraCentral_has_HoraEquipos_HoraEquipos1`
    FOREIGN KEY (`HoraEquipos_ID`)
    REFERENCES `clk`.`HoraEquipos` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
