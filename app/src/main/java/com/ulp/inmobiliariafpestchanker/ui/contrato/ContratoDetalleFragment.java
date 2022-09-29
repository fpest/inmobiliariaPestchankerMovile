package com.ulp.inmobiliariafpestchanker.ui.contrato;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ulp.inmobiliariafpestchanker.R;
import com.ulp.inmobiliariafpestchanker.databinding.FragmentContratoDetalleBinding;
import com.ulp.inmobiliariafpestchanker.databinding.FragmentInmuebleDetalleBinding;
import com.ulp.inmobiliariafpestchanker.databinding.FragmentInquilinoDetalleBinding;
import com.ulp.inmobiliariafpestchanker.modelo.Contrato;
import com.ulp.inmobiliariafpestchanker.modelo.Inmueble;
import com.ulp.inmobiliariafpestchanker.modelo.Inquilino;
import com.ulp.inmobiliariafpestchanker.ui.pago.PagosViewModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class ContratoDetalleFragment extends Fragment {


    private ContratoDetalleViewModel mViewModel;
    private PagosViewModel pViewModel;
    private FragmentContratoDetalleBinding binding;
    private Contrato cont;


    public static ContratoDetalleFragment newInstance() {
        return new ContratoDetalleFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mViewModel = new ViewModelProvider(this).get(ContratoDetalleViewModel.class);
        binding = FragmentContratoDetalleBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        mViewModel.getMutableDetalleContrato().observe(getViewLifecycleOwner(), new Observer<Contrato>() {
            @Override
            public void onChanged(Contrato i) {
                // TODO: cargar datos en las vistas
                binding.tvCodigo.setText(i.getIdContrato() + "");
                binding.tvFechaInicio.setText(i.getFechaInicio() + "");
                binding.tvFechaFinalizacion.setText(i.getFechaFin() + "");
                binding.tvMontoAlquiler.setText(String.valueOf(i.getMontoAlquiler() + ""));
                binding.tvInquilino.setText(i.getInquilino().getApellido() + ", " + i.getInquilino().getNombre());
                binding.tvDireccionInmueble.setText(i.getInmueble().getDireccion() + " "         );

                cont = i;
                Button btPagos = binding.getRoot().findViewById(R.id.btPagos);
                TextView tvInmueble = binding.getRoot().findViewById(R.id.tvCodigo);
                TextView tvContrato = binding.getRoot().findViewById(R.id.tvCodigoContrato);

                btPagos.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        Bundle bundle = new Bundle();
                        bundle.putSerializable("contrato", i );
                        Navigation.findNavController(v).navigate(R.id.pagosFragment,bundle);




                    }
                });

            }

        });


/*
        Button btPagos = binding.getRoot().findViewById(R.id.btPagos);
        TextView tvInmueble = binding.getRoot().findViewById(R.id.tvCodigo);
        TextView tvContrato = binding.getRoot().findViewById(R.id.tvCodigoContrato);

        btPagos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                pViewModel.listarPagos(cont);

            }
        });


*/


        Bundle bb = getArguments();
        mViewModel.setInmueble(bb);
        return root;





    }
}