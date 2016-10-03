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

CREATE TABLE `tplabo_2016`.`mozo` (
    `idMozo` INT NOT NULL AUTO_INCREMENT,
    `nombre` VARCHAR(45) NULL,
     PRIMARY KEY (`idMozo`)
);

CREATE TABLE `tplabo_2016`.`mesa` (
    `idMesa` INT NOT NULL AUTO_INCREMENT,
    `numero` INT NOT NULL,
    `capacidad` INT NOT NULL,
    `piso` INT NOT NULL,
    `sector` VARCHAR (45) NOT NULL,
    `estado` INT NULL,
    PRIMARY KEY (`idMesa`)
);

/*tabla intermedia menu*/

CREATE TABLE `tplabo_2016`.`platos` (
	idPlato INT NOT NULL AUTO_INCREMENT,
	nombrePlato VARCHAR(45)NOT NULL,
	precioPlato DECIMAL NOT NULL,
	tipoPlato VARCHAR(45) NOT NULL,
	PRIMARY KEY (idPlato)
	
);

CREATE TABLE `tplabo_2016`.`bebidas` (
	idBebida INT NOT NULL AUTO_INCREMENT,
	nombreBebida VARCHAR (45) NOT NULL,
	precioBebida DECIMAL NOT NULL,
	tipoBebida VARCHAR(45) NOT NULL,
	PRIMARY KEY (idBebida)
);

CREATE TABLE `tplabo_2016`.`menu` (
	idMenu INT NOT NULL AUTO_INCREMENT,
	nombreMenu VARCHAR(45) NOT NULL,
	precioMenu DECIMAL NOT NULL,
	PRIMARY KEY (idMenu)
);

CREATE TABLE `tplabo_2016`.`menus_bebidas`(
	idMenu INT NOT NULL,
	idBebida INT NOT NULL,
	FOREIGN KEY (idMenu) REFERENCES `tplabo_2016`.`menu` (idMenu),
	FOREIGN KEY (idBebida) REFERENCES `tplabo_2016`.`bebidas` (idBebida)
);

CREATE TABLE `tplabo_2016`.`menus_platos`(
	idMenu INT NOT NULL,
	idPlato INT NOT NULL,
	FOREIGN KEY (idMenu) REFERENCES `tplabo_2016`.`menu` (idMenu),
	FOREIGN KEY (idPlato) REFERENCES `tplabo_2016`.`platos` (idPlato)
);

/*tabla intermedia pedido*/

CREATE TABLE `tplabo_2016`.`pedidos`(
	idPedido INT NOT NULL AUTO_INCREMENT,
	idEstado INT (10),
	fecha DATE,
	PRIMARY KEY (idPedido),
	FOREIGN KEY (idEstado) REFERENCES `tplabo_2016`.`estados` (idEstados)
);

CREATE TABLE `tplabo_2016`.`pedido_plato`(
	idPedido INT NOT NULL,
	idPlato INT NOT NULL,
	FOREIGN KEY (idPedido) REFERENCES `tplabo_2016`.`pedidos` (idPedido),
	FOREIGN KEY (idPlato) REFERENCES `tplabo_2016`.`platos` (idPlato)
 );

CREATE TABLE `tplabo_2016`.`pedido_bebida`(
	idPedido INT NOT NULL,
	idBebida INT NOT NULL,
	FOREIGN KEY (idPedido) REFERENCES `tplabo_2016`.`pedidos` (idPedido),
	FOREIGN KEY (idBebida) REFERENCES `tplabo_2016`.`bebidas` (idBebida)
);

CREATE TABLE `tplabo_2016`.`pedido_menu`(
	idPedido INT NOT NULL,
	idMenu INT NOT NULL,
	FOREIGN KEY (idPedido) REFERENCES `tplabo_2016`.`pedidos` (idPedido),
	FOREIGN KEY (idMenu) REFERENCES `tplabo_2016`.`menu` (idMenu)
);

CREATE TABLE `tplabo_2016`.`pedido_mesa`(
	idPedido INT NOT NULL,
	idMesa INT NOT NULL,
	FOREIGN KEY (idPedido) REFERENCES `tplabo_2016`.`pedidos` (idPedido),
	FOREIGN KEY (idMesa) REFERENCES `tplabo_2016`.`mesa` (idMesa)
);

CREATE TABLE `tplabo_2016`.`pedido_mozo`(
	idPedido INT NOT NULL,
	idMozo INT NOT NULL,
	FOREIGN KEY (idPedido) REFERENCES `tplabo_2016`.`pedidos` (idPedido),
	FOREIGN KEY (idMozo) REFERENCES `tplabo_2016`.`mozo` (idMozo)
);

