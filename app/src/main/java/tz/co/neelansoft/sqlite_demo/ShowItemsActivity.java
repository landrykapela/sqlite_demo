package tz.co.neelansoft.sqlite_demo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import tz.co.neelansoft.sqlite_demo.database.DemoContract;
import tz.co.neelansoft.sqlite_demo.database.MySQLiteHelper;

/**
 * Created by Landry Kapela on 13/09/2019.
 */

public class ShowItemsActivity extends AppCompatActivity {
	
	MySQLiteHelper dbHelper;
	SQLiteDatabase db;
	
	ArrayList<String> itemList = new ArrayList<>();
	ListView listView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_show_items);
		dbHelper = new MySQLiteHelper(this);
		
		listView = findViewById(R.id.listView);
		
		new readDatabase().execute();
		
	}
	
	
	private class readDatabase extends AsyncTask<String,Integer,String>{
		
		@Override
		protected String doInBackground(String... strings) {
			
			db = dbHelper.getReadableDatabase();
			
			Cursor cursor = db.query(DemoContract.Items.TABLE_NAME,new String[]{DemoContract.Items._ID,DemoContract.Items.COLUMN_NAME_NAME,DemoContract.Items.COLUMN_NAME_DESCRIPTION},"",new String[]{},null,null,DemoContract.Items.COLUMN_NAME_NAME+" DESC");
			
			
			while(cursor.moveToNext()){
				itemList.add(cursor.getString(cursor.getColumnIndex(DemoContract.Items.COLUMN_NAME_NAME)));
			}
			return null;
		}
		
		protected void onPostExecute(String s){
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(ShowItemsActivity.this,android.R.layout.simple_list_item_1,itemList);
			
			listView.setAdapter(adapter);
		}
	}
}
