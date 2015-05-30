package com.webview.url.codes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.webview.url.R;

	public class SfcActivity extends AppCompatActivity {
		private WebView mWebView;

		@Override
		public void onCreate(Bundle icicle) {
		    super.onCreate(icicle);
		    
		    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
		            WindowManager.LayoutParams.FLAG_FULLSCREEN);
		    setContentView(R.layout.activity_sfc);

		    mWebView = (WebView) findViewById(R.id.webview);
		    WebSettings webSettings = mWebView.getSettings();
	        webSettings.setBuiltInZoomControls(true);
		 			mWebView.loadUrl("file:///android_asset/sfc_uno.html");
		 		
		 		mWebView.requestFocus();
		 		
		}

		  @Override
		  public boolean onCreateOptionsMenu(Menu menu){
		 		MenuInflater inflater = getMenuInflater();
		 		inflater.inflate(R.menu.main_direccion, menu);
		 		return true;
		 		  
		 }
		 		  
		  @Override
		  public boolean onOptionsItemSelected(MenuItem item)
		  
		 {
		 		switch (item.getItemId())
		 {
		 		case R.id.action_direccion:
		 		startActivity(new Intent(this, SfcActivityDos.class));
		 		return true;
		 		default:
		 		return super.onOptionsItemSelected(item);
		 		
		 	  }
		 			 
		   }

		}
	