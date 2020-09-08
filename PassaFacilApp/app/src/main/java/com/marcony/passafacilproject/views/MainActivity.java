package com.marcony.passafacilproject.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.marcony.passafacilproject.R;

public class MainActivity extends Activity {

    private EditText  emailUser,passwordUser;
    private Button btnEnter,btnRegister;
    private ProgressBar progressBar;

    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailUser= findViewById(R.id.main_edit_txt_email);
        passwordUser=findViewById(R.id.main_edit_txt_password);
        btnEnter=findViewById(R.id.main_btn_enter);
        btnRegister=findViewById(R.id.main_btn_register);
        progressBar = findViewById(R.id.main_progress);
        firebaseAuth= FirebaseAuth.getInstance();



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

        passwordUser.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_GO){
                        login();
                        return true;
                }
                return false;
            }
        });

    }

    private void login() {
        progressBar.setVisibility(View.VISIBLE);
        String email = emailUser.getText().toString();
        String password = passwordUser.getText().toString();

        if(!email.trim().isEmpty()&&!password.trim().isEmpty())
        {

            firebaseAuth.signInWithEmailAndPassword(email,password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    progressBar.setVisibility(View.GONE);
                    if(task.isSuccessful()){
                        startActivity(new Intent(getApplicationContext(),TelaPrincipal.class));
                        finish();
                    }else{
                        Toast.makeText(getApplicationContext(),"Email e/ou senha incorretos!",Toast.LENGTH_SHORT).show();
                        emailUser.setText("");
                        passwordUser.setText("");
                    }
                }
            });
        }




    }
}
