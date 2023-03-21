package sv.edu.utec.guia4_ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnValidar;EditText etvValor;TextView tvMensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnValidar=findViewById(R.id.btnValidar);
        etvValor=findViewById(R.id.edtNumero);
        tvMensaje=findViewById(R.id.txvMensaje);

        btnValidar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int valor;
                valor=Integer.parseInt(etvValor.getText().toString());

                if (Integer.toString(valor).length()<=3){
                    tvMensaje.setText("El numero tiene "+Integer.toString(valor).length()+" cifras");
                } else  {
                    tvMensaje.setText("ERROR: el numero tiene mas de 3 cifras");
                }
            }
        });
    }
}