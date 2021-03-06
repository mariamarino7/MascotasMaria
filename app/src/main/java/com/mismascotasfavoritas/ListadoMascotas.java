package com.mismascotasfavoritas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener;
import com.mismascotasfavoritas.adapter.PageAdapter;
import com.mismascotasfavoritas.fragments.FragmentoDePerfil;
import com.mismascotasfavoritas.fragments.RecyclerViewFragment;

import java.util.ArrayList;

public class ListadoMascotas extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tablayout;
    private ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_mascotas);

        toolbar =(Toolbar) findViewById(R.id.toolbar);
        tablayout = (TabLayout) findViewById(R.id.tabLayout);
        viewpager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();



        if (toolbar!=null){
            setSupportActionBar(toolbar);

        }




    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());

        fragments.add(new FragmentoDePerfil());
        return fragments;
    }

    private void setUpViewPager(){
        viewpager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tablayout.setupWithViewPager(viewpager);
        tablayout.getTabAt(0).setIcon(R.mipmap.ic_launcher_round);

        tablayout.getTabAt(1).setIcon(R.mipmap.ic_tab1);
        tablayout.addOnTabSelectedListener(new OnTabSelectedListener(){


            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }




            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mascotas_menu_app_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpTo(this, getIntent());
                return true;
            case R.id.acercaDe:
                Intent acercaDeIntent= new Intent(this,Acercade.class);
                startActivity(acercaDeIntent);
                return true;

            case R.id.action_favoritos:
                Intent intent = new Intent(this, MascotasFavoritas.class);

                intent.putParcelableArrayListExtra("ArrayList", RecyclerViewFragment.datosMascotas);
                startActivity(intent);
                return true;
            case R.id.contacto:
                Intent contactoIntent= new Intent (this,Contacto.class);
                startActivity(contactoIntent);
                return true;


            default:
                return super.onOptionsItemSelected(item);

        }
    }



}