package taskmasters.hebi525.taskmastersapp;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private TextInputLayout tilEmail;
    private TextInputLayout tilPass;
    private EditText etEmail;
    private EditText etPass;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tilEmail = (TextInputLayout)findViewById(R.id.til_email);
        tilPass = (TextInputLayout)findViewById(R.id.til_pass);
        etEmail = (EditText)findViewById(R.id.et_email);
        etPass = (EditText)findViewById(R.id.et_pass);
        btnLogin = (Button)findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(this);

        etEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                validateEmail();
            }
        });//TODO: more validations to be added.

        etPass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                validatePass();
            }
        });//TODO: more validations to be added.
    }

    //function to validate email text;
    private boolean validateEmail(){
        if(etEmail.getText().toString().length() < 1){
            tilEmail.setError("This field is required");
            return false;
        }
        else{
            tilEmail.setError(null);
            return true;
        }
    }

    //function to validate email text;
    private boolean validatePass(){
        if(etPass.getText().toString().length() < 1){
            tilPass.setError("This field is required");
            return false;
        }
        else{
            tilPass.setError(null);
            return true;
        }
    }

    @Override
    public void onClick(View v) {
        if(validateEmail() && validatePass()){
            startActivity(new Intent(this, MainActivity.class));
        }
    }

}
