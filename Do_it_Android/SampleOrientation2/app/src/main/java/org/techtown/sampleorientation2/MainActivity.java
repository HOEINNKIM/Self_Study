package org.techtown.sampleorientation2;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            showToast("방향 : ORIENTATION_LANDSCAPE");
        } else if(newConfig.orientation  == Configuration.ORIENTATION_PORTRAIT){
            showToast("방향 : ORIENTATION_PORTRAIT");
        }

    }

    private void showToast(String s) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
        System.out.println("!!!!");
    }
}
