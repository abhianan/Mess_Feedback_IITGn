package adityagoel.iitgnmohanicanteen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class activity_one extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        Thread background = new Thread() {
            public void run() {

                try {
                    // Thread will sleep for 5 seconds
                    //http://www.cuelogic.com/blog/creatingreading-an-excel-file-in-android/ for excel part
                    sleep(2000);
                    startActivity(new Intent(getApplicationContext(), activity_two.class));
                    finish();

                } catch (Exception e) {

                }
            }
        };
        background.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

}

