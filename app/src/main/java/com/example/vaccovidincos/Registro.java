package com.example.vaccovidincos;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.Calendar;
import java.util.LinkedList;

public class Registro extends AppCompatActivity implements Response.Listener<JSONObject>,Response.ErrorListener {
    EditText fechaNac,fechaVac;
    private  int dia,mes,anio;

    //campos formulario

    EditText nombres,apellidos,carnet,fechanacimiento,municipio,estasalud,fechavacuna,dosis,proxvacuna;
    Spinner servsaludlista,proveedor;

    Button registrar;

    RequestQueue requestQueue;
    JsonObjectRequest jsonObjectRequest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        fechaNac = (EditText) findViewById(R.id.txtfechanac);
        fechaVac = (EditText) findViewById(R.id.txtfechavacuna);

        //enlazando campos
        nombres=(EditText) findViewById(R.id.txtnombre);
        apellidos=(EditText) findViewById(R.id.txtape);
        carnet=(EditText) findViewById(R.id.txtcarnet);
        estasalud=(EditText) findViewById(R.id.txtestsalud);
        municipio=(EditText) findViewById(R.id.txtmunicipio);
        dosis=(EditText) findViewById(R.id.txtdosis);
        proxvacuna=(EditText) findViewById(R.id.proxfechvac);

        servsaludlista = (Spinner) findViewById(R.id.spinner2);

        proveedor = (Spinner) findViewById(R.id.spinner3);

        registrar = (Button) findViewById(R.id.btn_registrar);

        requestQueue = Volley.newRequestQueue(getApplicationContext());
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cargarWsRegistro();
            }
        });

    }

    private void cargarWsRegistro() {

        String url = "http://192.168.0.6:9095/proyectocovid/conexremotas/conexregistrar.php?nombres="+nombres.getText().toString()+"&apellidos="+apellidos.getText().toString()+"&carnet="+carnet.getText().toString()+"&estasalud="+estasalud.getText().toString()+"&municipio="+municipio.getText().toString()+"&dosis="+dosis.getText().toString()+"&proxvacuna="+proxvacuna.getText().toString()+"&servsaludlista="+ servsaludlista.getSelectedItem().toString()+"&proveedor="+proveedor.getSelectedItem().toString()+"&fechaNac="+fechaNac.getText().toString()+"&fechaVac="+fechaVac.getText().toString();
        url= url.replace(" ","%20");

        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,this,this);

        requestQueue.add(jsonObjectRequest);


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

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getApplicationContext(),"No se pudo registrar"+error.toString(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(getApplicationContext(),"Registro exitosamente!",Toast.LENGTH_SHORT).show();
        nombres.setText("");
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
