package sv.edu.utec.parcial02_2502022019;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class EmpleadosAdapter extends ArrayAdapter<Empleados> {

    private Context contexto;
    private List<Empleados> empleados;

    public EmpleadosAdapter(Context context, List<Empleados> empleados){
        super(context,R.layout.listado_empleados,empleados);
        this.contexto = context;
        this.empleados = empleados;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View view = convertView;

        if (view == null){
            LayoutInflater inflater = LayoutInflater.from(contexto);
            view = inflater.inflate(R.layout.listado_empleados,null);
        }

        Empleados empleado = empleados.get(position);

        TextView nombreEmpleado = view.findViewById(R.id.tvNombre);
        nombreEmpleado.setText(empleado.getNombre());

        TextView cargoEmpleado = view.findViewById(R.id.tvCargo);
        cargoEmpleado.setText(empleado.getCargo());

        TextView companiaEmpleado = view.findViewById(R.id.tvCompañia);
        companiaEmpleado.setText(empleado.getCompañia());

        ImageView avatarEmpleado = view.findViewById(R.id.imvAvatar);
        avatarEmpleado.setImageResource(empleado.getAvatar());

        return view;
    }
}
