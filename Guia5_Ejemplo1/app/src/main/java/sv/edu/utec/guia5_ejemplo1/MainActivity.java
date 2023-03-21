package sv.edu.utec.guia5_ejemplo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String []paises={"Costa Rica","El Salvadopr","Guatemala","Honduras","Nicaragua"};
    ListView lvstPais;
    Integer[]ImgPais={
            R.drawable.banderacr,
            R.drawable.banderaesa,
            R.drawable.banderaguatemala,
            R.drawable.banderahon,
            R.drawable.banderanic
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AdaptadorPais adaptador=new AdaptadorPais(this,paises,ImgPais);
        lvstPais=findViewById(R.id.listPaises);
        lvstPais.setAdapter(adaptador);
    }
}