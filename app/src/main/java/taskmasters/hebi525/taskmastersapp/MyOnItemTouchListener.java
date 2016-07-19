package taskmasters.hebi525.taskmastersapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import taskmasters.hebi525.taskmastersapp.models.RClickListener;

/**
 * Created by hebi525 on 06-Jul-16.
 */
public class MyOnItemTouchListener implements RecyclerView.OnItemTouchListener {
    private GestureDetector gestureDetector;
    private RClickListener rClickListener;

    public MyOnItemTouchListener(Context context, RClickListener rClickListener){
        gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });
        gestureDetector.setIsLongpressEnabled(true);
        this.rClickListener = rClickListener;
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        View child = rv.findChildViewUnder(e.getX(), e.getY());
        if(child!=null && rClickListener!=null && gestureDetector.onTouchEvent(e)){
            rClickListener.onClick(child, rv.getChildPosition(child));
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
