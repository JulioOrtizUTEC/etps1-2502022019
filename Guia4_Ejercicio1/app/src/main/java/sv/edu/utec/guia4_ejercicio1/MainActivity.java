package sv.edu.utec.guia4_ejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
                if (valor>0){
                    tvMensaje.setText("El numero el positivo");
                } else if (valor<0) {
                    tvMensaje.setText("El numero el negativo");
                }
            }
        });
    }
}