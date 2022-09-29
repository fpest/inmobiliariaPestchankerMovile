package com.ulp.inmobiliariafpestchanker.ui.inmueble;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.navigation.Navigation;
import com.google.android.gms.maps.model.LatLng;
import com.ulp.inmobiliariafpestchanker.modelo.Inmueble;
import com.ulp.inmobiliariafpestchanker.request.ApiClient;
import com.ulp.inmobiliariafpestchanker.ui.inicio.LeerMapa;

import java.util.ArrayList;
import java.util.List;

public class InmuebleDetalleViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<Inmueble> inmuebleMutableLiveData;
    private ApiClient api;

    public InmuebleDetalleViewModel(@NonNull Application application) {
        super(application);
        this.context= application.getApplicationContext();
        this.api = ApiClient.getApi();
    }
    public LiveData<Inmueble> getMutableLeerInmueble(){
        if(inmuebleMutableLiveData==null){
            inmuebleMutableLiveData=new MutableLiveData<>();
        }
        return inmuebleMutableLiveData;
    }

    public void setInmueble(Bundle b) {
        Inmueble i = (Inmueble)b.getSerializable("inmueble");
     inmuebleMutableLiveData.setValue(i);
    }

    public LiveData<Inmueble> getMutableDetalleInmueble(){
        if(inmuebleMutableLiveData==null){
            inmuebleMutableLiveData = new MutableLiveData<>();
        }
        return inmuebleMutableLiveData;
    }


    public void combo(Boolean checked, String codigo) {
       ArrayList<Inmueble> pro= api.obtnerPropiedades();

        for(Inmueble inmueble:pro){
            int codigoBase = inmueble.getIdInmueble();
            int codigoNumero = Integer.parseInt(codigo);
            if(inmueble.getIdInmueble()==codigoNumero){
                inmueble.setEstado(checked);
                api.actualizarInmueble(inmueble);
            }
        }




        }

}