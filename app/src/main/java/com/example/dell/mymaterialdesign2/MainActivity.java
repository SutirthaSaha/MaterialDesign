package com.example.dell.mymaterialdesign2;

import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab;
    CoordinatorLayout myLayout;
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab=(FloatingActionButton)findViewById(R.id.fab);
        myLayout=(CoordinatorLayout) findViewById(R.id.mylayout);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawerlayout);

        android.support.v7.widget.Toolbar toolbar=(android.support.v7.widget.Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("Learnstack");
        toolbar.inflateMenu(R.menu.menu_main);
        toolbar.setOnMenuItemClickListener(new android.support.v7.widget.Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Snackbar.make(myLayout,item.getTitle()+" Selected",Snackbar.LENGTH_SHORT).show();
                if(item.getItemId()==R.id.delete){
                    Snackbar snackbar=Snackbar.make(myLayout,"File Delete SuccessFully",Snackbar.LENGTH_LONG);
                    snackbar.setAction("Undo", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Snackbar.make(myLayout,"File Recovered Successfully",Snackbar.LENGTH_SHORT).show();
                        }
                    });
                    snackbar.show();
                }
                return true;

            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Floating Action Button Clicked",Toast.LENGTH_LONG).show();
                Snackbar.make(myLayout,"Grenade",Snackbar.LENGTH_LONG).show();
            }
        });

        final NavigationView navigationView=(NavigationView)findViewById(R.id.navigationView);
        ActionBarDrawerToggle actionBarDrawerToggle=new ActionBarDrawerToggle(MainActivity.this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Toast.makeText(MainActivity.this,item.getTitle(),Toast.LENGTH_LONG).show();
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });


    }
}
