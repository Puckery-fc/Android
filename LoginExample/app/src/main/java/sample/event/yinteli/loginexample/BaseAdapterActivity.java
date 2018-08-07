package sample.event.yinteli.loginexample;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class BaseAdapterActivity extends ActionBarActivity {

    ListView listView;
    private CustomerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_adapter);
        listView = (ListView) findViewById(R.id.listview);

        adapter = new CustomerAdapter(this,getData());
        listView.setAdapter(adapter);
    }

    public List getData()
    {
        List list = new ArrayList<Hero>();

        Hero ymhd = new Hero();
        ymhd.setName("樱木花道");
        ymhd.setDescription("头碰篮板的男人");
        ymhd.setImageURL(R.drawable.yinmuhuadao);

        list.add(ymhd);

        Hero lcf = new Hero();
        lcf.setName("流川枫");
        lcf.setDescription("打法很飘逸");
        lcf.setImageURL(R.drawable.liuchuanfeng);

        list.add(lcf);
        return list;
    }

    class CustomerAdapter extends BaseAdapter {

        List list;
        Context context;

        public CustomerAdapter(Context context, List list) {
            this.list = list;
            this.context = context;
        }

        //规定listview有多少行
        @Override
        public int getCount() {
            return list.size();
        }

        //规定listview返回哪一行的data
        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        //规定listview返回他所在行数。（第一行是0）
        @Override
        public long getItemId(int i) {
            return i;
        }

        //返回一行的view
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            View mview = View.inflate(context, R.layout.friends_list_base_adapter_layout, null);
            Hero hero = (Hero)list.get(i);
            ImageView ivIcon = (ImageView)mview.findViewById(R.id.iv_icon);
            ivIcon.setBackgroundResource(hero.getImageURL());
            TextView tvName = (TextView)mview.findViewById(R.id.tv_name);
            tvName.setText(hero.getName());
            TextView tvDes = (TextView)mview.findViewById(R.id.tv_des);
            tvDes.setText(hero.getDescription());
            return mview;
        }
    }


}
