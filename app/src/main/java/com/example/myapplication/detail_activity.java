package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class detail_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Bundle bunble=getIntent().getExtras();
        if(bunble==null)
        {
            return;
        }
        User user= (User) bunble.get("object_user");
        TextView tvUserName= findViewById(R.id.tv_name_user);
        tvUserName.setText(user.getName());
    }
}