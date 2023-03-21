package sv.edu.utec.guia5_ejemplo2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Personas> listapersonas;
    ListView lv1;
    Integer[]ImgPpersonas={
            R.drawable.alejandra,
            R.drawable.antonio,
            R.drawable.carla,
            R.drawable.carlos,
            R.drawable.cristina,
            R.drawable.elena,
            R.drawable.fatima,
            R.drawable.josue,
            R.drawable.julia,
            R.drawable.mario
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listapersonas = new ArrayList<Personas>();
        listapersonas.add(new Personas("alejandra", 'f'));
        listapersonas.add(new Personas("antonio", 'm'));
        listapersonas.add(new Personas("carla", 'f'));
        listapersonas.add(new Personas("carlos", 'm'));
        listapersonas.add(new Personas("cristina", 'f'));
        listapersonas.add(new Personas("elena", 'f'));
        listapersonas.add(new Personas("fatima", 'f'));
        listapersonas.add(new Personas("josue", 'm'));
        listapersonas.add(new Personas("julia", 'f'));
        listapersonas.add(new Personas("mario", 'm'));
        AdaptadorPersonas adaptador = new AdaptadorPersonas(this);
        lv1 = findViewById(R.id.lsvPersonas);
        lv1.setAdapter(adaptador);
    }
        class AdaptadorPersonas extends ArrayAdapter<Personas> {
            AppCompatActivity appCompatActivity;
            AdaptadorPersonas(AppCompatActivity context) {
                super(context, R.layout.personas, listapersonas);
                appCompatActivity = context;
            }
            public View getView(int position, View convertView, ViewGroup parent)
            {
                LayoutInflater inflater = appCompatActivity.getLayoutInflater();
                View item = inflater.inflate(R.layout.personas, null);
                TextView textView1 = item.findViewById(R.id.tvNombre);
                textView1.setText(listapersonas.get(position).getNombre());
                ImageView imageView1 = item.findViewById(R.id.imvFoto);
                imageView1.setImageResource(ImgPpersonas[position]);
                return(item);
            }
        }
}