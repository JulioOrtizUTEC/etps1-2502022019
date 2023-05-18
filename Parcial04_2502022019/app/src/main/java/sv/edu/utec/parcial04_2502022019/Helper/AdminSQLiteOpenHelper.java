package sv.edu.utec.parcial04_2502022019.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Creando la tabla MP_Clientes
        db.execSQL("CREATE TABLE MP_Clientes (ID_Cliente integer primary key autoincrement" +
                ", sNombreCliente text, sApellidosCliente text, sDireccionCliente text, sCiudadCliente text)");

        //Creando la tabla MP_Vehiculos
        db.execSQL("CREATE TABLE MP_Vehiculos (ID_Vehiculo integer primary key autoincrement" +
                ", sMarca text, sModelo text)");

        //Creando la tabla MP_ClienteVehiculo
        db.execSQL("CREATE TABLE MP_ClienteVehiculo (ID_Cliente integer" +
                ", ID_Vehiculo integer, sMatricula text, iKilometros text, FOREIGN KEY (ID_Cliente) REFERENCES MP_Clientes(ID_Cliente) "+
                ", FOREIGN KEY (ID_Vehiculo) REFERENCES MP_Vehiculos(ID_Vehiculo))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}