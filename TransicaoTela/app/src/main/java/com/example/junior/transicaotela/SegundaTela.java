package com.example.junior.transicaotela;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SegundaTela extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);

        Intent it = getIntent();
        if (it != null){
            Bundle params = it.getExtras();
            if (params != null){
                String nomeUsuario = params.getString("nomeUser");
                String cpfUsuario = params.getString("cpfUser");

                TextView nome = (TextView) findViewById(R.id.textView4);
                TextView cpf = (TextView) findViewById(R.id.textView6);

                nome.setText(nomeUsuario);
                cpf.setText(cpfUsuario);

                Button btVoltar = (Button) findViewById(R.id.button2);
                btVoltar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //finish();
                        Intent it2 = new Intent(SegundaTela.this, MainActivity.class);
                        startActivity(it2);
                    }
                });

            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
