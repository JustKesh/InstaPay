package hack.attwomen.allowancemanager;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {
	SQLiteDatabase db;
	JavaArrays arry = new JavaArrays();
	
	private EditText getUsername;
	private EditText getPassword;
	// private Button btnLogin;

	Intent loginCheck;
	private static final String DB_NAME = "Info.db";
	String user_type = "";
	Users database = new Users(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		db = database.getWritableDatabase();

		getUsername = (EditText) findViewById(R.id.editText1);
		getPassword = (EditText) findViewById(R.id.editText2);
		// btnLogin = (Button) findViewById(R.id.button1);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void checkLogin(View v) {
		String username = getUsername.getText().toString();
		String password = getPassword.getText().toString();
		String storedPwd;
		String storedUser;

		int size = arry.Users.length;
		 for (int i=0; i<size; i++)
		    {
			 if (username.equals(arry.Users[i])){
				 Log.i("MainActivity", "Login successful.");
				 user_type = arry.Users[i+2];
			 }
		    }
		/*
		 * String[] columns = new String[] { database.COLUMN_USERNAME,
		 * database.COLUMN_PASSWORD, database.COLUMN_USERTYPE}; Cursor cursor =
		 * db.query(database.TABLE_USERS, columns,null,null,null,null,null);
		 * 
		 * if (cursor.moveToFirst()) { do { storedUser =
		 * cursor.getString(cursor.getColumnIndex(database.COLUMN_USERNAME));
		 * storedPwd =
		 * cursor.getString(cursor.getColumnIndex(database.COLUMN_PASSWORD));
		 */
		// if username and password is found in the database ()
		/*if (username.equals("keshia.clarke@yahoo.com")) {
			Log.i("MainActivity", "Parent Login successful.");
			// user_type =
			// cursor.getString(cursor.getColumnIndex(database.COLUMN_USERTYPE));
			user_type = "Parent";
		} else if (username.equals("shelby.thomas@yahoo.com")) {
			Log.i("MainActivity", "Child Login successful.");
			user_type = "Child";
		}*/

		if (user_type == "Parent") {
			loginCheck = new Intent(MainActivity.this, GetStarted.class);
		} else {
			loginCheck = new Intent(MainActivity.this, ChildView.class);
		}
		startActivity(loginCheck);
		/*
		 * }
		 * 
		 * } while (cursor.moveToNext()); }
		 */

	}
}