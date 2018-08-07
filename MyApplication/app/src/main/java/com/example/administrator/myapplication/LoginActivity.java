package com.example.administrator.myapplication;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class LoginActivity extends Activity{


    EditText etAccount, etPSW;
    Button btnRegister;
    public static final String ARG_STR_ACCOUNT = "ARG_STR_ACCOUNT";
    public static final String ARG_STR_PSW = "ARG_STR_PSW";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init()
    {
        initEditText();
        initButton();
    }

    private void initEditText()
    {
        etAccount = (EditText)findViewById(R.id.et_account);

        etPSW = (EditText)findViewById(R.id.et_psw);
    }

    private void initButton()
    {
        btnRegister = (Button)findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(new innerClassListner());
    }

    private class innerClassListner implements View.OnClickListener
    {

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(LoginActivity.this, FriendsActivity.class);
            intent.putExtra(ARG_STR_ACCOUNT,etAccount.getText().toString());
            intent.putExtra(ARG_STR_PSW, etPSW.getText().toString());
            startActivity(intent);
        }
    }

}
