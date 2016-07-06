package taskmasters.hebi525.taskmastersapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import taskmasters.hebi525.taskmastersapp.R;

/**
 * Created by hebi525 on 6/19/2016.
 */
public class BaseFragment extends Fragment {
    public ViewGroup fragmentContainer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_base, container, false);
        fragmentContainer = (LinearLayout)rootView.findViewById(R.id.fragment_container);
        return rootView;
    }

    //function to animate the fragment as it is attached to the screen
    public void showAnimate(){
        Animation animation = AnimationUtils.loadAnimation(getActivity(), android.R.anim.fade_in);
        fragmentContainer.startAnimation(animation);
    }

    //function to animate the fragment as it is removed from the screen
    public void hideAnimate(){
        Animation animation = AnimationUtils.loadAnimation(getActivity(), android.R.anim.fade_out);
        fragmentContainer.startAnimation(animation);
    }
}
