package com.runfeng1688.lib.about;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.runfeng1688.lib.aboutscreen.AppAboutScreenActivity;
import com.runfeng1688.lib.aboutscreen.AppAboutScreenArguments;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView iv = findViewById(R.id.ivAppLogo);
//        iv.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        iv.setImageResource(R.mipmap.ic_launcher);
        Button btnDemo = findViewById(R.id.btnDemo);
        btnDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppAboutScreenActivity.launch(MainActivity.this,
                        new AppAboutScreenArguments(
                                getString(R.string.app_name),
                                "v1.0",
                                "粤ICP备 YYYYYYYYYY",
                                "https://cn.bing.com",
                                "https://www.runfeng1688.com/%E8%A5%BF%E8%A5%BF%E5%BC%97%E6%96%AFTask-%E7%94%A8%E6%88%B7%E4%BD%BF%E7%94%A8%E5%8D%8F%E8%AE%AE%E4%B8%8E%E9%9A%90%E7%A7%81%E6%9D%A1%E6%AC%BE.html",
                                "https://runfeng1688.com",
                                R.mipmap.ic_launcher
                        ));
            }
        });
    }
}