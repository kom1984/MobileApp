package com.example.parkauto.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parkauto.R;
import com.example.parkauto.entity.VehiculeEntity;

import java.util.List;

public class VehiculeAdapter extends RecyclerView.Adapter<VehiculeHolder> {
    private List<VehiculeEntity> vehiculeList;

    public VehiculeAdapter(List<VehiculeEntity> vehiculeList) {
        this.vehiculeList = vehiculeList;
    }

    public VehiculeAdapter() {
    }

    @NonNull
    @Override
    public VehiculeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_vehicules_item,parent,false);

        return new VehiculeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VehiculeHolder holder, int position) {
        VehiculeEntity vehiculeEntity = vehiculeList.get(position);
        holder.anneeModel.setText(vehiculeEntity.getAnneeModel());
        holder.MarqueVehicule.setText(vehiculeEntity.getMarqueVehicule());
        holder.descriptif.setText(vehiculeEntity.getDescriptif());
        holder.imageVehicule.setText(vehiculeEntity.getImageVehicule());
        holder.prix.setText(String.format(Double.toString(vehiculeEntity.getPrix())));


    }

    @Override
    public int getItemCount() {
        return vehiculeList.size();
    }
}
