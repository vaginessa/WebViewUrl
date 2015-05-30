package com.webview.url;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.webkit.JavascriptInterface;

public class WebAppInterface {

	Context context;

	public WebAppInterface(Context context) {
		this.context = context;
	}

	
	@JavascriptInterface
	public void showDialog(String message) {

		// Use the Builder class for convenient dialog construction
		AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
		builder.setMessage(message).setNeutralButton("OK",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						dialog.dismiss();
					}
				});
		// Create the AlertDialog object and return it
		builder.create().show();
	}
}
