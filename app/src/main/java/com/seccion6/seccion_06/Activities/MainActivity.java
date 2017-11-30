package com.seccion6.seccion_06.Activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Toast;

import com.seccion6.seccion_06.Adapter.PageAdapter;
import com.seccion6.seccion_06.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        // setSupportActionBar es un metodo del activity
        setSupportActionBar(myToolbar);

        // Obtener el tablayout
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        // Añadir tabs
        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));
        //
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        // Obtener el viewpager
        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        PageAdapter pagerAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(pagerAdapter);
        // Listener de cambio de pagina
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        // Listener accion en tab
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // Cuando seleccionas un nuevo tab
                Toast.makeText(MainActivity.this, "Selected ->" + tab.getText(), Toast.LENGTH_LONG).show();
                int position = tab.getPosition();
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // Cuando seleccionas otro tab
                Toast.makeText(MainActivity.this, "Unselected ->" + tab.getText(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // Cuando seleccionas el mismo tab
                Toast.makeText(MainActivity.this, "Reselected ->" + tab.getText(), Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
