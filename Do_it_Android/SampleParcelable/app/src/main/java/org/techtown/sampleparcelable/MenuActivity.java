package org.techtown.sampleparcelable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MenuActivity extends AppCompatActivity {

    TextView textView;
    public static final String KEY_SIMPLE_DATA = "data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        textView = (TextView)findViewById(R.id.textView);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //인텐트 객체 생성
                Intent intent = new Intent();
                intent.putExtra("name", "wayne");

                setResult(RESULT_OK, intent);
                finish();
            }
        });

        //메인으로부터 받은 인텐드 확인
        Intent intent = getIntent();
        processIntent(intent);
    }

    private void processIntent(Intent intent){
        if(intent != null){
            //인텐트 안의 번들 객체 참조
            Bundle bundle = intent.getExtras();

            //번들 객체 내의 SimpleData 참조
            SimpleData data = (SimpleData)bundle.getParcelable(KEY_SIMPLE_DATA);

            //텍스트 뷰에 값 표기
            textView.setText("전달 받은 데이터\nNumber : " + data.getNumber() + "\nMessage : " + data.getMessage());
        }
    }

}
