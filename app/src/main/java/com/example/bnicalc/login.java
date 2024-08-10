package com.example.bnicalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText username2,password2;
    TextView icon3,icon4;
    Button register2;
    ImageView imageView;
    String a,b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username2 = findViewById(R.id.username2);
        password2 = findViewById(R.id.password2);
        icon3 = findViewById(R.id.icon3);
        icon4 = findViewById(R.id.icon4);
        register2 = findViewById(R.id.register2);
        imageView = findViewById(R.id.imageView);
        Intent intent1 = getIntent();
        a = intent1.getStringExtra("email");
        b = intent1.getStringExtra("pass");
        register2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (valedate()) {
                    Intent intent2 = new Intent(getApplicationContext(), bmi.class);
                    startActivity(intent2);
                }
            }
        });
    }
    private boolean valedate(){
        String em =username2.getText().toString();
        String ps =password2.getText().toString();
        if (!(em.equals(a) && ps.equals(b))){
            Toast.makeText(login.this,"login failed!",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}