package com.abneralcantara.vacinaja2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {
    private static final String PREF_NAME = "LoginActivityPreferences";

    Button button2;
    EditText email;
    EditText senha;
    DBHelper MyDB;

    @Override
    protected void onCreate(Bundle savedInstaceState) {
        super.onCreate(savedInstaceState);
        setContentView(R.layout.activity_login_page);

        email = (EditText) findViewById(R.id.email);
        senha = (EditText) findViewById(R.id.senha);

        // Shared Preferences
        SharedPreferences sp = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        String emailll = sp.getString("email", "");
        String senhaaa = sp.getString("senha", "");

        MyDB = new DBHelper(this);

        button2 = (Button) findViewById(R.id.submit);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emaill = email.getText().toString();
                String senhaa = senha.getText().toString();

                if(email.equals("")) {
                    Toast.makeText(LoginPage.this, "Digite seu Email", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean result = MyDB.checkemail(emaill);
                    if (result == false) {
                        Toast.makeText(LoginPage.this, "Usuário não existente.", Toast.LENGTH_SHORT).show();
                    } else {
                        Boolean resultSenha = MyDB.checksenha(senhaa);
                        if(resultSenha == false) {
                            Toast.makeText(LoginPage.this, "Senha Incorreta.", Toast.LENGTH_SHORT).show();
                        } else {
                            SharedPreferences sp = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
                            SharedPreferences.Editor editor = sp.edit();

                            editor.putString(emaill, emailll);
                            editor.putString(senhaa, senhaaa);
                            editor.commit();
                            Intent intent = new Intent(getApplicationContext(), Principal.class);
                            startActivity(intent);
                        }
                    }
                }
            }
        });
    }
}
