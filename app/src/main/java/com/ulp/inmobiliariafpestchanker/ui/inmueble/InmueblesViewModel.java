package com.ulp.inmobiliariafpestchanker.ui.inmueble;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ulp.inmobiliariafpestchanker.modelo.Inmueble;
import com.ulp.inmobiliariafpestchanker.request.ApiClient;

import java.util.ArrayList;
import java.util.List;

public class InmueblesViewModel extends AndroidViewModel {

    private Context context;
    private MutableLiveData<Inmueble> inmuebleMutableLiveData;
    private MutableLiveData<List<Inmueble>> propiedadesMutableLiveData;
    private ApiClient api;

    //
    public InmueblesViewModel(@NonNull Application application) {
        super(application);
        this.context = application.getApplicationContext();
        this.api = ApiClient.getApi();
    }

    public MutableLiveData<List<Inmueble>> getPropiedadesMutableLiveData() {
        if (propiedadesMutableLiveData == null) {
            propiedadesMutableLiveData = new MutableLiveData<>();
        }
        listarPropiedades();
        return propiedadesMutableLiveData;
    }

    public void listarPropiedades() {
        List<Inmueble> inm = api.obtnerPropiedades();
        propiedadesMutableLiveData.setValue(inm);
    }

    public void setInmueble(Bundle b) {
        Inmueble i = (Inmueble) b.getSerializable("inmueble");
        inmuebleMutableLiveData.setValue(i);
    }
}

