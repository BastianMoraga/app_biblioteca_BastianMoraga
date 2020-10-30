package com.example.app_biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progress;
    private Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progress = (ProgressBar)findViewById(R.id.pb);
        progress.setVisibility(View.INVISIBLE);

        boton = (Button)findViewById(R.id.btnLogin);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Task().execute();
            }
        });
    }

    class Task extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            progress.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings) {
            for(int i = 0; i <= 10; i++)
            {
                try{
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            progress.setVisibility(View.INVISIBLE);

            Intent i = new Intent(getBaseContext(), menu_act.class);
            startActivity(i);
        }
    }

    public void github(View view)
    {
        ArrayList<String> productos = new ArrayList<String>();
        productos.add("Farenheith");
        productos.add("Revival");
        productos.add("El Alquimista");
        productos.add("El Poder");
        productos.add("Despertar");

        Intent i = new Intent(this, github_act.class);

        i.putExtra("listaProducto", productos);

        startActivity(i);
    }
}