package mx.maxitoners.datos;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import mx.maxitoners.negocio.Categoria;
import mx.maxitoners.negocio.Producto;

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

        //Predefinir datos de prueba
        try {
            crearTabla();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, "Error al leer base de datos", ex);
            JOptionPane.showMessageDialog(null, "Hubo un error al leer la base de datos.", "Error", JOptionPane.ERROR);
            System.exit(0);
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

    public void crearTabla() throws SQLException {

        //Crear tabla si no existe
        try (Statement statement = getConnection().createStatement()) {
            statement.executeUpdate(""
                    + "CREATE TABLE IF NOT EXISTS productos("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "nombre TEXT,"
                    + "cantidad INT,"
                    + "precio DOUBLE,"
                    + "categoria INT"
                    + ")"
            );
        }

        //Insertar datos si la tabla esta vacia
        try (Statement statement = getConnection().createStatement()) {
            try (ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM productos;")) {
                if (rs.next()) {
                    if (rs.getInt(1) == 0) {
                        statement.executeUpdate(""
                                + "INSERT INTO productos VALUES "
                                + "(NULL, '** DATOS DE PRUEBA **', 1, 100, 1),"
                                + "(NULL, 'Tinta HP Colores', 100, 100, 1),"
                                + "(NULL, 'Toner HP tinta negra', 400, 14, 2),"
                                + "(NULL, 'Pieza Scanner HP', 250, 5, 3)"
                        );
                    }
                }
            }
        }
    }

    public ArrayList<Producto> cargarTodos() {
        ArrayList<Producto> productosCargados = new ArrayList<>();

        try (Statement statement = getConnection().createStatement()) {
            try (ResultSet rs = statement.executeQuery("SELECT * FROM productoS;")) {
                while (rs.next()) {
                    Producto p = new Producto();
                    p.setId(rs.getInt(1));
                    p.setNombre(rs.getString(2));
                    p.setCantidad(rs.getInt(3));
                    p.setPrecio(rs.getDouble(4));

                    Categoria cat = Categoria.getCategoria(rs.getInt(5));
                    if (cat == null) {
                        System.out.println(String.format("Error al cargar producto #%s '%s', enumerador no encontrado", p.getId(), p.getNombre()));
                        continue;
                    }
                    p.setCategoria(cat);
                    productosCargados.add(p);
                }
                return productosCargados;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
