package com.example.junior.helloword;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SegundaTela extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("SegundaTela","Aplicação no onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("SegundaTela","Aplicação no onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("SegundaTela", "Aplicação no onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("SegundaTela","Aplicação no onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("SegundaTela","Aplicação no onDestroy");
    }
}
