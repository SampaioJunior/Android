package com.example.sphinx.crudsqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.R.attr.id;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cadastrar(View v){

        Intent it = new Intent(MainActivity.this, SegundaTela.class);
        startActivity(it);

    }

    public void buscar(View v){

        Intent it = new Intent(MainActivity.this, Operacoes.class);
        startActivity(it);

    }


}
