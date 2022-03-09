package com.example.taxcalculator;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class VehicleActivity extends AppCompatActivity {

    private Spinner sprType, sprService;
    private final String[] Types = {"Automóvil", "Motocicleta"};
    private final String[] Service = {"Privado", "Público"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle);

        sprType = findViewById(R.id.sprType);
        sprService = findViewById(R.id.sprService);

        ArrayAdapter<String> adType = new ArrayAdapter<String>(this, R.layout.btn_spinner_layout, Types);

        ArrayAdapter<String> adService = new ArrayAdapter<String>(this, R.layout.btn_spinner_layout, Service);

        sprType.setAdapter(adType);
        sprService.setAdapter(adService);

    }

    public void calculateTax(View view) {


    }
}