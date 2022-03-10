package com.example.taxcalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class RetentionActivity extends AppCompatActivity {

    private Spinner spinnerRetention;
    private TextView txtBaseUVT;
    private TextView txtBaseMinimaPesos;
    private TextView txtPorcentajeRetencion;
    private TextView txtMensajeSalidaRetencion;
    private EditText txtCantidad;
    public int [] UVT;
    public int [] basePesos;
    public double [] porcentajeRetencion;
    private double price;
    private double retencion = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retention);

        spinnerRetention = (Spinner) findViewById(R.id.spinnerRetentionConcept);

        String [] concepts = {"Compras generales (declarantes)","Compras generales (no declarantes)",
                "Compras de bienes o productos agrícolas o pecuarios sin procesamiento industrial",
        "Servicios de transporte de carga","Contratos de construcción y urbanización."};

        UVT = new int[]{27,27,92,4,27};

        basePesos = new int[]{1026000,1026000,3496000,152000,1026000};

        porcentajeRetencion = new double[] {0.025,0.035,0.015,0.01,0.02};

        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,concepts);

        spinnerRetention.setAdapter(adapter);

        txtBaseUVT = (TextView) findViewById(R.id.txtBaseUVT);
        txtBaseMinimaPesos = (TextView) findViewById(R.id.txtBaseMinimaPesos);
        txtPorcentajeRetencion = (TextView) findViewById(R.id.txtPorcentajeRetencion);
        txtCantidad = (EditText) findViewById((R.id.txtNumberPrice));
        txtMensajeSalidaRetencion = (TextView) findViewById(R.id.txtMensajeSalidaRetencion);
    }


    public void calculateRetention(View view){

        int indice = spinnerRetention.getSelectedItemPosition();

        switch (indice){
            case 0:
                calculateRetention(0);
                break;

            case 1:
                calculateRetention(1);
                break;


            case 2:
                calculateRetention(2);
                break;
            case 3:

                calculateRetention(3);
                break;
            case 4:

                calculateRetention(4);
                break;
        }

    }

    public void calculateRetention(int indice){

        txtBaseUVT.setText("La base UVT es de: " + Integer.toString(UVT[indice]));
        txtPorcentajeRetencion.setText("El porcentaje de retencion es de : " + Double.toString(porcentajeRetencion[indice] * 100) + "%");
        txtBaseMinimaPesos.setText("La base minima para este concepto es de: " + basePesos[indice]);
        try {
            price = Double.parseDouble(txtCantidad.getText().toString());

            if(price <= basePesos[indice]){

                Toast.makeText(getApplicationContext(),"El precio debe ser mayor a la base minima para calcular la retencion", Toast.LENGTH_LONG).show();
                retencion = 0;
                txtMensajeSalidaRetencion.setText("La retencion es de : " + retencion);
            }else{
                retencion = price * porcentajeRetencion[4];
                txtMensajeSalidaRetencion.setText("La retencion es de : " + retencion);
            }

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El valor agregado es incorrecto, por favor ingrese un valor valido", Toast.LENGTH_LONG).show();
        }


    }
}