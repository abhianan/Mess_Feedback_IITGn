package adityagoel.iitgnmohanicanteen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;


/**
 * Created by Aditya_Goel on 10-Mar-16.
 */
//http://javatechig.com/android/how-to-create-excel-file-in-android
//http://javatechig.com/android/android-sqlite-database-tutorial
public class activity_four extends AppCompatActivity {

    private Button submit;
    private EditText eT1, eT2;
    private SQLcontroller dbController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
        submit = (Button) findViewById(R.id.b1);
        eT1 = (EditText) findViewById(R.id.et1);
        eT2 = (EditText) findViewById(R.id.et2);

        dbController = new SQLcontroller(this);
        dbController.open();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = dbController.fetch();

                Intent i1=getIntent();
                Bundle ib= i1.getExtras();
                String rb1 = (String)ib.get("rb1");
                String rb2 =(String)ib.get("rb2");
                String rb3 = (String)ib.get("rb3");
                String rb4 = (String)ib.get("rb4");
                String rb5 = (String)ib.get("rb5");

                String t2 = (String)ib.get("t2");
                String t3 = (String)ib.get("t3");
                String t4 = (String)ib.get("t4");
                String t5 = (String)ib.get("t5");
                String t6 = (String)ib.get("t6");
                String t7 = (String)ib.get("t7");
                String t8 = (String)ib.get("t8");


                String RollNo = (eT1.getText().toString());
                String Email = (eT2.getText().toString());

                dbController.insert(rb1, rb2, rb3, rb4, rb5, t2, t3, t4, t5, t6, t7, t8, RollNo, Email);
                exportToExcel(cursor);

                Toast.makeText(getApplicationContext(),
                        "Thank You For Feedback", Toast.LENGTH_SHORT).show();

                Intent home_intent = new Intent(getApplicationContext(),
                        activity_one.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(home_intent);
            }
        });
    }
    private void exportToExcel(Cursor cursor) {
        final String fileName = "Feedback.xls";

        //Saving file in external storage
        File sdCard = Environment.getExternalStorageDirectory();
        File directory = new File(sdCard.getAbsolutePath() + "/Mess Feedback");

        //create directory if not exist
        if(!directory.isDirectory()){
            directory.mkdirs();
        }

        //file path
        File file = new File(directory, fileName);

        WorkbookSettings wbSettings = new WorkbookSettings();
        wbSettings.setLocale(new Locale("en", "EN"));
        WritableWorkbook workbook;

        try {
            workbook = Workbook.createWorkbook(file, wbSettings);
            //Excel sheet name. 0 represents first sheet
            WritableSheet sheet = workbook.createSheet("Feedback", 0);

            try {
                sheet.addCell(new Label(0, 0, "Short 1")); // column and row
                sheet.addCell(new Label(1, 0, "Short 2"));
                sheet.addCell(new Label(2, 0, "Short 3"));
                sheet.addCell(new Label(3, 0, "Short 4"));
                sheet.addCell(new Label(4, 0, "Short 5"));

                sheet.addCell(new Label(5, 0, "Long 1"));
                sheet.addCell(new Label(6, 0, "Long 2"));
                sheet.addCell(new Label(7, 0, "Long 3"));
                sheet.addCell(new Label(8, 0, "Long 4"));
                sheet.addCell(new Label(9, 0, "Long 5"));
                sheet.addCell(new Label(10, 0, "Long 6"));
                sheet.addCell(new Label(11, 0, "Long 7"));

                sheet.addCell(new Label(12, 0, "Roll No."));
                sheet.addCell(new Label(13, 0, "Email"));


                if (cursor.moveToFirst()) {
                    do {
                        String s1 = cursor.getString(cursor.getColumnIndex(DBHelper.S1));
                        String s2 = cursor.getString(cursor.getColumnIndex(DBHelper.S2));
                        String s3 = cursor.getString(cursor.getColumnIndex(DBHelper.S3));
                        String s4 = cursor.getString(cursor.getColumnIndex(DBHelper.S4));
                        String s5 = cursor.getString(cursor.getColumnIndex(DBHelper.S5));

                        String l1 = cursor.getString(cursor.getColumnIndex(DBHelper.L1));
                        String l2 = cursor.getString(cursor.getColumnIndex(DBHelper.L2));
                        String l3 = cursor.getString(cursor.getColumnIndex(DBHelper.L3));
                        String l4 = cursor.getString(cursor.getColumnIndex(DBHelper.L4));
                        String l5 = cursor.getString(cursor.getColumnIndex(DBHelper.L5));
                        String l6 = cursor.getString(cursor.getColumnIndex(DBHelper.L6));
                        String l7 = cursor.getString(cursor.getColumnIndex(DBHelper.L7));

                        String roll = cursor.getString(cursor.getColumnIndex(DBHelper.ROLL));
                        String email = cursor.getString(cursor.getColumnIndex(DBHelper.MAIL));

                        int i = cursor.getPosition() + 1;

                        sheet.addCell(new Label(0, i, s1));
                        sheet.addCell(new Label(1, i, s2));
                        sheet.addCell(new Label(2, i, s3));
                        sheet.addCell(new Label(3, i, s4));
                        sheet.addCell(new Label(4, i, s5));

                        sheet.addCell(new Label(5, i, l1));
                        sheet.addCell(new Label(6, i, l2));
                        sheet.addCell(new Label(7, i, l3));
                        sheet.addCell(new Label(8, i, l4));
                        sheet.addCell(new Label(9, i, l5));
                        sheet.addCell(new Label(10, i, l6));
                        sheet.addCell(new Label(11, i, l7));

                        sheet.addCell(new Label(12, i, roll));
                        sheet.addCell(new Label(13, i, email));

                    } while (cursor.moveToNext());
                }
                //closing cursor
                cursor.close();
            } catch (RowsExceededException e) {
                e.printStackTrace();
            } catch (WriteException e) {
                e.printStackTrace();
            }
            workbook.write();
            try {
                workbook.close();
            } catch (WriteException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}