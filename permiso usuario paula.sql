SELECT * FROM usuarios;

-- Crear un nuevo usuario con una contraseña segura
CREATE USER 'paula'@'localhost' IDENTIFIED BY '123';

-- Otorgar todos los privilegios a la base de datos 'horoscopo'
GRANT ALL PRIVILEGES ON horoscopo.* TO 'paula'@'localhost';

-- Refrescar los privilegios para que los cambios surtan efecto
FLUSH PRIVILEGES;

GRANT ALL PRIVILEGES ON horoscopo.* TO 'paula'@'localhost';

