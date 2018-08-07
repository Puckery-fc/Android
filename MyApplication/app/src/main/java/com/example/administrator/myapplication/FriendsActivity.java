package com.example.administrator.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by yinteli on 15/10/10.
 */
public class FriendsActivity extends Activity {
    TextView tvAccount, tvPSW;
    ListView listView;
    ArrayAdapter listViewAdapter;

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friends_list_layout);
        Intent intent = getIntent();
        init(intent);
    }

    private void init(Intent intent)
    {
        initTV(intent);
        initListView();
        initSpinner();
    }

    private void initTV(Intent intent)
    {
        tvAccount = (TextView)findViewById(R.id.tv_account);
        tvAccount.setText(intent.getStringExtra(LoginActivity.ARG_STR_ACCOUNT));
        tvPSW = (TextView)findViewById(R.id.tv_psw);
        tvPSW.setText(intent.getStringExtra(LoginActivity.ARG_STR_PSW));

    }
    private void initListView()
    {
        listView = (ListView)findViewById(R.id.listview);
        listViewAdapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, getNames());
        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }

    private void initSpinner()
    {
        spinner = (Spinner)findViewById(R.id.spinner);
        spinner.setAdapter(listViewAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(FriendsActivity.this,"点击了： "+ spinner.getAdapter().getItem(i).toString(), Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
    private String[] getNames()
    {
        return new String[]{"林发伦","林忆莲","林冲"};
    }
}
