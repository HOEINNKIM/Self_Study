package org.techtown.samplecallintent;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    public static final int REQUEST_CODE_MENU = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.editText);

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String data = editText.getText().toString();

                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(data));
                startActivity(intent);
            }
        });
    }

    public void onButton1Clicked(View v){
        Intent intent = new Intent();

        ComponentName name = new ComponentName("org.techtown.samplecallintent", "org.techtown.samplecallintent.MenuActivity");
        intent.setComponent(name);
        startActivityForResult(intent, REQUEST_CODE_MENU);
    }

}
