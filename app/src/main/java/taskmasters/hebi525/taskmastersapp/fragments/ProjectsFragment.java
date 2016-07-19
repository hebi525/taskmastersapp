package taskmasters.hebi525.taskmastersapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import taskmasters.hebi525.taskmastersapp.MyOnItemTouchListener;
import taskmasters.hebi525.taskmastersapp.R;
import taskmasters.hebi525.taskmastersapp.models.Project;
import taskmasters.hebi525.taskmastersapp.models.RClickListener;

/**
 * Created by hebi525 on 05-Jul-16.
 */
public class ProjectsFragment extends Fragment {
    private RecyclerView recyclerView;

    public static ProjectsFragment newInstance() {
        ProjectsFragment fragment = new ProjectsFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_projects, container, false);

        recyclerView = (RecyclerView)rootView.findViewById(R.id.projects_list);

        initRecyclerView();

        return rootView;
    }

    //function to initialise recycler view
    private void initRecyclerView(){
        MyRecyclerAdapter adapter = new MyRecyclerAdapter(getActivity(), populateList(20));

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addOnItemTouchListener(new MyOnItemTouchListener(getActivity(), new RClickListener() {
            @Override
            public void onClick(View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putString("PROJECT_NAME", "project "+position);
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                        .replace(R.id.main_fragment_container, ProjectviewFragment.newInstance(bundle))
                        .addToBackStack(null)
                        .commit();

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    //temp function to create project list
    private ArrayList<Project> populateList(int size){
        ArrayList<Project> list = new ArrayList<>();
        for(int i = 0; i < size; i++){
            list.add(new Project("project"+i, "P100", "hehe"));
        }
        return list;
    }

    private static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public TextView textView1;
        public TextView textView2;

        public MyViewHolder(View itemView) {
            super(itemView);

            textView = (TextView)itemView.findViewById(R.id.project_name);
            textView1 = (TextView)itemView.findViewById(R.id.project_status);
            textView2 = (TextView)itemView.findViewById(R.id.project_price);
        }
    }

    private class MyRecyclerAdapter extends RecyclerView.Adapter<MyViewHolder>{
        private LayoutInflater inflater;
        private List<Project> itemList;

        public MyRecyclerAdapter(Context context, ArrayList<Project> itemList){
            this.inflater = LayoutInflater.from(context);
            this.itemList = itemList;
        }

        public List<Project> getItemList() {
            return itemList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View rootView = inflater.inflate(R.layout.item_project, parent, false);

            MyViewHolder holder = new MyViewHolder(rootView);
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.textView.setText(itemList.get(position).getProjectName());
            holder.textView1.setText(itemList.get(position).getProjectStatus());
            holder.textView2.setText(itemList.get(position).getProjectPrice());
        }

        @Override
        public int getItemCount() {
            return itemList.size();
        }
    }
}
