package com.example.ui1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private int rbMasculino;
    private int masculino;
    private int anio, mes, dia, anioDialog, mesDialog, diaDialog;
    static final int IdFecha = 0;
    Calendar C = Calendar.getInstance();
    EditText txtFechaNac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mesDialog = C.get(Calendar.MONTH);
        diaDialog = C.get(Calendar.DAY_OF_MONTH);
        anioDialog = C.get(Calendar.YEAR);
        txtFechaNac = (EditText) findViewById(R.id.txtFechaNac);

        txtFechaNac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showDialog(IdFecha);
            }
        });
    }

    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int month, int day) {
                    anio = year; mes = month; dia = day;
                    txtFechaNac.setText(dia + "/" + (mes + 1) +"/" + anio);
                }
            };

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case IdFecha:
                return new DatePickerDialog(this, mDateSetListener, anioDialog, mesDialog, diaDialog);
        }
        return null;
    }

    public void btnEnviar(View view) {

        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        EditText txtNombre = (EditText) findViewById(R.id.txtNombre);
        RadioButton rbMasculino = (RadioButton) findViewById(R.id.rbMasculino);
        RadioButton rbFemenino = (RadioButton) findViewById(R.id.rbFemenino);
        //EditText txtFechaNac = (EditText) findViewById(R.id.txtFechaNac);
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