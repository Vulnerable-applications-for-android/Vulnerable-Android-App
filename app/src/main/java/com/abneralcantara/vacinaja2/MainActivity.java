package com.abneralcantara.vacinaja2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import com.scottyab.rootbeer.RootBeer;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Button button1;

    EditText nome, email, senha;
    TextView rooteado;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = (EditText) findViewById(R.id.nome);
        email = (EditText) findViewById(R.id.email);
        senha = (EditText) findViewById(R.id.senha);
        rooteado = (TextView) findViewById(R.id.rooteado);

        button = (Button) findViewById(R.id.register);

        rooteado.setText(new RootBeer(this).isRooted() ? "Device rooteado." : "Device ta de boa.");

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openRegister();
            }
        });

        button1 = (Button) findViewById(R.id.login);
        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openLogin();
            }
        });
    }

    public void openRegister()
    {
        Intent intent = new Intent(getApplicationContext(), RegisterPage.class);
        startActivity(intent);
    }

    public void openLogin()
    {
        Intent intent = new Intent(getApplicationContext(), LoginPage.class);
        startActivity(intent);
    }
}