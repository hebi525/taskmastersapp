package taskmasters.hebi525.taskmastersapp.fragments.incomelogs;

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
public class LogListFragment extends Fragment {
    private RecyclerView recyclerView;

    public static LogListFragment newInstance(){
        LogListFragment fragment = new LogListFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_log_list, container, false);

        recyclerView = (RecyclerView)rootView.findViewById(R.id.income_logs_list);

        initRecyclerView();

        return rootView;
    }

    private void initRecyclerView(){
        MyRecyclerAdapter adapter = new MyRecyclerAdapter(getActivity(), populateList(20));

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private ArrayList<String> populateList(int size){
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < size; i++){
            list.add("06/29/16 - ₱100 - Casino Reviews (31)");
        }
        return list;
    }

    private static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);

            textView = (TextView)itemView.findViewById(R.id.log_text);
        }
    }

    private class MyRecyclerAdapter extends RecyclerView.Adapter<MyViewHolder>{
        private LayoutInflater inflater;
        private List<String> itemList;

        public MyRecyclerAdapter(Context context, ArrayList<String> itemList){
            this.inflater = LayoutInflater.from(context);
            this.itemList = itemList;
        }

        public List<String> getItemList() {
            return itemList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View rootView = inflater.inflate(R.layout.item_log, parent, false);

            MyViewHolder holder = new MyViewHolder(rootView);
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.textView.setText(itemList.get(position));
        }

        @Override
        public int getItemCount() {
            return itemList.size();
        }
    }
}
