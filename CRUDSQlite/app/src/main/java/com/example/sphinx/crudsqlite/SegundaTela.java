package com.example.sphinx.crudsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.R.attr.id;

public class SegundaTela extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);

        Button inserir = (Button) findViewById(R.id.inserir);
        inserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrar();
            }
        });
    }

    public void cadastrar(){
        EditText etName = (EditText) findViewById(R.id.nome);
        EditText etCpf = (EditText) findViewById(R.id.cpf);
        EditText etEmail = (EditText) findViewById(R.id.email);
        EditText etTelefone = (EditText) findViewById(R.id.telefone);

        String nome = etName.getText().toString();
        String cpf = etCpf.getText().toString();
        String email = etEmail.getText().toString();
        String telefone = etTelefone.getText().toString();

        Usuario user = new Usuario(nome, cpf, email, telefone);
        UserDAO dao = new UserDAO(SegundaTela.this);

        dao.insertUser(user);
        finish();
    }


}
