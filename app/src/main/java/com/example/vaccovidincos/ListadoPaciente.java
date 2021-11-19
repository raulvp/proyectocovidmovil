package com.example.vaccovidincos;

import android.support.v7.app.AppCompatActivity;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONObject;

public class ListadoPaciente extends AppCompatActivity implements Response.Listener<JSONObject>,Response.ErrorListener {


    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {

    }
}
