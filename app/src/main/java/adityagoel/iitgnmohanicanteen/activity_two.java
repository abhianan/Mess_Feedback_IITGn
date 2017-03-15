package adityagoel.iitgnmohanicanteen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by Aditya_Goel on 09-Mar-16.
 */
public class activity_two extends AppCompatActivity {
    Button submit;
    RadioGroup rg1,rg2,rg3,rg4,rg5;
    RadioButton rb1, rb2, rb3, rb4,rb5;
    String s1,s2,s3,s4,s5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        rg1=(RadioGroup)findViewById(R.id.rg1);
        rg2=(RadioGroup)findViewById(R.id.rg2);
        rg3=(RadioGroup)findViewById(R.id.rg3);
        rg4=(RadioGroup)findViewById(R.id.rg4);
        rg5=(RadioGroup)findViewById(R.id.rg5);


        submit =(Button)findViewById(R.id.b1);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(rg1.getCheckedRadioButtonId()==-1) {
                    s1="Not Filled";
                }else{
                    int sel1=rg1.getCheckedRadioButtonId();
                    rb1=(RadioButton)findViewById(sel1);
                    s1 = rb1.getText().toString();
                }
                if(rg2.getCheckedRadioButtonId()==-1) {
                    s2="Not Filled";
                }else{
                    int sel2=rg2.getCheckedRadioButtonId();
                    rb2=(RadioButton)findViewById(sel2);
                    s2 = rb2.getText().toString();
                }
                if(rg3.getCheckedRadioButtonId()==-1) {
                    s3="Not Filled";
                }else{
                    int sel3=rg3.getCheckedRadioButtonId();
                    rb3=(RadioButton)findViewById(sel3);
                    s3 = rb3.getText().toString();
                }
                if(rg4.getCheckedRadioButtonId()==-1) {
                    s4="Not Filled";
                }else{
                    int sel4=rg4.getCheckedRadioButtonId();
                    rb4=(RadioButton)findViewById(sel4);
                    s4 = rb4.getText().toString();
                }
                if(rg5.getCheckedRadioButtonId()==-1) {
                    s5="Not Filled";
                }else{
                    int sel5=rg5.getCheckedRadioButtonId();
                    rb5=(RadioButton)findViewById(sel5);
                    s5 = rb5.getText().toString();
                }

                Intent i =new Intent(getApplicationContext(), activity_three.class);
                i.putExtra("rb1",s1);
                i.putExtra("rb2",s2);
                i.putExtra("rb3",s3);
                i.putExtra("rb4",s4);
                i.putExtra("rb5",s5);

                startActivity(i);

            }
        });
    }
}

