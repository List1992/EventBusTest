package com.superdroid.eventbustest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tosecond)
    Button mTosecond;
    @BindView(R.id.desc)
    TextView mDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        EventBus.getDefault().register(this);

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void receiveMsg(MyEventBus bus) {

        String msg = bus.getMsg();

        mDesc.setText(msg);
    }

    @OnClick(R.id.tosecond)
    public void OnClick(View v) {

        startActivity(new Intent(this, SecondActivity.class));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
