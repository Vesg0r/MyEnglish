package com.an2.myapplication;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import com.an2.myapplication.ui.recyceler.RecyclerFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity implements HeaderListener {
    BottomNavigationView navView;
    private TextView header;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        header = findViewById(R.id.head_text);
        navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.navigation_study:{
                        RecyclerFragment fragment = new RecyclerFragment();
                        Bundle arguments = new Bundle();
                        arguments.putString("TYPE","THEMES");
                        fragment.setArguments(arguments);
                        navigateToFragment(fragment);
                        return true;
                    }
                    case R.id.navigation_vocabulary:{
                        RecyclerFragment fragment = new RecyclerFragment();
                        Bundle arguments = new Bundle();
                        arguments.putString("TYPE","VOCABULARY");
                        fragment.setArguments(arguments);
                        navigateToFragment(fragment);
                        return true;
                    }
                }
                return false;
            }
        });
        navView.setSelectedItemId(R.id.navigation_study);
    }

    @Override
    public void setTitle(String text) {
        header.setText(text);
    }

    private void navigateToFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container,fragment)
                .addToBackStack(fragment.toString())
                .commit();
    }

}
