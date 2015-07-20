package kr.edcan.grooshbene.hackathon;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.kakao.KakaoLink;
import com.kakao.KakaoParameterException;
import com.kakao.KakaoTalkLinkMessageBuilder;

import java.util.ArrayList;
import java.util.List;


public class Home extends ActionBarActivity {
    public KakaoLink kakaoLink;
    public KakaoTalkLinkMessageBuilder kakaoTalkLinkMessageBuilder;
    ListView listv;
    ArrayList<CData> dataArr;
    DataAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        listv = (ListView)findViewById(R.id.listv);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try {
//                    kakaoLink = KakaoLink.getKakaoLink(getApplicationContext());
//                    kakaoTalkLinkMessageBuilder = kakaoLink.createKakaoTalkLinkMessageBuilder();
//                    kakaoTalkLinkMessageBuilder.addText("박지수님이 당신을 지목하였습니다.");
//                    kakaoTalkLinkMessageBuilder.addImage("https://lh3.googleusercontent.com/-iSOlEUxX5E8/VazgGlcSToI/AAAAAAAAAFU/rygHzNrUVXY/w346-h221/main.png", 300, 200);
//                    kakaoTalkLinkMessageBuilder.addAppLink("앱으로 연결합니다");
//                    kakaoLink.sendMessage(kakaoTalkLinkMessageBuilder.build(), Home.this);
//                    kakaoTalkLinkMessageBuilder = kakaoLink.createKakaoTalkLinkMessageBuilder();
//                } catch (KakaoParameterException e) {
//                    Log.e("error", e.getMessage());
//                }
//            }
//        });
        dataArr = new ArrayList<CData>();
        mAdapter = new DataAdapter(Home.this, dataArr);
        listv.setAdapter(mAdapter);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

