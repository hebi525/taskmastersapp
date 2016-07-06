package taskmasters.hebi525.taskmastersapp.fragments.groupview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import taskmasters.hebi525.taskmastersapp.R;
import taskmasters.hebi525.taskmastersapp.fragments.BaseFragment;

/**
 * Created by hebi525 on 6/19/2016.
 */
public class FilesFragment extends BaseFragment {
    private NestedScrollView scrollView;

    public static FilesFragment newInstance(){
        FilesFragment fragment = new FilesFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_files, container, false);
        super.fragmentContainer = (LinearLayout)rootView.findViewById(R.id.fragment_container);

        return rootView;
    }
}
