package sv.edu.utec.guia5_ejercicio3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView lstPaises;
ArrayAdapter<CharSequence> adapatador;
ArrayAdapter adaptadores;
    ArrayList<String> listaPaises;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstPaises =findViewById(R.id.lvlistaPaises);


//llenado desde un array list
        listaPaises = new ArrayList<>();
        listaPaises.add("El Salvador");
        listaPaises.add("Guatemala");
        listaPaises.add("Honduras");
        listaPaises.add("Nicaragua");
        listaPaises.add("Costarica");
        listaPaises.add("Panama");
        listaPaises.add("Belice");


       adaptadores= new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaPaises);

        lstPaises.setAdapter(adaptadores);

        lstPaises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Toast.makeText(parent.getContext(),"Selecciono "+parent.getItemAtPosition(position).toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });




    }
}