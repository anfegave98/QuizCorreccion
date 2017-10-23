/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.ContextoNavegacionn;
import model.UnidadAbstractaInformacionn;
import util.DbUtil;

/**
 *
 * @author LabingXEON
 */
public class UnidadAbstractaInformacionDAO {

    private Connection connection;

    public UnidadAbstractaInformacionDAO() throws SQLException {
        connection = DbUtil.getConnection();
    }

    public boolean addUnidadAbs(UnidadAbstractaInformacionn unidad) throws SQLException {
        boolean result = false;
        Connection connection = DbUtil.getConnection();
        String query = "insert into unidadabstractainformacion (unidadabstractainformacion.id_contexto,unidadabstractainformacion.id_tabla) values (?, ? );";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, unidad.getId_contexto());
            preparedStmt.setInt(2, unidad.getId_tabla());
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<UnidadAbstractaInformacionn> getAllUnidades() throws SQLException {
        List<UnidadAbstractaInformacionn> unidad = null;
        boolean result = false;
        String query = "SELECT * FROM unidadabstractainformacion";
        Connection connection = DbUtil.getConnection();
        try {

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            int id = 0;
            int id_contexto = 0;
            int id_tabla = 0;

            while (rs.next()) {
                if (unidad == null) {
                    unidad = new ArrayList<UnidadAbstractaInformacionn>();
                }
                UnidadAbstractaInformacionn registro = new UnidadAbstractaInformacionn(id_contexto, id_tabla);
                id = rs.getInt("id");
                registro.setId_unidadabs(id);

                id_contexto = rs.getInt("id_contexto");
                registro.setId_contexto(id_contexto);

                id_tabla = rs.getInt("id_tabla");
                registro.setId_tabla(id_tabla);

                unidad.add(registro);

            }
            if (unidad != null) {
                for (int i = 0; i < unidad.size(); i++) {
                    System.out.println(unidad.get(i).getId_unidadabs()+ " " + unidad.get(i).getId_contexto() + " " + unidad.get(i).getId_tabla());
                }
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Unidades");
            e.printStackTrace();
        }

        return unidad;

    }
}
