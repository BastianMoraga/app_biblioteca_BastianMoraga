package com.example.app_biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import Clases.Productos;

public class github_act extends AppCompatActivity {

    private Spinner spinner;
    private TextView opcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github_act);

        spinner = (Spinner)findViewById(R.id.sp);
        opcion = (TextView)findViewById(R.id.txtOpcion);

        ArrayList<String> listaProducto = (ArrayList<String>) getIntent().getSerializableExtra("listaProducto");
        ArrayAdapter<String> adapt = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaProducto);

        spinner.setAdapter(adapt);
    }

    public void ver(View view)
    {
        String producto = spinner.getSelectedItem().toString();

        Productos productos = new Productos();

        if(producto.equals("Farenheith"))
        {
            opcion.setText("El valor de Farenheith es: " + productos.getFarenheith());
        }
        if(producto.equals("Revival"))
        {
            opcion.setText("El valor de Revival es: " + productos.getRevival());
        }
        if (producto.equals("El Alquimista"))
        {
            opcion.setText("El valor de El Alquimista es: " + productos.getElAlquimista());
        }
    }
}