package com.example.appapiconviewmodel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AppAdaptador extends RecyclerView.Adapter<AppAdaptador.ViewHolder> {

    private List<Usuario> mData;
    private LayoutInflater mInflater;

    AppAdaptador(Context context) {
        this.mInflater = LayoutInflater.from(context);
        mData = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.activity_app_adaptador, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.dni.setText(String.valueOf("\n" + "Id: " + mData.get(position).id));
        holder.nombre.setText(String.valueOf("Nombre: " + mData.get(position).nombre));
        holder.hombre.setText(String.valueOf("Hombre: " + mData.get(position).hombre));
        holder.edad.setText(String.valueOf("Edad: " + mData.get(position).edad + "\n"));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void addData(List<Usuario> info) {
        mData.addAll(info);
        notifyDataSetChanged();
    }

    Usuario getItem(int id) {
        return mData.get(id);
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView dni;
        TextView nombre;
        TextView hombre;
        TextView edad;

        public ViewHolder(View itemView) {
            super(itemView);
            dni=itemView.findViewById(R.id.txtId);
            nombre=itemView.findViewById(R.id.txtNombre);
            hombre=itemView.findViewById(R.id.txtHombre);
            edad=itemView.findViewById(R.id.txtEdad);
        }
    }
}