package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
private String mensaje;
private Integer precioFinal;
private TextView precioLabel;
private Integer precioLab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        precioFinal = 120;
        precioLabel = findViewById(R.id.precioLbl);

    }

    public void sendMessage(View view) {
        //usando el mensaje que se extrae se manda el intent
        mensaje =  extraerRecursos();
        mensaje = mensaje+ "\u0020" + "- El precio de la orden es: $"+precioFinal;
        Log.d("SecondActivity", mensaje);
        Uri uri = Uri.parse("https://wa.me/17089329187?text="+mensaje);
        Intent it = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(it);
    }
    private String extraerRecursos(){
        //Extraer color de pozole elegido
        RadioGroup radio = findViewById(R.id.radioColor);
        int radioSel = radio.getCheckedRadioButtonId();
        RadioButton radioBot = findViewById(radioSel);
        String color = radioBot.getText().toString();

        //Extraer tamano de pozole elegido
        RadioGroup radio2 = findViewById(R.id.radioTamano);
        int radioSel2 = radio2.getCheckedRadioButtonId();
        RadioButton radioBot2 = findViewById(radioSel2);
        String tamano = radioBot2.getText().toString();

        if(tamano.equals("Chico")){
            precioFinal = 120;

        } else if (tamano.equals("Mediano")) {
            precioFinal = 130;

        } else if (tamano.equals("Grande")) {
            precioFinal = 140;

        }
        //Comenzar el mensaje usando el texto predeterminado con la cantidad, color y tamano indicados
        EditText text = findViewById(R.id.cantidadEditT);
        String cant = text.getText().toString();
        String ordenParte2 = getResources().getString(R.string.ordenTxt2);
        mensaje = getResources().getString(R.string.ordenTxt);
        mensaje = mensaje + "\u0020"+ cant + "\u0020"+ ordenParte2;
        mensaje = mensaje + "\u0020" + color + "," + "\u0020"+ tamano + "\u0020" +"con:";

        //Extraer extras para el pozole
        CheckBox repollo = findViewById(R.id.repolloCheck);
        if(repollo.isChecked()){
           mensaje = mensaje + "\u0020"+ repollo.getText().toString();
        }

        CheckBox rabanos = findViewById(R.id.rabanosCheck);
        if(rabanos.isChecked()){
            mensaje = mensaje + "\u0020"+ "Rabanos";
            precioFinal= precioFinal+10;
        }

        CheckBox cebolla = findViewById(R.id.cebollaCheck);
        if(cebolla.isChecked()){
            mensaje = mensaje + "\u0020"+ cebolla.getText().toString();
        }

        CheckBox salsa = findViewById(R.id.salsaCheck);
        if(salsa.isChecked()){
            mensaje = mensaje + "\u0020"+ salsa.getText().toString();
        }
        Integer cantidad = Integer.parseInt(cant);
        precioFinal = precioFinal*cantidad;
        return(mensaje);
    }

    public void cambiarFoto(View view) {
        ImageView imagen = findViewById(R.id.pozoleIMG);
        imagen.setImageResource(R.drawable.pozverde);
    }

    public void cambiarFoto2(View view) {
        ImageView imagen = findViewById(R.id.pozoleIMG);
        imagen.setImageResource(R.drawable.pozrojo);
    }

    public void cambiarPrecio(View view) {
        CheckBox rabanos = findViewById(R.id.rabanosCheck);
        if(rabanos.isChecked()){
            precioLab= precioLab+10;
            precioLabel.setText("MX $"+precioLab+".00");
        }else if(!rabanos.isChecked()){
            precioLab= precioLab-10;
            precioLabel.setText("MX $"+precioLab+".00");
        }
    }

    //Cambiar precio depende del tamano si es chico
    public void cambiarPrecioLabel(View view) {
        precioLab = 120;
        CheckBox rabanos = findViewById(R.id.rabanosCheck);
        if(rabanos.isChecked()){
            precioLab= precioLab+10;
            precioLabel.setText("MX $"+precioLab+".00");
        }
        precioLabel.setText("MX $"+precioLab+".00");

    }
    //Cambiar precio depende del tamano si es med
    public void cambiarPrecioLabel2(View view) {
        precioLab = 130;
        CheckBox rabanos = findViewById(R.id.rabanosCheck);
        if(rabanos.isChecked()){
            precioLab= precioLab+10;
            precioLabel.setText("MX $"+precioLab+".00");
        }
        precioLabel.setText("MX $"+precioLab+".00");

    }
    //Cambiar precio depende del tamano si es grande
    public void cambiarPrecioLabel3(View view) {
        precioLab = 140;
        CheckBox rabanos = findViewById(R.id.rabanosCheck);
        if(rabanos.isChecked()){
            precioLab= precioLab+10;
            precioLabel.setText("MX $"+precioLab+".00");
        }
        precioLabel.setText("MX $"+precioLab+".00");

    }


}