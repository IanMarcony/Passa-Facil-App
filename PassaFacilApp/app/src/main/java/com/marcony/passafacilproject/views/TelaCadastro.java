package com.marcony.passafacilproject.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.marcony.passafacilproject.R;
import com.marcony.passafacilproject.firebasemodel.User;

public class TelaCadastro extends Activity {

    EditText name , birthDate,numPass,sexo,cpf,rg,adress, email,password;
    ProgressBar progressBar;
    Button btn_concludes;
    private FirebaseAuth auth;

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
        auth=FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(email.getText().toString().trim(), password.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    User user = new User(FirebaseAuth.getInstance().getUid(),
                            name.getText().toString(),
                            email.getText().toString(),
                            birthDate.getText().toString(),
                            sexo.getText().toString(),
                            cpf.getText().toString(),
                            rg.getText().toString(),
                            adress.getText().toString(),
                            Integer.parseInt(numPass.getText().toString()));
                    DatabaseReference  databaseReference = FirebaseDatabase.getInstance().getReference().child("users");
                    databaseReference.child(user.getUid()).setValue(user);
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(),"Não foi possível criar sua conta",Toast.LENGTH_SHORT).show();
                }
            }
        });







        Toast.makeText(getApplicationContext(),"Registrado",Toast.LENGTH_SHORT).show();
        progressBar.setVisibility(View.GONE);
    }
}
