package com.example.parkauto.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.parkauto.R;
import com.example.parkauto.entity.VehiculeEntity;
import com.example.parkauto.repository.VehiculeRepository;
import com.example.parkauto.retrofit.RetrofitVehicule;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeComponents();
    }
    private void initializeComponents(){
        TextInputEditText inputEditTextAnneeModel=findViewById(R.id.form_textFieldAnneeModel);
        TextInputEditText inputEditTextMarqueVehicule= findViewById(R.id.form_textFieldMarqueVehicule);
        TextInputEditText inputEditTextPrix=findViewById(R.id.form_textFieldPrix);
        TextInputEditText inputEditTextImage=findViewById(R.id.form_textFieldImage);
        TextInputEditText inputEditTextDescription=findViewById(R.id.form_textFieldDescription);


        MaterialButton buttonSave= findViewById(R.id.form_button_save_vehicules);



        //injection des données à partir du retrofit
        RetrofitVehicule retrofitVehicule = new RetrofitVehicule();
        VehiculeRepository vehiculeRepository = retrofitVehicule.getRetrofit().create(VehiculeRepository.class);

        buttonSave.setOnClickListener(
                view-> {
                    String anneeModel= String.valueOf(inputEditTextAnneeModel.getText());
                    String marqueVehicule= String.valueOf(inputEditTextMarqueVehicule.getText());
                    Double prix= Double.parseDouble(inputEditTextPrix.getText().toString());
                    String imageVehicule= String.valueOf(inputEditTextImage.getText());
                    String descriptif= String.valueOf(inputEditTextDescription.getText());




                    VehiculeEntity vehiculeEntity = new VehiculeEntity();
                    vehiculeEntity.setAnneeModel(anneeModel);
                    vehiculeEntity.setMarqueVehicule(marqueVehicule);
                    vehiculeEntity.setPrix(prix);
                    vehiculeEntity.setImageVehicule(imageVehicule);
                    vehiculeEntity.setDescriptif(descriptif);



                    vehiculeRepository.saveVehicules(vehiculeEntity)
                            .enqueue(
                                    new Callback<VehiculeEntity>() {
                                        @Override
                                        public void onResponse(Call<VehiculeEntity> call, Response<VehiculeEntity> response) {
                                            Toast.makeText(MainActivity.this, "Save successfull !!!", Toast.LENGTH_SHORT).show();
                                        }

                                        @Override
                                        public void onFailure(Call<VehiculeEntity> call, Throwable t) {
                                            Toast.makeText(MainActivity.this, "Save failled !!!", Toast.LENGTH_SHORT).show();
                                            Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE,"Error Occured",t);
                                        }
                                    }
                            );




        });



    }
}