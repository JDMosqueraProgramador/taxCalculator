package com.example.taxcalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class PropietyTaxActivity extends AppCompatActivity {

    int [] rangeMin;
    int [] rangeMax;
    double [] rate;

    EditText value;
    private Spinner typeSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propiety_tax);

        value  = (EditText) findViewById(R.id.ptxtValue);
        typeSpinner = (Spinner) findViewById(R.id.spinnerTypeHouse);
        rangeMax = new int[] {124150000,132299000,152306000,172315000,192322000,212330000,232338000,252345000,285691000,319039000,
        352384000,385730000,419077000,452423000,485769000,519116000,552462000,599147000,645832000,692515000,739202000,785885000,
        832570000,879255000,925940000,1092671000,1259404000,1426135000,1600622000,1600622001};

        rangeMin = new int[] {0,124150001,132299001,152306001,172315001,192322001,212330001,232338001,252345001,285691001,319039001,
                352384001,385730001,419077001,452423001,485769001,519116001,552462001,599147001,645832001,692515001,739202001,785885001,
                832570001,879255001,925940001,1092671001,1259404001,1426135001,1600622001};

        rate = new double []{5.5,5.6,5.7,5.8,5.9,6.0,6.1,6.2,6.3,6.4,6.5,6.6,6.8,7.0,7.2,7.4,7.6,7.8,8.0,8.2,8.4,8.6,8.8,9.0,9.2,
        9.5,9.9,10.3,10.8,11.3};

        ArrayList<String> typeProperty = new ArrayList<String>();
        typeProperty.add("Residencia");
        typeProperty.add("Comercial");
        typeProperty.add("Deposito o parqueadero");

        ArrayAdapter adpProperty = new ArrayAdapter(PropietyTaxActivity.this, android.R.layout.simple_spinner_dropdown_item,typeProperty);

        typeSpinner.setAdapter(adpProperty);
        typeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String element = (String) typeSpinner.getAdapter().getItem(position);
                Toast.makeText(PropietyTaxActivity.this,"Seleccionaste" + element, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void findValuePropierty(View view){
        int arrayIndex = typeSpinner.getSelectedItemPosition();
        double eigenValue = Double.parseDouble(value.getText().toString());
        double result = 0;

        switch (arrayIndex){

            case 0:


        }

    }
}