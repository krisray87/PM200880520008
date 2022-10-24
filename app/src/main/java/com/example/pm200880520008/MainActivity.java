package com.example.pm200880520008;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.pm200880520008.configuracion.SQLiteConexion;
import com.example.pm200880520008.tablas.transacciones;

public class MainActivity extends AppCompatActivity {

    Spinner paises;
    EditText nombre,telefono,nota;
    Button guardar,ver;
    ImageView foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        paises = (Spinner) findViewById(R.id.sppaises);
        nombre = (EditText) findViewById(R.id.txtnombre);
        telefono = (EditText) findViewById(R.id.txttelefono);
        nota = (EditText) findViewById(R.id.txtnota);
        guardar = (Button) findViewById(R.id.btnguardar);
        ver = (Button) findViewById(R.id.btnverc);
        foto = (ImageView) findViewById(R.id.imageView2);
        String [] lpaises= {"Honduras (504)","Costa Rica","Guatemala (502)","El Salvador"};
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,lpaises);
        paises.setAdapter(adapter);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AgregarContacto();
            }
        });
        ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ListaContactos.class);
                startActivity(intent);
            }
        });
    }

    private void AgregarContacto() {
        SQLiteConexion conexion = new SQLiteConexion(this, transacciones.nameDatabase,null,1);
        SQLiteDatabase db = conexion.getWritableDatabase();
    if (nombre.getText().toString().isEmpty()){
        AlertDialog.Builder alerta1 = new AlertDialog.Builder(this);
        alerta1.setMessage("Debe escribir un nombre");
        AlertDialog titulo = alerta1.create();
        titulo.setTitle("Error");
        titulo.show();

    }else if (telefono.getText().toString().isEmpty()){
        AlertDialog.Builder alerta2 = new AlertDialog.Builder(this);
        alerta2.setMessage("Debe escribir un telefono");
        AlertDialog titulo = alerta2.create();
        titulo.setTitle("Error");
        titulo.show();

    }else if (nota.getText().toString().isEmpty()){
        AlertDialog.Builder alerta3 = new AlertDialog.Builder(this);
        alerta3.setMessage("Debe escribir una nota");
        AlertDialog titulo = alerta3.create();
        titulo.setTitle("Error");
        titulo.show();

    }else{
        ContentValues valores = new ContentValues();
        valores.put(transacciones.pais, paises.getSelectedItem().toString());
        valores.put(transacciones.nombre, nombre.getText().toString());
        valores.put(transacciones.telefono, telefono.getText().toString());
        valores.put(transacciones.nota, nota.getText().toString());

        Long resultado = db.insert(transacciones.Tcontactos,transacciones.id,valores);
        Toast.makeText(this, "Contacto guardado con exito" + resultado.toString(), Toast.LENGTH_SHORT).show();
        db.close();
        Limpiar();
    }




    }

    private void Limpiar() {
        nombre.setText("");
        telefono.setText("");
        nota.setText("");
    }
}