package sample.event.yinteli.loginexample;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;


public class LoginActivity extends ActionBarActivity {

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
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, BaseAdapterActivity.class);
                intent.putExtra(ARG_STR_ACCOUNT,etAccount.getText().toString());
                intent.putExtra(ARG_STR_PSW, etPSW.getText().toString());
                startActivity(intent);
            }
        });
    }


}
