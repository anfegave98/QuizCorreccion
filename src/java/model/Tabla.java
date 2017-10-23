package model;

public class Tabla {

    private int id_tabla;
    private String nombre_tabla;
    private int id_esquema;
    private int id_unidad; 
    private String nombre_columna;
    

    public Tabla(String nombre_tabla, int id_esquema) {
        this.nombre_tabla = nombre_tabla;
        this.id_esquema = id_esquema;
    }

    public Tabla(int id_tabla, String nombre_tabla,String nombre_columna) {
        this.id_tabla = id_tabla;
        this.nombre_tabla = nombre_tabla;
        this.nombre_columna = nombre_columna;
    }

    public int getId_unidad() {
        return id_unidad;
    }

    public void setId_unidad(int id_unidad) {
        this.id_unidad = id_unidad;
    }

    public String getNombre_columna() {
        return nombre_columna;
    }

    public void setNombre_columna(String nombre_columna) {
        this.nombre_columna = nombre_columna;
    }
    
    
    public int getId_tabla() {
        return id_tabla;
    }

    public void setId_tabla(int id_tabla) {
        this.id_tabla = id_tabla;
    }

    public String getNombre_tabla() {
        return nombre_tabla;
    }

    public void setNombre_tabla(String nombre_tabla) {
        this.nombre_tabla = nombre_tabla;
    }

    public int getId_esquema() {
        return id_esquema;
    }

    public void setId_esquema(int id_esquema) {
        this.id_esquema = id_esquema;
    }

    @Override
    public String toString() {
        return "Tabla{" + "id_tabla=" + id_tabla + ", nombre_tabla=" + nombre_tabla + ", id_esquema=" + id_esquema + '}';
    }

}
