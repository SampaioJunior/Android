package com.example.junior.transicaotela;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btEnviar = (Button) findViewById(R.id.button);

        btEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nome = (EditText) findViewById(R.id.editText);
                EditText cpf = (EditText) findViewById(R.id.editText2);

                String nomeUsuario = nome.getText().toString();
                String cpfUsuario = cpf.getText().toString();

                Intent it = new Intent(MainActivity.this,SegundaTela.class);
                Bundle params = new Bundle();
                params.putString("nomeUser", nomeUsuario);
                params.putString("cpfUser", cpfUsuario);

                it.putExtras(params);
                startActivity(it);
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
