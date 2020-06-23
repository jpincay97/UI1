package com.example.ui1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView  txtNombre = (TextView)findViewById(R.id.lblNombre2);
        TextView  txtGenero = (TextView)findViewById(R.id.lblGenero2);
        TextView  txtFechaNac = (TextView)findViewById(R.id.lblFechaNac2);
        TextView  txtTelefono = (TextView)findViewById(R.id.lblTelefono2);

        Bundle bundle = this.getIntent().getExtras();

        txtNombre.setText(bundle.getString("NOMBRE"));
        txtGenero.setText(bundle.getString("GENERO"));
        txtFechaNac.setText(bundle.getString("FECHANAC"));
        txtTelefono.setText(bundle.getString("TELEFONO"));
    }
}
