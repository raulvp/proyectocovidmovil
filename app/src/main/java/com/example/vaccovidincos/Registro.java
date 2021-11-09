package com.example.vaccovidincos;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class Registro extends AppCompatActivity {
    EditText fechaNac,fechaVac;
    private  int dia,mes,anio;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        fechaNac = (EditText) findViewById(R.id.txtfechanac);
        fechaVac = (EditText) findViewById(R.id.txtfechavacuna);


    }

    public void fechaNacimiento(View view) {
        final Calendar calendar = Calendar.getInstance();
        dia = calendar.get(Calendar.DAY_OF_MONTH);
        mes = calendar.get(Calendar.MONTH);
        anio = calendar.get(Calendar.YEAR);


        DatePickerDialog dp = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                fechaNac.setText(i2 + "/"+(i1+1)+"/"+i);
            }
        },dia,mes,anio);

        dp.show();

    }

    public void fechaVacuna(View view) {

        final Calendar calendar2 = Calendar.getInstance();
        dia = calendar2.get(Calendar.DAY_OF_MONTH);
        mes = calendar2.get(Calendar.MONTH);
        anio = calendar2.get(Calendar.YEAR);


        DatePickerDialog dpv = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                fechaVac.setText(i2 + "/"+(i1+1)+"/"+i);
            }
        },dia,mes,anio);

        dpv.show();
    }



/*

    @Override
    public void onClick(View view) {
        final Calendar calendar = Calendar.getInstance();
        dia = calendar.get(Calendar.DAY_OF_MONTH);
        mes = calendar.get(Calendar.MONTH);
        anio = calendar.get(Calendar.YEAR);


        DatePickerDialog dp = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                fechaNac.setText(i2 + "/"+(i1+1)+"/"+i);
            }
        },dia,mes,anio);

        dp.show();
    }*/

}
