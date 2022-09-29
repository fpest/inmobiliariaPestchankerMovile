package com.ulp.inmobiliariafpestchanker.ui.inmueble;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ulp.inmobiliariafpestchanker.R;
import com.ulp.inmobiliariafpestchanker.adapter.InmuebleAdapter;
import com.ulp.inmobiliariafpestchanker.databinding.FragmentInmueblesBinding;
import com.ulp.inmobiliariafpestchanker.modelo.Inmueble;
import com.ulp.inmobiliariafpestchanker.request.ApiClient;

import java.util.List;

public class InmueblesFragment extends Fragment {
    private RecyclerView recyclerViewInmueble;
    private ApiClient api = ApiClient.getApi();
    private InmueblesViewModel mInmViewModel;
    List<Inmueble> listaInmuebles;

    private FragmentInmueblesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        InmueblesViewModel mInmViewModel =
                new ViewModelProvider(this).get(InmueblesViewModel.class);

        binding = FragmentInmueblesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mInmViewModel.getPropiedadesMutableLiveData().observe(getViewLifecycleOwner(), new Observer<List<Inmueble>>() {


            @Override
            public void onChanged(List<Inmueble> inmuebles) {
                inicializarVista(root, inflater,inmuebles);
            }

        });
    return root;
    }

    public void inicializarVista(View view, LayoutInflater layoutInflater, List<Inmueble> listaInmuebles){

        recyclerViewInmueble = view.findViewById(R.id.recyclerViewInmuebles);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),2,GridLayoutManager.VERTICAL,false);
        recyclerViewInmueble.setLayoutManager(gridLayoutManager);
        InmuebleAdapter inmuebleAdapter = new InmuebleAdapter(getContext(),listaInmuebles,layoutInflater);
        recyclerViewInmueble.setAdapter(inmuebleAdapter);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}