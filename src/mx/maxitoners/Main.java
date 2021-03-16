package mx.maxitoners;

import java.sql.SQLException;
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
