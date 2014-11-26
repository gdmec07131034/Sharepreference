package com.example.sharepreference;

import java.util.prefs.Preferences;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MyMainActivity extends ActionBarActivity {
	private SharedPreferences preferences;
	private Editor editor;
	
	private EditText et;
	private TextView tv;
	private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_main);
        
        et = (EditText) findViewById(R.id.editText1);
        tv= (TextView) findViewById(R.id.textView1);
        btn = (Button) findViewById(R.id.button1);
        
        preferences = getPreferences(Context.MODE_PRIVATE);
        
        String text = preferences.getString("key", "我是默认值");
        
        tv.setText(text);
        
        btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				editor = preferences.edit();
				editor.putString("key", et.getText().toString());
				
				editor.commit();
				
			}});
    }


  
}
