package com.example.sphinx.crudsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.R.attr.id;

public class Operacoes extends AppCompatActivity {
    Usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operacoes);

        final Button buscar = (Button) findViewById(R.id.opBuscar);
        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscar();
            }
        });

        Button update = (Button) findViewById(R.id.editar);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                atualizarUser();
            }
        });

        Button delete = (Button) findViewById(R.id.excluir);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deletarUser();
            }
        });

        Button voltar = (Button) findViewById(R.id.voltar);
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void buscar(){
        EditText edtNome = (EditText) findViewById(R.id.opnome);

        String nome = edtNome.getText().toString();

        UserDAO userDao = new UserDAO(Operacoes.this);

        this.user = userDao.consulta(nome);

        TextView apNome = (TextView) findViewById(R.id.apNome);
        TextView apCPF = (TextView) findViewById(R.id.apCpf);
        TextView apTelefone = (TextView) findViewById(R.id.apTelefone);
        TextView apEmail = (TextView) findViewById(R.id.apEmail);

        apNome.setText(user.getNome());
        apCPF.setText(user.getCpf());
        apTelefone.setText(user.getCpf());
        apEmail.setText(user.getEmail());
    }

    public void atualizarUser(){
        EditText etName = (EditText) findViewById(R.id.nome);
        EditText etCpf = (EditText) findViewById(R.id.cpf);
        EditText etEmail = (EditText) findViewById(R.id.email);
        EditText etTelefone = (EditText) findViewById(R.id.telefone);

        String nome = etName.getText().toString();
        String cpf = etCpf.getText().toString();
        String email = etEmail.getText().toString();
        String telefone = etTelefone.getText().toString();

        Usuario user = new Usuario(nome,cpf,telefone,email);
        UserDAO dao = new UserDAO(Operacoes.this);
        dao.updateUser(user);
    }

    public void deletarUser(){
        UserDAO dao = new UserDAO(this);

        Usuario usuario = dao.userById(id);

        dao.deleteUser(usuario);
    }

}
