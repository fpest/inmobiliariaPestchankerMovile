package com.ulp.inmobiliariafpestchanker.ui.contrato   ;

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
import com.ulp.inmobiliariafpestchanker.modelo.Contrato;
import com.ulp.inmobiliariafpestchanker.modelo.Inmueble;
import com.ulp.inmobiliariafpestchanker.modelo.Inquilino;
import com.ulp.inmobiliariafpestchanker.request.ApiClient;
import com.ulp.inmobiliariafpestchanker.ui.inicio.LeerMapa;

import java.util.ArrayList;
import java.util.List;

public class ContratoDetalleViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<Contrato> contratoMutableLiveData;
    private ApiClient api;

    public ContratoDetalleViewModel(@NonNull Application application) {
        super(application);
        this.context= application.getApplicationContext();
        this.api = ApiClient.getApi();
    }
    public LiveData<Contrato> getMutableLeerContrato(){
        if(contratoMutableLiveData==null){
            contratoMutableLiveData=new MutableLiveData<>();
        }
        return contratoMutableLiveData;
    }

    public void setInmueble(Bundle b) {
        Inmueble i = (Inmueble) b.getSerializable("inmueble");
        Contrato contrato = api.obtenerContratoVigente(i);


        contratoMutableLiveData.setValue(contrato);
    }

    public LiveData<Contrato> getMutableDetalleContrato(){
        if(contratoMutableLiveData==null){
            contratoMutableLiveData = new MutableLiveData<>();
        }
        return contratoMutableLiveData;
    }



}