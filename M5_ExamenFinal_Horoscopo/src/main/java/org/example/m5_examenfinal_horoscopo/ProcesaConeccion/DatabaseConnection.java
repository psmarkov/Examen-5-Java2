package org.example.m5_examenfinal_horoscopo.ProcesaConeccion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // ATRIBUTOS CON CREDENCIALES DE CONEXION A LA BD POSTGRES
    private static final String DB_URL = "jdbc:mysql://localhost:3306/horoscopo";
    private static final String DB_USER = "paula";
    private static final String DB_PASSWORD = "123";

    // VARIABLES NECESARIAS PARA MANEJAR LAS INSTANCIAS DE CONEXION
    private static DatabaseConnection instance; // INSTANCIA PROPIA DE LA CLASE
    private Connection connection; // INSTANCIA DE CONEXION

    // CONSTRUCTOR PRIVADO PARA GESTIONAR LAS INSTANCIAS
    private DatabaseConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Driver de MySQL


        } catch (ClassNotFoundException e) {
            throw new RuntimeException("No se pudo cargar el driver de la base de datos ", e);

        }
    }

    // METODO QUE CONSUME AL CONSTRUCTOR
    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    // METODO QUE DEVUELVE LA INSTANCIA DE CONEXION
    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
        }
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}