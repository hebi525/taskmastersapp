package taskmasters.hebi525.taskmastersapp.fragments.projectview;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import taskmasters.hebi525.taskmastersapp.R;
import taskmasters.hebi525.taskmastersapp.fragments.BaseFragment;
import taskmasters.hebi525.taskmastersapp.models.UserComment;

/**
 * Created by hebi525 on 6/19/2016.
 */
public class CommentsFragment extends BaseFragment {
    private RecyclerView recyclerView;
    private EditText editText;
    private Button button;

    private MyRecyclerAdapter adapter;

    public static CommentsFragment newInstance(){
        CommentsFragment fragment = new CommentsFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_comments, container, false);
        super.fragmentContainer = (NestedScrollView)rootView.findViewById(R.id.fragment_container);
        recyclerView = (RecyclerView)rootView.findViewById(R.id.comments_list);
        editText = (EditText)rootView.findViewById(R.id.comments_edittext);
        button = (Button)rootView.findViewById(R.id.comments_send);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText!=null && recyclerView!=null){
                    if(editText.getText().toString().length()>0){
                        MyRecyclerAdapter adapter;
                        adapter = (MyRecyclerAdapter)recyclerView.getAdapter();
                        adapter.addItem(new UserComment("Geralt of Rivia", editText.getText().toString(), "3:35", 0));
                        recyclerView.smoothScrollToPosition(adapter.getItemCount()-1);
                    }
                }
            }
        });
        initCommentsList();
        return rootView;
    }

    //function to initialise the recycler view comments
    private void initCommentsList(){
        if(recyclerView!=null){
            adapter = new MyRecyclerAdapter(getActivity());
            recyclerView.setAdapter(adapter);
            LinearLayoutManager manager = new LinearLayoutManager(getActivity());
            manager.setStackFromEnd(true);
            recyclerView.setLayoutManager(manager);
        }
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView textView;
        public TextView textView1;
        public TextView textView2;

        public MyViewHolder(View itemView) {
            super(itemView);

            textView = (TextView)itemView.findViewById(R.id.comment_username);
            textView1 = (TextView)itemView.findViewById(R.id.comment_text);
            textView2 = (TextView)itemView.findViewById(R.id.comment_timestamp);
        }
    }

    private class MyRecyclerAdapter extends RecyclerView.Adapter<MyViewHolder>{
        private LayoutInflater inflater;
        private List<UserComment> itemList = new ArrayList<>();

        public MyRecyclerAdapter(Context context){
            this.inflater = LayoutInflater.from(context);
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View rootView = inflater.inflate(R.layout.item_comment, parent, false);
            MyViewHolder holder = new MyViewHolder(rootView);
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.textView.setText(itemList.get(position).getUsername());
            holder.textView1.setText(itemList.get(position).getCommentText());
            holder.textView2.setText(itemList.get(position).getTimeStamp());
        }

        @Override
        public int getItemCount() {
            return itemList.size();
        }

        public void addItem(UserComment item){
            itemList.add(item);
            notifyDataSetChanged();
        }
    }
}
