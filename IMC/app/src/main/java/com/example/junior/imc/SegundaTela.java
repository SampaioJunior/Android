package com.example.junior.imc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SegundaTela extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
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

                EditText nome = (EditText) findViewById(R.id.nome);
                EditText telefone = (EditText) findViewById(R.id.telefone);
                EditText email = (EditText) findViewById(R.id.email);
                EditText peso = (EditText) findViewById(R.id.peso);
                EditText altura = (EditText) findViewById(R.id.altura);

                String nomeUser = nome.getText().toString();
                String telefoneUser = telefone.getText().toString();
                String emailUser = email.getText().toString();
                String pesoUser = peso.getText().toString();
                String alturaUser = altura.getText().toString();

                Double resultado = Double.parseDouble(pesoUser) / (Double.parseDouble(alturaUser) * Double.parseDouble(alturaUser));

                Bundle params = new Bundle();
                params.putString("resultado", resultado.toString());

                it.putExtras(params);

                setResult(RESULT_OK, it);
                finish();
            }
        });


    }
}
