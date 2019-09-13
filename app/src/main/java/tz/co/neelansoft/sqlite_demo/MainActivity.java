package tz.co.neelansoft.sqlite_demo;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import tz.co.neelansoft.sqlite_demo.database.DemoContract;
import tz.co.neelansoft.sqlite_demo.database.MySQLiteHelper;

public class MainActivity extends AppCompatActivity {
	
	MySQLiteHelper dbHelper;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		dbHelper = new MySQLiteHelper(this);
		
		final EditText etName = findViewById(R.id.etName);
		final EditText etDescription = findViewById(R.id.etDescription);
		Button btnSave = findViewById(R.id.btnSave);
		Button btnView = findViewById(R.id.btnView);
		
		btnSave.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String name = etName.getText().toString();
				String description = etDescription.getText().toString();
				if(!name.isEmpty()){
					long result = saveItem(name,description);
					Toast.makeText(MainActivity.this,"Successful with id: "+String.valueOf(result), Toast.LENGTH_LONG).show();
				}
				
			}
		});
		
		btnView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, ShowItemsActivity.class));
				
			}
		});
		
	}
	
	private long saveItem(String itemName, String itemDesc){
		ContentValues values = new ContentValues();
		values.put(DemoContract.Items.COLUMN_NAME_NAME, itemName);
		values.put(DemoContract.Items.COLUMN_NAME_DESCRIPTION,itemDesc);
		
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		
		return db.insert(DemoContract.Items.TABLE_NAME,null,values);
	}
}
