package com.example.bnicalc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView icon,icon2;
    ImageView imageView2;
    EditText name,contact,username,password;
    Button register;
    boolean allfield= false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        icon=findViewById(R.id.icon);
        icon2=findViewById(R.id.icon2);
        imageView2=findViewById(R.id.imageView2);
        name=findViewById(R.id.name);
        contact=findViewById(R.id.contact);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        register=findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allfield=allfields();
                if (allfield) {
                    Intent intent = new Intent(getApplicationContext(), login.class);
                    intent.putExtra("email",username.getText().toString());
                    intent.putExtra("pass",password.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
    private  boolean allfields(){
        if (name.length()==0){
            name.requestFocus();
            name.setError("Enter Your Name");
            return false;
        }
        if (contact.length()==0){
            contact.requestFocus();
            contact.setError("Enter Contact");
            return false;
        }
        String suser=username.getText().toString();
        if (suser.isEmpty()){
            username.requestFocus();
            username.setError("Enter User ID");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(suser).matches()) {
            username.requestFocus();
            username.setError("Enter valid User ID");
            return false;
        }
        if (password.length()==0){
            password.requestFocus();
            password.setError("Enter Password");
            return false;
        } else if (password.length()<6) {
            password.requestFocus();
            password.setError("Password must be of atleast 6 digits");
            return false;
        }
        return true;
    }
}

