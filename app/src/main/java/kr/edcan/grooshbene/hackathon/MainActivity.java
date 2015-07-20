package kr.edcan.grooshbene.hackathon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.kakao.KakaoLink;
import com.kakao.KakaoTalkLinkMessageBuilder;

public class MainActivity extends Activity {
    LinearLayout splash;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        splash = (LinearLayout)findViewById(R.id.splash);
        splash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, Home.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
