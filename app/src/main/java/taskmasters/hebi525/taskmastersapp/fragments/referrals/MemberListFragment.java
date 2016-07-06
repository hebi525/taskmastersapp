package taskmasters.hebi525.taskmastersapp.fragments.referrals;

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

import taskmasters.hebi525.taskmastersapp.R;
import taskmasters.hebi525.taskmastersapp.models.Member;

/**
 * Created by hebi525 on 07-Jul-16.
 */
public class MemberListFragment extends Fragment {
    private RecyclerView recyclerView;

    public static MemberListFragment newInstance(){
        MemberListFragment fragment = new MemberListFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_member_list, container, false);

        recyclerView = (RecyclerView)rootView.findViewById(R.id.referrals_list);

        initRecyclerView();

        return rootView;
    }

    private void initRecyclerView(){
        MyRecyclerAdapter adapter = new MyRecyclerAdapter(getActivity(), populateList(20));

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private ArrayList<Member> populateList(int size){
        ArrayList<Member> list = new ArrayList<>();
        for(int i = 0; i < size; i++){
            list.add(new Member("member "+i, "2 days ago"));
        }
        return list;
    }

    private static class MyViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView textView;
        public TextView textView1;

        public MyViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView)itemView.findViewById(R.id.member_image);
            textView = (TextView)itemView.findViewById(R.id.member_name);
            textView1 = (TextView)itemView.findViewById(R.id.member_last_activity_time);
        }
    }

    private class MyRecyclerAdapter extends RecyclerView.Adapter<MyViewHolder>{
        private LayoutInflater inflater;
        private List<Member> itemList;

        public MyRecyclerAdapter(Context context, ArrayList<Member> itemList){
            this.inflater = LayoutInflater.from(context);
            this.itemList = itemList;
        }

        public List<Member> getItemList() {
            return itemList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View rootView = inflater.inflate(R.layout.item_member, parent, false);

            MyViewHolder holder = new MyViewHolder(rootView);
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.imageView.setImageResource(R.mipmap.ic_launcher);
            holder.textView.setText(itemList.get(position).getName());
            holder.textView1.setText(itemList.get(position).getLastActivityTime());
        }

        @Override
        public int getItemCount() {
            return itemList.size();
        }
    }
}
