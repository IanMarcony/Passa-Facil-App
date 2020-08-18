package com.marcony.passafacilproject.views;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.marcony.passafacilproject.R;

import java.util.Timer;

public class TelaCompraCreditos extends Activity {

    EditText value, numCard, numImprCard, numCvv, valMes,valAno;
    Button btnTrans,btn_map;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_compra_creditos);
        buildViews();

        btnTrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);



                progressBar.setVisibility(View.GONE);
                
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
