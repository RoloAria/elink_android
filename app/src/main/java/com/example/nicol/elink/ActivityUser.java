package com.example.nicol.elink;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;
import com.example.nicol.elink.UI.AboutFragment;
import com.example.nicol.elink.Usuario.Usuario;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public abstract class ActivityUser extends AppCompatActivity{

    private DrawerLayout drawer;
    private TextView userEmailTextView;
    private TextView userNameTextView;
    private NavigationView navView;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference reference;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firebaseAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_user);
        navView = findViewById(R.id.nav_view);
        prepareDrawer();
        prepareHeader();
        prepareMenu();
        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AboutFragment()).commit();
            navView.setCheckedItem(R.id.about_item);
        }
    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    public void prepareDrawer(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar, R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    public void prepareHeader(){
        userEmailTextView = navView.getHeaderView(0).findViewById(R.id.text_view_user_email);
        userNameTextView = navView.getHeaderView(0).findViewById(R.id.text_view_user_name);
    }

    public void prepareMenu(){
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.about_item:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AboutFragment()).commit();
                        break;
                    case R.id.cerrar_sesion_item:
                        break;
                }
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    public abstract void prepareUser();
    //Getters y Setters-----------------------------------------
    public void setFirebaseAuth(FirebaseAuth firebaseAuth) {
        this.firebaseAuth = firebaseAuth;
    }


    public void setUserEmailTextView(TextView userEmailTextView) {
        this.userEmailTextView = userEmailTextView;
    }
    public void setUserNameTextView(TextView userNameTextView) {
        this.userNameTextView = userNameTextView;
    }


    public void setReference(DatabaseReference reference) {
        this.reference = reference;
    }
    public void setNavView(NavigationView navView) {
        this.navView = navView;
    }
    public FirebaseAuth getFirebaseAuth() {
        return firebaseAuth;
    }
    public TextView getUserEmailTextView() {
        return userEmailTextView;
    }
    public DatabaseReference getReference() {
        return reference;
    }
    public TextView getUserNameTextView() {
        return userNameTextView;
    }
    public NavigationView getNavView() {
        return navView;
    }
    public DrawerLayout getDrawer() {
        return drawer;
    }
    public void setDrawer(DrawerLayout drawer) {
        this.drawer = drawer;
    }
}
