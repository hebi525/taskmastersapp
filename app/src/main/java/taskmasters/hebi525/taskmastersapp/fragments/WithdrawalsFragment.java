package taskmasters.hebi525.taskmastersapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.ShareCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jaredrummler.materialspinner.MaterialSpinner;

import taskmasters.hebi525.taskmastersapp.R;

/**
 * Created by hebi525 on 07-Jul-16.
 */
public class WithdrawalsFragment extends Fragment {
    private TextInputEditText editText;
    private TextView textView;
    private MaterialSpinner materialSpinner;

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

        initEditText();
        initMaterialSpinner();

        return rootView;
    }

    private void initMaterialSpinner(){
        if(materialSpinner!=null){
            materialSpinner.setItems("- Select -", "Paypal", "Visa", "Mastercard");
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
}
