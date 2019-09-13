package tz.co.neelansoft.sqlite_demo.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Landry Kapela on 13/09/2019.
 */

public class MySQLiteHelper extends SQLiteOpenHelper {
	
	private static final String CREATE_TABLE_QUERY = "CREATE TABLE " + DemoContract.Items.TABLE_NAME +"(" + DemoContract.Items._ID + " INTEGER PRIMARY KEY, "+ DemoContract.Items.COLUMN_NAME_NAME + " TEXT, " + DemoContract.Items.COLUMN_NAME_DESCRIPTION +"TEXT)";
	private static final String UPGRADE_QUERY = "DROP TABLE IF EXISTS " + DemoContract.Items.TABLE_NAME;
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "homeitems.db";
	
	public MySQLiteHelper(Context ctx){
		super(ctx, DATABASE_NAME ,null,DATABASE_VERSION);
	}
	@Override
	public void onCreate(SQLiteDatabase db){
		db.execSQL(CREATE_TABLE_QUERY);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer){
		db.execSQL(UPGRADE_QUERY);
		onCreate(db);
	}
}
