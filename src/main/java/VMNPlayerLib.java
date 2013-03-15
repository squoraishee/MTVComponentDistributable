package main.java;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class VMNPlayerLib  {

	boolean cancelled = false;
	Activity act;
	
	public VMNPlayerLib(Activity act,String dialogMessage) {
		this.act = act;
		final Dialog dialog = new Dialog(act);
		dialog.setTitle(dialogMessage);
		  RelativeLayout relativeLayout = new RelativeLayout(act);

	        // Defining the RelativeLayout layout parameters.
	        // In this case I want to fill its parent
	        RelativeLayout.LayoutParams rlp = new RelativeLayout.LayoutParams(
	        RelativeLayout.LayoutParams.FILL_PARENT,
	        RelativeLayout.LayoutParams.FILL_PARENT);

	        // Creating a new TextView
	        ImageView image = new ImageView(act);
	        final TextView tv = new TextView(act);
	        tv.setText("This is a custom MTV Component");
	        image.setImageBitmap(BitmapFactory.decodeResource(act.getApplicationContext().getResources(),android.R.drawable.ic_menu_agenda));
	        //image.setImageBitmap(getImageBitmap("http://www.bangsandabun.com/wp-content/uploads/2011/04/MTV-Logo-MTV.jpg"));
		       
	        Button closeButton = new Button(act);
	        closeButton.setText("Close");
	        closeButton.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					cancelled = true;
					dialog.cancel();
				}
			});
	       
	        // Defining the layout parameters of the TextView
	        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
	                RelativeLayout.LayoutParams.WRAP_CONTENT,
	                RelativeLayout.LayoutParams.WRAP_CONTENT);
	        lp.addRule(RelativeLayout.CENTER_IN_PARENT);

	        // Setting the parameters on the TextView
	        tv.setLayoutParams(lp);

	        // Adding the TextView to the RelativeLayout as a child
	        relativeLayout.addView(image);
		    relativeLayout.addView(tv);
	        relativeLayout.addView(closeButton);
	        // Setting the RelativeLayout as our content view
	        dialog.setContentView(relativeLayout, rlp);
	        dialog.show();
	        
	}
	
}
