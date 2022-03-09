package com.example.taxcalculator;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goTo(View view) {

        Class cls = null;


        switch(view.getId()) {
            case R.id.btnPropietyTax:
                cls = PropietyTaxActivity.class;
                break;

            case R.id.btnRetention:
                cls = RetentionActivity.class;
                break;

            case R.id.btnVehicule:
                //cls = RetentionActivity.class;
                break;
        }

        if(cls != null) {
            Intent intent = new Intent(this, cls);
            startActivity(intent);
        }

    }
}