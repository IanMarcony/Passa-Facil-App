package com.marcony.passafacilproject.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.marcony.passafacilproject.R;
import com.marcony.passafacilproject.models.Bus;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class TelaPrincipal extends Activity {
    private TextView txt_saldo, txt_n_viagens;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference userDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
        firebaseAuth=FirebaseAuth.getInstance();
        userDatabase = FirebaseDatabase.getInstance().getReference("users").child(firebaseAuth.getUid());

        txt_saldo = findViewById(R.id.textSaldo);
        txt_n_viagens = findViewById(R.id.textNViagens);

        snapshotValueUser();

    }

    private void snapshotValueUser(){
        userDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    float saldo = Float.parseFloat(snapshot.child("passa_facil").child("saldo").getValue().toString());

                    int n_viagens= (int) (saldo/1.5);

                    txt_saldo.setText(Float.toString(saldo));
                    txt_n_viagens.setText(Integer.toString(n_viagens));

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(),"Erro ao acessar os dados na nuvem", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void navigateToScreen(View view){
        switch (view.getId()){

            case R.id.btn_buy_main:startActivity(new Intent(this, TelaCompraCreditos.class));
                break;
                case R.id.btn_historic_main:startActivity(new Intent(this,HistoryActivity.class));
                break;
            case R.id.btn_map_main:startActivity(new Intent(this,MapActivity.class));
                break;
            case R.id.btnLogout:

                firebaseAuth.signOut();
                startActivity(new Intent(this, MainActivity.class));
                finish();
            break;

            case R.id.btnBus:
                if(Float.parseFloat(txt_saldo.getText().toString())==0)return;
                userDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            float saldo = Float.parseFloat(snapshot.child("passa_facil").child("saldo").getValue().toString());
                            saldo-=1.5;
                            String[] arrayLines = {"355","560","044","041","356","213","629","418","319"};
                            SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yyyy");
                            SimpleDateFormat sdfHour = new SimpleDateFormat("HH:mm");
                            Date dataHj = new Date();

                            Bus newBus = new Bus(sdfDate.format(dataHj),
                                    sdfHour.format(dataHj)
                                    ,arrayLines[new Random().nextInt(arrayLines.length)]);
                            userDatabase.child("passa_facil").child("saldo").setValue(saldo);
                            userDatabase.child("historico").push().setValue(newBus);



                            Toast.makeText(getApplicationContext(),"Registrou", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(getApplicationContext(),"Erro ao registrar os dados na nuvem", Toast.LENGTH_SHORT).show();
                    }
                });





                break;
        }
    }
}
