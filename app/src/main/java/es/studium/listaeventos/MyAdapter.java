package es.studium.listaeventos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    Context context;
    int layout;
    ArrayList<String> elementos;
    public MyAdapter (Context context, int layout, ArrayList<String> names){
        this.context=context;
        this.layout=layout;
        this.elementos=names;
    }
    @Override
    public int getCount(){
        return this.elementos.size();
    }
    @Override
    public Object getItem(int position){
        return this.elementos.get(position);
    }
    @Override
    public long getItemId(int id){
        return id;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup){
        //Copiamos la vista
        View v= convertView;
        //Inflamos la vista con nuestro layout
        LayoutInflater layoutInflater= LayoutInflater.from(this.context);
        v=layoutInflater.inflate(R.layout.list_item, null);
        //valor actual segun posicion
        String currentName = elementos.get(position);
        //Referenciamos el elemento a modificar y lo rellenamos
        TextView textView= (TextView) v.findViewById(R.id.textView);
        textView.setText(currentName);
        //Devolvemos la vista inflada
        return v;
    }
}
