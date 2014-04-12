package hack.attwomen.allowancemanager;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class ChildView extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.childview);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.child_view, menu);
		return true;
	}

	//when child clicks Mark Complete button
    public void markComplete (View view){
    	//Intent intent = new Intent(this, DisplayMessageActivity.class);
    	
    	CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox1);
    	CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
    	String message = "";
    	if (checkBox.isChecked() && checkBox2.isChecked()){
    		message = checkBox.getText().toString() + "\n" + checkBox2.getText().toString();
    	}
    	else if (checkBox.isChecked() && !checkBox2.isChecked()){
    		message = checkBox.getText().toString();
    	}
    	else if (!checkBox.isChecked() && checkBox2.isChecked()){
    		message = checkBox2.getText().toString();
    	}
    	else {
    		message = "You didn't select any tasks to mark complete.";
    	}
    	Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    	//intent.putExtra(COMPLETE_TASKS, message);
    	//startActivity(intent);
    }
}
