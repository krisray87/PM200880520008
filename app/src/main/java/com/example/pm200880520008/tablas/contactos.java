package com.example.pm200880520008.tablas;

public class contactos {
    public Integer id;
    public String pais;
    public String nombre;
    public String telefono;
    public String nota;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public contactos(){

    }

    public contactos(Integer id,String pais, String nombre, String telefono, String nota) {
        this.id = id;
        this.pais = pais;
        this.nombre = nombre;
        this.telefono = telefono;
        this.nota = nota;
    }

    public String getPais() {
        return pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
