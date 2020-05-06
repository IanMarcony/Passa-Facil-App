package com.marcony.passafacilproject.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.marcony.passafacilproject.R;
import com.marcony.passafacilproject.adapter.MyRecycleViewAdapter;
import com.marcony.passafacilproject.models.Bus;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    ImageButton btn_back;
    RecyclerView list_bus_view;
    List<Bus>  busList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        btn_back= findViewById(R.id.activity_history_btn_back);
        list_bus_view= findViewById(R.id.activity_history_list_recycle);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        busList = new ArrayList<Bus>();

        busList.add(new Bus("123","15:00","20/05/2020"));
        busList.add(new Bus("345","15:00","20/05/2020"));
        busList.add(new Bus("743","15:00","20/05/2020"));


        list_bus_view.setAdapter( new MyRecycleViewAdapter(busList));



    }
}
