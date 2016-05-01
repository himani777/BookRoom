package com.example.gangwars.bookroom;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



public class CheckAvailibility extends AppCompatActivity implements View.OnClickListener{
    int b[] = new int[20];
    int id[]={R.id.room1,R.id.room2,R.id.room3,R.id.room4,R.id.room5,R.id.room6,R.id.room7,R.id.room8,R.id.room9,R.id.room10,R.id.room11,R.id.room12,R.id.room13,R.id.room14,R.id.room15,R.id.room16,R.id.room17,R.id.room18,R.id.room19,R.id.room20};
        ImageView image[] = new ImageView[20];
Button btnrelread;
    String booked[]=new String[20];
    MyDbAdapter dbadapter;
    TextView statustextput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_availibility);
         dbadapter = new MyDbAdapter(this);
        btnrelread = (Button) findViewById(R.id.releaseread);
        btnrelread.setOnClickListener(this);
        statustextput= (TextView) findViewById(R.id.status);

        for(int i=0; i<20; i++)
        {
            image[i]= (ImageView) findViewById(id[i]);
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
            case R.id.room1 :
                Toast.makeText(CheckAvailibility.this, "You Clicked at R01" , Toast.LENGTH_SHORT).show();
                if(b[0]==0)
                {
                    statustextput.setText("THE ROOM IS NOT BOOKED");
                }
                else if(b[0]==1)
                {
                    statustextput.setText("THE ROOM IS BOOKED BY " + booked[0] );
                }

                break;

            case R.id.room2 :
                Toast.makeText(CheckAvailibility.this, "You Clicked at R02" , Toast.LENGTH_SHORT).show();
                if(b[1]==0)
                {
                    statustextput.setText("THE ROOM IS NOT BOOKED");
                }
                else if(b[1]==1)
                {
                    statustextput.setText("THE ROOM IS BOOKED BY " + booked[1]);
                }
                break;

            case R.id.room3 :
                Toast.makeText(CheckAvailibility.this, "You Clicked at R03" , Toast.LENGTH_SHORT).show();
                if(b[2]==0)
                {
                    statustextput.setText("THE ROOM IS NOT BOOKED");
                }
                else if(b[2]==1)
                {
                    statustextput.setText("THE ROOM IS BOOKED" + booked[2]);
                }
                break;

            case R.id.room4 :
                Toast.makeText(CheckAvailibility.this, "You Clicked at R04" , Toast.LENGTH_SHORT).show();
                if(b[3]==0)
                {
                    statustextput.setText("THE ROOM IS NOT BOOKED");
                }
                else if(b[3]==1)
                {
                    statustextput.setText("THE ROOM IS BOOKED BY " + booked[3]);
                }
                break;

            case R.id.room5 :
                Toast.makeText(CheckAvailibility.this, "You Clicked at R05" , Toast.LENGTH_SHORT).show();
                if(b[4]==0)
                {
                    statustextput.setText("THE ROOM IS NOT BOOKED" );
                }
                else if(b[4]==1)
                {
                    statustextput.setText("THE ROOM IS BOOKED BY " + booked[4]);
                }
                break;

            case R.id.room6 :
                Toast.makeText(CheckAvailibility.this, "You Clicked at R06" , Toast.LENGTH_SHORT).show();
                if(b[5]==0)
                {
                    statustextput.setText("THE ROOM IS NOT BOOKED");
                }
                else if(b[5]==1)
                {
                    statustextput.setText("THE ROOM IS BOOKED BY " + booked[5]);
                }
                break;

            case R.id.room7 :
                Toast.makeText(CheckAvailibility.this, "You Clicked at R07" , Toast.LENGTH_SHORT).show();
                if(b[6]==0)
                {
                    statustextput.setText("THE ROOM IS NOT BOOKED");
                }
                else if(b[6]==1)
                {
                    statustextput.setText("THE ROOM IS BOOKED BY " + booked[6]);
                }
                break;

            case R.id.room8 :
                Toast.makeText(CheckAvailibility.this, "You Clicked at R08" , Toast.LENGTH_SHORT).show();
                if(b[7]==0)
                {
                    statustextput.setText("THE ROOM IS NOT BOOKED");
                }
                else if(b[7]==1)
                {
                    statustextput.setText("THE ROOM IS BOOKED BY " + booked[7]);
                }
                break;

            case R.id.room9 :
                Toast.makeText(CheckAvailibility.this, "You Clicked at R09" , Toast.LENGTH_SHORT).show();
                if(b[8]==0)
                {
                    statustextput.setText("THE ROOM IS NOT BOOKED");
                }
                else if(b[8]==1)
                {
                    statustextput.setText("THE ROOM IS BOOKED BY " + booked[8]);
                }
                break;

            case R.id.room10 :
                Toast.makeText(CheckAvailibility.this, "You Clicked at R10" , Toast.LENGTH_SHORT).show();
                if(b[9]==0)
                {
                    statustextput.setText("THE ROOM IS NOT BOOKED");
                }
                else if(b[9]==1)
                {
                    statustextput.setText("THE ROOM IS BOOKED BY " + booked[9]);
                }
                break;

            case R.id.room11 :
                Toast.makeText(CheckAvailibility.this, "You Clicked at R11" , Toast.LENGTH_SHORT).show();
                if(b[10]==0)
                {
                    statustextput.setText("THE ROOM IS NOT BOOKED");
                }
                else if(b[10]==1)
                {
                    statustextput.setText("THE ROOM IS BOOKED BY " + booked[10]);
                }
                break;

            case R.id.room12 :
                Toast.makeText(CheckAvailibility.this, "You Clicked at R12" , Toast.LENGTH_SHORT).show();
                if(b[11]==0)
                {
                    statustextput.setText("THE ROOM IS NOT BOOKED");
                }
                else if(b[11]==1)
                {
                    statustextput.setText("THE ROOM IS BOOKED BY " + booked[11]);
                }
                break;

            case R.id.room13 :
                Toast.makeText(CheckAvailibility.this, "You Clicked at R13" , Toast.LENGTH_SHORT).show();

                if(b[12]==0)
                {
                    statustextput.setText("THE ROOM IS NOT BOOKED");
                }
                else if(b[12]==1)
                {
                    statustextput.setText("THE ROOM IS BOOKED BY " + booked[12]);
                }
                break;

            case R.id.room14 :
                Toast.makeText(CheckAvailibility.this, "You Clicked at R14" , Toast.LENGTH_SHORT).show();
                if(b[13]==0)
                {
                    statustextput.setText("THE ROOM IS NOT BOOKED");
                }
                else if(b[13]==1)
                {
                    statustextput.setText("THE ROOM IS BOOKED BY " + booked[13]);
                }
                break;

            case R.id.room15 :
                Toast.makeText(CheckAvailibility.this, "You Clicked at R15" , Toast.LENGTH_SHORT).show();
                if(b[14]==0)
                {
                    statustextput.setText("THE ROOM IS NOT BOOKED");
                }
                else if(b[14]==1)
                {
                    statustextput.setText("THE ROOM IS BOOKED BY " + booked[14]);
                }
                break;

            case R.id.room16 :
                Toast.makeText(CheckAvailibility.this, "You Clicked at R16" , Toast.LENGTH_SHORT).show();
                if(b[15]==0)
                {
                    statustextput.setText("THE ROOM IS NOT BOOKED");
                }
                else if(b[15]==1)
                {
                    statustextput.setText("THE ROOM IS BOOKED BY " + booked[15]);
                }
                break;

            case R.id.room17 :
                Toast.makeText(CheckAvailibility.this, "You Clicked at R17" , Toast.LENGTH_SHORT).show();
                if(b[16]==0)
                {
                    statustextput.setText("THE ROOM IS NOT BOOKED");
                }
                else if(b[16]==1)
                {
                    statustextput.setText("THE ROOM IS BOOKED BY "+ booked[16]);
                }
                break;

            case R.id.room18 :
                Toast.makeText(CheckAvailibility.this, "You Clicked at R18" , Toast.LENGTH_SHORT).show();
                if(b[17]==0)
                {
                    statustextput.setText("THE ROOM IS NOT BOOKED");
                }
                else if(b[17]==1)
                {
                    statustextput.setText("THE ROOM IS BOOKED BY "+ booked[17]);
                }
                break;

            case R.id.room19 :
                Toast.makeText(CheckAvailibility.this, "You Clicked at R19" , Toast.LENGTH_SHORT).show();
                if(b[18]==0)
                {
                    statustextput.setText("THE ROOM IS NOT BOOKED");
                }
                else if(b[18]==1)
                {
                    statustextput.setText("THE ROOM IS BOOKED BY "+ booked[18]);
                }
                break;

            case R.id.room20 :
                Toast.makeText(CheckAvailibility.this, "You Clicked at R20" , Toast.LENGTH_SHORT).show();
                if(b[19]==0)
                {
                    statustextput.setText("THE ROOM IS NOT BOOKED");
                }
                else if(b[19]==1)
                {
                    statustextput.setText("THE ROOM IS BOOKED BY "+ booked[19]);
                }
                break;

            case R.id.releaseread :
                releasereadlock();
                Intent i=new Intent(CheckAvailibility.this,Homepage.class);
                startActivity(i);

                break;
        }



    }


    public void releasereadlock()
    {
        dbadapter.updatelockdatabase(0);

    }

}
