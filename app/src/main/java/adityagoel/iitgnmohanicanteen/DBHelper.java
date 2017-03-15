package adityagoel.iitgnmohanicanteen;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Abhishek on 16-03-2016.
 */
public class DBHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "FEEDBACK";

    // Table columns
    public static final String _ID = "_id";
    public static final String S1 = "S1";
    public static final String S2 = "S2";
    public static final String S3 = "S3";
    public static final String S4 = "S4";
    public static final String S5 = "S5";

    public static final String L1 = "L1";
    public static final String L2 = "L2";
    public static final String L3 = "L3";
    public static final String L4 = "L4";
    public static final String L5 = "L5";
    public static final String L6 = "L6";
    public static final String L7 = "L7";

    public static final String ROLL = "ROLL";
    public static final String MAIL = "MAIL";
    // Database Information
    static final String DB_NAME = "FEEDBACK.DB";

    // database version
    static final int DB_VERSION = 1;

    // Creating table query
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + _ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + S1 + " TEXT , " + S2 + " TEXT , "+ S3 + " TEXT , " + S4 + " TEXT , "
            + S5 + " TEXT , " + L1 + " TEXT , " + L2 + " TEXT , " + L3 + " TEXT , " + L4 + " TEXT , " + L5 + " TEXT , "
            + L6 + " TEXT , " + L7 + " TEXT , " + ROLL + " TEXT , "+ MAIL + " TEXT);";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
