package com.merrily01.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerView;

    private Button change_listView;
    private Button change_gridView;
    private Button change_waterFall;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_main);
        buttonInit();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_main);
        MyAdapter adapter = new MyAdapter(this);
        recyclerView.setAdapter(adapter);
    }

    /**
     * 按钮点击事件监听及方法
     */
    private void buttonInit() {
        change_listView = (Button) findViewById(R.id.change_listView);
        change_gridView = (Button) findViewById(R.id.change_gridView);
        change_waterFall = (Button) findViewById(R.id.change_waterFall);

        change_listView.setOnClickListener(this);
        change_gridView.setOnClickListener(this);
        change_waterFall.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.change_listView:
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                break;
            case R.id.change_gridView:
                recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,2));
                break;
            case R.id.change_waterFall:
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
                break;
            default:
                break;
        }
    }
}
