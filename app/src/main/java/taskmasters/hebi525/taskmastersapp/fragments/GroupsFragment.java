package taskmasters.hebi525.taskmastersapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import taskmasters.hebi525.taskmastersapp.MyOnItemTouchListener;
import taskmasters.hebi525.taskmastersapp.R;
import taskmasters.hebi525.taskmastersapp.models.Group;
import taskmasters.hebi525.taskmastersapp.models.RClickListener;

/**
 * Created by hebi525 on 03-Jul-16.
 */
public class GroupsFragment extends Fragment {
    private RecyclerView recyclerView;

    public static GroupsFragment newInstance() {
        GroupsFragment fragment = new GroupsFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_groups, container, false);

        recyclerView = (RecyclerView)rootView.findViewById(R.id.groups_list);

        initRecyclerView();

        return rootView;
    }

    //function to initialise recycler view
    private void initRecyclerView(){
        MyRecyclerAdapter adapter = new MyRecyclerAdapter(getActivity());
        adapter.getItemList().add(new Group("Group 1"));
        adapter.getItemList().add(new Group("Group 2"));
        adapter.getItemList().add(new Group("Group 3"));

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addOnItemTouchListener(new MyOnItemTouchListener(getActivity(), new RClickListener() {
            @Override
            public void onClick(View view, int position) {
                Bundle bundle = new Bundle();
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                        .replace(R.id.main_fragment_container, GroupviewFragment.newInstance(bundle))
                        .addToBackStack(null)
                        .commit();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    private static class MyViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView textView;
        public TextView textView1;
        public TextView textView2;

        public MyViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView)itemView.findViewById(R.id.group_image);
            textView = (TextView)itemView.findViewById(R.id.group_name);
            textView1 = (TextView)itemView.findViewById(R.id.group_online_count);
            textView2 = (TextView)itemView.findViewById(R.id.group_last_activity_time);
        }
    }

    private class MyRecyclerAdapter extends RecyclerView.Adapter<MyViewHolder>{
        private LayoutInflater inflater;
        private List<Group> itemList = new ArrayList<>();

        public MyRecyclerAdapter(Context context){
        this.inflater = LayoutInflater.from(context);
        }

        public List<Group> getItemList() {
            return itemList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View rootView = inflater.inflate(R.layout.item_group, parent, false);

            MyViewHolder holder = new MyViewHolder(rootView);
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.imageView.setImageResource(itemList.get(position).getImageRes());
            holder.textView.setText(itemList.get(position).getGroupName());
            holder.textView1.setText("Members online: "+itemList.get(position).getOnlineCount());
            holder.textView2.setText("Last activity: "+itemList.get(position).getLastActivityTime());
        }

        @Override
        public int getItemCount() {
            return itemList.size();
        }
    }
}
