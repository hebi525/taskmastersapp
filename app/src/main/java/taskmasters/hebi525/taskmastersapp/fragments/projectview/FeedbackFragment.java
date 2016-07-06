package taskmasters.hebi525.taskmastersapp.fragments.projectview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import taskmasters.hebi525.taskmastersapp.R;
import taskmasters.hebi525.taskmastersapp.fragments.BaseFragment;

/**
 * Created by hebi525 on 6/19/2016.
 */
public class FeedbackFragment extends BaseFragment {

    public static FeedbackFragment newInstance(){
        FeedbackFragment fragment = new FeedbackFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_feedback, container, false);
        super.fragmentContainer = (LinearLayout)rootView.findViewById(R.id.fragment_container);
        return rootView;
    }
}
