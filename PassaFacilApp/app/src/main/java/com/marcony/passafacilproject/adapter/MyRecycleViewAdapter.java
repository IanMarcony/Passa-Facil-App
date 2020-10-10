package com.marcony.passafacilproject.adapter;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.marcony.passafacilproject.R;
import com.marcony.passafacilproject.models.Bus;

import java.util.List;

public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.ViewHolder> {

    public List<Bus> busList;

    public MyRecycleViewAdapter(List<Bus> busList){

        this.busList = busList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView lineBus, hourBus, dateBus;

        public  ViewHolder(@NonNull View itemView){
            super(itemView);
            lineBus = itemView.findViewById(R.id.list_line_bus);
            hourBus = itemView.findViewById(R.id.list_hour_bus);
            dateBus = itemView.findViewById(R.id.list_date_bus);
        }

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_recycle_view,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.lineBus.setText("Linha "+busList.get(position).getLine());
        holder.hourBus.setText("Horário: "+busList.get(position).getHour());
        holder.dateBus.setText(" Data: "+busList.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return busList.size();
    }
}
