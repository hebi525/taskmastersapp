package taskmasters.hebi525.taskmastersapp.fragments.myprojects;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import taskmasters.hebi525.taskmastersapp.R;

/**
 * Created by hebi525 on 6/19/2016.
 */
public class ProjectFragment extends BaseFragment {
    private TextView textView;

    public static ProjectFragment newInstance(){
        ProjectFragment fragment = new ProjectFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_project, container, false);
        super.fragmentContainer = (LinearLayout)rootView.findViewById(R.id.fragment_container);
        return rootView;
    }
}
