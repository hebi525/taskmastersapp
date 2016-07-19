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

import taskmasters.hebi525.taskmastersapp.MyOnItemTouchListener;
import taskmasters.hebi525.taskmastersapp.R;
import taskmasters.hebi525.taskmastersapp.fragments.ProjectviewFragment;
import taskmasters.hebi525.taskmastersapp.models.Contact;
import taskmasters.hebi525.taskmastersapp.models.Project;
import taskmasters.hebi525.taskmastersapp.models.RClickListener;

/**
 * Created by hebi525 on 19-Jul-16.
 */
public class ContactsFragment extends Fragment {
    private RecyclerView recyclerView;

    public static ContactsFragment newInstance(){
        ContactsFragment fragment = new ContactsFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_contactlist, container, false);

        recyclerView = (RecyclerView)rootView.findViewById(R.id.contactlist_list);

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
    private ArrayList<Contact> populateList(int size){
        ArrayList<Contact> list = new ArrayList<>();
        for(int i = 0; i < size; i++){
            list.add(new Contact(R.mipmap.ic_launcher, "Geralt of Rivia "+i));
        }
        return list;
    }
    private static class MyViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView textView;
        public ImageView imageView1;

        public MyViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView)itemView.findViewById(R.id.contact_image);
            textView = (TextView)itemView.findViewById(R.id.contact_name);
            imageView1 = (ImageView)itemView.findViewById(R.id.contact_status);
        }
    }

    private class MyRecyclerAdapter extends RecyclerView.Adapter<MyViewHolder>{
        private LayoutInflater inflater;
        private List<Contact> itemList;

        public MyRecyclerAdapter(Context context, ArrayList<Contact> itemList){
            this.inflater = LayoutInflater.from(context);
            this.itemList = itemList;
        }

        public List<Contact> getItemList() {
            return itemList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View rootView = inflater.inflate(R.layout.item_contact, parent, false);

            MyViewHolder holder = new MyViewHolder(rootView);
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.imageView.setImageResource(itemList.get(position).getImageRes());
            holder.textView.setText(itemList.get(position).getContactName());
        }

        @Override
        public int getItemCount() {
            return itemList.size();
        }
    }
}
