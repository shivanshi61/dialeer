package com.example.dialer;

import android.Manifest;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

//import androidx.annotation.NonNull;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText ed;
    Button one,two,three,four,five,six,seven,eight,nine,btn,zero,btn2,clear,dial,back;

    String s="";
    String number;
    Cursor cu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ed=findViewById(R.id.editText);
        one=findViewById(R.id.button);
        two=findViewById(R.id.button2);
        three=findViewById(R.id.button3);
        four=findViewById(R.id.button4);
        five=findViewById(R.id.button5);
        six=findViewById(R.id.button6);
        seven=findViewById(R.id.button7);
        eight=findViewById(R.id.button8);
        nine=findViewById(R.id.button9);
        btn=findViewById(R.id.button10);
        zero=findViewById(R.id.button11);
        btn2=findViewById(R.id.button12);
        clear=findViewById(R.id.button13);
        dial=findViewById(R.id.button14);
        back=findViewById(R.id.button15);

        ed.setShowSoftInputOnFocus(false);

        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        btn.setOnClickListener(this);
        zero.setOnClickListener(this);
        btn2.setOnClickListener(this);
        clear.setOnClickListener(this);
        dial.setOnClickListener(this);
        back.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onClick(View v) {

       s=ed.getText().toString();

        if(v==one){
            ed.setText(s+"1");
        }
        if(v==two){
            ed.setText(s+"2");
        }
        if(v==three){
            ed.setText(s+"3");
        }
        if(v==four){
            ed.setText(s+"4");
        }
        if(v==five){
            ed.setText(s+"5");
        }
        if(v==six){
            ed.setText(s+"6");
        }
        if(v==seven){
            ed.setText(s+"7");
        }
        if(v==eight){
            ed.setText(s+"8");
        }
        if(v==nine){
            ed.setText(s+"9");
        }
        if(v==btn){
            ed.setText(s+"+");
        }
        if(v==zero){
            ed.setText(s+"0");
        }
        if(v==btn2){
            ed.setText(s+"#");
        }
        if(v==clear){
            ed.setText("");
        }
        if(v==dial){
            number=ed.getText().toString();
            Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+number));

            if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.M)
            {
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED)
                {
                    startActivity(callIntent);
                }
                else
                {
                    ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},0);
                }
            }
            else
            {
                startActivity(callIntent);
            }


        }
        if(v==back) {
            String b=ed.getText().toString();
            char ch[]=b.toCharArray();
            int i;
            String c="";
            for(i=0;i<b.length()-1;i++){
            c=c+ch[i];
        }
            ed.setText(c);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==0)
        {
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED)
            {
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED)
                {
                    Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+number));
                    startActivity(callIntent);
                }
                else
                {
                    ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},0);
                }
            }
        }
    }
}

