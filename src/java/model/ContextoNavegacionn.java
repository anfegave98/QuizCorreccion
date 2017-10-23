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
public class ContextoNavegacionn {
    private int id_contexto;
    private String link;
    private int id_modeloNaveg;

    public ContextoNavegacionn(String link, int id_modeloNaveg) {
        this.link = link;
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

    public int getId_modeloNaveg() {
        return id_modeloNaveg;
    }

    public void setId_modeloNaveg(int id_modeloNaveg) {
        this.id_modeloNaveg = id_modeloNaveg;
    }
    
}
