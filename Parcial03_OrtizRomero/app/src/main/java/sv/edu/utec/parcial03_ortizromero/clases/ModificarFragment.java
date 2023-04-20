package sv.edu.utec.parcial03_ortizromero.clases;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
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

public class ModificarFragment extends Fragment {

    EditText edtNombresContacto, edtApellidosContacto,edtTelefonoContacto,edtCorreoContacto;
    Button btnModificar;

    @SuppressLint("MissingInflatedId")
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmento_modificar,container,false);
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getContext(), "Parcial",null,1);

        edtNombresContacto = view.findViewById(R.id.edtNomC);
        edtApellidosContacto = view.findViewById(R.id.edtApeC);
        edtTelefonoContacto = view.findViewById(R.id.edtTelC);
        edtCorreoContacto = view.findViewById(R.id.edtCorreoC);

        btnModificar = view.findViewById(R.id.btnModificar);

        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase bd = admin.getWritableDatabase();

                String nombres = edtNombresContacto.getText().toString();
                String apellidos = edtApellidosContacto.getText().toString();
                String telefono = edtTelefonoContacto.getText().toString();
                String correo = edtCorreoContacto.getText().toString();
                String codigo = "";

                Cursor filas = bd.rawQuery("select codContacto from Contactos where NombresContacto='"+nombres+"' or ApellidosContacto='"+apellidos+"' or TelContacto='"
                        +telefono+"' or CorreoContacto='"+correo+"'",null);
                if(filas.moveToFirst()){
                    codigo = filas.getString(0);
                }

                ContentValues informacion = new ContentValues();
                informacion.put("NombresContacto",nombres);
                informacion.put("ApellidosContacto",apellidos);
                informacion.put("TelContacto",telefono);
                informacion.put("CorreoContacto",correo);

                try{
                    int cat = bd.update("Contactos", informacion, "codContacto="+codigo,null);
                    bd.close();
                    Toast.makeText(getContext(), "Se ha modificado el contacto",Toast.LENGTH_LONG).show();
                    edtNombresContacto.setText("");
                    edtApellidosContacto.setText("");
                    edtTelefonoContacto.setText("");
                    edtCorreoContacto.setText("");
                }catch (Exception e){
                    Toast.makeText(getContext(), "Ha ocurrido un error al modificar el contacto: "+e,Toast.LENGTH_LONG).show();
                }
            }
        });
        return view;
    }
}
