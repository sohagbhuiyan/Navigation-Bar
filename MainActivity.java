package com.example.navygationbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    Fragment fragment;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.id.tolbar);
        setSupportActionBar(toolbar);

        navigationView= findViewById(R.id.navg);
        drawerLayout =findViewById(R.id.drawerlayout);

        toggle=new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.menu_open,R.string.menu_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
        navigationView.setCheckedItem(R.id.optHome);
        navigationView.setNavigationItemSelectedListener (new NavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuitem) {
                switch (menuitem.getItemId()){
                    case R.id.optHome:
                        fragment=new Home_fragment();
                        break;
                    case R.id.optSetting:
                        fragment=new Setting_fragment();
                        break;
                    case R.id.optAccount:
                        fragment=new Call_fragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        } );

    }
}