package com.example.gangwars.bookroom;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BookRoom extends AppCompatActivity implements View.OnClickListener {
    int b[] = new int[20];
    String currentuser;
    int selectedindex=767;
    Button btnrel;
    int select[]= {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2};
    int idnew[]={ R.id.rooom1,R.id.rooom2,R.id.rooom3,R.id.rooom4,R.id.rooom5,R.id.rooom6,R.id.rooom7,R.id.rooom8,R.id.rooom9,R.id.rooom10,R.id.rooom11,R.id.rooom12,R.id.rooom13,R.id.rooom14,R.id.rooom15,R.id.rooom16,R.id.rooom17,R.id.rooom18,R.id.rooom19,R.id.rooom20};
    ImageView image[] = new ImageView[20];
TextView f;
    String booked[]=new String[20];
    MyDbAdapter dbadapter;
    Button btnpay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_room);
        Bundle bundle = getIntent().getExtras();
        currentuser = bundle.getString("usercopied");
        dbadapter = new MyDbAdapter(this);
f= (TextView) findViewById(R.id.finalstats);
        btnrel = (Button) findViewById(R.id.releasewrite);
        btnrel.setOnClickListener(this);
        btnpay= (Button) findViewById(R.id.bookroombtn);
        btnpay.setOnClickListener(this);

        for(int i=0; i<20; i++)
        {
            image[i]= (ImageView) findViewById(idnew[i]);
            image[i].setOnClickListener(this);
            booked[i]=dbadapter.searchroombooked(i);
            if(booked[i].equals("not found"))
            {
                b[i]=0;
                image[i].setImageResource(R.drawable.greencircle);

            }
            else //room booked by some user
            {
                b[i]=1;
                image[i].setImageResource(R.drawable.redcircle);
            }
        }

    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.rooom1 :
                Toast.makeText(BookRoom.this, "You Clicked at R01", Toast.LENGTH_SHORT).show();
                selectedindex=0;

                break;

            case R.id.rooom2 :
                Toast.makeText(BookRoom.this, "You Clicked at R02" , Toast.LENGTH_SHORT).show();
                selectedindex=1;

                break;

            case R.id.rooom3 :
                Toast.makeText(BookRoom.this, "You Clicked at R03" , Toast.LENGTH_SHORT).show();
                selectedindex=2;

                break;

            case R.id.rooom4 :
                Toast.makeText(BookRoom.this, "You Clicked at R04" , Toast.LENGTH_SHORT).show();
                selectedindex=3;

                break;

            case R.id.rooom5 :
                Toast.makeText(BookRoom.this, "You Clicked at R05" , Toast.LENGTH_SHORT).show();
                selectedindex=4;
                break;

            case R.id.rooom6 :
                Toast.makeText(BookRoom.this, "You Clicked at R06" , Toast.LENGTH_SHORT).show();
                selectedindex=5;
                break;

            case R.id.rooom7 :
                Toast.makeText(BookRoom.this, "You Clicked at R07" , Toast.LENGTH_SHORT).show();
                selectedindex=6;

                break;

            case R.id.rooom8 :
                Toast.makeText(BookRoom.this, "You Clicked at R08" , Toast.LENGTH_SHORT).show();
                selectedindex=7;

                break;

            case R.id.rooom9 :
                Toast.makeText(BookRoom.this, "You Clicked at R09" , Toast.LENGTH_SHORT).show();
                selectedindex=8;
                break;

            case R.id.rooom10 :
                Toast.makeText(BookRoom.this, "You Clicked at R10" , Toast.LENGTH_SHORT).show();
                selectedindex=9;
                break;

            case R.id.rooom11 :
                Toast.makeText(BookRoom.this, "You Clicked at R11" , Toast.LENGTH_SHORT).show();
                selectedindex=10;
                break;

            case R.id.rooom12 :
                Toast.makeText(BookRoom.this, "You Clicked at R12" , Toast.LENGTH_SHORT).show();
                selectedindex=11;
                break;

            case R.id.rooom13 :
                Toast.makeText(BookRoom.this, "You Clicked at R13" , Toast.LENGTH_SHORT).show();
                selectedindex=12;
                break;

            case R.id.rooom14 :
                Toast.makeText(BookRoom.this, "You Clicked at R14" , Toast.LENGTH_SHORT).show();
                selectedindex=13;
                break;

            case R.id.rooom15 :
                Toast.makeText(BookRoom.this, "You Clicked at R15" , Toast.LENGTH_SHORT).show();
                selectedindex=14;
                break;

            case R.id.rooom16 :
                Toast.makeText(BookRoom.this, "You Clicked at R16" , Toast.LENGTH_SHORT).show();
                selectedindex=15;
                break;

            case R.id.rooom17 :
                Toast.makeText(BookRoom.this, "You Clicked at R17" , Toast.LENGTH_SHORT).show();
                selectedindex=16;
                break;

            case R.id.rooom18 :
                Toast.makeText(BookRoom.this, "You Clicked at R18" , Toast.LENGTH_SHORT).show();
                selectedindex=17;
                break;

            case R.id.rooom19 :
                Toast.makeText(BookRoom.this, "You Clicked at R19" , Toast.LENGTH_SHORT).show();
                selectedindex=18;
                break;

            case R.id.rooom20 :
                Toast.makeText(BookRoom.this, "You Clicked at R20" , Toast.LENGTH_SHORT).show();
                selectedindex=19;
                break;

            case R.id.bookroombtn:
if(selectedindex<20)
{
    if (b[selectedindex] == 0) //room will proceed for booked
    {
        dbadapter.insertRoomdata(selectedindex, currentuser);
        f.setText("Room is successfully booked by " + currentuser);
        image[selectedindex].setImageResource(R.drawable.redcircle);


    } else if (b[selectedindex] == 1) {
        f.setText("Room selected is already booked, Choose another");
    } else {
        f.setText("Room not selected");

    }
}
                else
{
    f.setText("Room not selected");
}

            break;

            case R.id.releasewrite :
                releasewritelock();
                Intent i=new Intent(BookRoom.this,Homepage.class);
                startActivity(i);
                break;
        }



    }

    public void releasewritelock()
    {
        dbadapter.updatelockdatabase(0);

    }
}
