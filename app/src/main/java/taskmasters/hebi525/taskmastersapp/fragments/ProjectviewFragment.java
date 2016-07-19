package taskmasters.hebi525.taskmastersapp.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationViewPager;

import java.util.ArrayList;
import java.util.List;

import taskmasters.hebi525.taskmastersapp.R;
import taskmasters.hebi525.taskmastersapp.fragments.projectview.AttachmentsFragment;
import taskmasters.hebi525.taskmastersapp.fragments.projectview.CommentsFragment;
import taskmasters.hebi525.taskmastersapp.fragments.projectview.FeedbackFragment;
import taskmasters.hebi525.taskmastersapp.fragments.projectview.ProjectFragment;

/**
 * Created by hebi525 on 6/19/2016.
 */
public class ProjectviewFragment extends Fragment {

    private AHBottomNavigationViewPager viewPager;
    private MyViewPagerAdapter adapter;
    private AHBottomNavigation bottomNavigation;
    private FloatingActionButton fab;

    private BaseFragment currentFragment;
    private List<AHBottomNavigationItem> bottomNavigationItems = new ArrayList<>();


    public static ProjectviewFragment newInstance(Bundle bundle) {
        ProjectviewFragment fragment = new ProjectviewFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_projectview, container, false);

        bottomNavigation = (AHBottomNavigation)rootView.findViewById(R.id.projectview_botnav);
        viewPager = (AHBottomNavigationViewPager)rootView.findViewById(R.id.projectview_viewpager);
        fab = (FloatingActionButton)rootView.findViewById(R.id.attachments_fab);

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
                    if(position == 1){//Attachments Tab
                        fab.show();
                    }
                    else{
                        fab.hide();
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
        bottomNavigationItems.add(new AHBottomNavigationItem("Project", android.R.drawable.ic_menu_info_details));
        bottomNavigationItems.add(new AHBottomNavigationItem("Attachments", android.R.drawable.ic_menu_gallery));
        bottomNavigationItems.add(new AHBottomNavigationItem("Comments", android.R.drawable.ic_menu_edit));
//        bottomNavigationItems.add(new AHBottomNavigationItem("Feedback", android.R.drawable.ic_menu_agenda));
    }

    private class MyViewPagerAdapter extends FragmentPagerAdapter{
        private List<BaseFragment> fragmentList = new ArrayList<>();
        private BaseFragment currentFragment;

        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);

            fragmentList.add(ProjectFragment.newInstance());
            fragmentList.add(AttachmentsFragment.newInstance());
            fragmentList.add(CommentsFragment.newInstance());
//            fragmentList.add(FeedbackFragment.newInstance());
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
