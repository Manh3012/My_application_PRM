package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity {
    private RecyclerView rev_user;
    private UserAdapter userAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        rev_user=findViewById(R.id.rev_user);
        userAdapter=new UserAdapter(this);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rev_user.setLayoutManager(linearLayoutManager);
        userAdapter.SetData(getListuser());
        rev_user.setAdapter(userAdapter);

    }
    @NonNull
    private List<User> getListuser()
    {
        List<User> list=new ArrayList<User>();
        list.add(new User(R.drawable.images,"UserName1"));
        list.add(new User(R.drawable.download__1_,"UserName4"));
        list.add(new User(R.drawable.images,"UserName1"));
        list.add(new User(R.drawable.download__1_,"UserName4"));
        return list;
    }
}
