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

                txtBaseUVT.setText("La base UVT es de: " + Integer.toString(UVT[0]));
                txtPorcentajeRetencion.setText("El porcentaje de retencion es de : " + Double.toString(porcentajeRetencion[0] * 100) + "%");
                txtBaseMinimaPesos.setText("La base minima para este concepto es de: " + basePesos[0]);

                 price = Double.parseDouble(txtCantidad.getText().toString());

                if(price <= basePesos[0]){

                    Toast.makeText(getApplicationContext(),"El precio debe ser mayor a la base minima para calcular la retencion", Toast.LENGTH_LONG).show();
                    retencion = 0;
                    txtMensajeSalidaRetencion.setText("La retencion es de : " + retencion);
                }else{
                    retencion = price * porcentajeRetencion[0];
                    txtMensajeSalidaRetencion.setText("La retencion es de : " + retencion);
                }
                break;

            case 1:
                txtBaseUVT.setText("La base UVT es de: " + Integer.toString(UVT[1]));
                txtPorcentajeRetencion.setText("El porcentaje de retencion es de : " + Double.toString(porcentajeRetencion[1] * 100) + "%");
                txtBaseMinimaPesos.setText("La base minima para este concepto es de: " + basePesos[1]);

                 price = Double.parseDouble(txtCantidad.getText().toString());
                if(price <= basePesos[1]){

                    Toast.makeText(getApplicationContext(),"El precio debe ser mayor a la base minima para calcular la retencion", Toast.LENGTH_LONG).show();
                    retencion = 0;
                    txtMensajeSalidaRetencion.setText("La retencion es de : " + retencion);
                }else{
                    retencion = price * porcentajeRetencion[1];
                    txtMensajeSalidaRetencion.setText("La retencion es de : " + retencion);
                }
                break;

            case 2:
                txtBaseUVT.setText("La base UVT es de: " + Integer.toString(UVT[2]));
                txtPorcentajeRetencion.setText("El porcentaje de retencion es de : " + Double.toString(porcentajeRetencion[2] * 100) + "%");
                txtBaseMinimaPesos.setText("La base minima para este concepto es de: " + basePesos[2]);

                price = Double.parseDouble(txtCantidad.getText().toString());
                if(price <= basePesos[2]){

                    Toast.makeText(getApplicationContext(),"El precio debe ser mayor a la base minima para calcular la retencion", Toast.LENGTH_LONG).show();
                    retencion = 0;
                    txtMensajeSalidaRetencion.setText("La retencion es de : " + retencion);
                }else{
                    retencion = price * porcentajeRetencion[2];
                    txtMensajeSalidaRetencion.setText("La retencion es de : " + retencion);
                }

                break;
            case 3:

                txtBaseUVT.setText("La base UVT es de: " + Integer.toString(UVT[3]));
                txtPorcentajeRetencion.setText("El porcentaje de retencion es de : " + Double.toString(porcentajeRetencion[3] * 100) + "%");
                txtBaseMinimaPesos.setText("La base minima para este concepto es de: " + basePesos[2]);

                price = Double.parseDouble(txtCantidad.getText().toString());
                if(price <= basePesos[3]){

                    Toast.makeText(getApplicationContext(),"El precio debe ser mayor a la base minima para calcular la retencion", Toast.LENGTH_LONG).show();
                    retencion = 0;
                    txtMensajeSalidaRetencion.setText("La retencion es de : " + retencion);
                }else{
                    retencion = price * porcentajeRetencion[3];
                    txtMensajeSalidaRetencion.setText("La retencion es de : " + retencion);
                }

                break;
            case 4:

                txtBaseUVT.setText("La base UVT es de: " + Integer.toString(UVT[4]));
                txtPorcentajeRetencion.setText("El porcentaje de retencion es de : " + Double.toString(porcentajeRetencion[4] * 100) + "%");
                txtBaseMinimaPesos.setText("La base minima para este concepto es de: " + basePesos[4]);

                price = Double.parseDouble(txtCantidad.getText().toString());
                if(price <= basePesos[4]){

                    Toast.makeText(getApplicationContext(),"El precio debe ser mayor a la base minima para calcular la retencion", Toast.LENGTH_LONG).show();
                    retencion = 0;
                    txtMensajeSalidaRetencion.setText("La retencion es de : " + retencion);
                }else{
                    retencion = price * porcentajeRetencion[4];
                    txtMensajeSalidaRetencion.setText("La retencion es de : " + retencion);
                }
                break;
        }

    }
}