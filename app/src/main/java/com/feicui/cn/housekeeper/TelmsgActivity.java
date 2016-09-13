package com.feicui.cn.housekeeper;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class TelmsgActivity extends Activity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telmsg);

        ListView listView= (ListView) findViewById(R.id.listview);
    }
}
