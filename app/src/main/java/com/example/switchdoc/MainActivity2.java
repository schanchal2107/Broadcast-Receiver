package com.example.switchdoc;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import org.w3c.dom.Text;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
public class MainActivity2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // perform click event on edit text

        Intent intent=getIntent();
        TextView name =(TextView)findViewById(R.id.name);
        name.setText(intent.getStringExtra("name"));
        TextView email =(TextView)findViewById(R.id.email);
        email.setText(intent.getStringExtra("email"));
        TextView age =(TextView)findViewById(R.id.age);
        age.setText(intent.getStringExtra("age"));
        TextView gender=(TextView)findViewById(R.id.gender);
        gender.setText(intent.getStringExtra("radioSex"));
        TextView branch=(TextView)findViewById(R.id.branch);
        branch.setText(intent.getStringExtra("branch"));
        TextView language=(TextView)findViewById(R.id.language);
        language.setText(intent.getStringExtra("language"));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
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

    public void Submit(View view) {
        Intent i =new Intent(MainActivity2.this,MainActivity.class);
        startActivity(i);
        //invoke the SecondActivity.
        finish();
    }
}