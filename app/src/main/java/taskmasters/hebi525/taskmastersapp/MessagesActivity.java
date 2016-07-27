package taskmasters.hebi525.taskmastersapp;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import taskmasters.hebi525.taskmastersapp.fragments.GroupsFragment;
import taskmasters.hebi525.taskmastersapp.fragments.incomelogs.LogListFragment;
import taskmasters.hebi525.taskmastersapp.fragments.messages.ContactsFragment;
import taskmasters.hebi525.taskmastersapp.fragments.messages.RecentMessagesFragment;

public class MessagesActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);

        Toolbar toolbar = (Toolbar)findViewById(R.id.messages_toolbar) ;
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Recent Messages");

        tabLayout = (TabLayout)findViewById(R.id.messages_tablayout);
        viewPager = (ViewPager)findViewById(R.id.messages_viewpager);

        initViewPager();
        initTabLayout();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //function to initialise tab layout
    private void initTabLayout(){
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(android.R.drawable.ic_btn_speak_now);
        tabLayout.getTabAt(1).setIcon(android.R.drawable.ic_btn_speak_now);
        tabLayout.getTabAt(2).setIcon(android.R.drawable.ic_btn_speak_now);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0: getSupportActionBar().setTitle("Recent Messages");break;
                    case 1: getSupportActionBar().setTitle("Contacts");break;
                    case 2: getSupportActionBar().setTitle("Groups");break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    //function to initialise view pager
    private void initViewPager(){
        MyViewPagerAdapter adapter = new MyViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(RecentMessagesFragment.newInstance(), "");
        adapter.addFragment(ContactsFragment.newInstance(), "");
        adapter.addFragment(GroupsFragment.newInstance(), "");
        viewPager.setAdapter(adapter);
    }

    private class MyViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public MyViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
