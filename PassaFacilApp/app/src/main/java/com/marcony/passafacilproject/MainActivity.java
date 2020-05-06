package com.marcony.passafacilproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText  emailUser,passwordUser;
    Button btnEnter,btnRegister;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailUser= findViewById(R.id.main_edit_txt_email);
        passwordUser=findViewById(R.id.main_edit_txt_password);
        btnEnter=findViewById(R.id.main_btn_enter);
        btnRegister=findViewById(R.id.main_btn_register);
        progressBar = findViewById(R.id.main_progress);

        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),TelaCadastro.class));

            }
        });


    }

    private void login() {
        progressBar.setVisibility(View.VISIBLE);
        String email = emailUser.getText().toString();
        String password = passwordUser.getText().toString();

        if(email.equals("admin")&&password.equals("admin")){
            progressBar.setVisibility(View.GONE);
            //startActivity(new Intent());
            //finish();
        }else{
            Toast.makeText(getApplicationContext(),"Seu email/senha  estão incorretos",Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
        }


    }
}
