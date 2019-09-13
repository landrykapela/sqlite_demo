package tz.co.neelansoft.sqlite_demo.database;

import android.provider.BaseColumns;

/**
 * Created by Landry Kapela on 13/09/2019.
 */

public final class DemoContract {
	//all global constacts required by the datase are defined here
	
	private DemoContract(){}
	
	public static class Items implements BaseColumns {
	
		public static final String TABLE_NAME = "items";
		public static final String COLUMN_NAME_NAME = "name";
		public static final String COLUMN_NAME_DESCRIPTION = "description";
		
	}
	
	public static class Animals implements BaseColumns {
		
		public static final String TABLE_NAME = "animals";
		public static final String COLUMN_NAME_NAME = "name";
		public static final String COLUMN_NAME_TYPE = "type";
		
	}
	
}
