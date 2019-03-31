package ro.pub.cs.systems.eim.practicaltest;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTestSecondaryActivity extends AppCompatActivity {

    EditText rezultat;
    Button verify,cancel;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test_secondary);


        rezultat = findViewById(R.id.rez);
        verify = findViewById(R.id.verify);
        cancel = findViewById(R.id.cancel);

        Intent intent = this.getIntent();
        String value = intent.getStringExtra("sablon").toString();
        rezultat.setText(value);
        activity =this;


        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PracticalTestSecondaryActivity.this, PracticalTestMainActivity.class);
                intent.putExtra("response" , "verify");
                activity.startActivity(intent);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PracticalTestSecondaryActivity.this, PracticalTestMainActivity.class);
                intent.putExtra("response" , "cancel");
                activity.startActivity(intent);
            }
        });



    }
}
