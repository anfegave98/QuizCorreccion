/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.UnidadAbstractaInformacion;
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

    public boolean addUnidadAbs(UnidadAbstractaInformacion unidad) throws SQLException {
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
}
