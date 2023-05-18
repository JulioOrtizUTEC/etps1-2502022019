package sv.edu.utec.parcial04_2502022019.clases;

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
import androidx.fragment.app.Fragment;

import sv.edu.utec.parcial04_2502022019.Helper.AdminSQLiteOpenHelper;
import sv.edu.utec.parcial04_2502022019.R;

public class AgregarCliente extends Fragment {

    EditText edtIDCliente,edtNombresCliente, edtApellidosCliente,edtDireccionCliente,edtCiudadCliente;
    Button btnCrear, btnBuscar, btnModificar, btnEliminar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragmento_agregar_cliente,container,false);
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getContext(), "Parcial04",null,1);

        edtIDCliente = view.findViewById(R.id.edtIDVehiculo);
        edtNombresCliente = view.findViewById(R.id.edtMarcaV);
        edtApellidosCliente = view.findViewById(R.id.edtModeloV);
        edtDireccionCliente = view.findViewById(R.id.edtDireccionC);
        edtCiudadCliente = view.findViewById(R.id.edtCiudadC);

        //Crear
        btnCrear = view.findViewById(R.id.btnCrear);

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase bd = admin.getWritableDatabase();

                String nombres = edtNombresCliente.getText().toString();
                String apellidos = edtApellidosCliente.getText().toString();
                String direccion = edtDireccionCliente.getText().toString();
                String ciudad = edtCiudadCliente.getText().toString();

                ContentValues informacion = new ContentValues();
                informacion.put("sNombreCliente",nombres);
                informacion.put("sApellidosCliente",apellidos);
                informacion.put("sDireccionCliente",direccion);
                informacion.put("sCiudadCliente",ciudad);

                try{
                    bd.insert("MP_Clientes",null,informacion);
                    bd.close();
                    Toast.makeText(getContext(), "Se ha insertado el cliente",Toast.LENGTH_LONG).show();
                    edtNombresCliente.setText("");
                    edtApellidosCliente.setText("");
                    edtDireccionCliente.setText("");
                    edtCiudadCliente.setText("");
                }catch (Exception e){
                    Toast.makeText(getContext(), "Ha ocurrido un error al insertar el cliente: "+e,Toast.LENGTH_LONG).show();
                }
            }
        });

        //Modificar
        btnModificar = view.findViewById(R.id.btnModificar);

        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase bd = admin.getWritableDatabase();

                String nombres = edtNombresCliente.getText().toString();
                String apellidos = edtApellidosCliente.getText().toString();
                String direccion = edtDireccionCliente.getText().toString();
                String ciudad = edtCiudadCliente.getText().toString();
                String codigo = "";

                Cursor filas = bd.rawQuery("select ID_Cliente from MP_Clientes where sNombreCliente='"+nombres+"' or sApellidosCliente='"+apellidos+"' or sDireccionCliente='"
                        +direccion+"' or sCiudadCliente='"+ciudad+"'",null);
                if(filas.moveToFirst()){
                    codigo = filas.getString(0);
                }

                ContentValues informacion = new ContentValues();
                informacion.put("sNombreCliente",nombres);
                informacion.put("sApellidosCliente",apellidos);
                informacion.put("sDireccionCliente",direccion);
                informacion.put("sCiudadCliente",ciudad);

                try{
                    int cat = bd.update("MP_Clientes", informacion, "ID_Cliente="+codigo,null);
                    bd.close();
                    Toast.makeText(getContext(), "Se ha modificado el cliente",Toast.LENGTH_LONG).show();
                    edtNombresCliente.setText("");
                    edtApellidosCliente.setText("");
                    edtDireccionCliente.setText("");
                    edtCiudadCliente.setText("");
                }catch (Exception e){
                    Toast.makeText(getContext(), "Ha ocurrido un error al modificar el cliente: "+e,Toast.LENGTH_LONG).show();
                }
            }
        });

        //Buscar
        btnBuscar = view.findViewById(R.id.btnBuscar);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("Recycle")
            @Override
            public void onClick(View view) {
                SQLiteDatabase bd = admin.getWritableDatabase();

                String nombres = edtNombresCliente.getText().toString();
                String apellidos = edtApellidosCliente.getText().toString();
                String direccion = edtDireccionCliente.getText().toString();
                String ciudad = edtCiudadCliente.getText().toString();

                Cursor filas;


                filas = bd.rawQuery("select sNombreCliente, sApellidosCliente, sDireccionCliente, sCiudadCliente from MP_Clientes where sNombreCliente='"+nombres+"' or sApellidosCliente='"+apellidos+"' or sDireccionCliente='"
                        +direccion+"' or sCiudadCliente='"+ciudad+"'",null);
                if(filas.moveToFirst()){
                    edtNombresCliente.setText(filas.getString(0));
                    edtApellidosCliente.setText(filas.getString(1));
                }else{
                    edtDireccionCliente.setText(filas.getString(2));
                    edtCiudadCliente.setText(filas.getString(3));
                    Toast.makeText(getContext(), "No se ha encontrado el cliente",Toast.LENGTH_LONG).show();
                }
            }
        });

        //Eliminar
        btnEliminar = view.findViewById(R.id.btnEliminar);

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("Recycle")
            @Override
            public void onClick(View view) {
                SQLiteDatabase bd = admin.getWritableDatabase();

                String nombres = edtNombresCliente.getText().toString();
                String apellidos = edtApellidosCliente.getText().toString();
                String direccion = edtDireccionCliente.getText().toString();
                String ciudad = edtCiudadCliente.getText().toString();
                String codigo = "";

                Cursor filas = bd.rawQuery("select ID_Cliente from MP_Clientes where sNombreCliente='"+nombres+"' or sApellidosCliente='"+apellidos+"' or sDireccionCliente='"
                        +direccion+"' or sCiudadCliente='"+ciudad+"'",null);
                if(filas.moveToFirst()){
                    codigo = filas.getString(0);
                }

                try{
                    int cat = bd.delete("MP_Clientes", "ID_Cliente="+codigo,null);
                    bd.close();
                    Toast.makeText(getContext(), "Se ha eliminado el cliente",Toast.LENGTH_LONG).show();
                    edtNombresCliente.setText("");
                    edtApellidosCliente.setText("");
                    edtDireccionCliente.setText("");
                    edtCiudadCliente.setText("");
                }catch (Exception e){
                    Toast.makeText(getContext(), "Ha ocurrido un error al eliminar el cliente: "+e,Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }
}
