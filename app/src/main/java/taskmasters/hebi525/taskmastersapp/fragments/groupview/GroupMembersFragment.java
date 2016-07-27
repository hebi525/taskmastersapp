package taskmasters.hebi525.taskmastersapp.fragments.groupview;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import taskmasters.hebi525.taskmastersapp.R;
import taskmasters.hebi525.taskmastersapp.fragments.BaseFragment;
import taskmasters.hebi525.taskmastersapp.models.GroupMember;

/**
 * Created by hebi525 on 6/19/2016.
 */
public class GroupMembersFragment extends BaseFragment {
    private RecyclerView recyclerView;

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    public static GroupMembersFragment newInstance(){
        GroupMembersFragment fragment = new GroupMembersFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_group_members, container, false);
        super.fragmentContainer = (LinearLayout)rootView.findViewById(R.id.fragment_container);

        recyclerView = (RecyclerView)rootView.findViewById(R.id.group_members_list);
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
    private ArrayList<GroupMember> populateList(int size){
        ArrayList<GroupMember> list = new ArrayList<>();
        list.add(new GroupMember("",""));
        list.add(new GroupMember("Geralt of Rivia", "Witcher"));
        list.add(new GroupMember("",""));
        list.add(new GroupMember("Geralt of Rivia", "Witcher"));
        list.add(new GroupMember("Geralt of Rivia", "Witcher"));
        list.add(new GroupMember("",""));
        list.add(new GroupMember("Geralt of Rivia", "Witcher"));
        list.add(new GroupMember("Geralt of Rivia", "Witcher"));
        list.add(new GroupMember("Geralt of Rivia", "Witcher"));
        return list;
    }

    private static class MyViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView textView;
        public TextView textView1;
        public LinearLayout linearLayout;

        public MyViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView)itemView.findViewById(R.id.group_member_image);
            textView = (TextView)itemView.findViewById(R.id.group_member_name);
            textView1 = (TextView)itemView.findViewById(R.id.group_member_rank_text);
            linearLayout = (LinearLayout)itemView.findViewById(R.id.group_member_rank_image_list);
        }
    }

    private static class MyHeaderViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;

        public MyHeaderViewHolder(View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.my_recycler_header_text);
        }
    }

    private class MyRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
        private LayoutInflater inflater;
        private List<GroupMember> itemList;

        public MyRecyclerAdapter(Context context, ArrayList<GroupMember> itemList){
            this.inflater = LayoutInflater.from(context);
            this.itemList = itemList;
        }

        public List<GroupMember> getItemList() {
            return itemList;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            RecyclerView.ViewHolder holder;
            if(viewType == TYPE_HEADER){
                View rootView = inflater.inflate(R.layout.my_recycler_header, parent, false);
                holder = new MyHeaderViewHolder(rootView);
            }
            else {
                View rootView = inflater.inflate(R.layout.item_group_member, parent, false);
                holder = new MyViewHolder(rootView);
            }
            return holder;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if(holder instanceof MyHeaderViewHolder){
                MyHeaderViewHolder headerViewHolder = (MyHeaderViewHolder)holder;
                switch (position){
                    case 0: headerViewHolder.textView.setText("ADMIN");break;
                    case 2: headerViewHolder.textView.setText("MODERATORS");break;
                    case 5: headerViewHolder.textView.setText("MEMBERS");break;
                }
            }
            else{
                MyViewHolder viewHolder = (MyViewHolder)holder;
                viewHolder.textView.setText(itemList.get(position).getGroupMemberName());
                viewHolder.textView1.setText(itemList.get(position).getGroupMemberRankText());
            }
        }

        @Override
        public int getItemViewType(int position) {
            switch (position){
                case 0: return TYPE_HEADER;
                case 2: return TYPE_HEADER;
                case 5: return TYPE_HEADER;
                default: return TYPE_ITEM;
            }
        }

        @Override
        public int getItemCount() {
            return itemList.size();
        }
    }
}
