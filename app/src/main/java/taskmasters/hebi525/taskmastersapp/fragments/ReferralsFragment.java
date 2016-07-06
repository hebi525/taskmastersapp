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
import taskmasters.hebi525.taskmastersapp.fragments.referrals.MemberListFragment;

/**
 * Created by hebi525 on 07-Jul-16.
 */
public class ReferralsFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    public static ReferralsFragment newInstance() {
        ReferralsFragment fragment = new ReferralsFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_referrals, container, false);

        tabLayout = (TabLayout)rootView.findViewById(R.id.referrals_tablayout);
        viewPager = (ViewPager)rootView.findViewById(R.id.referrals_viewpager);

        initViewPager();
        tabLayout.setupWithViewPager(viewPager);

        return  rootView;
    }

    //function to initialise view pager
    private void initViewPager(){
        MyViewPagerAdapter adapter = new MyViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(MemberListFragment.newInstance(), "Active Members");
        adapter.addFragment(MemberListFragment.newInstance(), "Inactive Members");
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
