package hack.attwomen.allowancemanager;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.TextView;

public class TaskManager extends Activity {
	
	SQLiteDatabase db;

	private EditText getChild1TaskOne;
	private EditText getChild1TaskTwo;
	private EditText getChild2TaskOne;
	private EditText getChild2TaskTwo;
	private String passChildName1;
	private String passChildName2;
	
	public final static String c1t1 = "com.example.allowancemanger.MESSAGE3";
	public final static String c1t2 = "com.example.allowancemanger.MESSAGE4";
	public final static String c2t1 = "com.example.allowancemanger.MESSAGE5";
	public final static String c2t2 = "com.example.allowancemanger.MESSAGE6";
	public final static String c1n1 = "com.example.allowancemanger.MESSAGE7";
	public final static String c2n1 = "com.example.allowancemanger.MESSAGE8";

	Intent insertTask;
	private static final String DB_NAME = "Info.db";
	Users database = new Users(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.todolist);
		
		db = database.getWritableDatabase();
		
		getChild1TaskOne = (EditText) findViewById(R.id.editText1);
		getChild1TaskTwo = (EditText) findViewById(R.id.editText2);
		getChild2TaskOne = (EditText) findViewById(R.id.editText3);
		getChild2TaskTwo = (EditText) findViewById(R.id.editText4);
		
		Intent intent = getIntent();
		String childName1 = intent.getStringExtra(AddChild.childName1);
		String childName2 = intent.getStringExtra(AddChild.childName2);
		passChildName1 = childName1;
		passChildName2 = childName2;
				
		TextView textView = (TextView) findViewById(R.id.textView1);
	    textView.setTextSize(20);
	    textView.setText(childName1);
	    
	    TextView textView2 = (TextView) findViewById(R.id.textView2);
	    textView2.setTextSize(20);
	    textView2.setText(childName2);
	    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.task_manager, menu);
		return true;
	}
	
	public void submit(View v) {
		insertTask= new Intent(TaskManager.this, ParentView.class);
		EditText c1task1 = getChild1TaskOne;
		EditText c1task2 = getChild1TaskTwo;
		EditText c2task1 = getChild2TaskOne;
		EditText c2task2 = getChild2TaskTwo;
		String c1task1txt = c1task1.getText().toString();
		String c1task2txt = c1task2.getText().toString();
		String c2task1txt = c2task1.getText().toString();
		String c2task2txt = c2task2.getText().toString();
		insertTask.putExtra(c1t1, c1task1txt);
		insertTask.putExtra(c1t2, c1task2txt);
		insertTask.putExtra(c2t1, c2task1txt);
		insertTask.putExtra(c2t2, c2task2txt);
		insertTask.putExtra(c1n1, passChildName1);
		insertTask.putExtra(c2n1, passChildName2);
		startActivity(insertTask);
	}

}
