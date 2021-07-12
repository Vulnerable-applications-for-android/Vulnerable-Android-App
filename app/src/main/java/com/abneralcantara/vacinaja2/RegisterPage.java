package com.abneralcantara.vacinaja2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.TaskStackBuilder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterPage extends AppCompatActivity
{
    EditText name, email, senha;
    Button submit;
    DBHelper MyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        name = (EditText) findViewById(R.id.nome);
        email = (EditText) findViewById(R.id.email);
        senha = (EditText) findViewById(R.id.senha);

        submit = (Button) findViewById(R.id.submit);

        MyDB = new DBHelper(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomee = name.getText().toString();
                String emaill = email.getText().toString();
                String senhaa = senha.getText().toString();

                if(nomee.equals("") || emaill.equals("") || senhaa.equals(""))
                {
                    Toast.makeText(RegisterPage.this, "Preencha todos os campos.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Boolean result = MyDB.checkemail(emaill);
                    if(result == false)
                    {
                        Boolean res = MyDB.insertData(nomee, emaill, senhaa);
                        if(res==true)
                        {
                            Toast.makeText(RegisterPage.this,"Cadastro com sucesso!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), Principal.class);
                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(RegisterPage.this,"Falha ao cadastro!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(RegisterPage.this, "Usuário já existe.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), LoginPage.class);
                        startActivity(intent);
                    }

                }
            }
        });
    }

}
