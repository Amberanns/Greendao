package com.bawei.zklianxi;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bawei.zklianxi.Fragment.HangqingFragment;
import com.bawei.zklianxi.Fragment.HomeFragment;
import com.bawei.zklianxi.Fragment.ZixuanFragment;
import com.bawei.zklianxi.Fragment.ZixunFragment;
import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.bottom_tab_bar)
    BottomTabBar bottomTabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        bottomTabBar.init(getSupportFragmentManager())
                .setImgSize(50, 50)
                .setFontSize(12)
                .setTabPadding(4, 6, 10)
                .setChangeColor(Color.RED, Color.DKGRAY)
                .addTabItem("首页", R.drawable.sy1, HomeFragment.class)
                .addTabItem("自选", R.drawable.ic_goods_list_ver, ZixuanFragment.class)
                .addTabItem("行情", R.drawable.car1, HangqingFragment.class)
                .addTabItem("咨询", R.drawable.wt1, ZixunFragment.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {


                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });
    }

    }

