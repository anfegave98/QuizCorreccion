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
import model.UnidadAbstractaInformacionn;
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

    public boolean addContexto(ContextoNavegacionn contexto) throws SQLException {
          boolean result = false;
        Connection connection = DbUtil.getConnection();
        String query = "insert into contextonavegacion (contextonavegacion.link,contextonavegacion.id_modelo) values (?, ? );";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, contexto.getLink());
            preparedStmt.setInt(2, contexto.getId_modeloNaveg());
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public List<ContextoNavegacionn> getAllContextos() throws SQLException {
      List<ContextoNavegacionn> contexto = null;
      boolean result = false;
        String query = "SELECT * FROM contextonavegacion";
        Connection connection = DbUtil.getConnection();
        try {
            
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
           
            int id =0;
            String link = null;
            int id_modelo=0;
     

            while (rs.next()) {
                if (contexto == null) {
                    contexto = new ArrayList<ContextoNavegacionn>();
                }
                ContextoNavegacionn registro = new ContextoNavegacionn(link,id_modelo);
                id = rs.getInt("id");
                registro.setId_contexto(id);

                link = rs.getString("link");
                registro.setLink(link);
                
                id_modelo = rs.getInt("id_modelo");
                registro.setId_modeloNaveg(id_modelo);
               
                contexto.add(registro);

            }
             if(contexto!=null)
            for (int i = 0; i < contexto.size(); i++) {
                System.out.println(contexto.get(i).getId_contexto()+ " " + contexto.get(i).getLink()+" "+contexto.get(i).getId_modeloNaveg());
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Contextos");
            e.printStackTrace();
        }

        return contexto;
    
    }
}
