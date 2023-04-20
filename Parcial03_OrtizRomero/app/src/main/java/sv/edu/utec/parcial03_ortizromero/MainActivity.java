package sv.edu.utec.parcial03_ortizromero;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import sv.edu.utec.parcial03_ortizromero.clases.BuscarFragment;
import sv.edu.utec.parcial03_ortizromero.clases.CrearFragment;
import sv.edu.utec.parcial03_ortizromero.clases.EliminarFragment;
import sv.edu.utec.parcial03_ortizromero.clases.ModificarFragment;

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
                case R.id.nav_crear:
                    seleccionFrag = new CrearFragment();
                    break;
                case R.id.nav_buscar:
                    seleccionFrag = new BuscarFragment();
                    break;
                case R.id.nav_editar:
                    seleccionFrag = new ModificarFragment();
                    break;
                case R.id.nav_eliminar:
                    seleccionFrag = new EliminarFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentCont, seleccionFrag).commit();
            return true;
        }
    };

    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_configuraciones,menu);
        return true ;
    }

    public boolean onOptionsItemSelected(MenuItem items){
        switch (items.getItemId()){
            case R.id.nav_op1:
                Toast.makeText(getApplicationContext(), "Llene el campo de Nombre para buscar por nombre",Toast.LENGTH_LONG).show();
                return true;
            case R.id.nav_op2:
                Toast.makeText(getApplicationContext(), "Llene el campo de Nombre para buscar por apellido",Toast.LENGTH_LONG).show();
                return true;
            case R.id.nav_op3:
                Toast.makeText(getApplicationContext(), "Llene el campo de Nombre para buscar por telefono",Toast.LENGTH_LONG).show();
                return true;
            case R.id.nav_op4:
                Toast.makeText(getApplicationContext(), "Llene el campo de Nombre para buscar por correo",Toast.LENGTH_LONG).show();
                return true;
        }

        return super.onOptionsItemSelected(items);
    }

}