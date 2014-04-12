package hack.attwomen.allowancemanager;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class GetStarted extends Activity {
	
	SQLiteDatabase db;

	private EditText getParentName;
	private EditText getParentEmail;
	private EditText getParentPhone;

	Intent insertParent;
	private static final String DB_NAME = "Info.db";
	Users database = new Users(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.getstarted);
		
		db = database.getWritableDatabase();
		
		getParentName = (EditText) findViewById(R.id.editText1);
		getParentEmail = (EditText) findViewById(R.id.editText2);
		getParentPhone = (EditText) findViewById(R.id.editText3);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.get_started, menu);
		return true;
	}
	
	public void storeParentCard(View v) {
		insertParent = new Intent(GetStarted.this, AddChild.class);
		startActivity(insertParent);
	}

}
