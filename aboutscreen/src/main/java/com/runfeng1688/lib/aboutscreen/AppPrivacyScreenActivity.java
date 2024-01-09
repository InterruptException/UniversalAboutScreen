package com.runfeng1688.lib.aboutscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import com.google.android.material.appbar.MaterialToolbar;

public class AppPrivacyScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_screen);
//        getSupportActionBar()

        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        String link = getIntent().getStringExtra("LINK");
        assert link != null;
        WebView wv = findViewById(R.id.wv);
        wv.loadUrl(link);

    }
}