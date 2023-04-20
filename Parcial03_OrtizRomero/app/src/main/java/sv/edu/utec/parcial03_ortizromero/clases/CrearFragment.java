package sv.edu.utec.parcial03_ortizromero.clases;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
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

public class CrearFragment extends Fragment{

    EditText edtNombresContacto, edtApellidosContacto,edtTelefonoContacto,edtCorreoContacto;
    Button btnCrear;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragmento_crear,container,false);
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getContext(), "Parcial",null,1);

        edtNombresContacto = view.findViewById(R.id.edtNomC);
        edtApellidosContacto = view.findViewById(R.id.edtApeC);
        edtTelefonoContacto = view.findViewById(R.id.edtTelC);
        edtCorreoContacto = view.findViewById(R.id.edtCorreoC);

        btnCrear = view.findViewById(R.id.btnCrear);

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase bd = admin.getWritableDatabase();

                String nombres = edtNombresContacto.getText().toString();
                String apellidos = edtApellidosContacto.getText().toString();
                String telefono = edtTelefonoContacto.getText().toString();
                String correo = edtCorreoContacto.getText().toString();

                ContentValues informacion = new ContentValues();
                informacion.put("NombresContacto",nombres);
                informacion.put("ApellidosContacto",apellidos);
                informacion.put("TelContacto",telefono);
                informacion.put("CorreoContacto",correo);

                try{
                    bd.insert("Contactos",null,informacion);
                    bd.close();
                    Toast.makeText(getContext(), "Se ha insertado el contacto",Toast.LENGTH_LONG).show();
                    edtNombresContacto.setText("");
                    edtApellidosContacto.setText("");
                    edtTelefonoContacto.setText("");
                    edtCorreoContacto.setText("");
                }catch (Exception e){
                    Toast.makeText(getContext(), "Ha ocurrido un error al insertar el contacto: "+e,Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }
}