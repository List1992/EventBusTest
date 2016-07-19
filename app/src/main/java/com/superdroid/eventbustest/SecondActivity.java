package com.superdroid.eventbustest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 李松涛 on 2016/7/18 16:07.
 * desc：第二个页面
 */
public class SecondActivity extends AppCompatActivity {

    @BindView(R.id.tomain)
    Button mTomain;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.tomain)
    public void onClick() {
        EventBus.getDefault().post(new MyEventBus("EVENTBUS"));
    }

}
