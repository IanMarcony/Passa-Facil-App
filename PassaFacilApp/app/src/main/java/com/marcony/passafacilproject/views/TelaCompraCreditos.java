package com.marcony.passafacilproject.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.marcony.passafacilproject.R;

import java.util.Timer;

public class TelaCompraCreditos extends Activity {

   private EditText value, numCard, numImprCard, numCvv, valMes,valAno;
    private  Button btnTrans,btn_map;
    private  ProgressBar progressBar;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference userDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_compra_creditos);
        firebaseAuth=FirebaseAuth.getInstance();
        userDatabase = FirebaseDatabase.getInstance().getReference("users").child(firebaseAuth.getUid());


        buildViews();

        btnTrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);

                userDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        if(snapshot.exists()){
                            float saldo = Float.parseFloat(snapshot.child("passa_facil").child("saldo").getValue().toString());
                            float more_saldo = Float.parseFloat(value.getText().toString());

                            saldo+=more_saldo;

                            userDatabase.child("passa_facil").child("saldo").setValue(saldo);
                        }
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(getApplicationContext(),"Compra feita com SUCESSO",Toast.LENGTH_SHORT).show();
                        finish();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(getApplicationContext(),"Não foi possível comprar os créditos",Toast.LENGTH_SHORT).show();

                        progressBar.setVisibility(View.GONE);
                    }
                });


                
            }
        });
        btn_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MapActivity.class));

            }
        });
    }


    private void buildViews(){

        value =  findViewById(R.id.buy_edit_value);
        numCard= findViewById(R.id.buy_edit_numcard);
        numImprCard=findViewById(R.id.buy_edit_impr_card);
        numCvv= findViewById(R.id.buy_edit_cvv);
        valMes = findViewById(R.id.buy_edit_val_mes);
        valAno = findViewById(R.id.buy_edit_val_ano);
        btnTrans = findViewById(R.id.buy_btn_trans);
        btn_map= findViewById(R.id.buy_btn_maps);
        progressBar =  findViewById(R.id.buy_progressBar);

    }

}
