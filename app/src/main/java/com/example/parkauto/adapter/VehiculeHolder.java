package com.example.parkauto.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parkauto.R;

public class VehiculeHolder extends RecyclerView.ViewHolder {
    TextView anneeModel, descriptif,MarqueVehicule,imageVehicule ,prix;
    public VehiculeHolder(@NonNull View itemView){
        super(itemView);

        anneeModel = itemView.findViewById(R.id.vehiculeList_anneeModel);
        descriptif = itemView.findViewById(R.id.vehiculeList_descriptif);
        MarqueVehicule = itemView.findViewById(R.id.vehiculeList_marqueVehicule);
        imageVehicule = itemView.findViewById(R.id.vehiculeList_ImageVehicule);
        prix = itemView.findViewById(R.id.vehiculeList_prix);



    }

}
