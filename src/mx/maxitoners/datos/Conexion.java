package mx.maxitoners.datos;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private Connection conexion = null;

    public Conexion() {

        //Crear y leer base de datos
        File archivo = null;
        try {
            archivo = new File("database.db");
            System.out.println(archivo.getAbsolutePath());
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        //Abrir conexion de base de datos
        try {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:" + archivo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return conexion;
    }

    public void closeConnection() {
        try {
            if (conexion != null) {
                conexion.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Prueba de base de datos
    public void prueba() throws SQLException {
        try (Statement statement = getConnection().createStatement()) {
            statement.executeUpdate(""
                    + "CREATE TABLE IF NOT EXISTS prueba("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT)"
            );
            statement.executeUpdate(""
                    + "INSERT INTO prueba VALUES (NULL),(NULL),(NULL)"
            );
        }
        try (Statement statement = getConnection().createStatement()) {
            try(ResultSet rs = statement.executeQuery("SELECT * FROM prueba;")){
                while(rs.next()){
                    System.out.println(rs.getInt(1));
                }
            }
        }
    }

}
