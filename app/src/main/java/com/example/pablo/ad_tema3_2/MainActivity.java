package com.example.pablo.ad_tema3_2;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    EditText nombre;
    EditText DNI;
    EditText fecha;
    RadioButton hombre;
    RadioButton mujer;
    Button enviar;
    String PREFS = "Mis preferencias";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText) findViewById(R.id.nombre);
        DNI = (EditText) findViewById(R.id.dni);
        fecha = (EditText) findViewById(R.id.fecha);

        hombre = (RadioButton) findViewById(R.id.hombre);
        mujer = (RadioButton) findViewById(R.id.mujer);

        enviar = (Button) findViewById(R.id.btn);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences mySharedPreferences = getSharedPreferences(PREFS, Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor = mySharedPreferences.edit();

                editor.putString("nombre",nombre.getText().toString());
                editor.putString("DNI",DNI.getText().toString());
                editor.putString("fecha",fecha.getText().toString());
                editor.putBoolean("esMujer",mujerOHombre());
                editor.commit();
                String nombre = mySharedPreferences.getString("nombre","");
                String DNI = mySharedPreferences.getString("DNI","");
                String fecha = mySharedPreferences.getString("fecha","");
                Boolean sexo = mySharedPreferences.getBoolean("esMujer",false);
                Bundle b = new Bundle();
                b.putString("nombre", nombre);
                b.putString("DNI", DNI);
                b.putString("fecha", fecha);
                b.putBoolean("sexo", sexo);
                Intent i = new Intent(getApplicationContext(), Sub_Activity.class);
                i.putExtras(b);
                MainActivity.this.startActivityForResult(i, 1);
            }
        });



    }

    private boolean mujerOHombre() {
        if (mujer.isChecked()==true) {
            return true;
        } else {

            return false;
        }
    }
}
