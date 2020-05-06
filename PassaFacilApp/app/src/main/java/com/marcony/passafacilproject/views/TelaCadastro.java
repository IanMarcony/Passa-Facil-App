package com.marcony.passafacilproject.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.marcony.passafacilproject.R;

public class TelaCadastro extends AppCompatActivity {

    EditText name , birthDate,numPass,sexo,cpf,rg,adress, email,password;
    ProgressBar progressBar;
    Button btn_concludes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);
        buildViews();

        btn_concludes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });


    }

    private void buildViews() {

        name = findViewById(R.id.register_name);
        birthDate= findViewById(R.id.register_birthdate);
        numPass = findViewById(R.id.register_numpass);
        sexo = findViewById(R.id.register_sexo);
        cpf= findViewById(R.id.register_cpf);
        rg = findViewById(R.id.register_rg);
        adress=findViewById(R.id.register_adress);
        email=findViewById(R.id.register_email);
        password=findViewById(R.id.register_password);

        progressBar=findViewById(R.id.register_progressBar);
        btn_concludes=findViewById(R.id.register_btn_concludes);
    }
    public void signup(){
        progressBar.setVisibility(View.VISIBLE);
        //Validar Campos


        Toast.makeText(getApplicationContext(),"Registrado",Toast.LENGTH_SHORT).show();
        progressBar.setVisibility(View.GONE);
    }
}
