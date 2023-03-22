package sv.edu.utec.guia5_ejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Personas> listapersonas;
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

        AdaptadorPersonas adaptador = new AdaptadorPersonas(this, listapersonas, ImgPpersonas);
        lv1 = findViewById(R.id.IsvPersonas);
        lv1.setAdapter(adaptador);
    }
}