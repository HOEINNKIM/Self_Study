package org.techtown.graphics.custom.style;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CustomViewStyles styles = new CustomViewStyles(this);
        setContentView(styles);
    }
}
