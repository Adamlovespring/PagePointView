package com.adam.pagepointview;

import android.app.Activity;
import android.os.Bundle;

import com.adam.library.ui.PagePointView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PagePointView pagePointView = (PagePointView) findViewById(R.id.pagePointView);
        pagePointView.setPointRadius(DimenUtil.dp2px(this,20));
    }
}
