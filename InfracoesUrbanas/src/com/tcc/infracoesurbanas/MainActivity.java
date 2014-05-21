package com.tcc.infracoesurbanas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void onEnterButtonClick(View v){
    	Intent i = new Intent();
    	i.setClass(this, com.tcc.infracoesurbanas.Menu.class);
    	startActivity(i);
    }
}
