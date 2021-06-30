package com.petpetfairy;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.petpetfairy.fragment.DashboardFragment;
import com.petpetfairy.fragment.HomeFragment;
import com.petpetfairy.fragment.NotificationsFragment;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

import androidx.annotation.NonNull;
import androidx.annotation.StringDef;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private FragmentManager mFragmentManager;
    private HomeFragment mHomeFragment;
    private DashboardFragment mDashboardFragment;
    private NotificationsFragment mNotificationsFragment;
    private AdView mAdView;

    @Retention(RetentionPolicy.SOURCE)
    @StringDef({
            HOME, DASHBOARD, NOTIFICATIONS, DETAIL
    })
    public @interface FragmentType {}
    public static final String HOME = "HOME";
    public static final String DASHBOARD = "DASHBOARD";
    public static final String NOTIFICATIONS = "NOTIFICATIONS";
    public static final String DETAIL = "DETAIL";
    public static final String DETAIL_MESSAGE = "DetailMessage";

    private boolean isOnHome = true;
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragmentManager = getFragmentManager();
        bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setItemIconTintList(null);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);
//        ((BottomNavigationView) findViewById(R.id.navigation)).setOnNavigationItemSelectedListener(this);
//        ((BottomNavigationView) findViewById(R.id.navigation)).setSelectedItemId(R.id.navigation_home);

        getAds();
    }

    public void getAds(){
        AdView adView = new AdView(this);

        adView.setAdSize(AdSize.BANNER);

        adView.setAdUnitId("ca-app-pub-4726414806993065/6407820358");

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        MobileAds.setRequestConfiguration(
                new RequestConfiguration.Builder().setTestDeviceIds(Arrays.asList("ABCDEF012345"))
                        .build());

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        });
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        if (mFragmentManager.findFragmentByTag(DETAIL) != null) {
            mFragmentManager.popBackStack();
        }

        switch (item.getItemId()) {
            case R.id.navigation_home:

                if (mHomeFragment == null) mHomeFragment = new HomeFragment();
                if (mDashboardFragment != null) fragmentTransaction.hide(mDashboardFragment);
                if (mNotificationsFragment != null) fragmentTransaction.hide(mNotificationsFragment);
                if (mHomeFragment.isAdded()) {
                    fragmentTransaction.show(mHomeFragment);
                } else {
                    fragmentTransaction.add(R.id.container_main, mHomeFragment, HOME);
                }
                fragmentTransaction.commit();
                this.isOnHome = true;
                return true;
            case R.id.navigation_dashboard:

                if (mDashboardFragment == null) mDashboardFragment = new DashboardFragment();
                if (mHomeFragment != null) fragmentTransaction.hide(mHomeFragment);
                if (mNotificationsFragment != null) fragmentTransaction.hide(mNotificationsFragment);
                if (mDashboardFragment.isAdded()) {
                    fragmentTransaction.show(mDashboardFragment);
                } else {
                    fragmentTransaction.add(R.id.container_main, mDashboardFragment, DASHBOARD);
                }
                fragmentTransaction.commit();
                this.isOnHome = false;
                return true;
            case R.id.navigation_notifications:

                if (mNotificationsFragment == null) mNotificationsFragment = new NotificationsFragment();
                if (mHomeFragment != null) fragmentTransaction.hide(mHomeFragment);
                if (mDashboardFragment != null) fragmentTransaction.hide(mDashboardFragment);
                if (mNotificationsFragment.isAdded()) {
                    fragmentTransaction.show(mNotificationsFragment);
                } else {
                    fragmentTransaction.add(R.id.container_main, mNotificationsFragment, NOTIFICATIONS);
                }
                fragmentTransaction.commit();
                this.isOnHome = false;
                return true;
        }
        return false;
    }

    public void openDetail(){
        this.isOnHome = false;
    }

//    public void onOpenDetail(String message) {
//
//        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
//
//        if (mHomeFragment != null && !mHomeFragment.isHidden()) {
//            fragmentTransaction.hide(mHomeFragment);
//            fragmentTransaction.addToBackStack(HOME);
//        }
//        if (mDashboardFragment != null && !mDashboardFragment.isHidden()) {
//            fragmentTransaction.hide(mDashboardFragment).addToBackStack(DASHBOARD);
//        }
//        if (mNotificationsFragment != null && !mNotificationsFragment.isHidden()) {
//            fragmentTransaction.hide(mNotificationsFragment).addToBackStack(NOTIFICATIONS);
//        }
//
//        DetailFragment fragment = new DetailFragment();
//        Bundle bundle = new Bundle();
//        bundle.putString(DETAIL_MESSAGE, message);
//        fragment.setArguments(bundle);
//
//        fragmentTransaction.add(R.id.container_main, fragment, DETAIL).commit();
//    }

    @Override
    public void onBackPressed() {
        if(bottomNavigationView.getSelectedItemId() == R.id.navigation_home && isOnHome)
        {
            super.onBackPressed();
            finish();
        }
        else {
            bottomNavigationView.setSelectedItemId(R.id.navigation_home);
        }
    }

    /** Called when leaving the activity */
    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    /** Called when returning to the activity */
    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    /** Called before the activity is destroyed */
    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }
}