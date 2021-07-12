package com.abneralcantara.vacinaja2;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.concurrent.ExecutionException;
import com.abneralcantara.vacinaja2.LoginPage;

public class CepPage extends AppCompatActivity {
    Button button;
    Button cep;
    EditText cepcampo;
    TextView welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cep_page);

        button = (Button) findViewById(R.id.button);
        cep = (Button) findViewById(R.id.cep);
        cepcampo = (EditText) findViewById(R.id.cepcampo);
        welcome = (TextView) findViewById(R.id.welcome);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Principal.class);
                startActivity(intent);
            }
        });

        cep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cepcampo.getText().toString().length() > 0 && !cepcampo.getText().toString().equals("") && cepcampo.getText().toString().length() == 8) {
                    HTTPService service = new HTTPService(cepcampo.getText().toString());
                    try {
                        CEP resposta = service.execute().get();
                        welcome.setText(resposta.toString());
                    } catch (ExecutionException | InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                }
        });
    }
}
