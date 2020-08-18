package com.marcony.passafacilproject.views;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.marcony.passafacilproject.R;

public class TelaPrincipal extends Activity {
    private TextView txt_saldo, txt_n_viagens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        txt_saldo = findViewById(R.id.textSaldo);
        txt_n_viagens = findViewById(R.id.textNViagens);

    }

    public void navigateToScreen(View view){
        switch (view.getId()){

            case R.id.btn_buy_main:startActivity(new Intent(this, TelaCompraCreditos.class));
                break;
                case R.id.btn_historic_main:startActivity(new Intent(this,HistoryActivity.class));
                break;
            case R.id.btn_map_main:startActivity(new Intent(this,MapActivity.class));
                break;
            case R.id.btnLogout: startActivity(new Intent(this, MainActivity.class));
            finish();
            break;
        }
    }
}
