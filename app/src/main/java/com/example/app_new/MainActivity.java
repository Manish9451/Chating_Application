package com.example.app_new;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bn=findViewById(R.id.bottumnagivationbar);

       MaterialToolbar materialToolbar = findViewById(R.id.material_toolbar);

        materialToolbar.setOnMenuItemClickListener(new MaterialToolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.favorite) {
                    Toast.makeText(MainActivity.this, "Favorites Clicked", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (itemId == R.id.search) {
                    Toast.makeText(MainActivity.this, "Search Clicked", Toast.LENGTH_SHORT).show();
                    return true;
                }

                else if (itemId == R.id.refine) {
                    Toast.makeText(MainActivity.this, "Refine Clicked", Toast.LENGTH_SHORT).show();

                    Intent intent=new Intent(MainActivity.this,RefineActivity.class);
                    startActivity(intent);
                    return true;
                }

                else {
                    return false;
                }
            }
        });
        bn.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id=item.getItemId();
                if(id==R.id.nav_explore){

                    lodfrag(new ExploreFragment(),false);

                } else if (id==R.id.nav_connection) {


                    lodfrag(new ConnectionFragment(),false);

                } else if (id==R.id.nav_chat) {

                    lodfrag(new ChatFragment(),false);

                } else if (id==R.id.nav_contact) {


                    lodfrag(new ContactsFragment(),false);
                }

                else if (id==R.id.nav_group) {


                    lodfrag(new GroupsFragment(),false);
                }

                else {

                    lodfrag(new ExploreFragment(),true);
                }


                return true;
            }
        });

        bn.setSelectedItemId(R.id.nav_explore);

    }
    public void lodfrag(Fragment fragment, boolean flag){


        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();
        if(flag){

            ft.add(R.id.framecontainer,fragment);
        }
        else
            ft.replace(R.id.framecontainer,fragment);

        ft.commit();

    }




}