package adityagoel.iitgnmohanicanteen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Aditya_Goel on 09-Mar-16.
 */
public class activity_three extends AppCompatActivity {
    private Button skip, submit;
    private EditText et2,et3,et4,et5,et6,et7,et8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        et2=(EditText)findViewById(R.id.eT2);
        et3=(EditText)findViewById(R.id.eT3);
        et4=(EditText)findViewById(R.id.eT4);
        et5=(EditText)findViewById(R.id.eT5);
        et6=(EditText)findViewById(R.id.eT6);
        et7=(EditText)findViewById(R.id.eT7);
        et8=(EditText)findViewById(R.id.eT8);

        skip = (Button)findViewById(R.id.b1);
        submit = (Button)findViewById(R.id.b2);

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=getIntent();
                Bundle ib= i1.getExtras();
                String rb1 = (String)ib.get("rb1");
                String rb2 =(String)ib.get("rb2");
                String rb3 = (String)ib.get("rb3");
                String rb4 = (String)ib.get("rb4");
                String rb5 = (String)ib.get("rb5");

                Intent i =new Intent(getApplicationContext(), activity_four.class);
                i.putExtra("rb1",rb1);
                i.putExtra("rb2",rb2);
                i.putExtra("rb3",rb3);
                i.putExtra("rb4",rb4);
                i.putExtra("rb5",rb5);
                startActivity(i);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i1=getIntent();
                Bundle ib= i1.getExtras();
                String rb1 = (String)ib.get("rb1");
                String rb2 =(String)ib.get("rb2");
                String rb3 = (String)ib.get("rb3");
                String rb4 = (String)ib.get("rb4");
                String rb5 = (String)ib.get("rb5");


                String t2=et2.getText().toString();
                String t3=et3.getText().toString();
                String t4=et4.getText().toString();
                String t5=et5.getText().toString();
                String t6=et6.getText().toString();
                String t7=et7.getText().toString();
                String t8=et8.getText().toString();

                Intent i =new Intent(getApplicationContext(), activity_four.class);

                i.putExtra("rb1",rb1);
                i.putExtra("rb2",rb2);
                i.putExtra("rb3",rb3);
                i.putExtra("rb4",rb4);
                i.putExtra("rb5",rb5);

                i.putExtra("t2", t2);
                i.putExtra("t3", t3);
                i.putExtra("t4", t4);
                i.putExtra("t5", t5);
                i.putExtra("t6", t6);
                i.putExtra("t7", t7);
                i.putExtra("t8", t8);

                startActivity(i);
            }
        });
    }

}
