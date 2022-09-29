package com.ulp.inmobiliariafpestchanker.ui.perfil;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.ulp.inmobiliariafpestchanker.modelo.Propietario;
import com.ulp.inmobiliariafpestchanker.request.ApiClient;


public class PerfilViewModel extends AndroidViewModel {

    private Context context;
    private MutableLiveData<Propietario> mPropietario;
    private MutableLiveData<Boolean> mEditEnabled;
    private MutableLiveData<String> mButtonText;
    private ApiClient api= ApiClient.getApi();

    public PerfilViewModel(@NonNull Application application) {
        super(application);
        this.context= application.getApplicationContext();

    }
    public LiveData<Propietario> getMutablePropietario(){
        if(mPropietario==null){
            mPropietario=new MutableLiveData<>();
        }
        return mPropietario;
    }
    public LiveData<String> getMutableButtonText(){
        if(mButtonText==null){
            mButtonText=new MutableLiveData<>();
        }
        return mButtonText;
    }
    public LiveData<Boolean> getMutableEditEnabled(){
        if(mEditEnabled==null){
            mEditEnabled=new MutableLiveData<>();
        }
        return mEditEnabled;
    }




    public void ObtenerUsuario(){
        Propietario p= api.obtenerUsuarioActual();
        mPropietario.setValue(p);
    }
    public void EditarGuardar(String textoBoton, Propietario p){

        if (textoBoton.equals("EDITAR")){
            mButtonText.setValue("GUARDAR");
            mEditEnabled.setValue(true);
        }else{
            mButtonText.setValue("EDITAR");
            api.actualizarPerfil(p);
            mEditEnabled.setValue(false);
        }

    }



}