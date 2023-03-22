package sv.edu.utec.guia5_ejercicio1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

class AdaptadorPersonas extends ArrayAdapter<Personas> {
    ArrayList<Personas> listapersonas;
    Integer[] ImgPpersonas;
    AppCompatActivity appCompatActivity;
    AdaptadorPersonas(AppCompatActivity context, ArrayList<Personas> personas, Integer[] imgs) {
        super(context, R.layout.persona, personas);
        appCompatActivity = context;
        listapersonas = personas;
        ImgPpersonas = imgs;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {

        LayoutInflater inflater = appCompatActivity.getLayoutInflater();

        View item = inflater.inflate(R.layout.persona, null);
        TextView textView1 = item.findViewById(R.id.tvNombre);
        textView1.setText(listapersonas.get(position).getNombre());
        ImageView imageView1 = item.findViewById(R.id.imvFoto);
        imageView1.setImageResource(ImgPpersonas[position]);
        return(item);

    }
}

