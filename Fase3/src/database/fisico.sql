-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema DSS_Project
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema DSS_Project
-- -----------------------------------------------------
DROP SCHEMA `DSS_Project` ;
CREATE SCHEMA IF NOT EXISTS `DSS_Project` DEFAULT CHARACTER SET utf8 ;
USE `DSS_Project` ;

-- -----------------------------------------------------
-- Table `DSS_Project`.`Campeonato`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DSS_Project`.`Palete` (
  `idCampeonato` INT NOT NULL, 
  `nomeCamp` VARCHAR(40) NOT NULL,
  `corridas` TEXT(10000) NOT NULL,
  `classficacaoCamp` INT(255) NOT NULL,
  PRIMARY KEY (`idCampeonato`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `DSS_Project`.`Carro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DSS_Project`.`Carro` (
  `idCarro` INT NOT NULL,
  `perfAerodinamico` INT NOT NULL,
  `cilindrada` INT NOT NULL,
  `potencia` INT NOT NULL,
  `fiabilidade` INT NOT NULL,
  `marca` VARCHAR(45) NULL,
  `modelo` VARCHAR(45) NOT NULL,
  `Campeonato_idCampeonato` INT NOT NULL,
  `Circuito_idCircuito` INT NOT NULL,  
  PRIMARY KEY (`idCarro`),
  INDEX `fk_Carro_Campeonato1_idx` (`Campeonato_idCampeonato` ASC) VISIBLE,
  CONSTRAINT `fk_Carro_Campeonato1`
    FOREIGN KEY (`Campeonato_idCampeonato`)
    REFERENCES `DSS_Project`.`Campeonato` (`idCampeonato`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Carro_Circuito1`
    FOREIGN KEY (`Circuito_idCircuito`)
    REFERENCES `DSS_Project`.`Circuito` (`idCircuito`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DSS_Project`.`Piloto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DSS_Project`.`Piloto` (
  `idPiloto` INT NOT NULL, 
  `nome` VARCHAR(45) NOT NULL,
  `SVA` FLOAT(24) NOT NULL,
  `CTS` FLOAT(24) NOT NULL,
  `Carro_idCarro` INT NOT NULL, 
  PRIMARY KEY (`idPiloto`),
  INDEX `fk_Piloto_Carro1_idx` (`Carro_idCarro` ASC) VISIBLE,
  CONSTRAINT `fk_Piloto_Carro1`
    FOREIGN KEY (`Carro_idCarro`)
    REFERENCES `DSS_Project`.`Carro` (`idCarro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `DSS_Project`.`Circuito`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DSS_Project`.`Circuito` (
  `idCircuito` INT NOT NULL,
  `numVoltas` INT NOT NULL,
  `distancia` INT NOT NULL,
  `curva` INT NOT NULL,
  `chicane` INT NOT NULL,
  `reta` INT NOT NULL,
  'Campeonato_idCampeonato' INT NOT NULL,  
  PRIMARY KEY (`idCircuito`),
  INDEX `fk_Circuito_Campeonato1_idx` (`Campeonato_idCampeonato` ASC) VISIBLE,
  CONSTRAINT `fk_Carro_Campeonato1`
    FOREIGN KEY (`Campeonato_idCampeonato`)
    REFERENCES `DSS_Project`.`Campeonato` (`idCampeonato`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `DSS_Project`.`Utilizador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DSS_Project`,`Utilizador` ( 
  `idUtilizador` INT NOT NULL,
  `Nome` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  `Premium` BOOLEAN NOT NULL,
  PRIMARY KEY ('idUtilizador'),
  INDEX `fk_Utilizador_Campeonato1_idx` (`Campeonato_idCampeonato` ASC) VISIBLE,
  CONSTRAINT `fk_Utilizador_Campeonato1`
    FOREIGN KEY (`Campeonato_idCampeonato`)
    REFERENCES `DSS_Project`.`Campeonato` (`idCampeonato`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
  
SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
