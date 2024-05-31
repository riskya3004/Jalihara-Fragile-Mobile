package com.example.fragile_jalihara;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fragile_jalihara.databinding.ActivityTicketDetailPageBinding;
import com.google.android.material.navigation.NavigationView;

public class TicketDetailPage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Integer quantityNum = 1;
    ActivityTicketDetailPageBinding binding;

    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_detail_page);

        Toolbar toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.nav_home:
                        startActivity(new Intent(TicketDetailPage.this, HomePage.class));
                        return true;
                    case R.id.nav_aboutus:
                        startActivity(new Intent(TicketDetailPage.this, AboutUs.class));
                        return true;
                    case R.id.nav_ticket:
                        startActivity(new Intent(TicketDetailPage.this, TicketCatalog.class));
                        return true;
                    case R.id.nav_logout:
                        startActivity(new Intent(TicketDetailPage.this, LoginPage.class));
                        return true;
                }
                return false;
            }
        });

//        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav);
//        drawerLayout.addDrawerListener(toogle);
//        toogle.syncState();
        // end Navbar Menu

        ImageView backbtn = findViewById(R.id.backbtn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TicketDetailPage.this, TicketCatalog.class));
            }
        });

        ImageView ticketIcon;
        ticketIcon = findViewById(R.id.ticketIcon);
        ticketIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TicketDetailPage.this, TicketCatalog.class));
            }
        });

        // display data
        Intent intent = this.getIntent();
        TextView showName = findViewById(R.id.showName);
        TextView showLocation = findViewById(R.id.showLocation);
        TextView showDate = findViewById(R.id.showDate);
        TextView showPrice = findViewById(R.id.showPrice);
        ImageView showImage = findViewById(R.id.showImage);

        if (intent != null){
            String title = intent.getStringExtra("title");
            String location = intent.getStringExtra("location");
            String date = intent.getStringExtra("date");
            String price = intent.getStringExtra("price");
            Integer imageid = intent.getIntExtra("image", R.drawable.denio);

            showName.setText(title);
            showLocation.setText(location);
            showDate.setText(date);
            showPrice.setText(price);
            showImage.setImageResource(imageid);
        }
        //end Display data

        // plus min
        TextView plusbtn = findViewById(R.id.plusButton);
        TextView minbtn = findViewById(R.id.minButton);
        TextView quantity = findViewById(R.id.quantity);
        plusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantityNum += 1;
                quantity.setText(String.valueOf(quantityNum));
            }
        });

        minbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantityNum -= 1;
                if (quantityNum < 1){
                    quantityNum = 1;
                    quantity.setText(String.valueOf(quantityNum));
                } else{
                    quantity.setText(String.valueOf(quantityNum));
                }
            }
        });
        // end plus min

        // validation
        Button buyDetail = findViewById(R.id.buyDetail);

        buyDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validateName()){
                    return;
                } else if (!validateRadio()){
                    return;
                } else {
                    startActivity(new Intent(TicketDetailPage.this, HomePage.class));
                }
            }
        });

    }

    public boolean validateName(){
        EditText name = findViewById(R.id.name);
        String buyerName = name.getText().toString();
        TextView errortext = findViewById(R.id.errorBuy);
        if (buyerName.isEmpty()){
            errortext.setText("Name Must be Fiiled");
            return false;
        } else{
            return true;
        }
    }

    public boolean validateRadio(){
        RadioGroup radioGroup = findViewById(R.id.radiogroup);
        TextView errortext = findViewById(R.id.errorBuy);
        if (radioGroup.getCheckedRadioButtonId() == -1){
            errortext.setText("Booth Type Must be Choosen");
            return false;
        } else{
            return true;
        }
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.standard:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.deluxe:
                if (checked)
                    // Ninjas rule
                    break;
            case R.id.luxury:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}