package com.example.timurbadretdinov.inception.ui.splash;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.timurbadretdinov.inception.R;
import com.example.timurbadretdinov.inception.presenters.splash.SplashContainerPresenter;
import com.example.timurbadretdinov.inception.presenters.splash.SplashContainerView;
import com.example.timurbadretdinov.inception.util.MyPagerAdapter;

public class SplashContainerActivity extends AppCompatActivity implements SplashContainerView{
    private static ViewPager viewPager;
    private static Button btnStart;
    private static TabLayout tabLayout;
    private static SplashContainerPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initViewPager();

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onStartClicked();
            }
        });
    }

    private void initViews() {
        presenter = new SplashContainerPresenter(this);
        viewPager = findViewById(R.id.pager);
        tabLayout = findViewById(R.id.tabDots);
        btnStart = findViewById(R.id.btnStart);
    }

    private void initViewPager() {
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        myPagerAdapter.addFragment(SplashFragment.newInstance(R.drawable.ic_lightning, "Fast and Legal", "here should be some text"));
        myPagerAdapter.addFragment(SplashFragment.newInstance(R.drawable.ic_circles, "Favorable price", "and here also should be some text"));
        myPagerAdapter.addFragment(SplashFragment.newInstance(R.drawable.ic_eye, "Secured", "But here should't be any text"));

        viewPager.setAdapter(myPagerAdapter);
        tabLayout.setupWithViewPager(viewPager, true);
    }

    @Override
    public void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
