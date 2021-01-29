package es.studium.listaeventos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView lista;
ArrayList<String> elementos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista=(ListView) findViewById(R.id.miLista);
        elementos = new ArrayList<String>();

        elementos.add("Almería");
        elementos.add("Cádiz");
        elementos.add("Córdoba");
        elementos.add("Granada");
        elementos.add("Huelva");
        elementos.add("Jaén");
        elementos.add("Málaga");
        elementos.add("Sevilla");

        //Crear adaptador
       // ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, elementos);
        MyAdapter myAdapter =  new MyAdapter(this, R.layout.list_item, elementos);
        //Asignar el adaptador a nuestro ListView
        lista.setAdapter(myAdapter);
        //Asignar un listener a cada elemento de la lista
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MainActivity.this,"Has Pulsado: " + elementos.get(position), Toast.LENGTH_LONG).show();
                Intent visorDetalles =new Intent(view.getContext(), Detalles.class);
                visorDetalles.putExtra("Provincia", elementos.get(position));
                startActivity(visorDetalles);
            }
        });
    }
}