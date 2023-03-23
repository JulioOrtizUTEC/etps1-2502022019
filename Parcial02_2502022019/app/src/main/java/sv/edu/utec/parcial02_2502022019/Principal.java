package sv.edu.utec.parcial02_2502022019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Principal extends AppCompatActivity {

    ListView lvlEmpleados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        lvlEmpleados = findViewById(R.id.lvlListaEmpleados);

        List<Empleados> empleados = new ArrayList<>();
        //Añadiendo a los empleados a la lista
        empleados.add(new Empleados("Alexander Pierrot","CEO","Insures S.O.",R.drawable.lead_photo_1));
        empleados.add(new Empleados("Carlos Lopez","Asistente","Hospital Blue",R.drawable.lead_photo_2));
        empleados.add(new Empleados("Sara Bonz","Directora de Marketing","Electrical Parts ltd",R.drawable.lead_photo_3));
        empleados.add(new Empleados("Liliana Clarence","Diseñadora de Producto","Creativa App",R.drawable.lead_photo_4));
        empleados.add(new Empleados("Benito Peralta","Supervisor de Ventas","Neumáticos Press",R.drawable.lead_photo_5));
        empleados.add(new Empleados("Juan Jaramillo","CEO","Banco Nacional",R.drawable.lead_photo_6));
        empleados.add(new Empleados("Christian Steps","CTO","Cooperativa Verde",R.drawable.lead_photo_7));
        empleados.add(new Empleados("Alexa Giraldo","Lead Programmer","Frutisofy",R.drawable.lead_photo_8));
        empleados.add(new Empleados("Linda Murillo","Directora de Marketing","Seguros Boliver",R.drawable.lead_photo_9));
        empleados.add(new Empleados("Lizeth Astrada","CEO","Concesionario Motolox",R.drawable.lead_photo_10));

        EmpleadosAdapter adapter = new EmpleadosAdapter(this, empleados);
        lvlEmpleados.setAdapter(adapter);
    }
}