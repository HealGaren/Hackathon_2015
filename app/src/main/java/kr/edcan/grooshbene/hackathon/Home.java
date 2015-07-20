package kr.edcan.grooshbene.hackathon;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.kakao.KakaoLink;
import com.kakao.KakaoParameterException;
import com.kakao.KakaoTalkLinkMessageBuilder;

import java.util.ArrayList;
import java.util.List;


public class Home extends Activity {
    public KakaoLink kakaoLink;
    public KakaoTalkLinkMessageBuilder kakaoTalkLinkMessageBuilder;
    ListView listv;
    int cnt;
    SharedPreferences pref1;
    SharedPreferences pref2;
    ArrayList<CData> dataArr;
    DataAdapter mAdapter;
    FloatingActionButton btn_add;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        listv = (ListView)findViewById(R.id.listv);
        pref1 = getSharedPreferences("lists",0);
        pref2 = getSharedPreferences("count",0);
        btn_add = (FloatingActionButton)findViewById(R.id.btn_add);
        btn_add.setColorNormalResId(R.color.white);
        btn_add.setColorPressedResId(R.color.white_pressed);
        btn_add.setIcon(R.drawable.heh);
        cnt = pref2.getInt("count",0);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Home.this, PlusDialog.class);
                startActivity(intent);

            }
        });
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
        //https://developers.kakao.com/docs/android 카카오톡 api
        //http://blog.saltfactory.net/mobile/using-kakaolink-api.html 카카오톡 api 설정 및 메시지 전송법
        dataArr = new ArrayList<CData>();
        mAdapter = new DataAdapter(Home.this, dataArr);
        listv.setAdapter(mAdapter);
        cnt = pref2.getInt("count",0);
        for(int i=0; i<cnt; i++) {
            String name = pref1.getString("name" + cnt, String.format("\0"));
            String fmil = pref1.getString("family" + cnt, String.format("\0"));
            String number = pref1.getString("number" + cnt, String.format("\0"));
            if(name.equals("\0") && fmil.equals("\0") && number.equals("\0")) continue;
            dataArr.add(new CData(getApplicationContext(), name, fmil, number));
        }
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

