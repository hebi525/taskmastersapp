package taskmasters.hebi525.taskmastersapp.fragments.myprojects;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import taskmasters.hebi525.taskmastersapp.R;

/**
 * Created by hebi525 on 6/19/2016.
 */
public class CommentsFragment extends BaseFragment {

    public static CommentsFragment newInstance(){
        CommentsFragment fragment = new CommentsFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_comments, container, false);
        super.fragmentContainer = (LinearLayout)rootView.findViewById(R.id.fragment_container);
        return rootView;
    }
}
