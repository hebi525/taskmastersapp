package taskmasters.hebi525.taskmastersapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import taskmasters.hebi525.taskmastersapp.R;
import taskmasters.hebi525.taskmastersapp.fragments.incomelogs.LogListFragment;
import taskmasters.hebi525.taskmastersapp.fragments.referrals.MemberListFragment;

/**
 * Created by hebi525 on 07-Jul-16.
 */
public class IncomeLogsFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    public static IncomeLogsFragment newInstance() {
        IncomeLogsFragment fragment = new IncomeLogsFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_income_logs, container, false);

        tabLayout = (TabLayout)rootView.findViewById(R.id.income_logs_tablayout);
        viewPager = (ViewPager)rootView.findViewById(R.id.income_logs_viewpager);

        initViewPager();
        initTabLayout();

        return  rootView;
    }

    //function to initialise tab layout
    private void initTabLayout(){
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(android.R.drawable.ic_btn_speak_now);
        tabLayout.getTabAt(1).setIcon(android.R.drawable.ic_btn_speak_now);
        tabLayout.getTabAt(2).setIcon(android.R.drawable.ic_btn_speak_now);
        tabLayout.getTabAt(3).setIcon(android.R.drawable.ic_btn_speak_now);
    }

    //function to initialise view pager
    private void initViewPager(){
        MyViewPagerAdapter adapter = new MyViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(LogListFragment.newInstance(), "Writer");
        adapter.addFragment(LogListFragment.newInstance(), "Editor");
        adapter.addFragment(LogListFragment.newInstance(), "Taskmaster");
        adapter.addFragment(LogListFragment.newInstance(), "Overrides");
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
