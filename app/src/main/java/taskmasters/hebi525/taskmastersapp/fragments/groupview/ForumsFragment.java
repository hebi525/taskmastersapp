package taskmasters.hebi525.taskmastersapp.fragments.groupview;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import taskmasters.hebi525.taskmastersapp.MyOnItemTouchListener;
import taskmasters.hebi525.taskmastersapp.R;
import taskmasters.hebi525.taskmastersapp.fragments.BaseFragment;
import taskmasters.hebi525.taskmastersapp.fragments.ProjectviewFragment;
import taskmasters.hebi525.taskmastersapp.models.Forum;
import taskmasters.hebi525.taskmastersapp.models.Project;
import taskmasters.hebi525.taskmastersapp.models.RClickListener;

/**
 * Created by hebi525 on 6/19/2016.
 */
public class ForumsFragment extends BaseFragment {
    private RecyclerView recyclerView;

    public static ForumsFragment newInstance(){
        ForumsFragment fragment = new ForumsFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_forums, container, false);
        super.fragmentContainer = (LinearLayout)rootView.findViewById(R.id.fragment_container);

        recyclerView = (RecyclerView)rootView.findViewById(R.id.forums_list);
        initRecyclerView();

        return rootView;
    }

    //function to initialise recycler view
    private void initRecyclerView(){
        MyRecyclerAdapter adapter = new MyRecyclerAdapter(getActivity(), populateList(20));

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    //temp function to create project list
    private ArrayList<Forum> populateList(int size){
        ArrayList<Forum> list = new ArrayList<>();
        for(int i = 0; i < size; i++){
            list.add(new Forum("Forum "+i, "This is a forum about stuff", "Created by Geralt of Rivia, 2 months ago"));
        }
        return list;
    }

    private static class MyViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView textView;
        public TextView textView1;
        public TextView textView2;

        public MyViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView)itemView.findViewById(R.id.forum_image);
            textView = (TextView)itemView.findViewById(R.id.forum_name);
            textView1 = (TextView)itemView.findViewById(R.id.forum_text);
            textView2 = (TextView)itemView.findViewById(R.id.forum_text1);
        }
    }

    private class MyRecyclerAdapter extends RecyclerView.Adapter<MyViewHolder>{
        private LayoutInflater inflater;
        private List<Forum> itemList;

        public MyRecyclerAdapter(Context context, ArrayList<Forum> itemList){
            this.inflater = LayoutInflater.from(context);
            this.itemList = itemList;
        }

        public List<Forum> getItemList() {
            return itemList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View rootView = inflater.inflate(R.layout.item_forum, parent, false);

            MyViewHolder holder = new MyViewHolder(rootView);
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.textView.setText(itemList.get(position).getForumName());
            holder.textView1.setText(itemList.get(position).getForumText());
            holder.textView2.setText(itemList.get(position).getForumText1());
        }

        @Override
        public int getItemCount() {
            return itemList.size();
        }
    }
}
