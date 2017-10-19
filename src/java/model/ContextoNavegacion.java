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
public class ContextoNavegacion {
    private int id_contexto;
    private String link;
    private int id_unidadAbs;
    private int id_modeloNaveg;

    public ContextoNavegacion(String link, int id_unidadAbs, int id_modeloNaveg) {
        this.link = link;
        this.id_unidadAbs = id_unidadAbs;
        this.id_modeloNaveg = id_modeloNaveg;
    }

    public int getId_contexto() {
        return id_contexto;
    }

    public void setId_contexto(int id_contexto) {
        this.id_contexto = id_contexto;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getId_unidadAbs() {
        return id_unidadAbs;
    }

    public void setId_unidadAbs(int id_unidadAbs) {
        this.id_unidadAbs = id_unidadAbs;
    }

    public int getId_modeloNaveg() {
        return id_modeloNaveg;
    }

    public void setId_modeloNaveg(int id_modeloNaveg) {
        this.id_modeloNaveg = id_modeloNaveg;
    }
    
}
