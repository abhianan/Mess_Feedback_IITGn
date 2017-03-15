package adityagoel.iitgnmohanicanteen;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Abhishek on 16-03-2016.
 */
public class SQLcontroller {
    private DBHelper dbHelper;
    private Context context;
    private SQLiteDatabase database;

    public SQLcontroller(Context c) {
        context = c;
    }

    public SQLcontroller open() throws SQLException {
        dbHelper = new DBHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;

    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String s1,String s2,String s3,String s4,String s5,String l1,
                       String l2,String l3,String l4,String l5,String l6,String l7,String roll, String mail) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DBHelper.S1, s1);
        contentValue.put(DBHelper.S2, s2);
        contentValue.put(DBHelper.S3, s3);
        contentValue.put(DBHelper.S4, s4);
        contentValue.put(DBHelper.S5, s5);
        contentValue.put(DBHelper.L1, l1);
        contentValue.put(DBHelper.L2, l2);
        contentValue.put(DBHelper.L3, l3);
        contentValue.put(DBHelper.L4, l4);
        contentValue.put(DBHelper.L5, l5);
        contentValue.put(DBHelper.L6, l6);
        contentValue.put(DBHelper.L7, l7);
        contentValue.put(DBHelper.ROLL, roll);
        contentValue.put(DBHelper.MAIL, mail);
        database.insert(DBHelper.TABLE_NAME, null, contentValue);
    }

    public Cursor fetch() {
        String[] columns = new String[] {DBHelper._ID,DBHelper.S1,DBHelper.S2,DBHelper.S3,DBHelper.S4,DBHelper.S5,
                DBHelper.L1,DBHelper.L2,DBHelper.L3,DBHelper.L4,DBHelper.L5,DBHelper.L6,DBHelper.L7,DBHelper.ROLL,DBHelper.MAIL};
        Cursor cursor = database.query(DBHelper.TABLE_NAME, columns, null,
                null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }
}
