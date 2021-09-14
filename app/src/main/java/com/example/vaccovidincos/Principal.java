package com.example.vaccovidincos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }

    public void registrar(View v){
        Intent it = new Intent(getApplicationContext(),Registro.class);
        startActivity(it);
    }
}
