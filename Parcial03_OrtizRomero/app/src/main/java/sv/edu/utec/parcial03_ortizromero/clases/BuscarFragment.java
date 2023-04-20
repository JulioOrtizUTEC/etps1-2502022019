package sv.edu.utec.parcial03_ortizromero.clases;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import sv.edu.utec.parcial03_ortizromero.Helper.AdminSQLiteOpenHelper;
import sv.edu.utec.parcial03_ortizromero.R;

public class BuscarFragment extends Fragment {

    EditText edtNombresContacto, edtApellidosContacto,edtTelefonoContacto,edtCorreoContacto;
    Button btnBuscar;
    String opBuscar= "Nombre";

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmento_buscar,container,false);
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getContext(), "Parcial",null,1);

        edtNombresContacto = view.findViewById(R.id.edtNomC);
        edtApellidosContacto = view.findViewById(R.id.edtApeC);
        edtTelefonoContacto = view.findViewById(R.id.edtTelC);
        edtCorreoContacto = view.findViewById(R.id.edtCorreoC);

        btnBuscar = view.findViewById(R.id.btnBuscar);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("Recycle")
            @Override
            public void onClick(View view) {
                SQLiteDatabase bd = admin.getWritableDatabase();

                String nombres = edtNombresContacto.getText().toString();
                String apellidos = edtApellidosContacto.getText().toString();
                String telefono = edtTelefonoContacto.getText().toString();
                String correo = edtCorreoContacto.getText().toString();

                Cursor filas;


                    filas = bd.rawQuery("select NombresContacto, ApellidosContacto, TelContacto, CorreoContacto from Contactos where NombresContacto='"+nombres+"' or ApellidosContacto='"+apellidos+"' or TelContacto='"
                            +telefono+"' or CorreoContacto='"+correo+"'",null);
                    if(filas.moveToFirst()){
                        edtNombresContacto.setText(filas.getString(0));
                        edtApellidosContacto.setText(filas.getString(1));
                    }else{
                        edtTelefonoContacto.setText(filas.getString(2));
                        edtCorreoContacto.setText(filas.getString(3));
                        Toast.makeText(getContext(), "No se ha encontrado el contacto",Toast.LENGTH_LONG).show();
                    }
            }
        });

        return view;
    }
}

