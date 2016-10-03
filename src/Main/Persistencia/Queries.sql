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

/*ENTRADA*/

CREATE TABLE `tplabo_2016`.`entrada` (
	`idEntrada` INT NOT NULL AUTO_INCREMENT,
	`nombre` VARCHAR (45) NOT NULL,
	`precio` DECIMAL NOT NULL,
	PRIMARY KEY(`idEntrada`)
);

/*PRINCIPAL*/

CREATE TABLE `tplabo_2016`.`principal` (
	`idPrincipal` INT NOT NULL AUTO_INCREMENT,
	`nombre` VARCHAR (45) NOT NULL,
	`precio` DECIMAL NOT NULL,
	PRIMARY KEY(`idPrincipal`)
);

/*POSTRE*/

CREATE TABLE `tplabo_2016`.`postre` (
	`idPostre` INT NOT NULL AUTO_INCREMENT,
	`nombre` VARCHAR (45) NOT NULL,
	`precio` DECIMAL NOT NULL,
	PRIMARY KEY(`idPostre`)
);

/*CONALCOHOL*/

CREATE TABLE `tplabo_2016`.`conAlcohol` (
	`idConAlcohol` INT NOT NULL AUTO_INCREMENT,
	`nombre` VARCHAR (45) NOT NULL,
	`precio` DECIMAL NOT NULL,
	PRIMARY KEY(`idConAlcohol`)
);

/*SINALCOHOL*/

CREATE TABLE `tplabo_2016`.`sinAlcohol` (
	`idSinAlcohol` INT NOT NULL AUTO_INCREMENT,
	`nombre` VARCHAR (45) NOT NULL,
	`precio` DECIMAL NOT NULL,
	PRIMARY KEY(`idSinAlcohol`)
);

/*CAFE*/

CREATE TABLE `tplabo_2016`.`cafe` (
	`idCafe` INT NOT NULL AUTO_INCREMENT,
	`nombre` VARCHAR (45) NOT NULL,
	`precio` DECIMAL NOT NULL,
	PRIMARY KEY(`idCafe`)
);

/*menu (platos y bebidas) y pedido(platos bebidas y menus)*/

/*tabla intermedia menu*/

CREATE TABLE menus_platos(
	idMenu INT NOT NULL,
	idBebida INT NOT NULL,
	FOREIGN KEY (idMenu) REFERENCES menu (idMenu),
	FOREIGN KEY (idBebida) REFERENCES bebidas (idBebida)
);

/*tabla intermedia pedido*/

CREATE TABLE pedido_plato_bebida_menu(
	idPedido INT NOT NULL,
	idPlato INT NOT NULL,
	idBebida INT NOT NULL,
	idMenu INT NOT NULL,
	FOREIGN KEY (idPedido) REFERENCES pedidos (idPedido),
	FOREIGN KEY (idPlato) REFERENCES platos (idPlato),
	FOREIGN KEY (idBebida) REFERENCES bebidas (idBebida),
	FOREIGN KEY (idMenu) REFERENCES menus (idMenu)
);

CREATE TABLE pedidos(
	idPedido INT NOT NULL AUTO_INCREMENT,
	idPlato INT(10),
	idBebida INT(10),
	idEmpleado INT(10),
	idMesa INT (10),
	idEstado INT (10),
	idMenu INT(10),
	fecha DATE,
	PRIMARY KEY (idPedido),
	FOREIGN KEY (idPlato) REFERENCES platos (idPlato),
	FOREIGN KEY (idBebida) REFERENCES bebidas (idBebida),
	FOREIGN KEY (idEmpleado) REFERENCES empleado (idEmpleado),
	FOREIGN KEY (idMesa) REFERENCES mesas (idMesa),
	FOREIGN KEY (idEstado) REFERENCES estados (idEstados),
	FOREIGN KEY (idMenu) REFERENCES menu (idMenu)
);

CREATE TABLE platos (
	idPlato INT NOT NULL AUTO_INCREMENT,
	nombrePlato VARCHAR(45)NOT NULL,
	precioPlato DECIMAL NOT NULL,
	tipoPlato VARCHAR(45) NOT NULL,
	PRIMARY KEY (idPlato)
	
);

CREATE TABLE bebidas (
	idBebida INT NOT NULL AUTO_INCREMENT,
	nombreBebida VARCHAR (45) NOT NULL,
	precioBebida DECIMAL NOT NULL,
	tipoBebida VARCHAR(45) NOT NULL,
	PRIMARY KEY (idBebida)
);


CREATE TABLE menu (
	idMenu INT NOT NULL AUTO_INCREMENT,
	idPlato INT (10),
	idBebida INT(10),
	nombreMenu VARCHAR(45) NOT NULL,
	precioMenu DECIMAL NOT NULL,
	PRIMARY KEY (idMenu),
	FOREIGN KEY (idPlato) REFERENCES platos (idPlato),
	FOREIGN KEY (idBebida) REFERENCES bebidas (idBebida)
);



/*MESA */ 

CREATE TABLE `tplabo_2016`.`mesa` (
    `idMesa` INT NOT NULL AUTO_INCREMENT,
    `numero` INT NOT NULL,
    `capacidad` INT NOT NULL,
    `piso` INT NOT NULL,
    `sector` VARCHAR (45) NOT NULL,
    `estado` INT NULL,
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

  ALTER TABLE `tplabo_2016`.`domicilio` 
DROP COLUMN `NroDpto`;

ALTER TABLE `tplabo_2016`.`localidad` 
ADD COLUMN `CodigoPostal` INT NULL AFTER `Descripcion`;

