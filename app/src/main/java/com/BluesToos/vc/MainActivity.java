package com.BluesToos.vc;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public FragmentManager frag_man = getSupportFragmentManager();
    public static int Change = 0;
    private ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //actionBar = getSupportActionBar();
        //actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ca0606")));
        setSupportActionBar(toolbar);
        frag_man.beginTransaction().replace(R.id.content_frame,new front_page()).commit();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            return true;

        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.front_page ) {
            frag_man.beginTransaction().replace(R.id.content_frame,new front_page()).commit();

        } else if (id == R.id.neighboor_guide) {
            frag_man.beginTransaction().replace(R.id.content_frame,new neighbor_hood()).commit();

        } else if (id == R.id.health_center) {
            frag_man.beginTransaction().replace(R.id.content_frame,new medcenter()).commit();

        } else if (id == R.id.family_room) {
            frag_man.beginTransaction().replace(R.id.content_frame,new famRoom()).commit();


        } else if (id == R.id.calendar) {
            frag_man.beginTransaction().replace(R.id.content_frame,new calendar()).commit();


        } else if (id == R.id. notifications) {
            frag_man.beginTransaction().replace(R.id.content_frame,new notifications()).commit();


        }
        else if (id == R.id. housePlan) {
            frag_man.beginTransaction().replace(R.id.content_frame,new house_floor_plans()).commit();


        }
        else if (id == R.id. houseRules) {
            frag_man.beginTransaction().replace(R.id.content_frame,new house_rules()).commit();


        }
        else if (id == R.id.religious_org) {
            frag_man.beginTransaction().replace(R.id.content_frame,new religious_org()).commit();

        }
        else if (id == R.id. prog_disc) {
            frag_man.beginTransaction().replace(R.id.content_frame,new program_disc()).commit();

        }
        else if (id == R.id. things_to_do) {
            frag_man.beginTransaction().replace(R.id.content_frame,new Todo()).commit();

        }
        else if (id == R.id. meet_team) {
            frag_man.beginTransaction().replace(R.id.content_frame,new meet_team()).commit();

        }
        else if (id == R.id. house_faq){
            frag_man.beginTransaction().replace(R.id.content_frame,new houseFaq()).commit();

        }




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
