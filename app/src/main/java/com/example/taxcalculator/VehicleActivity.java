package com.example.taxcalculator;

import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class VehicleActivity extends AppCompatActivity {

    private Spinner sprType, sprService;
    private TextView tvService;
    private EditText etValueVehicle;
    private TextView tvTax;
    private final String[] Types = {"Automóvil", "Motocicleta"};
    private final String[] Service = {"Privado", "Público"};
    private final String[] Cylinder = {"Menos de 125 km/h", "Más de 125 km/h"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle);

        sprType = findViewById(R.id.sprType);
        sprService = findViewById(R.id.sprService);
        tvService = findViewById(R.id.tvService);
        etValueVehicle = findViewById(R.id.etValueVehicle);
        tvTax = findViewById(R.id.tvValueTax);

        ArrayAdapter<String> adType = new ArrayAdapter<String>(this, R.layout.btn_spinner_layout, Types);
        ArrayAdapter<String> adService = new ArrayAdapter<String>(this, R.layout.btn_spinner_layout, Service);
        ArrayAdapter<String> adCylinder = new ArrayAdapter<String>(this, R.layout.btn_spinner_layout, Cylinder);

        sprType.setAdapter(adType);
        sprService.setAdapter(adService);

        sprType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                System.out.println(i);

                switch (i) {
                    case 0:
                        sprService.setAdapter(adService);
                        tvService.setText(R.string.tvService);
                        break;

                    case 1:
                        sprService.setAdapter(adCylinder);
                        tvService.setText("Cilindraje de la moto:");
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void calculateTax(View view) {

        int typeVehicle = sprType.getSelectedItemPosition();
        Double valueVehicle = Double.parseDouble(etValueVehicle.getText().toString());

        double tax = 0;

        if(typeVehicle == 0) {

            if(sprService.getSelectedItemPosition() == 0) {

                if (valueVehicle > 0 && valueVehicle < 50954000) {
                    tax = valueVehicle * 0.015;
                } else if (valueVehicle > 50954000 && valueVehicle < 114644000) {
                    tax = valueVehicle * 0.025;
                } else if (valueVehicle > 114644000) {
                    tax = valueVehicle * 0.035;
                }

            } else {
                tax = valueVehicle * 0.005;
            }

        } else {
            if(sprService.getSelectedItemPosition() == 0) {
                tax = 0;
            } else {
                tax = valueVehicle * 0.015;
            }
        }

        tvTax.setText("$" + Double.toString(tax));

    }
}