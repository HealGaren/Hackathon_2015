package kr.edcan.grooshbene.hackathon;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by grooshbene on 15. 7. 21.
 */
public class PlusDialog extends Activity {
    ImageView ok;
    ImageView no;
    TextView tv_title;
    Typeface ty;
    int cnt;
    SharedPreferences pref1;
    SharedPreferences pref2;
    SharedPreferences.Editor edit1;
    SharedPreferences.Editor edit2;
    EditText te_number;
    EditText te_fmil;
    EditText te_name;
    String text_name;
    String text_fmil;
    String text_number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plus_dialog);
        ok = (ImageView)findViewById(R.id.ok);
        no = (ImageView)findViewById(R.id.no);
        te_fmil = (EditText)findViewById(R.id.te_fmil);
        te_name = (EditText)findViewById(R.id.te_name);
        te_number = (EditText)findViewById(R.id.tv_number);
        text_fmil = te_fmil.getText().toString();
        text_name = te_name.getText().toString();
        text_number = te_number.getText().toString();
        pref1 = getSharedPreferences("lists", 0);
        pref2 = getSharedPreferences("count", 0);
        edit1 = pref1.edit();
        edit2 = pref2.edit();
        cnt = pref2.getInt("count", 0)+1;

        tv_title = (TextView)findViewById(R.id.tv_title);
        ty = Typeface.createFromAsset(this.getAssets(),"NotoSansCJKkr-Regular.otf");
        tv_title.setTypeface(ty);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit1.putString("name"+cnt,text_name);
                edit1.putString("family"+cnt, text_fmil);
                edit1.putString("number"+cnt,text_number);
                edit1.apply();
                edit2.putInt("count", cnt);
                edit2.apply();
                finish();
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public void setWindowManager() {
        //������ �޾ƿͼ� dimAmount����, �̰� �׳� �Ȱǵ����? �ɵ�
        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.8f;
        getWindow().setAttributes(lpWindow);
    }
}
