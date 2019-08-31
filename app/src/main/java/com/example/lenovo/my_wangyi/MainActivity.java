package com.example.lenovo.my_wangyi;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
      private TabLayout mTabLayout;
      private ViewPager mViewPager;
      private List<Fragment> mList=new ArrayList<Fragment>();
      private MyFragmentAdapter mMyFragmentAdapter;
      private Context mContext;
    private String[] titles=new String[]{"我的","发现","云村","视频"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
    mTabLayout=findViewById(R.id.tl_tabs);
    mViewPager=findViewById(R.id.vp);
    mList.add(new MineFragment());
    mList.add(new FindFragment());
    mList.add(new YCFragment());
    mList.add(new SPFragment());
        for(int i=0;i<titles.length;i++){
            mTabLayout.addTab(mTabLayout.newTab());
        }
        mTabLayout.setupWithViewPager(mViewPager,false);
        mMyFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(),mList);
        for(int i=0;i<titles.length;i++){
            mTabLayout.getTabAt(i).setText(titles[i]);
        }

    }
}
