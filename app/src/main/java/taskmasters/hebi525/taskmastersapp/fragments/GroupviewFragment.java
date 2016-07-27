package taskmasters.hebi525.taskmastersapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationViewPager;

import java.util.ArrayList;
import java.util.List;

import taskmasters.hebi525.taskmastersapp.R;
import taskmasters.hebi525.taskmastersapp.fragments.groupview.FilesFragment;
import taskmasters.hebi525.taskmastersapp.fragments.groupview.ForumsFragment;
import taskmasters.hebi525.taskmastersapp.fragments.groupview.GroupMembersFragment;
import taskmasters.hebi525.taskmastersapp.fragments.groupview.StatusFragment;

/**
 * Created by hebi525 on 06-Jul-16.
 */
public class GroupviewFragment extends Fragment {

    private AHBottomNavigationViewPager viewPager;
    private MyViewPagerAdapter adapter;
    private AHBottomNavigation bottomNavigation;

    private BaseFragment currentFragment;
    private List<AHBottomNavigationItem> bottomNavigationItems = new ArrayList<>();


    public static GroupviewFragment newInstance(Bundle bundle) {
        GroupviewFragment fragment = new GroupviewFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_groupview, container, false);

        bottomNavigation = (AHBottomNavigation)rootView.findViewById(R.id.groupview_botnav);
        viewPager = (AHBottomNavigationViewPager)rootView.findViewById(R.id.groupview_viewpager);

        initBottomNavigationItems();
        initBottomNavigation();

        return rootView;
    }

    //function to initialise bottom navigation
    private void initBottomNavigation(){
        bottomNavigation.setDefaultBackgroundColor(getResources().getColor(R.color.colorBottomNavigation));
        bottomNavigation.setAccentColor(getResources().getColor(android.R.color.white));
        bottomNavigation.addItems(bottomNavigationItems);

        adapter = new MyViewPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);

        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                if(!wasSelected){
                    if(currentFragment!=null){
                        currentFragment.hideAnimate();
                    }
                    viewPager.setCurrentItem(position, false);
                    currentFragment = adapter.getCurrentFragment();
                    currentFragment.showAnimate();
                }
                return true;
            }
        });
    }

    //function to initialise bottom navigation items
    private void initBottomNavigationItems(){
        bottomNavigationItems.add(new AHBottomNavigationItem("Forums", android.R.drawable.ic_menu_info_details));
        bottomNavigationItems.add(new AHBottomNavigationItem("Status", android.R.drawable.ic_menu_gallery));
        bottomNavigationItems.add(new AHBottomNavigationItem("Members", android.R.drawable.ic_menu_edit));
        bottomNavigationItems.add(new AHBottomNavigationItem("Files", android.R.drawable.ic_menu_agenda));
    }

    private class MyViewPagerAdapter extends FragmentPagerAdapter {
        private List<BaseFragment> fragmentList = new ArrayList<>();
        private BaseFragment currentFragment;

        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);

            fragmentList.add(ForumsFragment.newInstance());
            fragmentList.add(StatusFragment.newInstance());
            fragmentList.add(GroupMembersFragment.newInstance());
            fragmentList.add(FilesFragment.newInstance());
        }

        @Override
        public BaseFragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public void setPrimaryItem(ViewGroup container, int position, Object object) {
            if(currentFragment!=object){
                currentFragment = (BaseFragment)object;
            }
            super.setPrimaryItem(container, position, object);
        }

        public BaseFragment getCurrentFragment(){
            return currentFragment;
        }
    }
}
