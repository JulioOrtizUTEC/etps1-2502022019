package sv.edu.utec.parcial04_2502022019;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import sv.edu.utec.parcial04_2502022019.clases.AgregarCliente;
import sv.edu.utec.parcial04_2502022019.clases.AgregarClienteVehiculo;
import sv.edu.utec.parcial04_2502022019.clases.AgregarVehiculo;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView btnNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNav = findViewById(R.id.btnNav);

        btnNav.setOnNavigationItemSelectedListener((BottomNavigationView.OnNavigationItemSelectedListener) navaListener);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navaListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment seleccionFrag = null;

            switch (item.getItemId()) {
                case R.id.nav_cliente:
                    seleccionFrag = new AgregarCliente();
                    break;
                case R.id.nav_vehiculo:
                    seleccionFrag = new AgregarVehiculo();
                    break;
                case R.id.nav_cliente_vehiculo:
                    seleccionFrag = new AgregarClienteVehiculo();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentCont, seleccionFrag).commit();
            return true;
        }
    };

}