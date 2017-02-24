package com.example.sunny.sensorexhibit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.MainText);
    }
    float x1 = 0.0f;
    float x2 = 0.0f;

    // 点击屏幕事件
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x1 = x;
                break;
            case MotionEvent.ACTION_UP:
                x2 = x;
                if (x1 > x2) {
                    // 向左滑
                    Intent intent = new Intent();
                    intent.setClass(getApplicationContext(), ListViewActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.demo_scale, R.anim.demo_translate);
                } else if (x1 < x2 || x1 == x2) {
                    Toast.makeText(getApplicationContext(), "向左滑获取本机所有传感器信息", Toast.LENGTH_SHORT).show();
                    return false;
                }
            default:
                break;
        }

        return super.onTouchEvent(event);
    }


}
