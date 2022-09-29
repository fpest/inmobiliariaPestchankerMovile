package com.ulp.inmobiliariafpestchanker;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.ulp.inmobiliariafpestchanker.databinding.ActivityMainBinding;
import com.ulp.inmobiliariafpestchanker.request.ApiClient;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    private ImageView ivHeaderAvatar;
    private TextView tvHeaderNombreApellido;
    private TextView tvHeaderEmail;
    private ApiClient api= ApiClient.getApi();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);

       /*
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        */
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;




        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_inicio, R.id.nav_perfil, R.id.nav_perfil)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);

        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        View headerView = navigationView.getHeaderView(0);

        configuararHeader(headerView);


       // ivHeaderAvatar.setImageResource(R.drawable.juan);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    private void configuararHeader(View headerView){

        ivHeaderAvatar = headerView.findViewById(R.id.ivHeaderAvatar);
        ivHeaderAvatar = headerView.findViewById(R.id.ivHeaderAvatar);
        tvHeaderNombreApellido = headerView.findViewById(R.id.tvHeaderNombreApellido);
        tvHeaderEmail = headerView.findViewById(R.id.tvHeaderEmail);

        ivHeaderAvatar.setImageResource(api.obtenerUsuarioActual().getAvatar());
        tvHeaderNombreApellido.setText(api.obtenerUsuarioActual().getNombre() + ", " + api.obtenerUsuarioActual().getApellido());
        tvHeaderEmail.setText(api.obtenerUsuarioActual().getEmail());


    }



}