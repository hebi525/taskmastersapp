package taskmasters.hebi525.taskmastersapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaredrummler.materialspinner.MaterialSpinner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import taskmasters.hebi525.taskmastersapp.R;
import taskmasters.hebi525.taskmastersapp.models.Withdrawal;

/**
 * Created by hebi525 on 07-Jul-16.
 */
public class WithdrawalsFragment extends Fragment {
    private TextInputEditText editText;
    private TextView textView;
    private MaterialSpinner materialSpinner;
    private Button btnRequestWithdrawal;
    private RecyclerView recyclerView;

    private static final int WITHDRAWAL_FEE = 50;

    public static WithdrawalsFragment newInstance() {
        WithdrawalsFragment fragment = new WithdrawalsFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_withdrawals, container, false);

        editText = (TextInputEditText)rootView.findViewById(R.id.withdrawals_amount);
        textView = (TextView)rootView.findViewById(R.id.withdrawals_amountreq);
        materialSpinner = (MaterialSpinner)rootView.findViewById(R.id.withdrawals_paymethod);
        btnRequestWithdrawal = (Button)rootView.findViewById(R.id.withdrawals_request_withdrawal);
        recyclerView = (RecyclerView)rootView.findViewById(R.id.withdrawals_list);

        initEditText();
        initMaterialSpinner();
        initRecyclerView();

        return rootView;
    }

    private void initMaterialSpinner(){
        if(materialSpinner!=null){
            materialSpinner.setItems("Paypal", "Visa", "Mastercard");
            materialSpinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
                @Override
                public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
                    materialSpinner.setSelectedIndex(position);
                }
            });
        }
    }

    private void initEditText(){
        if(editText!=null){
            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    if(s.length()>0) {
                        try {
                            int inputValue = Integer.parseInt(s.toString());
                            updateAmountReq(inputValue - WITHDRAWAL_FEE);
                        }catch (NumberFormatException e){}

                        btnRequestWithdrawal.setEnabled(true);
                    }
                    else if(s.length()<1){
                        btnRequestWithdrawal.setEnabled(false);
                    }

                }
            });
        }
    }

    private void updateAmountReq(int amount){
        if(textView!=null) {
            textView.setText("Amount Requested: " + amount);
        }
    }

    //function to initialise recycler view
    private void initRecyclerView(){
        MyRecyclerAdapter adapter = new MyRecyclerAdapter(getActivity(), populateList(20));

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    //temp function to create contact list
    private ArrayList<Withdrawal> populateList(int size){
        ArrayList<Withdrawal> list = new ArrayList<>();
        Date date = new Date();
        String dateString = date.getMonth()+"/"+date.getDay()+"/"+date.getYear();
        for(int i = 0; i < size; i++){
            list.add(new Withdrawal(dateString, 999, 0));
        }
        return list;
    }

    private static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public TextView textView1;
        public ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);

            textView = (TextView)itemView.findViewById(R.id.withdrawal_date);
            textView1 = (TextView)itemView.findViewById(R.id.withdrawal_amount);
            imageView = (ImageView)itemView.findViewById(R.id.withdrawal_status);
        }
    }

    private class MyRecyclerAdapter extends RecyclerView.Adapter<MyViewHolder>{
        private LayoutInflater inflater;
        private List<Withdrawal> itemList;

        public MyRecyclerAdapter(Context context, ArrayList<Withdrawal> itemList){
            this.inflater = LayoutInflater.from(context);
            this.itemList = itemList;
        }

        public List<Withdrawal> getItemList() {
            return itemList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View rootView = inflater.inflate(R.layout.item_withdrawal, parent, false);

            MyViewHolder holder = new MyViewHolder(rootView);
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.textView.setText(itemList.get(position).getDate());
            holder.textView1.setText(itemList.get(position).getAmount()+"");
        }

        @Override
        public int getItemCount() {
            return itemList.size();
        }
    }
}
