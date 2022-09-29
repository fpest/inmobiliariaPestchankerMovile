package com.ulp.inmobiliariafpestchanker.adapter;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ulp.inmobiliariafpestchanker.R;
import com.ulp.inmobiliariafpestchanker.modelo.Inmueble;
import com.ulp.inmobiliariafpestchanker.modelo.Inquilino;
import com.ulp.inmobiliariafpestchanker.modelo.Pago;
import com.ulp.inmobiliariafpestchanker.ui.inmueble.InmuebleDetalleViewModel;

import java.util.List;

public class PagoAdapter extends RecyclerView.Adapter<PagoAdapter.ViewHolder>{

    private Context context;
    private List<Pago> listaPagos;
    private List<Inmueble> listaInmuebles;
    private LayoutInflater layautInflater;
    private InmuebleDetalleViewModel mViewModel;

    public PagoAdapter(Context context, List<Pago> listaPagos, LayoutInflater layautInflater) {
        this.context = context;
        this.listaPagos = listaPagos;
        this.layautInflater = layautInflater;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layautInflater.inflate(R.layout.detallepago,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Pago pago= listaPagos.get(position);





     //     holder.ivInmueble.setImageResource(R.drawable.casa);
        holder.tvCodigoPago.setText(pago.getIdPago() +"");
        holder.tvNumeroPago.setText(pago.getNumero() +"");
        holder.tvCodigoContrato.setText(pago.getContrato().getIdContrato() +"");
        holder.tvImporte.setText(pago.getImporte() +"");
        holder.tvFechaPago.setText(pago.getFechaDePago() +"");







    }

    @Override
    public int getItemCount() {
        return listaPagos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private TextView tvCodigoPago;
        private TextView tvNumeroPago;
        private TextView tvCodigoContrato;
        private TextView tvImporte;
        private TextView tvFechaPago;

        public ViewHolder(@NonNull View interView){
            super(interView);
            tvCodigoPago = interView.findViewById(R.id.tvCodigoPago);
            tvNumeroPago = interView.findViewById(R.id.tvNumeroPago);
            tvCodigoContrato = interView.findViewById(R.id.tvCodigoContrato);
            tvImporte    = interView.findViewById(R.id.tvImporte);
            tvFechaPago = interView.findViewById(R.id.tvFechaPago);



        }



    }


}
