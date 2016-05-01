package com.example.gangwars.bookroom;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
    Button b1;
    EditText e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        b1=(Button)findViewById(R.id.btn_signup);
        e1=(EditText)findViewById(R.id.signup_username);
        e2=(EditText)findViewById(R.id.signup_password);

        final MyDbAdapter dbadabter = new MyDbAdapter(this);

        b1.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {

                                      String user= e1.getText().toString();
                                      String pass=e2.getText().toString();
                                      long id = dbadabter.insertData(user, pass);
                                      if(id<0)
                                      {
                                          Toast.makeText(getApplication(), "Not Inserted", Toast.LENGTH_SHORT).show();
                                      }
                                      else
                                      {
                                          Toast.makeText(getApplication(), "Welcome", Toast.LENGTH_SHORT).show();
                                          Intent intent = new Intent(Signup.this, Homepage.class);
                                          intent.putExtra("usercopied",user);
                                          startActivity(intent);

                                      }


                                  }

                              }
        );

    }

}
