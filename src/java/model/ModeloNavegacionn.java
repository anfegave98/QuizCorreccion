/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author anfeg
 */
public class ModeloNavegacionn {
     private int id;
     private String nombre_modelo;

    public ModeloNavegacionn(String nombre_modelo) {
        this.nombre_modelo = nombre_modelo;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_modelo() {
        return nombre_modelo;
    }

    public void setNombre_modelo(String nombre_modelo) {
        this.nombre_modelo = nombre_modelo;
    }
     
}
