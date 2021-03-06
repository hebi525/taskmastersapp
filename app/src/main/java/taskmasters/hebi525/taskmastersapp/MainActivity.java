package taskmasters.hebi525.taskmastersapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.animation.AnimatorCompatHelper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.jaredrummler.materialspinner.MaterialSpinner;

import taskmasters.hebi525.taskmastersapp.fragments.GroupsFragment;
import taskmasters.hebi525.taskmastersapp.fragments.HomeFragment;
import taskmasters.hebi525.taskmastersapp.fragments.IncomeLogsFragment;
import taskmasters.hebi525.taskmastersapp.fragments.ProjectsFragment;
import taskmasters.hebi525.taskmastersapp.fragments.ReferralsFragment;
import taskmasters.hebi525.taskmastersapp.fragments.SettingsFragment;
import taskmasters.hebi525.taskmastersapp.fragments.WithdrawalsFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        final ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
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
        else if (id == R.id.action_messages) {
            startActivity(new Intent(getApplicationContext(), MessagesActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        //My Projects Selected
        if (id == R.id.nav_home) {
            if(!(currentFragment instanceof HomeFragment)) {
                currentFragment = HomeFragment.newInstance();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(android.R.anim.fade_in, 0);
                transaction.replace(R.id.main_fragment_container, currentFragment);
                transaction.commit();
            }
        }
        else if (id == R.id.nav_myprojects) {
            if(!(currentFragment instanceof ProjectsFragment)) {
                currentFragment = ProjectsFragment.newInstance();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(android.R.anim.fade_in, 0);
                transaction.replace(R.id.main_fragment_container, currentFragment);
                transaction.commit();
            }
        }
        else if (id == R.id.nav_groups) {
            if(!(currentFragment instanceof GroupsFragment)) {
                currentFragment = GroupsFragment.newInstance();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(android.R.anim.fade_in, 0);
                transaction.replace(R.id.main_fragment_container, currentFragment);
                transaction.commit();
            }
        }
        else if (id == R.id.nav_referrals) {
            if(!(currentFragment instanceof ReferralsFragment)) {
                currentFragment = ReferralsFragment.newInstance();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(android.R.anim.fade_in, 0);
                transaction.replace(R.id.main_fragment_container, currentFragment);
                transaction.commit();
            }
        }
        else if (id == R.id.nav_income_logs) {
            if(!(currentFragment instanceof IncomeLogsFragment)) {
                currentFragment = IncomeLogsFragment.newInstance();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(android.R.anim.fade_in, 0);
                transaction.replace(R.id.main_fragment_container, currentFragment);
                transaction.commit();
            }
        }
        else if (id == R.id.nav_withdrawals) {
            if(!(currentFragment instanceof WithdrawalsFragment)) {
                currentFragment = WithdrawalsFragment.newInstance();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(android.R.anim.fade_in, 0);
                transaction.replace(R.id.main_fragment_container, currentFragment);
                transaction.commit();
            }
        }
        else if (id == R.id.nav_settings) {
            if(!(currentFragment instanceof SettingsFragment)) {
                currentFragment = SettingsFragment.newInstance();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(android.R.anim.fade_in, 0);
                transaction.replace(R.id.main_fragment_container, currentFragment);
                transaction.commit();
            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
