package com.example.assignment3;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private boolean clickedBackButton = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        // Intent created to bind two components
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }

    public void sendMessageRelative(View viewrelative) {
        // Intent created to bind two components
        Intent intentrelative = new Intent(this, RelativeLayout.class);
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        String message = editText2.getText().toString();
        intentrelative.putExtra(EXTRA_MESSAGE, message);
        startActivity(intentrelative);
    }

    public void goToWebView(View view) {
        Intent intentWeb = new Intent(this, LayOutWebView.class);
        startActivity(intentWeb);
    }

    @Override
    public void onBackPressed() {
        if (!clickedBackButton){
            Toast.makeText(this, "Press back button again to exit", Toast.LENGTH_LONG).show();
            clickedBackButton = true;
        }
        else {
            super.onBackPressed();
        }

        new CountDownTimer(5000,1000){

            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                clickedBackButton = false;
            }
        }.start();
    }
}
