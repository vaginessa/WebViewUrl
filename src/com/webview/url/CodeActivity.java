package com.webview.url;

import com.webview.url.codes.ResActivity;
import com.webview.url.codes.SfcActivity;
import com.webview.url.info.InfoActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.view.View.OnClickListener;

public class CodeActivity extends AppCompatActivity{
	
	 @Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
	            WindowManager.LayoutParams.FLAG_FULLSCREEN);
	    setContentView(R.layout.activity_code);
	 
	  final Button btres = (Button) findViewById(R.id.Button1);

	  btres.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
			 Intent resIntent = new Intent(getApplicationContext(), ResActivity.class);
	    		
	    		startActivity(resIntent);
				
			}
			
	    });
	  
	  final Button btsfc = (Button) findViewById(R.id.Button2);

	  btsfc.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
			 Intent resIntent = new Intent(getApplicationContext(), SfcActivity.class);
	    		
	    		startActivity(resIntent);
				
			}
			
	    });
	  
	 }
	  
	  @Override
		public boolean onCreateOptionsMenu(Menu menu){
			MenuInflater inflater = getMenuInflater();
			inflater.inflate(R.menu.contact_menu, menu);
			return true;
	  
	 }
	  
	  @Override
		public boolean onOptionsItemSelected(MenuItem item)
		{
			switch (item.getItemId())
			{
				case R.id.action_info:
					startActivity(new Intent(this, InfoActivity.class));
					return true;
				default:
					return super.onOptionsItemSelected(item);
			}
         }
      }

