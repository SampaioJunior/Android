package com.example.junior.exemplointent;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirBrowser(View v) {
        Uri url = Uri.parse("http://www.google.com");
        Intent it = new Intent(Intent.ACTION_VIEW, url);
        startActivity(it);
    }

    public void ligar(View v) {
        Uri tel = Uri.parse("tel:9999999999");
        Intent it = new Intent(Intent.ACTION_CALL, tel);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(it);

    }

    public void buscarContatos(View v){
        Uri cont = Uri.parse("content://com.android.contacts/contacts/");
        Intent it = new Intent(Intent.ACTION_VIEW,cont);
        startActivity(it);
    }

    public void abrirContato(View v){
        Uri cont = Uri.parse("content://com.android.contacts/contacts/1");
        Intent it = new Intent(Intent.ACTION_VIEW,cont);
        startActivity(it);

    }
}
