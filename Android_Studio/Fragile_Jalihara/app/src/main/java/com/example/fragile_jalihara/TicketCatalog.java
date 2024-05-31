package com.example.fragile_jalihara;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.fragile_jalihara.databinding.ActivityTicketCatalogBinding;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class TicketCatalog extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, SelectListener{

    private DrawerLayout drawerLayout;
    //binding
    ActivityTicketCatalogBinding binding;
    //end binding

    private List<ShowModel> showList = new ArrayList<>();
    private ShowAdapterThree showAdapterThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTicketCatalogBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        setContentView(R.layout.activity_ticket_catalog);

        // Navbar menu
        Toolbar toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.nav_home:
                        startActivity(new Intent(TicketCatalog.this, HomePage.class));
                        return true;
                    case R.id.nav_aboutus:
                        startActivity(new Intent(TicketCatalog.this, AboutUs.class));
                        return true;
                    case R.id.nav_ticket:
                        startActivity(new Intent(TicketCatalog.this, TicketCatalog.class));
                        return true;
                    case R.id.nav_logout:
                        startActivity(new Intent(TicketCatalog.this, LoginPage.class));
                        return true;
                }
                return false;
            }
        });

        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();
        // end Navbar Menu

        // RecyclerView
        RecyclerView recyclerView = findViewById(R.id.horizontalRvThree);
        showAdapterThree = new ShowAdapterThree(this, showList, this);
        LinearLayoutManager sLayoutManager = new LinearLayoutManager(getApplicationContext());
        sLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(sLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(showAdapterThree);

        GlobalClass globalClass = (GlobalClass) getApplicationContext();
        if (globalClass.getCategory() == "theatre"){
            prepareShowDataTheatre();
        } else if (globalClass.getCategory() == "magic") {
            prepareShowDataMagic();
        } else if (globalClass.getCategory() == "music") {
            prepareShowDataMusic();
        } else if (globalClass.getCategory() == "dance") {
            prepareShowDataDance();
        } else if (globalClass.getCategory() == "orchestra") {
            prepareShowDataOrhestra();
        } else{
            prepareShowData();
        }

        //condition
        Button allbtn = findViewById(R.id.all);
        Button musicbtn = findViewById(R.id.music);
        Button dancebtn = findViewById(R.id.dance);
        Button magicbtn = findViewById(R.id.magic);
        Button theatrebtn = findViewById(R.id.theatre);
        Button orchestrabtn = findViewById(R.id.orchestra);

        allbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prepareShowData();
            }
        });

        musicbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prepareShowDataMusic();
            }
        });

        dancebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prepareShowDataDance();
            }
        });

        magicbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prepareShowDataMagic();
            }
        });

        theatrebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prepareShowDataTheatre();
            }
        });

        orchestrabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prepareShowDataOrhestra();
            }
        });

//        Intent intent = this.getIntent();
//        if (intent != null){
//            String title = intent.getStringExtra("title");
//            String location = intent.getStringExtra("location");
//            int imageid = intent.getIntExtra("imageid",R.drawable.banner1);
//
//            binding.titleTicket.setText(title);
//            binding.locationTicket.setText(location);
//            binding.imgTicket.setImageResource(imageid);
//        }
//        setContentView(R.layout.activity_ticket_catalog);
        ImageView ticketIcon;
        ticketIcon = findViewById(R.id.ticketIcon);
        ticketIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TicketCatalog.this, TicketCatalog.class));
            }
        });
    }

    public  void  prepareShowData(){
        showList.clear();
        ShowModel show = new ShowModel("F.A.B.", "dance", "IDR 500,000", "May 21, 2023", "New York",R.drawable.dance5);
        showList.add(show);
        show = new ShowModel("Live Rock Arlington", "music", "IDR 675,000", "May 25, 2023", "Arlington",R.drawable.music7);
        showList.add(show);
        show = new ShowModel("Jazz Festival: Night 2", "music", "IDR 1,150,000", "May 27, 2023", "Maryland",R.drawable.music2);
        showList.add(show);
        show = new ShowModel("Jazz Live", "music", "IDR 500,000", "May 29, 2023", "New York",R.drawable.music1);
        showList.add(show);
        show = new ShowModel("Jazz Concert", "music", "IDR 1,000,000", "May 30, 2023", "New York",R.drawable.music2);
        showList.add(show);
        show = new ShowModel("Dance InOvation", "dance", "IDR 1,000,000", "May 27, 2023", "New York",R.drawable.dance2);
        showList.add(show);
        show = new ShowModel("Parents Weekend", "dance", "IDR 500,000", "May 27, 2023", "New York",R.drawable.dance7);
        showList.add(show);
        show = new ShowModel("Detroit Ballet", "dance", "IDR 1,600,000", "May 28, 2023", "Detroit",R.drawable.dance3);
        showList.add(show);
        show = new ShowModel("Rise.", "dance", "IDR 490,000", "May 28, 2023", "Beijing",R.drawable.dance8);
        showList.add(show);
        show = new ShowModel("Electrified Dance", "dance", "IDR 700,000", "May 30, 2023", "Jakarta",R.drawable.dance4);
        showList.add(show);
        show = new ShowModel("England Magic Show", "magic", "IDR 200,000", "May 21, 2023", "England",R.drawable.magic3);
        showList.add(show);
        show = new ShowModel("Sentul Magic Show", "magic", "IDR 935,000", "May 23, 2023", "Sentul",R.drawable.magic4);
        showList.add(show);
        show = new ShowModel("BSD Magic Show", "magic", "IDR 315,000", "May 24, 2023", "Tangerang",R.drawable.magic5);
        showList.add(show);
        show = new ShowModel("Dinner and Magic", "magic", "IDR 125,000", "May 29, 2023", "Singapore",R.drawable.magic1);        showList.add(show);
        showList.add(show);
        show = new ShowModel("Finding Neverland", "theatre", "IDR 280,000", "May 11, 2023", "Seoul",R.drawable.theatre3);
        showList.add(show);
        show = new ShowModel("Frozen: The Broadway", "theatre", "IDR 580,000", "May 25, 2023", "New York",R.drawable.theatre4);
        showList.add(show);
        show = new ShowModel("London Symphony", "orchestra", "IDR 1,000,000", "May 30, 2023", "London",R.drawable.orchestra2);
        showList.add(show);

        showAdapterThree.notifyDataSetChanged();
    }

    public  void  prepareShowDataMusic(){
        showList.clear();
        ShowModel show = new ShowModel("Live Acoustic", "music", "IDR 500,000", "May 24, 2023", "Arlington",R.drawable.music6);
        showList.add(show);
        show = new ShowModel("Live Rock Arlington", "music", "IDR 675,000", "May 25, 2023", "Arlington",R.drawable.music7);
        showList.add(show);
        show = new ShowModel("Jazz Festival: Night 2", "music", "IDR 1,150,000", "May 27, 2023", "Maryland",R.drawable.music2);
        showList.add(show);
        show = new ShowModel("Jazz Live", "music", "IDR 500,000", "May 29, 2023", "New York",R.drawable.music1);
        showList.add(show);
        show = new ShowModel("Jazz Concert", "music", "IDR 1,000,000", "May 30, 2023", "New York",R.drawable.music2);
        showList.add(show);
        showAdapterThree.notifyDataSetChanged();
    }

    public  void  prepareShowDataDance(){
        showList.clear();
        ShowModel show = new ShowModel("F.A.B.", "dance", "IDR 500,000", "May 21, 2023", "New York",R.drawable.dance5);
        showList.add(show);
        show = new ShowModel("Dance InOvation", "dance", "IDR 1,000,000", "May 27, 2023", "New York",R.drawable.dance2);
        showList.add(show);
        show = new ShowModel("Parents Weekend", "dance", "IDR 500,000", "May 27, 2023", "New York",R.drawable.dance7);
        showList.add(show);
        show = new ShowModel("Detroit Ballet", "dance", "IDR 1,600,000", "May 28, 2023", "Detroit",R.drawable.dance3);
        showList.add(show);
        show = new ShowModel("Rise.", "dance", "IDR 490,000", "May 28, 2023", "Beijing",R.drawable.dance8);
        showList.add(show);
        show = new ShowModel("Electrified Dance", "dance", "IDR 700,000", "May 30, 2023", "Jakarta",R.drawable.dance4);
        showList.add(show);
        showAdapterThree.notifyDataSetChanged();
    }

    public  void  prepareShowDataMagic(){
        showList.clear();
        ShowModel show = new ShowModel("Kids Magic Show", "magic", "IDR 700,000", "May 21, 2023", "Tokyo",R.drawable.magic2);
        showList.add(show);
        show = new ShowModel("England Magic Show", "magic", "IDR 200,000", "May 21, 2023", "England",R.drawable.magic3);
        showList.add(show);
        show = new ShowModel("Sentul Magic Show", "magic", "IDR 935,000", "May 23, 2023", "Sentul",R.drawable.magic4);
        showList.add(show);
        show = new ShowModel("BSD Magic Show", "magic", "IDR 315,000", "May 24, 2023", "Tangerang",R.drawable.magic5);
        showList.add(show);
        show = new ShowModel("Dinner and Magic", "magic", "IDR 125,000", "May 29, 2023", "Singapore",R.drawable.magic1);        showList.add(show);
        showList.add(show);
        showAdapterThree.notifyDataSetChanged();
    }

    public  void  prepareShowDataTheatre(){
        showList.clear();
        ShowModel show = new ShowModel("The Nutcracker", "theatre", "IDR 950,000", "May 21, 2023", "New York",R.drawable.theatre8);
        showList.add(show);
        show = new ShowModel("Finding Neverland", "theatre", "IDR 280,000", "May 11, 2023", "Seoul",R.drawable.theatre3);
        showList.add(show);
        show = new ShowModel("Frozen: The Broadway", "theatre", "IDR 580,000", "May 25, 2023", "New York",R.drawable.theatre4);
        showList.add(show);
        showAdapterThree.notifyDataSetChanged();
        showAdapterThree.notifyDataSetChanged();
    }

    public  void  prepareShowDataOrhestra(){
        showList.clear();
        ShowModel show = new ShowModel("London Symphony", "orchestra", "IDR 1,000,000", "May 30, 2023", "London",R.drawable.orchestra2);
        showList.add(show);
        show = new ShowModel("London Symphony", "orchestra", "IDR 1,000,000", "May 30, 2023", "London",R.drawable.orchestra2);
        showList.add(show);
        showAdapterThree.notifyDataSetChanged();
    }

    @Override
    public void onItemClicked(HomePage.ShowModel showModel) {

    }

    @Override
    public void onItemClickedCatalog(ShowModel showModel) {
        Intent changeintent = new Intent(TicketCatalog.this, TicketDetailPage.class);
        changeintent.putExtra("title", showModel.getTitle());
        changeintent.putExtra("location", showModel.getLocation());
        changeintent.putExtra("date", showModel.getDate());
        changeintent.putExtra("price", showModel.getPrice());
        changeintent.putExtra("image", showModel.getImg());
        startActivity(changeintent);
    }

    public class ShowModel {
        private String title, location, price, date, category;
        private Integer img;
        public ShowModel() {
        }
        public ShowModel(String title, String category, String price, String date, String location, Integer img) {
            this.title = title;
            this.location = location;
            this.category = category;
            this.img = img;
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

        public String getCategory() {
            return category;
        }
        public void setCategory(String category) {
            this.category = category;
        }
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        return false;
    }
}