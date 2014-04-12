package hack.attwomen.allowancemanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Users extends SQLiteOpenHelper {
private	String UserID;
private	String Name;
private	String Username;
private	String Password;
private	String Usertype;
private	String AccountEmail;
	
private	String ChoresID;
private	String Assignee;
private	String Completed;
private	String DueDate;
private	String DateCompleted;
	
	private static final String DATABASE_NAME = "Info.db";
	private static final int DATABASE_VERSION = 1;
	
	// Users Table variables
  public static final String COLUMN_USERID = "_id";
  public static final String COLUMN_NAME = "name";
  public static final String COLUMN_USERNAME = "username";
  public static final String COLUMN_PASSWORD = "password";
  public static final String COLUMN_USERTYPE = "usertype";
  public static final String COLUMN_ACCOUNTEMAIL = "accountEmail";
  public static final String TABLE_USERS = "Users";
  
  // Chores Table variables
  public static final String COLUMN_CHORESID = "_choresID";
  public static final String COLUMN_ASSIGNEE = "assignee";
  public static final String COLUMN_COMPLETED = "completed";
  public static final String COLUMN_DUEDATE = "dueDate";
  public static final String COLUMN_DATECOMPLETED = "dateCompleted";
  public static final String TABLE_CHORES = "Chores";
  
    // Database creation sql statement
  private static final String DATABASE_CREATE1 = "create table "
      + TABLE_USERS + "(" + COLUMN_USERID + " text not null,"
		  + COLUMN_NAME + " text," 
		  + COLUMN_USERNAME + " text not null,"
          + COLUMN_PASSWORD + " text not null," 
		  + COLUMN_USERTYPE + " text not null,"
		  + COLUMN_ACCOUNTEMAIL + " text not null);";
		  
  
  // Database creation sql statement
  private static final String DATABASE_CREATE2 = "create table "
      + TABLE_CHORES + "(" + COLUMN_CHORESID + " text," 
		  + COLUMN_ASSIGNEE + " text,"
          + COLUMN_COMPLETED + " text," 
		  + COLUMN_DUEDATE + " text,"
		  + COLUMN_DATECOMPLETED+ " text);";
		  

  public Users(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase database) {
    database.execSQL(DATABASE_CREATE1);
    database.execSQL(DATABASE_CREATE2);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    Log.w(Users.class.getName(),
        "Upgrading database from version " + oldVersion + " to "
            + newVersion + ", which will destroy all old data");
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHORES);
    onCreate(db);
  }

	public void setUserID(String UserID)
	{ 
		this.UserID = UserID;
	}
	
	public String getUserID()
	{
		return UserID;
	}
	
	public void setName(String Name)
	{ 
		this.Name = Name;
	}
	
	public String getName()
	{
		return Name;
	}
	
	public void setUsername(String Username)
	{ 
		this.Username = Username;
	}
	
	public String getUsername()
	{
		return Username;
	}
	
	public void setPassword(String Password)
	{ 
		this.Password = Password;
	}
	
	public String getPassword()
	{
		return Password;
	}
	
	public void setUsertype(String Usertype)
	{ 
		this.Usertype = Usertype;
	}
	
	public String getUsertype()
	{
		return Usertype;
	}
	
	public void setAccountEmail(String AccountEmail)
	{ 
		this.AccountEmail = AccountEmail;
	}
	
	public String getAccountEmail()
	{
		return AccountEmail;
	}
	
	public void setChoresID(String ChoresID)
	{ 
		this.ChoresID = ChoresID;
	}
	
	public String getChoresID()
	{
		return ChoresID;
	}
	
	public void setAssignee(String Assignee)
	{ 
		this.Assignee = Assignee;
	}
	
	public String getAssignee()
	{
		return Assignee;
	}
	public void setCompleted(String Completed)
	{ 
		this.Completed = Completed;
	}
	
	public String getCompleted()
	{
		return Completed;
	}
	
	public void setDueDate(String DueDate)
	{ 
		this.DueDate = DueDate;
	}
	
	public String getDueDate()
	{
		return DueDate;
	}

	public void setDateCompleted(String DateCompleted)
	{ 
		this.DateCompleted = DateCompleted;
	}
	
	public String getDateCompleted()
	{
		return DateCompleted;
	}
}
