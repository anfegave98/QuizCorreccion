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
import model.ModeloNavegacionn;
import model.Tabla;
import util.DbUtil;

/**
 *
 * @author anfeg
 */
public class ModeloNavegacionDAO {
     private Connection connection;
    
    public ModeloNavegacionDAO() throws SQLException {
        connection = DbUtil.getConnection();
    }

    public boolean addModelo(ModeloNavegacionn modelo) throws SQLException {
          boolean result = false;
        Connection connection = DbUtil.getConnection();
        String query = "insert into modelonavegacion (modelonavegacion.nombre) values (?);";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, modelo.getNombre_modelo());
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
     public List<ModeloNavegacionn> getAllModelos() throws SQLException {
      List<ModeloNavegacionn> modelo = null;
      boolean result = false;
        String query = "SELECT * FROM modelonavegacion";
        Connection connection = DbUtil.getConnection();
        try {
            
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
           
            int id =0;
            String nombre = null;
     

            while (rs.next()) {
                if (modelo == null) {
                    modelo = new ArrayList<ModeloNavegacionn>();
                }
                ModeloNavegacionn registro = new ModeloNavegacionn(nombre);
                id = rs.getInt("id");
                registro.setId(id);

                nombre = rs.getString("nombre");
                registro.setNombre_modelo(nombre);
               
                modelo.add(registro);

            }
             if(modelo!=null)
            for (int i = 0; i < modelo.size(); i++) {
                System.out.println(modelo.get(i).getId()+ " " + modelo.get(i).getNombre_modelo());
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Modelos");
            e.printStackTrace();
        }

        return modelo;
    
    }
}
