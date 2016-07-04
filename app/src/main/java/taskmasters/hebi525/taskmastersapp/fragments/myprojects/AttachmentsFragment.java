package taskmasters.hebi525.taskmastersapp.fragments.myprojects;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;

import taskmasters.hebi525.taskmastersapp.R;

/**
 * Created by hebi525 on 6/19/2016.
 */
public class AttachmentsFragment extends BaseFragment {
    private NestedScrollView scrollView;

    public static AttachmentsFragment newInstance(){
        AttachmentsFragment fragment = new AttachmentsFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_attachments, container, false);
        super.fragmentContainer = (FrameLayout)rootView.findViewById(R.id.fragment_container);
        scrollView = (NestedScrollView) rootView.findViewById(R.id.attachments_scrollview);
        return rootView;
    }
}
