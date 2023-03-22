package sv.edu.utec.guia5_ejercicio2;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class FrutasAdapter extends ArrayAdapter<Frutas> {

    private Context contexto;
    private List<Frutas> frutas;

    public FrutasAdapter(Context context, List<Frutas> frutas){
        super(context,R.layout.lista_frutas, frutas);
        this.contexto = context;
        this.frutas = frutas;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;
        if (view == null){
            LayoutInflater inflater = LayoutInflater.from(contexto);
            view = inflater.inflate(R.layout.lista_frutas,null);
        }

        Frutas fruta = frutas.get(position);

        TextView nombreFruta = view.findViewById(R.id.tvFrutNom);
        nombreFruta.setText(fruta.getNombre());

        TextView descripcionFruta = view.findViewById(R.id.tvFrutDesc);
        descripcionFruta.setText(fruta.getDescripcion());

        return view;
    }
}
