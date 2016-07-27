package taskmasters.hebi525.taskmastersapp.fragments.messages;

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
import taskmasters.hebi525.taskmastersapp.models.Contact;
import taskmasters.hebi525.taskmastersapp.models.RecentMessage;

/**
 * Created by hebi525 on 25-Jul-16.
 */
public class RecentMessagesFragment extends Fragment {
    private RecyclerView recyclerView;

    public static RecentMessagesFragment newInstance(){
        RecentMessagesFragment fragment = new RecentMessagesFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recent_messages, container, false);
        recyclerView = (RecyclerView)rootView.findViewById(R.id.recent_messages_list);
        initRecyclerView();
        return rootView;
    }

    //function to initialise recycler view
    private void initRecyclerView(){
        MyRecyclerAdapter adapter = new MyRecyclerAdapter(getActivity(), populateList(20));

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    //temp function to create contact list
    private ArrayList<RecentMessage> populateList(int size){
        ArrayList<RecentMessage> list = new ArrayList<>();
        for(int i = 0; i < size; i++){
            list.add(new RecentMessage("Geralt of Rivia", getString(R.string.lorem1)));
        }
        return list;
    }

    private static class MyViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView textView;
        public TextView textView1;

        public MyViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView)itemView.findViewById(R.id.recent_message_image);
            textView = (TextView)itemView.findViewById(R.id.recent_message_name);
            textView1 = (TextView)itemView.findViewById(R.id.recent_message_text);
        }
    }

    private class MyRecyclerAdapter extends RecyclerView.Adapter<MyViewHolder>{
        private LayoutInflater inflater;
        private List<RecentMessage> itemList;

        public MyRecyclerAdapter(Context context, ArrayList<RecentMessage> itemList){
            this.inflater = LayoutInflater.from(context);
            this.itemList = itemList;
        }

        public List<RecentMessage> getItemList() {
            return itemList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View rootView = inflater.inflate(R.layout.item_recent_message, parent, false);

            MyViewHolder holder = new MyViewHolder(rootView);
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.textView.setText(itemList.get(position).getContactName());
            holder.textView1.setText(itemList.get(position).getText());
        }

        @Override
        public int getItemCount() {
            return itemList.size();
        }
    }
}
