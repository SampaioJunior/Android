package com.example.junior.imc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SegundaTela extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);

        Intent it = getIntent();
        Bundle params = it.getExtras();

        String nomeUser = params.getString("nome");
        String telefoneUser = params.getString("telefone");
        String emailUser = params.getString("email");
        String pesoUser = params.getString("peso");
        String alturaUser = params.getString("altura");

        EditText nome = (EditText) findViewById(R.id.nome);
        EditText telefone = (EditText) findViewById(R.id.telefone);
        EditText email = (EditText) findViewById(R.id.email);
        EditText peso = (EditText) findViewById(R.id.peso);
        EditText altura = (EditText) findViewById(R.id.altura);

        nome.setText(nomeUser);
        telefone.setText(telefoneUser);
        email.setText(emailUser);
        peso.setText(pesoUser);
        altura.setText(alturaUser);


        Button botao = (Button) findViewById(R.id.calcular);
        assert botao != null;
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent();
                EditText altura = (EditText) findViewById(R.id.altura);
                EditText peso = (EditText) findViewById(R.id.peso);
                double p = Double.parseDouble(altura.getText().toString());
                double a = Double.parseDouble(peso.getText().toString());
                double imc = p/(a*a);

                TextView t = (TextView) findViewById(R.id.imc);
                t.setText(""+imc);
                if (imc >= 40){
                    TextView r = (TextView) findViewById(R.id.resultado);
                    r.setText("Obesidade Mórbida");
                }
                if (imc >= 35 && imc < 40){
                    TextView r = (TextView) findViewById(R.id.resultado);
                    r.setText("Obesidade Severa");
                }
                if (imc >= 30 && imc < 35){
                    TextView r = (TextView) findViewById(R.id.resultado);
                    r.setText("Obesidade Grau I");
                }
                if (imc >= 25 && imc < 30){
                    TextView r = (TextView) findViewById(R.id.resultado);
                    r.setText("Sobrepeso");
                }
                if (imc >= 18.5 && imc < 25){
                    TextView r = (TextView) findViewById(R.id.resultado);
                    r.setText("Saudável");
                }
                if (imc >= 17 && imc < 18.5){
                    TextView r = (TextView) findViewById(R.id.resultado);
                    r.setText("Magreza Leve");
                }
                if (imc >= 16 && imc < 17){
                    TextView r = (TextView) findViewById(R.id.resultado);
                    r.setText("Magreza Moderada");
                }
                if (imc < 16){
                    TextView r = (TextView) findViewById(R.id.resultado);
                    r.setText("Magreza Grave");
                }
                it.putExtra("params", peso.getText().toString());
                it.putExtra("params", altura.getText().toString());
                setResult(RESULT_OK,it);
                finish();
            }
        });



    }



}
