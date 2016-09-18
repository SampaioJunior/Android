package com.example.junior.aulaead;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void abrirNavegador(View v) {
        Uri url = Uri.parse("http://9gag.com/");
        Intent it = new Intent(Intent.ACTION_VIEW, url);
        startActivity(it);
    }

    public void fazerLigacao(View v) {
        Uri tel = Uri.parse("tel:06481335739");
        Intent it = new Intent(Intent.ACTION_CALL, tel);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(it);
    }

    public void agenda(View v) {
        Uri contatos = Uri.parse("content://com.android.contacts/contacts");
        Intent idContatos = new Intent(Intent.ACTION_PICK, contatos);
        int contatoSelecionado = 0;
        startActivityForResult(idContatos, contatoSelecionado);

    }

    protected void onActivityResult(int codigo, int resultado, Intent intent) {
        Uri resultadoCont = intent.getData();
        mensagemExibir("contato", "" + resultadoCont);
    }

    public void mensagemExibir(String titulo, String texto) {
        AlertDialog.Builder mensagem = new AlertDialog.Builder(MainActivity.this);
        mensagem.setTitle(titulo);
        mensagem.setMessage(texto);
        mensagem.setNeutralButton("OK", null);
        mensagem.show();
    }

    public void abrirMapa(View v) {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("geo:47.6,-122.3"));
        startActivity(intent);

    }

    public void tirarFoto(View v) {
        File picsDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File imageFile = new File(picsDir, "foto.jpg");

        Intent it = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        it.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(imageFile));

        startActivity(it);

    }

    public void pesquisar(View v) {

        TextView pesquisa = (TextView) findViewById(R.id.editText);
        String url = "http://www.google.com/#q=";
        String query = pesquisa.getText().toString().replace(" ", "+").trim();
        String final_url = url + query;
        Uri uri = Uri.parse(final_url);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }


}
