package com.fuicuiedu.xc.recyclerview_20170215;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

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
    private MyAdapter adapter;

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
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //设置适配器
        recyclerView.setAdapter(adapter = new MyAdapter());
    }

    //RecyclerView的适配器
    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

        //创建ViewHolder（泛型里，自己做的ViewHolder）
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_view,parent,false));
            return myViewHolder;
        }

        //数据绑定
        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.textView.setText(mData.get(position));
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }

        //自定义Viewholder
        class MyViewHolder extends RecyclerView.ViewHolder{
            TextView textView;

            public MyViewHolder(View itemView) {
                super(itemView);
                textView = (TextView) itemView.findViewById(R.id.item_tv);
            }
        }
    }
}
