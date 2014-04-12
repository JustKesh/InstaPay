package hack.attwomen.allowancemanager;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AddChild extends Activity {
	
	SQLiteDatabase db;

	private EditText getChild1Name;
	private EditText getChild1Email;
	private EditText getChild1Phone;
	private EditText getChild2Name;
	private EditText getChild2Email;
	private EditText getChild2Phone;
	

	Intent insertChild;
	private static final String DB_NAME = "Info.db";
	Users database = new Users(this);
	
	public final static String childName1 = "com.example.allowancemanger.MESSAGE";
	public final static String childName2 = "com.example.allowancemanger.MESSAGE2";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addchild);
		
		db = database.getWritableDatabase();
		
		getChild1Name = (EditText) findViewById(R.id.editText1);
		getChild1Email = (EditText) findViewById(R.id.editText2);
		getChild1Phone = (EditText) findViewById(R.id.editText3);
		getChild2Name = (EditText) findViewById(R.id.editText4);
		getChild2Email = (EditText) findViewById(R.id.editText5);
		getChild2Phone = (EditText) findViewById(R.id.editText6);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_child, menu);
		return true;
	}
	
	public void storeChild (View v) {
		insertChild = new Intent(AddChild.this, TaskManager.class);
		EditText cName1 = getChild1Name;
		EditText cName2 = getChild2Name;
		String child1 = cName1.getText().toString();
		String child2 = cName2.getText().toString();
		insertChild.putExtra(childName1, child1);
		insertChild.putExtra(childName2, child2);
		startActivity(insertChild);
	}

}
