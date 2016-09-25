CREATE SCHEMA `tplabo_2016` ;

/*Creo tabla*/ 

/*ESTADOS */ 

CREATE TABLE `tplabo_2016`.`estados` (
    `idEstados` INT NOT NULL AUTO_INCREMENT,
    `Descripcion` VARCHAR(45) NULL,
    `esMesa` BIT NOT NULL,
    `esMozo` BIT NOT NULL,
    `esPedido` BIT NOT NULL,
    PRIMARY KEY (`idEstados`)
);

/*CONTACTO */ 

CREATE TABLE `tplabo_2016`.`contacto` (
    `idcontacto` INT NOT NULL AUTO_INCREMENT,
    `TipoContacto` VARCHAR(45) NOT NULL,
    `DirEMail` VARCHAR(45) NULL,
    `NroTelefonoLinea` INT(64) NOT NULL,
    `NroTelefonoCelular` INT(64) NULL,
    PRIMARY KEY (`idcontacto`)
);
 
 /*LOCALIDAD */ 
 
CREATE TABLE `tplabo_2016`.`localidad` (
    `idlocalidad` INT NOT NULL AUTO_INCREMENT,
    `Descripcion` VARCHAR(45) NULL,
    PRIMARY KEY (`idlocalidad`)
);

/*DOMICILIO */ 

CREATE TABLE `tplabo_2016`.`domicilio` (
    `idDomicilio` INT NOT NULL AUTO_INCREMENT,
    `idLocalidad` INT NOT NULL,
    `Calle` VARCHAR(45) NULL,
    `NroDireccion` INT NULL,
    `NroPiso` INT NULL,
    `NroDpto` VARCHAR(10) NULL,
    `CodigoPostal` INT NULL,
    PRIMARY KEY (`idDomicilio`),
    INDEX `idLocalidad_idx` (`idLocalidad` ASC),
    CONSTRAINT `idLocalidad` FOREIGN KEY (`idLocalidad`)
        REFERENCES `tplabo_2016`.`localidad` (`idlocalidad`)
        ON DELETE NO ACTION ON UPDATE NO ACTION
);
          
/*EMPLEADO */ 

CREATE TABLE `tplabo_2016`.`empleado` (
    `idEmpleado` INT NOT NULL AUTO_INCREMENT,
    `Nombre` VARCHAR(45) NULL,
    `Apellido` VARCHAR(45) NULL,
    `DNI` INT(64) NOT NULL,
    `idContacto` INT NOT NULL,
    `idDomicilio` INT NOT NULL,
    `idEstado` INT NULL,
    `esMozo` BIT NULL,
    `esEncargado` BIT NULL,
    PRIMARY KEY (`idEmpleado`),
    INDEX `idDomicilio_idx` (`idDomicilio` ASC),
    INDEX `idContacto_idx` (`idContacto` ASC),
    INDEX `idEstado_idx` (`idEstado` ASC),
    CONSTRAINT `idDomicilio` FOREIGN KEY (`idDomicilio`)
        REFERENCES `tplabo_2016`.`domicilio` (`idDomicilio`)
        ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `idContacto` FOREIGN KEY (`idContacto`)
        REFERENCES `tplabo_2016`.`contacto` (`idcontacto`)
        ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `idEstado` FOREIGN KEY (`idEstado`)
        REFERENCES `tplabo_2016`.`estados` (`idEstados`)
        ON DELETE NO ACTION ON UPDATE NO ACTION
);

/*MESA */ 

CREATE TABLE `tplabo_2016`.`mesa` (
    `idMesa` INT NOT NULL AUTO_INCREMENT,
    `capasidad` INT NOT NULL,
    `posicionX` FLOAT NULL,
    `posicionY` FLOAT NULL,
    `idMozo` INT NULL,
    `idEstado` INT NULL,
    PRIMARY KEY (`idMesa`)
);
    ALTER TABLE `tplabo_2016`.`mesa` 
    ADD INDEX `idEmpleado_idx` (`idMozo` ASC);
    ALTER TABLE `tplabo_2016`.`mesa` 
    ADD CONSTRAINT `idEmpleado`
      FOREIGN KEY (`idMozo`)
      REFERENCES `tplabo_2016`.`empleado` (`idEmpleado`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;
      ALTER TABLE `tplabo_2016`.`mesa` 
      CHANGE COLUMN `idEstado` `idEstados` INT(11) NULL DEFAULT NULL ;
      ALTER TABLE `tplabo_2016`.`mesa` 
ADD CONSTRAINT `idEstados`
  FOREIGN KEY (`idEstados`)
  REFERENCES `tplabo_2016`.`estados` (`idEstados`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

