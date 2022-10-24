package com.example.pm200880520008.tablas;

public class transacciones {
    public static final String nameDatabase = "dbex01";

    public static final String Tcontactos = "contactos";

    public static final String id = "id";
    public static final String pais = "pais";
    public static final String nombre = "nombre";
    public static final String telefono = "telefono";
    public static final String nota = "nota";
    public static final String rfoto = "rfoto";

    public static final String cTcontactos = "CREATE TABLE contactos(id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "pais TEXT,nombre TEXT,telefono TEXT, nota TEXT)";

    public static final String droptcontactos = "DROP TABLE IF EXIST contactos";
    public static final String getContactos = "SELECT * FROM "+transacciones.Tcontactos


            ;

}
