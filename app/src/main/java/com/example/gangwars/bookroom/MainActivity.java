package com.example.gangwars.bookroom;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e1, e2;
    Button b1;
    TextView t;
int lock=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1= (EditText) findViewById(R.id.input_username);
        e2= (EditText) findViewById(R.id.input_password);
        b1=(Button) findViewById(R.id.btn_login);
        t= (TextView) findViewById(R.id.link_signup);

        final MyDbAdapter dbadapter = new MyDbAdapter(this);

        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Signup.class);

                        startActivity(intent);
            }
        });


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernametext= e1.getText().toString();
                String r=e2.getText().toString();
                String a=dbadapter.getData(usernametext);

                String check=dbadapter.searchpass(usernametext);
             //   e1.setText(check);
                if(r.equals(check))
                {
                    Toast.makeText(getApplication(), "Found, Welcome "+ usernametext  , Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, Homepage.class);
                    intent.putExtra("usercopied",usernametext);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplication(), "Not Found, Please try again!" , Toast.LENGTH_LONG).show();
                }


            }
        });

    }


}



