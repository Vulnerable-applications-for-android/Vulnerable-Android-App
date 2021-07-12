package com.abneralcantara.vacinaja2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.net.Uri;
import java.util.List;

public class SpecialPage extends AppCompatActivity {

    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstaceState) {
        super.onCreate(savedInstaceState);
        setContentView(R.layout.activity_special_page);

        textView2 = findViewById(R.id.textView2);

        Intent intent = getIntent();
        String action = intent.getAction();
        Uri data = intent.getData();
    }

}
