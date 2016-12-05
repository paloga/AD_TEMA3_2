package com.example.pablo.ad_tema3_2;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Sub_Activity extends AppCompatActivity {
    String hombre;
    String mujer;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_);
        txt = (TextView) findViewById(R.id.txt);

        String nombre = getIntent().getExtras().getString("nombre");
        String DNI = getIntent().getExtras().getString("DNI");
        String fecha = getIntent().getExtras().getString("fecha");
        Boolean sexo = getIntent().getExtras().getBoolean("sexo");
        if (sexo==true){
            mujer = "Es una mujer;";
            txt.setText("El nombre es: "+nombre+".\n"+"El DNI es: "+DNI+".\n"+"La fecha de nacimiento es: "+fecha+".\n"+mujer);
        }else{
            hombre = "Es un hombre";
            txt.setText("El nombre es: "+nombre+".\n"+"El DNI es: "+DNI+".\n"+"La fecha de nacimiento es: "+fecha+".\n"+hombre);
        }




    }
}
