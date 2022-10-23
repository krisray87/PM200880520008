package com.example.pm200880520008;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import com.example.pm200880520008.configuracion.SQLiteConexion;
import com.example.pm200880520008.tablas.transacciones;

public class ListaContactos extends AppCompatActivity {

    SQLiteConexion conexion;
    ListView listacontact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_contactos);
    conexion = new SQLiteConexion(this, transacciones.nameDatabase,null,1);

    listacontact = (ListView) findViewById(R.id.listacontactos);
    Getcontactos();

    }

    private void Getcontactos() {
        SQLiteDatabase db = conexion.getReadableDatabase();
    }
}