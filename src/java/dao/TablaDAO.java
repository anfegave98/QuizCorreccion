package dao;

import model.Tabla;
import util.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TablaDAO {

    private Connection connection;

    public TablaDAO() throws SQLException {
        connection = DbUtil.getConnection();
    }

    public boolean addTabla(Tabla tabla) throws SQLException {
        boolean result = false;
        Connection connection = DbUtil.getConnection();
        String query = "insert into tabla (tabla.nombre_tabla,tabla.id_esquema) values (?, ? );";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, tabla.getNombre_tabla());
            preparedStmt.setInt(2, tabla.getId_esquema());
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean deleteTabla(int a) throws SQLException {
        boolean result = false;
        Connection connection = DbUtil.getConnection();
        String query = "delete from tabla where id_tabla = ?";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, a);
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public boolean updateTabla(int a, String nombreNuevo) throws SQLException {
        boolean result = false;
        Connection connection = DbUtil.getConnection();
        String query = "update tabla set nombre_tabla = ? where id_tabla = ?";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, nombreNuevo);
            preparedStmt.setInt(2, a);
            if (preparedStmt.executeUpdate() > 0) {
                result = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<Tabla> getAllTables() throws SQLException {
        List<Tabla> tabla = null;
        boolean result = false;
        String query = "SELECT * FROM tabla";
        Connection connection = DbUtil.getConnection();
        try {

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            int id = 0;
            String nombre = null;
            int id_esquema = 0;

            while (rs.next()) {
                if (tabla == null) {
                    tabla = new ArrayList<Tabla>();
                }
                Tabla registro = new Tabla(nombre, id_esquema);
                id = rs.getInt("id_tabla");
                registro.setId_tabla(id);

                nombre = rs.getString("nombre_tabla");
                registro.setNombre_tabla(nombre);

                id_esquema = rs.getInt("id_esquema");
                registro.setId_esquema(id_esquema);

                tabla.add(registro);

            }
            if (tabla != null) {
                for (int i = 0; i < tabla.size(); i++) {
                    System.out.println(tabla.get(i).getId_tabla() + " " + tabla.get(i).getNombre_tabla() + " " + tabla.get(i).getId_esquema());
                }
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Tablas");
            e.printStackTrace();
        }

        return tabla;

    }

    public List<Tabla> getAllTablesId(int a) throws SQLException {
        List<Tabla> tabla = null;
        boolean result = false;
        String query = "select tabla.id_tabla,tabla.nombre_tabla,columna.nombre_columna from tabla,columna where columna.id_tabla=tabla.id_tabla and tabla.id_tabla="+a;
        Connection connection = DbUtil.getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            int id_tabla = 0;
            String nombre_tabla = null;
            String nombre_columna = null;

            while (rs.next()) {
                if (tabla == null) {
                    tabla = new ArrayList<Tabla>();
                }
                Tabla registro = new Tabla(id_tabla, nombre_tabla, nombre_columna);
                id_tabla = rs.getInt("id_tabla");
                registro.setId_tabla(id_tabla);

                nombre_tabla = rs.getString("nombre_tabla");
                registro.setNombre_tabla(nombre_tabla);

                nombre_columna = rs.getString("nombre_columna");
                registro.setNombre_columna(nombre_columna);

                tabla.add(registro);

            }
            if (tabla != null) {
                for (int i = 0; i < tabla.size(); i++) {
                    System.out.println(tabla.get(i).getId_tabla() + " " + tabla.get(i).getNombre_tabla() + " " + tabla.get(i).getNombre_columna());
                }
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Tablas");
            e.printStackTrace();
        }

        return tabla;

    }

}
