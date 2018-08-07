package com.example.administrator.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SimpleAdapterActivity extends Activity {

    ListView listView;
    SimpleAdapter simpleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter);

        listView = (ListView) findViewById(R.id.listview);
        simpleAdapter = new SimpleAdapter(this, getData(), R.layout.simple_adapter_layout, new String[]{"名字"}, new int[]{R.id.tv_name});
    }

    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> mList = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<>();
        map.put("名字", "林黛玉");
        mList.add(map);

        map = new HashMap<>();
        map.put("名字", "贾宝玉");
        mList.add(map);
        return mList;
    }
}
