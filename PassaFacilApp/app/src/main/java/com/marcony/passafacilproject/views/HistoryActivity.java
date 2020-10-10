package com.marcony.passafacilproject.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.marcony.passafacilproject.R;
import com.marcony.passafacilproject.adapter.MyRecycleViewAdapter;
import com.marcony.passafacilproject.models.Bus;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends Activity {

    private ImageButton btn_back;
    private RecyclerView list_bus_view;
    private List<Bus>  busList;
    private RecyclerView.LayoutManager layoutManager;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference userDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        firebaseAuth=FirebaseAuth.getInstance();
        userDatabase = FirebaseDatabase.getInstance().getReference("users").child(firebaseAuth.getUid());

        btn_back= findViewById(R.id.activity_history_btn_back);
        list_bus_view= findViewById(R.id.activity_history_list_recycle);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        busList = new ArrayList<Bus>();

        layoutManager = new LinearLayoutManager(this);
        list_bus_view.setLayoutManager(layoutManager);


        getAllHistoricBus();



    }

    private void getAllHistoricBus(){
        userDatabase.child("historico").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                        Log.d("AQUI","Bus: "+dataSnapshot.getValue().toString());
                        String date = dataSnapshot.child("date").getValue().toString();
                        String hour = dataSnapshot.child("hour").getValue().toString();
                        String line = dataSnapshot.child("line").getValue().toString();

                        Bus bus = new Bus(date,hour,line);

                        busList.add(bus);

                    }

                    list_bus_view.setAdapter( new MyRecycleViewAdapter(busList));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(),"Erro ao acessar os dados na nuvem", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
