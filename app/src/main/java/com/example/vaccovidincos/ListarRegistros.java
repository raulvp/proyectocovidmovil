package com.example.vaccovidincos;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.loopj.android.http.*;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;


public class ListarRegistros extends AppCompatActivity {

    private AsyncHttpClient paciente;
    private ListView listado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_registros);

        listado = (ListView) findViewById(R.id.listPacientes);
        paciente = new AsyncHttpClient();

        obtenerRegistros();

    }

    private void obtenerRegistros() {
        String url = "http://192.168.0.6:9095/proyectocovid/conexremotas/conexlista.php";
        paciente.post(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if(statusCode == 200){
                    listarRegistros(new String(responseBody));
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });

    }

    private void listarRegistros(String respuesta){
        final ArrayList<Paciente> lista = new ArrayList <Paciente> ();
        try{
            JSONArray jsonArreglo = new JSONArray(respuesta);
            for(int i=0;i<jsonArreglo.length();i++){
                Paciente p = new Paciente();

                p.setIdPaciente(jsonArreglo.getJSONObject(i).getInt("idPaciente"));
                p.setNombre(jsonArreglo.getJSONObject(i).getString("nombres"));
                p.setApellidos(jsonArreglo.getJSONObject(i).getString("apellidos"));
                p.setCedula(jsonArreglo.getJSONObject(i).getInt("cedula"));
                p.setFechaNac(jsonArreglo.getJSONObject(i).getString("fechaNac"));
                p.setServSalud(jsonArreglo.getJSONObject(i).getString("serviciosSalud"));
                p.setMunicipio(jsonArreglo.getJSONObject(i).getString("municipio"));
                p.setEstablecimiento(jsonArreglo.getJSONObject(i).getString("establecimiento"));
                p.setFechaVacuna(jsonArreglo.getJSONObject(i).getString("fechaVac"));
                p.setDosis(jsonArreglo.getJSONObject(i).getString("dosis"));
                p.setProveedor(jsonArreglo.getJSONObject(i).getString("proveedor"));
                p.setProxVacuna(jsonArreglo.getJSONObject(i).getString("proxVac"));

                lista.add(p);
            }

            ArrayAdapter<Paciente> a = new ArrayAdapter(this,android.R.layout.simple_list_item_1,lista);
            listado.setAdapter(a);

            /**mostrar informacion***/

            listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Paciente p = lista.get(i);
                    StringBuffer b = new StringBuffer();
                    b.append("ID: " + p.getIdPaciente() + "\n");
                    b.append("NOMBRES: " + p.getNombre() + "\n");
                    b.append("APELLIDOS: $" + p.getApellidos() + "\n");
                    b.append("CARNET: " + p.getCedula() + "\n");
                    b.append("VACUNA: " + p.getProveedor());

                    AlertDialog.Builder a = new AlertDialog.Builder(ListarRegistros.this);
                    a.setCancelable(true);
                    a.setTitle("Detalle");
                    a.setMessage(b.toString());
                    //a.setIcon(R.drawable.ok);
                    a.show();
                }
            });

        }catch(Exception e){
            e.printStackTrace();
        }
    }



}
