package mx.maxitoners;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.maxitoners.datos.Conexion;

public class Main {

    public static void main(String[] args) {
        Conexion con = new Conexion();
        try {
            con.prueba();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
