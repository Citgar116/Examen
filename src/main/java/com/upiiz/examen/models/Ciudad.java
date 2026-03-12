package com.upiiz.examen.models;

public class Ciudad {

    private int id;
    private String nombre;
    private String pais;
    private int poblacion;

    public Ciudad() {}

    public Ciudad(int id, String nombre, String pais, int poblacion) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
        this.poblacion = poblacion;
    }

    public int getId() {return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }
    public int getPoblacion() { return poblacion; }
    public void setPoblacion(int poblacion) { this.poblacion = poblacion; }
}


