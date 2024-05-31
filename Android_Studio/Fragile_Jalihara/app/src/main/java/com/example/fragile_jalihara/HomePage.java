package com.example.fragile_jalihara;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.fragile_jalihara.databinding.ActivityHomePageBinding;
import com.example.fragile_jalihara.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, SelectListener  {

    private DrawerLayout drawerLayout;

//    private NavigationView navigationView;
    private List<ShowModel> showList = new ArrayList<>();
    private ShowAdapter sAdapter;
    private ShowAdapterTwo showAdapterTwo;

    //binding
    ActivityHomePageBinding binding;
    //binding end

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Navbar menu
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Toolbar toolbar = findViewById(R.id.toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.nav_home:
                        startActivity(new Intent(HomePage.this, HomePage.class));
                        return true;
                    case R.id.nav_aboutus:
                        startActivity(new Intent(HomePage.this, AboutUs.class));
                        return true;
                    case R.id.nav_ticket:
                        startActivity(new Intent(HomePage.this, TicketCatalog.class));
                        return true;
                    case R.id.nav_logout:
                        startActivity(new Intent(HomePage.this, LoginPage.class));
                        return true;
                }
                return false;
            }
        });
        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();
//        View home = findViewById(R.id.nav_home);

        // end Navbar Menu

        // set text to global name user
        TextView testing = findViewById(R.id.testing);
        GlobalClass globalClass = (GlobalClass) getApplicationContext();
        testing.setText(globalClass.getUsername() + ' ' + '!');
        // end set text to global name user

        // Carousel
        ImageSlider imageSlider = findViewById(R.id.imageSlider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.banner1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.banner2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.banner1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.banner2, ScaleTypes.FIT));
        imageSlider.setImageList(slideModels, ScaleTypes.FIT);
        // end Carousel

        // category clicked -theatre
        View theatre;
        theatre = findViewById(R.id.theatre);
        theatre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                globalClass.setCategory("theatre");
                startActivity(new Intent(HomePage.this, TicketCatalog.class));
            }
        });

        // category clicked -magic
        View magic;
        magic = findViewById(R.id.magic);
        magic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                globalClass.setCategory("magic");
                startActivity(new Intent(HomePage.this, TicketCatalog.class));
            }
        });

        // category clicked -music
        View music;
        music = findViewById(R.id.music);
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                globalClass.setCategory("music");
                startActivity(new Intent(HomePage.this, TicketCatalog.class));
            }
        });

        // category clicked -dance
        View dance;
        dance = findViewById(R.id.dance);
        dance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                globalClass.setCategory("dance");
                startActivity(new Intent(HomePage.this, TicketCatalog.class));
            }
        });

        // category clicked -orchestra
        View orchestra;
        orchestra = findViewById(R.id.Orchestra);
        orchestra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                globalClass.setCategory("orchestra");
                startActivity(new Intent(HomePage.this, TicketCatalog.class));
            }
        });

        // end of all category clicked

        //recycler (list show)
        RecyclerView recyclerView = findViewById(R.id.horizontalRv);
        sAdapter = new ShowAdapter(this, showList, this);
        LinearLayoutManager sLayoutManager = new LinearLayoutManager(getApplicationContext());
        sLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(sLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(sAdapter);
        prepareShowData();

        // See All -Clicked
        TextView seeall;
        seeall = findViewById(R.id.seeall);
        seeall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomePage.this, TicketCatalog.class));
            }
        });

        ImageView ticketIcon;
        ticketIcon = findViewById(R.id.ticketIcon);
        ticketIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomePage.this, TicketCatalog.class));
            }
        });

       // List View -akhir
        RecyclerView recyclerViewTwo = findViewById(R.id.horizontalRvTwo);
        showAdapterTwo = new ShowAdapterTwo(this, showList, this);
        LinearLayoutManager sLayoutManagerTwo = new LinearLayoutManager(getApplicationContext());
        sLayoutManagerTwo.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewTwo.setLayoutManager(sLayoutManagerTwo);
        recyclerViewTwo.setItemAnimator(new DefaultItemAnimator());
        recyclerViewTwo.setAdapter(showAdapterTwo);
        prepareShowData();

    }
    //set show data
    public  void  prepareShowData(){
        ShowModel show = new ShowModel("Finding Neverland", "theatre", "IDR 280,000", "May 11, 2023", "Seoul",R.drawable.theatre3);
        showList.add(show);
        show = new ShowModel("F.A.B.", "dance", "IDR 500,000", "May 21, 2023", "New York",R.drawable.dance5);
        showList.add(show);
        show = new ShowModel("Cinderella", "theatre", "IDR 1,000,000", "May 22, 2023", "Atlanta",R.drawable.theatre2);
        showList.add(show);
        show = new ShowModel("Rise.", "dance", "IDR 490,000", "May 28, 2023", "Beijing",R.drawable.dance8);
        showList.add(show);
        show = new ShowModel("Dance InOvation", "dance", "IDR 1,000,000", "May 27, 2023", "New York",R.drawable.dance2);
        showList.add(show);
        sAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClicked(ShowModel showModel) {
//        Toast.makeText(this, showModel.getTitle(), Toast.LENGTH_SHORT).show();
        Intent changeintent = new Intent(HomePage.this, TicketDetailPage.class);
        changeintent.putExtra("title", showModel.getTitle());
        changeintent.putExtra("location", showModel.getLocation());
        changeintent.putExtra("date", showModel.getDate());
        changeintent.putExtra("price", showModel.getPrice());
        changeintent.putExtra("image", showModel.getImg());

        startActivity(changeintent);
    }

    @Override
    public void onItemClickedCatalog(TicketCatalog.ShowModel showModel) {

    }

    // set model
    public class ShowModel {
//        private String title, location;
        private String title, location, category, price, date;
        private Integer img;
        public ShowModel() {
        }
        public ShowModel(String title, String category, String price, String date, String location, Integer img) {
            this.title = title;
            this.location = location;
            this.img = img;
            this.category = category;
            this.price = price;
            this.date = date;
        }
        public String getTitle() {
            return title;
        }
        public void setTitle(String name) {
            this.title = name;
        }

        public String getLocation() {
            return location;
        }
        public void setLocation(String location) {
            this.location = location;
        }
        public Integer getImg() {
            return img;
        }
        public void setImg(Integer img) {
            this.img = img;
        }

        public String getCategory() {
            return category;
        }
        public void setCategory(String category) {
            this.category = category;
        }

        public String getPrice() {
            return price;
        }
        public void setPrice(String price) {
            this.price = price;
        }

        public String getDate() {
            return date;
        }
        public void setDate(String date) {
            this.date = date;
        }
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        } else{
            super.onBackPressed();
        }
    }

}