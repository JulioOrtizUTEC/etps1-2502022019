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

public class AgregarVehiculo extends Fragment {

    EditText edtIDVehiculo,edtMarcaVehiculo, edtModeloVehiculo;
    Button btnCrear, btnBuscar, btnModificar, btnEliminar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragmento_agregar_vehiculos,container,false);
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getContext(), "Parcial",null,1);

        edtIDVehiculo = view.findViewById(R.id.edtIDVehiculo);
        edtMarcaVehiculo = view.findViewById(R.id.edtMarcaV);
        edtModeloVehiculo = view.findViewById(R.id.edtModeloV);

        //Crear
        btnCrear = view.findViewById(R.id.btnCrear);

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase bd = admin.getWritableDatabase();

                String Marca = edtMarcaVehiculo.getText().toString();
                String Modelo = edtModeloVehiculo.getText().toString();

                ContentValues informacion = new ContentValues();
                informacion.put("sMarca",Marca);
                informacion.put("sModelo",Modelo);

                try{
                    bd.insert("MP_Vehiculos",null,informacion);
                    bd.close();
                    Toast.makeText(getContext(), "Se ha insertado el vehiculo",Toast.LENGTH_LONG).show();
                    edtMarcaVehiculo.setText("");
                    edtModeloVehiculo.setText("");
                }catch (Exception e){
                    Toast.makeText(getContext(), "Ha ocurrido un error al insertar el vehiculo: "+e,Toast.LENGTH_LONG).show();
                }
            }
        });

        //Modificar
        btnModificar = view.findViewById(R.id.btnModificar);

        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase bd = admin.getWritableDatabase();

                String Marca = edtMarcaVehiculo.getText().toString();
                String Modelo = edtModeloVehiculo.getText().toString();
                String codigo = "";

                Cursor filas = bd.rawQuery("select ID_Vehiculo from MP_Vehiculos where sMarca='"+Marca+"' or sModelo='"+Modelo+"'",null);
                if(filas.moveToFirst()){
                    codigo = filas.getString(0);
                }

                ContentValues informacion = new ContentValues();
                informacion.put("sMarca",Marca);
                informacion.put("sModelo",Modelo);

                try{
                    int cat = bd.update("MP_Vehiculos", informacion, "ID_Vehiculo="+codigo,null);
                    bd.close();
                    Toast.makeText(getContext(), "Se ha modificado el vehiculo",Toast.LENGTH_LONG).show();
                    edtMarcaVehiculo.setText("");
                    edtModeloVehiculo.setText("");
                }catch (Exception e){
                    Toast.makeText(getContext(), "Ha ocurrido un error al modificar el vehiculo"+e,Toast.LENGTH_LONG).show();
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

                String Marca = edtMarcaVehiculo.getText().toString();
                String Modelo = edtModeloVehiculo.getText().toString();

                Cursor filas;

                filas = bd.rawQuery("select sMarca, sModelo from MP_Vehiculos where sMarca='"+Marca+"' or sModelo='"+Modelo+"'",null);
                if(filas.moveToFirst()){
                    edtMarcaVehiculo.setText(filas.getString(0));
                    edtModeloVehiculo.setText(filas.getString(1));
                }else{
                    Toast.makeText(getContext(), "No se ha encontrado el vehiculo",Toast.LENGTH_LONG).show();
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

                String Marca = edtMarcaVehiculo.getText().toString();
                String Modelo = edtModeloVehiculo.getText().toString();
                String codigo = "";

                Cursor filas = bd.rawQuery("select ID_Vehiculo from MP_Vehiculos where sMarca='"+Marca+"' or sModelo='"+Modelo+"'",null);
                if(filas.moveToFirst()){
                    codigo = filas.getString(0);
                }

                try{
                    int cat = bd.delete("MP_Clientes", "ID_Cliente="+codigo,null);
                    bd.close();
                    Toast.makeText(getContext(), "Se ha eliminado el vehiculo",Toast.LENGTH_LONG).show();
                    edtMarcaVehiculo.setText("");
                    edtModeloVehiculo.setText("");
                }catch (Exception e){
                    Toast.makeText(getContext(), "Ha ocurrido un error al eliminar el vehiculo: "+e,Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }

}
