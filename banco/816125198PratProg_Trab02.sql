-- a. Crie uma tabela Pais com os atributos id (int autoincrement) , nome(varchar 100),
-- populacao (bigint) e area (number 15,2). Carregue alguns países. Consulte a Wikipedia para
-- obter as informações de população e área. 

CREATE DATABASE 81727834PratProg_Trab02; DROP DATABASE 81727834PratProg_Trab02;

USE 81727834PratProg_Trab02;

CREATE TABLE IF NOT EXISTS Pais (
   id 			INT		(11)     UNSIGNED NOT NULL AUTO_INCREMENT,
   nome 		VARCHAR (100)    NOT NULL,
   populacao 	BIGINT	         NULL DEFAULT NULL,
   area 		INT	    (15.2) 	 NOT NULL,
  PRIMARY KEY (id));

DESCRIBE Pais;

INSERT INTO Pais VALUES (1, China,          '1.372.470.000', 9.596961);
INSERT INTO Pais VALUES (2, India,          '1.278.160.000', 3.287590);
INSERT INTO Pais VALUES (3, Estados_Unidos, '321.968.000',	 9.371174);
INSERT INTO Pais VALUES (4, Paquistão, 	    '209.156.000', 	 880.254);
INSERT INTO Pais VALUES (5, Brasil,         '207.660.929', 	 8.515767);

USE Pais;

SET SQL_MODE=@OLD_SQL_MODE;
