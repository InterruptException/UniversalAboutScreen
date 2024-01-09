package com.runfeng1688.lib.aboutscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AppAboutScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_about_screen);
        Intent intent = getIntent();
        ImageView ivLogo = findViewById(R.id.logo);
        TextView tvAppName = findViewById(R.id.name);
        TextView tvVerNum = findViewById(R.id.version_number);
        TextView tvIcpNum = findViewById(R.id.icp_number);
        TextView tvPrivacy = findViewById(R.id.privacy);
        TextView tvWebsite = findViewById(R.id.website);
        final AppAboutScreenArguments args = intent.getParcelableExtra("ARGS");
        assert args != null;
//        Bitmap bitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(), args.logoResId);
//        ivLogo.setImageBitmap(bitmap);

        ivLogo.setImageResource(args.logoResId);

        tvAppName.setText(args.appName);
        tvVerNum.setText(args.versionNumber);
        String icpText = String.format("<a href='%s'>%s</a>", args.icpLink, args.icpNumber);
        Log.d("[About]", icpText);
        tvIcpNum.setText(Html.fromHtml(icpText, Html.FROM_HTML_MODE_COMPACT));
        tvIcpNum.setMovementMethod(LinkMovementMethod.getInstance());
//        String privacyText = String.format("<a href='%s'>%s</a>", args.privacyLink, getString(R.string.privacy_policy));
        tvPrivacy.setText(getString(R.string.privacy_policy));
        tvPrivacy.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(AppAboutScreenActivity.this, AppPrivacyScreenActivity.class);
                        intent.putExtra("LINK", args.privacyLink);
                        startActivity(intent);
                    }
                }
        );
        tvWebsite.setText(args.websiteLink);

    }

    public static void launch(Activity activity, AppAboutScreenArguments args) {
        Intent intent = new Intent(activity, AppAboutScreenActivity.class);
//        intent.putExtra("appName", args.appName);
//        intent.putExtra("versionNumber", args.versionNumber);
//        intent.putExtra("icpNumber", args.icpNumber);
//        intent.putExtra("icpLink", args.icpLink);
//        intent.putExtra("privacyLink", args.privacyLink);
//        intent.putExtra("websiteLink", args.websiteLink);
//        intent.putExtra("logoResId", args.logoResId);
        intent.putExtra("ARGS", args);
        activity.startActivity(intent);
    }
}