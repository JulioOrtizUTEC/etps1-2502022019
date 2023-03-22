package sv.edu.utec.guia5_ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText edtNom, edtDesc;
    ListView lvlFrutas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvlFrutas = findViewById(R.id.lvlListaFrutas);

        List<Frutas> frutas = new ArrayList<>();
        //Se añade la fruta a la vista
        frutas.add(new Frutas("Arandanos","Esta fruta pertenece a las bayas"));
        frutas.add(new Frutas("Frambuesas","Esta fruta pertenece a las bayas"));
        frutas.add(new Frutas("Fresa","Esta fruta pertenece a las bayas"));
        frutas.add(new Frutas("Limón","Esta fruta pertenece a los citricos"));
        frutas.add(new Frutas("Mandarína","Esta fruta pertenece a los citricos"));
        frutas.add(new Frutas("Naranja","Esta fruta pertenece a los citricos"));
        frutas.add(new Frutas("Melón","Esta fruta pertenece a las cucurbitáceas"));
        frutas.add(new Frutas("Sandía","Esta fruta pertenece a las cucurbitáceas"));
        frutas.add(new Frutas("Aguacate","Es una fruta exótica"));
        frutas.add(new Frutas("Carambola","Es una fruta exótica"));
        frutas.add(new Frutas("Coco","Es una fruta exótica"));
        frutas.add(new Frutas("Kiwi","Es una fruta exótica"));
        frutas.add(new Frutas("Mango","Es una fruta exótica"));
        frutas.add(new Frutas("Papaya","Es una fruta exótica"));
        frutas.add(new Frutas("Piña","Es una fruta exótica"));
        frutas.add(new Frutas("Platano","Es una fruta exótica"));
        frutas.add(new Frutas("Cereza","Es una fruta dulce"));
        frutas.add(new Frutas("Ciruela","Es una fruta dulce"));
        frutas.add(new Frutas("Manzana","Es una fruta dulce"));
        frutas.add(new Frutas("Higo","Es una fruta dulce"));
        frutas.add(new Frutas("Melocotón","Es una fruta dulce"));
        frutas.add(new Frutas("Uva","Es una fruta dulce"));
        frutas.add(new Frutas("Pera","Es una fruta dulce"));
        frutas.add(new Frutas("Nispero","Pertenece a los frutos secos"));
        frutas.add(new Frutas("Almendra","Pertenece a los frutos secos"));

        FrutasAdapter adapter = new FrutasAdapter(this, frutas);
        lvlFrutas.setAdapter(adapter);

    }
}