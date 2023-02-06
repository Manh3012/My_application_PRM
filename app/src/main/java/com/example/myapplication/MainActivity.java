package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1;
    Button btnLaunchSecondApp;
    EditText t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button)findViewById(R.id.button1);
        t1 = (EditText)findViewById(R.id.editText1);
        t2 = (EditText)findViewById(R.id.editText2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = t1.getText().toString();
                String password = t2.getText().toString();
                if(t1.getText().toString().equals("admin") &&
                        t2.getText().toString().equals("12345")) {
                    Toast.makeText(getApplicationContext(),
                            "Complete...",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, UserActivity.class);
                    startActivity(intent);
                }else {
                    // Login failed
                    Toast.makeText(MainActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                }
            }

        });

        btnLaunchSecondApp = findViewById(R.id.btnLaunchSecondApp);

        btnLaunchSecondApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Use Intent to launch the second application
                Intent intent = getPackageManager().getLaunchIntentForPackage("com.example.instagram");
                startActivity(intent);
            }
        });
    }
}