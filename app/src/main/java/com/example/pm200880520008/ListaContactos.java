package com.example.pm200880520008;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.pm200880520008.configuracion.SQLiteConexion;
import com.example.pm200880520008.tablas.contactos;
import com.example.pm200880520008.tablas.transacciones;

import java.util.ArrayList;

public class ListaContactos extends AppCompatActivity {

    SQLiteConexion conexion;
    ListView listacontact;
    ArrayList <contactos> lista;
    ArrayList <String> listacon;
    Button atras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_contactos);
    conexion = new SQLiteConexion(this, transacciones.nameDatabase,null,1);
        atras = (Button) findViewById(R.id.btnAtras);
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        listacontact = (ListView) findViewById(R.id.listacontact);

    Getcontactos();
        ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listacon);
        listacontact.setAdapter(adp);


    }



    private void Getcontactos() {
        SQLiteDatabase db = conexion.getReadableDatabase();

        contactos listacontactos = null;

        lista = new ArrayList<contactos>();

        Cursor cursor = db.rawQuery(transacciones.getContactos,null);
        while (cursor.moveToNext()){
            listacontactos = new contactos();
            listacontactos.setId(cursor.getInt(0));
            listacontactos.setPais(cursor.getString(1));
            listacontactos.setNombre(cursor.getString(2));
            listacontactos.setTelefono(cursor.getString(3));
            listacontactos.setNota(cursor.getString(4));

            lista.add(listacontactos);

        }
        cursor.close();

        llenarlista();
    }

    private void llenarlista() {
        listacon = new ArrayList<String>();
        for (int i=0;i<lista.size();i++){
            listacon.add(lista.get(i).getNombre()+"        "+lista.get(i).getTelefono());
        }
    }
}