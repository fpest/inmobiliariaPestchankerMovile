package com.ulp.inmobiliariafpestchanker.login;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ulp.inmobiliariafpestchanker.MainActivity;
import com.ulp.inmobiliariafpestchanker.modelo.Propietario;
import com.ulp.inmobiliariafpestchanker.request.ApiClient;

public class LoginViewModel extends AndroidViewModel {
    private MutableLiveData<String> error;
    private Context context;


    public LoginViewModel(@NonNull Application application) {
        super(application);
        this.context = application.getApplicationContext();

    }

    public LiveData<String> getErrorVisibility() {
        if (error == null) { error = new MutableLiveData<>(); }
        return error;
    }


    public void login(String email, String pass) {
        ApiClient api = ApiClient.getApi();
        Propietario p = api.login(email, pass);

        if (p != null) {
            //error.setValue("Usuario o Contraseña OK");
            Intent i = new Intent(context, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        } else {
            if (email.isEmpty() || pass.isEmpty())
                error.setValue("Los datos de Usuario y Contraseña deben estar cargados.");
            else {
                error.setValue("Usuario o Contraseña incorrecto.");
            }        }
    }
}
