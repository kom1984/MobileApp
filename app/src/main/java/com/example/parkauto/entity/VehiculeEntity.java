package com.example.parkauto.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

//@Data
//@RequiredArgsConstructor

public class VehiculeEntity {

    private Long id;
    private String anneeModel;
    private String marqueVehicule;
    private String imageVehicule;
    private String descriptif;
    private double prix;

    public VehiculeEntity() {
    }

    public VehiculeEntity(Long id, String anneeModel, String marqueVehicule, String imageVehicule, String descriptif, double prix) {
        this.id = id;
        this.anneeModel = anneeModel;
        this.marqueVehicule = marqueVehicule;
        this.imageVehicule = imageVehicule;
        this.descriptif = descriptif;
        this.prix = prix;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnneeModel() {
        return anneeModel;
    }

    public void setAnneeModel(String anneeModel) {
        this.anneeModel = anneeModel;
    }

    public String getMarqueVehicule() {
        return marqueVehicule;
    }

    public void setMarqueVehicule(String marqueVehicule) {
        this.marqueVehicule = marqueVehicule;
    }

    public String getImageVehicule() {
        return imageVehicule;
    }

    public void setImageVehicule(String imageVehicule) {
        this.imageVehicule = imageVehicule;
    }

    public String getDescriptif() {
        return descriptif;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
