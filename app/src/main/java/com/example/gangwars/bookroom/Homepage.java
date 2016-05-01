package com.example.gangwars.bookroom;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class Homepage extends AppCompatActivity implements View.OnClickListener {
    ArrayList<String> data;
    RecyclerAdapter iconsRecyclerAdapter;
    RecyclerView recyclerView;
    String usernamegot;
    RelativeLayout check;
    RelativeLayout bookkok;
    MyDbAdapter dbadapter;
    Button unlockdb;
    Button read;
    Button write;
    int lock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        dbadapter = new MyDbAdapter(this);
        Bundle bundle = getIntent().getExtras();
         usernamegot = bundle.getString("usercopied");
        unlockdb= (Button) findViewById(R.id.unlock);
        unlockdb.setOnClickListener(this);
        read= (Button) findViewById(R.id.shared);
        read.setOnClickListener(this);
        write= (Button) findViewById(R.id.exclusive);
        write.setOnClickListener(this);
        data=new ArrayList<>();
        data.add("a");
        data.add("b");
        data.add("c");
        data.add("d");
        data.add("e");
        data.add("f");
        data.add("g");
        recyclerView=(RecyclerView)findViewById(R.id.icon_recycler_view);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        iconsRecyclerAdapter=new RecyclerAdapter(data,getApplicationContext());
        recyclerView.setAdapter(iconsRecyclerAdapter);
        check= (RelativeLayout) findViewById(R.id.check);
check.setOnClickListener(this);
        bookkok= (RelativeLayout) findViewById(R.id.bookroomm);
        bookkok.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.check :

                // now check status of lock, is system available

                lock = getlock();

                if(lock==0) //unlocked state , can get read lock
                {
                 dbadapter.updatelockdatabase(1);
                    Toast.makeText(Homepage.this, "Unlocked state, Read Lock aquired, Proceed", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(Homepage.this,CheckAvailibility.class);
                    startActivity(i);
                    break;
                }
                else if(lock==1) //already reading allowed .. proceed
                {
                    Toast.makeText(Homepage.this, "Read lock is alreday aquired, Proceed", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(Homepage.this,CheckAvailibility.class);
                    startActivity(i);
                    break;

                }
                else if(lock==2) // write lock by some other user, wait
                {
                    Toast.makeText(Homepage.this, "Write lock is already aquired, wait for process to complete", Toast.LENGTH_SHORT).show();
                        break;
                }
                else
                {
                    Toast.makeText(Homepage.this, "some error with lock", Toast.LENGTH_SHORT).show();
                    break;
                }



            case R.id.bookroomm :

                lock = getlock();

                if(lock==0) //unlocked state , can get write lock
                {
                    dbadapter.updatelockdatabase(2);
                    Toast.makeText(Homepage.this, "Unlocked state, Write Lock aquired, Proceed", Toast.LENGTH_SHORT).show();
                    Intent j = new Intent(Homepage.this,BookRoom.class);
                    j.putExtra("usercopied", usernamegot);
                    startActivity(j);

                    break;
                }
                else if(lock==1) //already reading allowed .. cannot write
                {
                    Toast.makeText(Homepage.this, "Read lock is alreday aquired, Wait", Toast.LENGTH_SHORT).show();

                    break;

                }
                else if(lock==2) // write lock by some other user, wait
                {
                    Toast.makeText(Homepage.this, "Write lock is already aquired, wait for process to complete", Toast.LENGTH_SHORT).show();
                    break;
                }
                else
                {
                    Toast.makeText(Homepage.this, "some error with lock", Toast.LENGTH_SHORT).show();
                    break;
                }


            case R.id.unlock :
                dbadapter.updatelockdatabase(0);

                break;

            case R.id.shared :
                dbadapter.updatelockdatabase(1);
                break;

            case R.id.exclusive:
                dbadapter.updatelockdatabase(2);
                break;
            default: break;
        }
    }

public int  getlock()
{
    return  dbadapter.getlockfromdatabase();

}

    // 0: un locked state : no lock in put(aquired) by database

    // 1: shared lock : reading allowed : check availibility

    // 2: exclusive lock : write allowed : book room



}
