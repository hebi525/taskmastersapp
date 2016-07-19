package taskmasters.hebi525.taskmastersapp.fragments.projectview;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

import taskmasters.hebi525.taskmastersapp.MyOnItemTouchListener;
import taskmasters.hebi525.taskmastersapp.R;
import taskmasters.hebi525.taskmastersapp.fragments.BaseFragment;
import taskmasters.hebi525.taskmastersapp.fragments.ProjectviewFragment;
import taskmasters.hebi525.taskmastersapp.models.Attachment;
import taskmasters.hebi525.taskmastersapp.models.Project;
import taskmasters.hebi525.taskmastersapp.models.RClickListener;

/**
 * Created by hebi525 on 6/19/2016.
 */
public class AttachmentsFragment extends BaseFragment {
    private NestedScrollView scrollView;
    private RecyclerView recyclerView;

    public static AttachmentsFragment newInstance(){
        AttachmentsFragment fragment = new AttachmentsFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_attachments, container, false);
        super.fragmentContainer = (LinearLayout)rootView.findViewById(R.id.fragment_container);
        scrollView = (NestedScrollView) rootView.findViewById(R.id.attachments_scrollview);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.attachments_list);



        initRecyclerView();
        return rootView;
    }

    private void initRecyclerView(){
        if(recyclerView!=null){
            MyRecyclerAdapter adapter = new MyRecyclerAdapter(getActivity(), populateList(20));
            recyclerView.setAdapter(adapter);
            recyclerView.addOnItemTouchListener(new MyOnItemTouchListener(getActivity(), new RClickListener() {
                @Override
                public void onClick(View view, int position) {
                    AlertDialog dialog = new AlertDialog.Builder(getActivity())
                            .setTitle(populateList(20).get(position).getFileName())
                            .setPositiveButton("Download", null)
                            .create();

                    dialog.show();
                }

                @Override
                public void onLongClick(View view, int position) {

                }
            }));
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        }
    }

    //temp function to create attachments list
    private ArrayList<Attachment> populateList(int size){
        ArrayList<Attachment> list = new ArrayList<>();
        for(int i = 0; i < size; i++){
            list.add(new Attachment("user "+i, "filename", "2 days ago"));
        }
        return list;
    }

    private static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public TextView textView1;
        public TextView textView2;

        public MyViewHolder(View itemView) {
            super(itemView);

            textView = (TextView)itemView.findViewById(R.id.attachment_username);
            textView1 = (TextView)itemView.findViewById(R.id.attachment_filename);
            textView2 = (TextView)itemView.findViewById(R.id.attachment_timestamp);
        }
    }

    private class MyRecyclerAdapter extends RecyclerView.Adapter<MyViewHolder>{
        private LayoutInflater inflater;
        private List<Attachment> itemList;

        public MyRecyclerAdapter(Context context, ArrayList<Attachment> itemList){
            this.inflater = LayoutInflater.from(context);
            this.itemList = itemList;
        }

        public List<Attachment> getItemList() {
            return itemList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View rootView = inflater.inflate(R.layout.item_attachment, parent, false);

            MyViewHolder holder = new MyViewHolder(rootView);
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.textView.setText(itemList.get(position).getUsername());
            holder.textView1.setText(itemList.get(position).getFileName());
            holder.textView2.setText(itemList.get(position).getTimeStamp());
        }

        @Override
        public int getItemCount() {
            return itemList.size();
        }
    }
}
