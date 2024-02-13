package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements FragmentA.SendMessage{
    private ViewPagerAdapter viewPagerAdapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewpager);
// configuration de l'adaptateur
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
// ajouter les fragments
        viewPagerAdapter.add(new FragmentA(), "Tab - 1");
        viewPagerAdapter.add(new FragmentB(), "Tab - 2");
// définir l'adaptateur
        viewPager.setAdapter(viewPagerAdapter);
// Les titres de la page (fragment) seront affichés dans le
// tabLayout, il faut donc définir le visualisateur de page.
// On utilise la fonction setupWithViewPager().
        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }
    @Override
    public void sendData(String message) {
        String tag = "android:switcher:" + R.id.viewpager + ":" + 1;
        FragmentB f = (FragmentB)
                getSupportFragmentManager().findFragmentByTag(tag);
        f.displayReceivedData(message);
    }
}