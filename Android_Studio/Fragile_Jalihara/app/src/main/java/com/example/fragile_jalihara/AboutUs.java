package com.example.fragile_jalihara;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class AboutUs extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener, SelectListener {

    private DrawerLayout drawerLayout;
    Button callAboutUs;
    Button callContactUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        //navbar menu
        Toolbar toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.nav_home:
                        startActivity(new Intent(AboutUs.this, HomePage.class));
                        return true;
                    case R.id.nav_aboutus:
                        startActivity(new Intent(AboutUs.this, AboutUs.class));
                        return true;
                    case R.id.nav_ticket:
                        startActivity(new Intent(AboutUs.this, TicketCatalog.class));
                        return true;
                    case R.id.nav_logout:
                        startActivity(new Intent(AboutUs.this, LoginPage.class));
                        return true;
                }
                return false;
            }
        });

        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();
        // end Navbar Menu

        // Tab layout
//        TabLayout tabLayout = findViewById(R.id.tabLayout);
//        ViewPager2 viewPager2 = findViewById(R.id.pager);
//
//        AdapterAboutUs adapterAboutUs = new AdapterAboutUs(getSupportFragmentManager(), getLifecycle());
//        viewPager2.setAdapter(adapterAboutUs);
//
//        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
//            if ((position+1)==1){
//                tab.setText("About Us");
//            } else{
//                tab.setText("Contact Us");
//            }
//        }).attach();

            ImageView ticketIcon;
            ticketIcon = findViewById(R.id.ticketIcon);
            ticketIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(AboutUs.this, TicketCatalog.class));
                }
            });

            initial();
            //AboutUs Fragment
            callAboutUs = findViewById(R.id.callAboutUs);
            callAboutUs.setOnClickListener(this);

            callContactUs = findViewById(R.id.callContactUs);
            callContactUs.setOnClickListener(this);
    }

    @Override
    public void onItemClicked(HomePage.ShowModel showModel) {

    }

    @Override
    public void onItemClickedCatalog(TicketCatalog.ShowModel showModel) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.callAboutUs){
            callAboutUs.setBackgroundColor(getResources().getColor(R.color.pink));
            callAboutUs.setTextColor(getResources().getColor(R.color.white));
            callContactUs.setBackgroundColor(getResources().getColor(R.color.white));
            callContactUs.setTextColor(getResources().getColor(R.color.black));
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new aboutUsFragment()).commit();
        } else if (view.getId()==R.id.callContactUs) {
            callContactUs.setBackgroundColor(getResources().getColor(R.color.pink));
            callContactUs.setTextColor(getResources().getColor(R.color.white));
            callAboutUs.setBackgroundColor(getResources().getColor(R.color.white));
            callAboutUs.setTextColor(getResources().getColor(R.color.black));
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new contacUsFragment()).commit();
        }
    }

    public void initial(){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new aboutUsFragment()).commit();
    }
}