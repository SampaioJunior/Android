package com.example.junior.imc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Imc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        Intent it = getIntent();
        Bundle params = it.getExtras();

        String calculo = params.getString("resultado");

        TextView imc = (TextView) findViewById(R.id.imc);
        imc.setText(calculo);


        Double calculoImc = Double.parseDouble(calculo.replace("IMC: ", ""));
        String resultado = "Resultado: ";

        if (calculoImc >= 40) {
            resultado += "Obesidade Morbida";
        }
        if (calculoImc >= 35 && calculoImc < 40) {
            resultado += "Obesidade Severa";
        }
        if (calculoImc >= 30 && calculoImc < 35) {
            resultado += "Obesidade Grau I";
        }
        if (calculoImc >= 25 && calculoImc < 30) {
            resultado += "Sobrepeso";
        }
        if (calculoImc >= 18.5 && calculoImc < 25) {
            resultado += "Saudavel";
        }
        if (calculoImc >= 17 && calculoImc < 18.5) {
            resultado += "Magraza leve";
        }
        if (calculoImc >= 16 && calculoImc < 17) {
            resultado += "Magreza Moderada";
        }
        if (calculoImc < 16) {
            resultado += "Magreza grave";
        }

        TextView campoResultado = (TextView) findViewById(R.id.resultado);
        campoResultado.setText(resultado);
    }
}


