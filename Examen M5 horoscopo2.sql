use horoscopo;

# CREA Tablas ---------------------------------------
CREATE TABLE IF NOT EXISTS `HOROSCOPO`(

  `ANIMAL` 				VARCHAR(30) NOT NULL,
  `FECHA_INICIO` 		DATE,
  `FECHA_FIN`			DATE
  

  );
  

CREATE TABLE USUARIOS(
ID					INT,
NOMBRE 				VARCHAR(30 ),
USERNAME 			VARCHAR(30 ),
EMAIL 				VARCHAR(30 ),
FECHA_NACIMIENTO 	DATE,
PASSWORDD 			VARCHAR(30 ),
ANIMAL 				VARCHAR(30 )

);

-- Insertar datos en la tabla usuario
INSERT INTO usuarios (ID, NOMBRE, USERNAME, EMAIL, FECHA_NACIMIENTO , PASSWORDD , ANIMAL ) 
VALUES 


(1 , 'Juan1', 'JuanUSERNAME1' , 'juan1@example.com',  '2024-04-01' , 'contraseña1231', 'Perro'),
(2 , 'Juan2', 'JuanUSERNAME2' , 'juan2@example.com',  '2024-04-02' , 'contraseña1232', 'Perro'),
(3 , 'Juan3', 'JuanUSERNAME3' , 'juan1@example.com',  '2024-04-01' , 'contraseña1231', 'Perro');

# Modificar datos en las tablas -----------------------------
-- Modificar el nombre del segundo Proveedor
use horoscopo;
		UPDATE usuarios u
			SET u.PASSWORDD = '12345' 
			WHERE u.id = 3;


# Instrucciones SQL ---------------------------------------------

-- Listar los usuarios busqueda por username y password
	select *
	From  usuarios u
	where u.USERNAME  = 'JuanUSERNAME1' and u.PASSWORDD =  '123' ;

SELECT * FROM usuarios;
SELECT * FROM Usuario WHERE Id = 1;
