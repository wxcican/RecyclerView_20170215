package com.fuicuiedu.xc.recyclerview_20170215;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


//recyclerView使用
//1.依赖
//2.布局文件中使用该控件
//3.找到控件（findViewbyId）
//4.数据（假数据）
//5.设置布局管理器（线性布局）
//6.适配器




public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<String> mData;
    private MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        //初始化数据，添加假数据
        mData = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            mData.add("第" + i + "条");
        }

        //设置布局管理器
        RecyclerView.LayoutManager manager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(manager);

        //设置适配器
        adapter = new MainAdapter(mData);
        adapter.setOnItemClickListener(new MainAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int postion) {
                Toast.makeText(MainActivity.this, "点击了" + postion, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int postion) {
                Toast.makeText(MainActivity.this, "长安了" + postion, Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(adapter);
    }
}
