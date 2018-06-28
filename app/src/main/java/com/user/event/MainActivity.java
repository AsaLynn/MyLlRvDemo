package com.user.event;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTouch;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.layout_view3_name)
    TextView layoutView3Name;
    @BindView(R.id.recycler_view3)
    RecyclerView recyclerView3;
    @BindView(R.id.right_view3)
    ImageView rightView3;
    @BindView(R.id.layout_view3)
    LinearLayout layoutView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        recyclerView3.setHasFixedSize(true);
        recyclerView3.setNestedScrollingEnabled(false);
//        recyclerView3.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView3.setLayoutManager(new GridLayoutManager(this, 4));
        /*recyclerView3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    layoutView3.performClick();  //模拟父控件的点击
                }
                return false;
            }
        });*/


        ArrayList<String> data = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            data.add("1111" + i);
        }
        HomeAdapter adapter = new HomeAdapter(R.layout.activity_group_info_item);
        recyclerView3
                .setAdapter(adapter);
        adapter.setNewData(data);
    }

    @OnClick({/*R.id.layout_view3_name,  R.id.right_view3,*/ R.id.recycler_view3,R.id.layout_view3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
//            case R.id.layout_view3_name:
//                break;
            case R.id.recycler_view3:
                Toast.makeText(this, "这是recyclerview布局!", Toast.LENGTH_SHORT).show();
                break;
//            case R.id.right_view3:
//                Toast.makeText(this, "这是右侧按钮!", Toast.LENGTH_SHORT).show();
//                break;
            case R.id.layout_view3:
                Toast.makeText(this, "这是线性布局!", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public class HomeAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
        public HomeAdapter(int layoutResId) {
            super(layoutResId);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {
            Log.i(TAG, "convert: " + item);
            helper.setText(R.id.name, item);
        }
    }

   @OnTouch(R.id.recycler_view3)
    public boolean onViewTouch(View v, MotionEvent event){
       if (event.getAction() == MotionEvent.ACTION_UP) {
           layoutView3.performClick();
       }
       return false;
   }

}
