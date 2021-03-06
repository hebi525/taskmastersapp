package taskmasters.hebi525.taskmastersapp.fragments.projectview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import taskmasters.hebi525.taskmastersapp.R;
import taskmasters.hebi525.taskmastersapp.fragments.BaseFragment;

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
        super.fragmentContainer = (NestedScrollView)rootView.findViewById(R.id.fragment_container);
        textView = (TextView)rootView.findViewById(R.id.project_details);
        initText();
        return rootView;
    }

    //temporary function
    public void initText(){
        textView.append(getString(R.string.lorem)+"\n\n");
        textView.append(getString(R.string.lorem)+"\n\n");
        textView.append(getString(R.string.lorem)+"\n\n");
        textView.append(getString(R.string.lorem)+"\n\n");
        textView.append(getString(R.string.lorem)+"\n\n");
    }
}
