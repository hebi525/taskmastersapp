package taskmasters.hebi525.taskmastersapp.fragments.myprojects;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;

import taskmasters.hebi525.taskmastersapp.R;

/**
 * Created by hebi525 on 6/19/2016.
 */
public class AttachmentsFragment extends BaseFragment {
    private ScrollView scrollView;
    public static AHBottomNavigation bottomNavigation;

    public static AttachmentsFragment newInstance(AHBottomNavigation bottomNavigation1){
        AttachmentsFragment fragment = new AttachmentsFragment();
        bottomNavigation = bottomNavigation1;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_attachments, container, false);
        super.fragmentContainer = (FrameLayout)rootView.findViewById(R.id.fragment_container);
        scrollView = (ScrollView)rootView.findViewById(R.id.attachments_scrollview);
        scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if(scrollY > oldScrollY){
                    bottomNavigation.hideBottomNavigation(true);
                }
                else{
                    bottomNavigation.
                }
            }
        });
        return rootView;
    }
}
