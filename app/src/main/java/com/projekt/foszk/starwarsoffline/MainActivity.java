package com.projekt.foszk.starwarsoffline;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.OpenDrawer, R.string.CloseDrawer);

        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();

        //////////////////////////////////////////////
        // Play background music, Star Wars theme song service

        Intent intentMp = new Intent(this, MpService.class);
        startService(intentMp);

        loadFragment(new HomeFragment());

        //////////////////////////////////////////////
        // creating an instance of MediaPlayer, and set the volume

        MediaPlayer saberSound = MediaPlayer.create(this, R.raw.saber);
        saberSound.setVolume(0.15f, 0.15f);

        //////////////////////////////////////////////
        // Navigation Drawer

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.optHome){
                    saberSound.start();
                    loadFragment(new HomeFragment());
                    Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();

                } else if (id == R.id.optAbout) {
                    saberSound.start();
                    loadFragment(new AboutFragment());
                    Toast.makeText(MainActivity.this, "About", Toast.LENGTH_SHORT).show();

                } else if (id == R.id.optFilms) {
                    saberSound.start();
                    loadFragment(new FilmsFragment());
                    Toast.makeText(MainActivity.this, "Films", Toast.LENGTH_SHORT).show();

                } else if (id == R.id.optPeoples) {
                    saberSound.start();
                    loadFragment(new PeopleFragment());
                    Toast.makeText(MainActivity.this, "People", Toast.LENGTH_SHORT).show();

                } else if (id == R.id.optPlanets) {
                    saberSound.start();
                    loadFragment(new PlanetsFragment());
                    Toast.makeText(MainActivity.this, "Planets", Toast.LENGTH_SHORT).show();

                } else if (id == R.id.optSpecies) {
                    saberSound.start();
                    loadFragment(new SpeciesFragment());
                    Toast.makeText(MainActivity.this, "Species", Toast.LENGTH_SHORT).show();

                } else if (id == R.id.optStarships) {
                    saberSound.start();
                    loadFragment(new StarshipsFragment());
                    Toast.makeText(MainActivity.this, "Starships", Toast.LENGTH_SHORT).show();

                } else if (id == R.id.optVehicles) {
                    saberSound.start();
                    loadFragment(new VehiclesFragment());
                    Toast.makeText(MainActivity.this, "Vehicles", Toast.LENGTH_SHORT).show();
                }

                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }
}