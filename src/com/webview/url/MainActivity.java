package com.webview.url;

import static android.widget.Toast.LENGTH_SHORT;
import static java.lang.System.currentTimeMillis;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	private WebView myWebView;

	@SuppressLint("SetJavaScriptEnabled") @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
		this.setContentView(R.layout.activity_main);

		 this.myWebView = (WebView) this.findViewById(R.id.webView);

		 myWebView.addJavascriptInterface(new WebAppInterface(this),
		 "Android");
		
		    WebSettings webSettings = myWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);

			//Provide a WebViewClient for your WebView
			myWebView.setWebViewClient(new MyWebViewClient());

			myWebView.loadUrl("http://www.ccdevs.es");

	}

	@Override
	public void onBackPressed() {

		if (this.myWebView.canGoBack())
			this.myWebView.goBack();
		else
			super.onBackPressed();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_menu, menu);
		return true;
		
    }
		
		@Override
		public boolean onOptionsItemSelected(MenuItem item)
		{
			switch (item.getItemId())
			{
				case R.id.action_code:
					startActivity(new Intent(this, CodeActivity.class));
					return true;
				default:
					return super.onOptionsItemSelected(item);
					
			}				
		}
	
	private class MyWebViewClient extends WebViewClient {

		private long loadTime;

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {

			if (Uri.parse(url).getHost().equals("android_asset/ejemplo.html")) {
				// This is my web site, so do not override; let my WebView load
				// the page
				return false;
			}

			Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
			startActivity(intent);
			return true;
		}

		@Override
		public void onPageStarted(WebView view, String url, Bitmap favicon) {
			super.onPageStarted(view, url, favicon);

			// Save start time
			this.loadTime = currentTimeMillis();

			// Show a toast
			Toast.makeText(getApplicationContext(),
					"La página esta cargando...", LENGTH_SHORT).show();
		}

		@Override
		public void onPageFinished(WebView view, String url) {
			super.onPageFinished(view, url);

			// Calculate load time
			this.loadTime = currentTimeMillis() - this.loadTime;

			// Convert milliseconds to date format
			String time = new SimpleDateFormat("mm:ss:SSS", Locale.getDefault())
					.format(new Date(this.loadTime));

			// Show a toast
			Toast.makeText(getApplicationContext(),
					"La página terminó de cargar " + time, LENGTH_SHORT)
					.show();

		}
		
	}

}

