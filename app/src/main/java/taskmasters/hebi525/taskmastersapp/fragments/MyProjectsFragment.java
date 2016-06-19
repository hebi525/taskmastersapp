package taskmasters.hebi525.taskmastersapp.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
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

import taskmasters.hebi525.taskmastersapp.MainActivity;
import taskmasters.hebi525.taskmastersapp.R;
import taskmasters.hebi525.taskmastersapp.fragments.myprojects.AttachmentsFragment;
import taskmasters.hebi525.taskmastersapp.fragments.myprojects.BaseFragment;
import taskmasters.hebi525.taskmastersapp.fragments.myprojects.CommentsFragment;
import taskmasters.hebi525.taskmastersapp.fragments.myprojects.FeedbackFragment;
import taskmasters.hebi525.taskmastersapp.fragments.myprojects.ProjectFragment;

/**
 * Created by hebi525 on 6/19/2016.
 */
public class MyProjectsFragment extends Fragment {

    private AHBottomNavigationViewPager viewPager;
    private MyViewPagerAdapter adapter;
    private AHBottomNavigation bottomNavigation;
    private FloatingActionButton fab;

    private BaseFragment currentFragment;
    private List<AHBottomNavigationItem> bottomNavigationItems = new ArrayList<>();


    public static MyProjectsFragment newInstance() {
        MyProjectsFragment fragment = new MyProjectsFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_myprojects, container, false);

        bottomNavigation = (AHBottomNavigation)rootView.findViewById(R.id.myprojects_botnav);
        viewPager = (AHBottomNavigationViewPager)rootView.findViewById(R.id.myprojects_viewpager);
        fab = (FloatingActionButton)rootView.findViewById(R.id.attachments_fab);

        initBottomNavigationItems();
        initBottomNavigation();

        return rootView;
    }

    //function to initialise bottom navigation
    private void initBottomNavigation(){
        bottomNavigation.setAccentColor(getResources().getColor(R.color.colorAccent));
        bottomNavigation.addItems(bottomNavigationItems);

        adapter = new MyViewPagerAdapter(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                if(!wasSelected){
                    if(currentFragment!=null){
                        currentFragment.hideAnimate();
                    }
                    if(position == 1){
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
        bottomNavigationItems.add(new AHBottomNavigationItem("Feedback", android.R.drawable.ic_menu_agenda));
    }

        private List<BaseFragment> fragmentList = new ArrayList<>();
        private BaseFragment currentFragment;

        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);

            fragmentList.add(ProjectFragment.newInstance());
            fragmentList.add(CommentsFragment.newInstance());
            fragmentList.add(FeedbackFragment.newInstance());
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
