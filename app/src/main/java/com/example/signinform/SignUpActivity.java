package com.example.signinform;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText etUsername;
    private EditText etPassword;
    private EditText etConfimPassword;
    private TextView tvAllreadyAccount;
    private Button btnSignUp;

    private final String REQUIRE = "Require";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);
        this.etUsername = findViewById(R.id.etUsername);
        this.etPassword = findViewById(R.id.etPassword);
        this.etConfimPassword = findViewById(R.id.etConfirmPassword);
        this.tvAllreadyAccount = findViewById(R.id.tvAlreadyAccount);
        this.btnSignUp = findViewById(R.id.btnSinUp);

        tvAllreadyAccount.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);
    }

    private boolean checkInput(){
        if(TextUtils.isEmpty(etUsername.getText().toString())){
            etUsername.setError(REQUIRE);
            return false;
        }

        if(TextUtils.isEmpty(etPassword.getText().toString())){
            etPassword.setError(REQUIRE);
            return false;
        }

        if(TextUtils.isEmpty(etConfimPassword.getText().toString())){
            etConfimPassword.setError(REQUIRE);
            return false;
        }

        if(!TextUtils.equals(etConfimPassword.getText().toString(), etConfimPassword.getText().toString())){
            Toast.makeText(this, "Password must match", Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }

    private void signUp(){
        if(!checkInput()){
            return;
        }
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
        finish();
    }

    private void signInForm(){
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnSinUp:
                signInForm();
                break;
            case R.id.tvAlreadyAccount:
                signInForm();
                break;
        }

    }
}
