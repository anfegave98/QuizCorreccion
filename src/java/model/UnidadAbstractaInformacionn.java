/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author LabingXEON
 */
public class UnidadAbstractaInformacionn {
    
    private int id_unidadabs;
    private int id_contexto;
    private int id_tabla;

    public UnidadAbstractaInformacionn(int id_contexto, int id_tabla) {
        this.id_contexto = id_contexto;
        this.id_tabla = id_tabla;
    }

    public int getId_unidadabs() {
        return id_unidadabs;
    }

    public void setId_unidadabs(int id_unidadabs) {
        this.id_unidadabs = id_unidadabs;
    }

    public int getId_contexto() {
        return id_contexto;
    }

    public void setId_contexto(int id_contexto) {
        this.id_contexto = id_contexto;
    }

    public int getId_tabla() {
        return id_tabla;
    }

    public void setId_tabla(int id_tabla) {
        this.id_tabla = id_tabla;
    }
    
    
}
