package com.oguz.coinfo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.oguz.coinfo.databinding.ActivityHomeBinding;
import com.oguz.coinfo.databinding.ActivityLoginBinding;
import com.oguz.coinfo.databinding.FragmentMarketBinding;

import java.util.Objects;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;
    FirebaseAuth auth;

    private BottomNavigationView bottomNavigationView;
    private NavController navController;

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        auth = FirebaseAuth.getInstance();

        replaceFragment(new HomeFragment());

        binding.materialToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.DrawerLayoutHome.openDrawer(GravityCompat.START);
            }
        });

        binding.navigationDrawer.setNavigationItemSelectedListener(item -> {

            item.setChecked(true);
            switch (item.getItemId()){
                case R.id.SettingsNav:
                    //Toast.makeText(this, "Settings Clicked", Toast.LENGTH_LONG).show();
                    replaceFragment(new SettingsFragment());
                    break;
                case R.id.HelpNav:
                    //Toast.makeText(this, "Help Clicked", Toast.LENGTH_LONG).show();
                    replaceFragment(new HelpFragment());
                    break;
                case R.id.AboutUsNav:
                    //Toast.makeText(this, "About Clicked", Toast.LENGTH_LONG).show();
                    replaceFragment(new AboutFragment());
                    break;
                case R.id.LogOutNav:
                    //Toast.makeText(this, "Logout Clicked", Toast.LENGTH_LONG).show();
                    auth.signOut();
                    Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                    startActivity(intent);


                    break;
                default:
                    return true;
            }

            binding.DrawerLayoutHome.closeDrawer(GravityCompat.START);
            return true;
        });

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.homeButton:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.chainsButton:
                    replaceFragment(new ChainFragment());
                    break;
                case R.id.marketsButton:
                    replaceFragment(new MarketFragment());
                    break;
            }

            return true;
        });
    }

    /*public boolean onNavigationItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case R.id.
        }


        return true;
    }*/

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}