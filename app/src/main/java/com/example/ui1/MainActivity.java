package com.example.ui1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    private int rbMasculino;
    private int masculino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnEnviar(View view) {

        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        EditText txtNombre = (EditText) findViewById(R.id.txtNombre);
        RadioButton rbMasculino = (RadioButton) findViewById(R.id.rbMasculino);
        RadioButton rbFemenino = (RadioButton) findViewById(R.id.rbFemenino);
        EditText txtFechaNac = (EditText) findViewById(R.id.txtFechaNac);
        EditText txtTelefono = (EditText) findViewById(R.id.txtTelefono);

        Bundle b = new Bundle();
        b.putString("NOMBRE", txtNombre.getText().toString());
        if(rbMasculino.isChecked())
        {
            b.putString("GENERO", "Masculino");
        }
        if(rbFemenino.isChecked())
        {
            b.putString("GENERO", "Femenino");
        }
        b.putString("FECHANAC", txtFechaNac.getText().toString());
        b.putString("TELEFONO", txtTelefono.getText().toString());

        intent.putExtras(b);
        startActivity(intent);

    }
}