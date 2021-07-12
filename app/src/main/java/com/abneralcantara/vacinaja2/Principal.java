package com.abneralcantara.vacinaja2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Principal extends AppCompatActivity
{
    Button logout;
    Button ceppage;
    Button webviewbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        logout = (Button) findViewById(R.id.logout);
        ceppage = (Button) findViewById(R.id.ceppage);
        webviewbtn = (Button) findViewById(R.id.webviewbtn);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        ceppage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CepPage.class);
                startActivity(intent);
            }
        });

        webviewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WebviewPage.class);
                startActivity(intent);
            }
        });
    }
}