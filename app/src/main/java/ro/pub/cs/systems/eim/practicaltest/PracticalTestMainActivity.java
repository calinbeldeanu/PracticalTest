package ro.pub.cs.systems.eim.practicaltest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTestMainActivity extends AppCompatActivity {


    Button changeActivity;
    Button center,topRight,topLeft,bottomLeft,bottomRight;
    EditText sablon;
    Integer hits  = 0;
    final Integer NR_HITS = 10;
    private IntentFilter intentFilter = new IntentFilter();
    boolean serviceStarted = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test_main);

        sablon = findViewById(R.id.sablon);
        topLeft = findViewById(R.id.leftTop);
        topRight = findViewById(R.id.rightTop);
        bottomLeft = findViewById(R.id.leftBottom);
        bottomRight = findViewById(R.id.rightBottom);
        center = findViewById(R.id.center);
        changeActivity = findViewById(R.id.changeActivity);



        topLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sablonText = sablon.getText().toString().trim();
                sablonText = sablonText + ", " + topLeft.getText().toString();
                sablon.setText(sablonText);
                hits++;
                if(hits > NR_HITS && serviceStarted == false) {
                    Intent intent = new Intent(getApplicationContext(), PracticalTestService.class);
                    intent.putExtra("sablon", sablon.getText().toString().trim());
                    PracticalTestMainActivity.this.startService(intent);
                    serviceStarted = true;
                    Toast.makeText(PracticalTestMainActivity.this, "SERVICE STARTED", Toast.LENGTH_SHORT).show();
                }
            }
        });

        topRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sablonText = sablon.getText().toString().trim();
                sablonText = sablonText + ", " + topRight.getText().toString();
                sablon.setText(sablonText);
                hits++;
                if(hits > NR_HITS && serviceStarted == false) {
                    Intent intent = new Intent(getApplicationContext(), PracticalTestService.class);
                    intent.putExtra("sablon", sablon.getText().toString().trim());
                    PracticalTestMainActivity.this.startService(intent);
                    serviceStarted = true;
                    Toast.makeText(PracticalTestMainActivity.this, "SERVICE STARTED", Toast.LENGTH_SHORT).show();
                }
            }
        });

        center.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sablonText = sablon.getText().toString().trim();
                sablonText = sablonText + ", " + center.getText().toString();
                sablon.setText(sablonText);
                hits++;
                if(hits > NR_HITS && serviceStarted == false) {
                    Intent intent = new Intent(getApplicationContext(), PracticalTestService.class);
                    intent.putExtra("sablon", sablon.getText().toString().trim());
                    PracticalTestMainActivity.this.startService(intent);
                    serviceStarted = true;
                    Toast.makeText(PracticalTestMainActivity.this, "SERVICE STARTED", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bottomLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sablonText = sablon.getText().toString().trim();
                sablonText = sablonText + ", " + bottomLeft.getText().toString();
                sablon.setText(sablonText);
                hits++;
                if(hits > NR_HITS && serviceStarted == false) {
                    Intent intent = new Intent(getApplicationContext(), PracticalTestService.class);
                    intent.putExtra("sablon", sablon.getText().toString().trim());
                    PracticalTestMainActivity.this.startService(intent);
                    serviceStarted = true;
                    Toast.makeText(PracticalTestMainActivity.this, "SERVICE STARTED", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bottomRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sablonText = sablon.getText().toString().trim();
                sablonText = sablonText + ", " + bottomRight.getText().toString();
                sablon.setText(sablonText);
                hits++;
                if(hits > NR_HITS && serviceStarted == false) {
                    Intent intent = new Intent(getApplicationContext(), PracticalTestService.class);
                    intent.putExtra("sablon", sablon.getText().toString().trim());
                    PracticalTestMainActivity.this.startService(intent);
                    serviceStarted = true;
                    Toast.makeText(PracticalTestMainActivity.this, "SERVICE STARTED", Toast.LENGTH_SHORT).show();
                }
            }
        });

        changeActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PracticalTestMainActivity.this, PracticalTestSecondaryActivity.class);
                intent.putExtra("sablon", sablon.getText().toString().trim());
                PracticalTestMainActivity.this.startActivity(intent);
            }
        });

        if(this.getIntent() != null){
            String response = this.getIntent().getStringExtra("response");
            if(response != null){
                Toast.makeText(this, response, Toast.LENGTH_SHORT).show();
                hits = 0;
                sablon.setText("");
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("hits", String.valueOf(hits));
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {


        if (savedInstanceState.containsKey("hits")) {
            hits = Integer.valueOf(savedInstanceState.getString("hits").toString());
            Toast.makeText(this, "Number of button hits:" + String.valueOf(hits), Toast.LENGTH_LONG).show();
        }
    }
    private MessageBroadcastReceiver messageBroadcastReceiver = new MessageBroadcastReceiver();
    private class MessageBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("lax", intent.getStringExtra("message"));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(messageBroadcastReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        unregisterReceiver(messageBroadcastReceiver);
        super.onPause();
    }
}
