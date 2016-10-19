package com.example.junior.imc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final int COD_ACTIVITY = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button res = (Button) findViewById(R.id.button4);
        assert res != null;
        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, Imc.class);
                TextView conta = (TextView) findViewById(R.id.calculo);

                Bundle params = new Bundle();
                params.putString("resultado",conta.getText().toString());
                it.putExtras(params);
                startActivity(it);
            }
        });
    }

    public void dados(View v) {
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

        Intent it = new Intent(MainActivity.this, SegundaTela.class);
        Bundle params = new Bundle();
        params.putString("nome", nomeUser);
        params.putString("telefone", telefoneUser);
        params.putString("email", emailUser);
        params.putString("peso", pesoUser);
        params.putString("altura", alturaUser);

        it.putExtras(params);
        startActivityForResult(it, COD_ACTIVITY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == COD_ACTIVITY) {
            TextView imc = (TextView) findViewById(R.id.calculo);

            if (resultCode == RESULT_OK && data.hasExtra("resultado")) {
                String campoImc = data.getExtras().getString("resultado");
                imc.setText("IMC: " + campoImc);
            }
        }
    }
}
