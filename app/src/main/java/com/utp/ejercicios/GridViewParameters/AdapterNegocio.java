package com.utp.ejercicios.GridViewParameters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.utp.ejercicios.R;

import java.util.ArrayList;

public class AdapterNegocio extends BaseAdapter {
    private Context context;
    private ArrayList<Negocio> listaNegocios;

    public AdapterNegocio(Context context, ArrayList<Negocio> listaNegocios) {
        this.context = context;
        this.listaNegocios = listaNegocios;
    }

    @Override
    public int getCount() {
        return listaNegocios.size();
    }

    @Override
    public Object getItem(int position) {
        return listaNegocios.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_listado, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.nombreCoche = convertView.findViewById(R.id.modelCoche);
            viewHolder.imagenCarrito = convertView.findViewById(R.id.comprarButton);
            viewHolder.imagenCoche = convertView.findViewById(R.id.imagenCoche);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Negocio negocio = listaNegocios.get(position);

        viewHolder.nombreCoche.setText(negocio.getNombre());
        viewHolder.imagenCarrito.setImageResource(negocio.getImagenCarrito());
        viewHolder.imagenCoche.setImageResource(negocio.getImagenCoche());

        viewHolder.imagenCarrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Acción al hacer clic en el botón de carrito de compras
                Toast.makeText(context, "Botón de carrito de compras presionado", Toast.LENGTH_SHORT).show();
            }
        });

        viewHolder.imagenCarrito.setBackgroundResource(R.drawable.button_selector);

        return convertView;
    }

    private static class ViewHolder {
        TextView nombreCoche;
        ImageView imagenCarrito;
        ImageView imagenCoche;
    }
}

