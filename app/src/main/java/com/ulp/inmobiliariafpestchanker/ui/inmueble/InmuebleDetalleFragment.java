package com.ulp.inmobiliariafpestchanker.ui.inmueble;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ulp.inmobiliariafpestchanker.databinding.FragmentInmuebleDetalleBinding;
import com.ulp.inmobiliariafpestchanker.modelo.Inmueble;


public class InmuebleDetalleFragment extends Fragment {


    private InmuebleDetalleViewModel mViewModel;
    private FragmentInmuebleDetalleBinding binding;


    public static InmuebleDetalleFragment newInstance() {
        return new InmuebleDetalleFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mViewModel = new ViewModelProvider(this).get(InmuebleDetalleViewModel.class);
        binding = FragmentInmuebleDetalleBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        mViewModel.getMutableDetalleInmueble().observe(getViewLifecycleOwner(), new Observer<Inmueble>() {
            @Override
            public void onChanged(Inmueble i) {
                // TODO: cargar datos en las vistas
                binding.tvDireccion.setText(i.getDireccion() + "");
                binding.tvPrecio.setText(String.valueOf(i.getPrecio() + ""));
                binding.tvUso.setText(i.getTipo() + "");
                binding.tvCodigo.setText(i.getIdInmueble() + "");
                binding.tvAmbientes.setText(String.valueOf(i.getAmbientes() + ""));
                binding.tvPropietario.setText(i.getPropietario().getNombre() + " " + i.getPropietario().getApellido());

                binding.cbDisponible.setChecked(i.isEstado());

                Glide.with(root.getContext())
                        .load(i.getImagen())
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(binding.ivPropiedad);



                binding.cbDisponible.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        mViewModel.combo(binding.cbDisponible.isChecked(), binding.tvCodigo.getText().toString());
                    }
                });


            }

        });


        Bundle bb = getArguments();
        mViewModel.setInmueble(bb);
        return root;





    }
}