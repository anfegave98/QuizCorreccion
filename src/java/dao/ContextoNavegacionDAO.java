/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.ContextoNavegacion;
import model.UnidadAbstractaInformacion;
import util.DbUtil;

/**
 *
 * @author LabingXEON
 */
public class ContextoNavegacionDAO {
    
    private Connection connection;
    
    public ContextoNavegacionDAO() throws SQLException {
        connection = DbUtil.getConnection();
    }

    public boolean addContexto(ContextoNavegacion contexto) throws SQLException {
          boolean result = false;
        Connection connection = DbUtil.getConnection();
        String query = "insert into contextonavegacion (contextonavegacion.link,contextonavegacion.id_unidadAbs,contextonavegacion.id_modeloNaveg) values (?, ?,? );";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, contexto.getLink());
            preparedStmt.setInt(2, contexto.getId_unidadAbs());
            preparedStmt.setInt(3, contexto.getId_modeloNaveg());
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
