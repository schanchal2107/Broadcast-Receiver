package com.example.switchdoc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import java.util.IllegalFormatCodePointException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class apply extends Activity {
    EditText Name;
    EditText Email;
    EditText Age;
    RadioGroup radioSex;
    Spinner branch;
    ArrayAdapter<CharSequence>adapter;
    CheckBox hindi,english;
    Button Submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply);
        //View form Button
        Button button =(Button)findViewById(R.id.send);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Name.getText().toString().trim().isEmpty()){
                    Name.setError("Please enter your name");
                    Name.requestFocus();
                }
                else if (!isValideEmail(Email.getText().toString()))
                {
                    Email.setError("Please enter your Email");
                    Email.requestFocus();
                }
                else if (Age.getText().toString().trim().isEmpty()){
                    Age.setError("Please enter your");
                    Age.requestFocus();
                }
                else {
                    sendMessage();
                }
            }
        });
        Name=(EditText)findViewById(R.id.name);
        Email=(EditText)findViewById(R.id.email);
        Age=(EditText)findViewById(R.id.age);
        radioSex=(RadioGroup)findViewById(R.id.radioSex);
        branch=(Spinner)findViewById(R.id.branch);
        adapter =ArrayAdapter.createFromResource(this,R.array.branch,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hindi=(CheckBox)findViewById(R.id.hindi);
        english=(CheckBox)findViewById(R.id.english);
        branch.setAdapter(adapter);
        branch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    private boolean isValideEmail(String Email){
        String Email_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(Email_PATTERN);
        Matcher matcher = pattern.matcher(Email);
        return matcher.matches();
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
    public void sendMessage(){
        Intent intent =new Intent(apply.this,MainActivity2.class);
        intent.putExtra("name",Name.getText().toString());
        intent.putExtra("email",Email.getText().toString());
        intent.putExtra("age",Age.getText().toString());
        //get selected radio button from radioGroup
        int selectedId =radioSex.getCheckedRadioButtonId();
        //find the radiobutton by retunend id
        RadioButton radioSexButton = (RadioButton)findViewById(selectedId);
        intent.putExtra("radioSex", radioSexButton.getText());
        intent.putExtra("branch",branch.getSelectedItem().toString());
        if(hindi.isChecked()&&english.isChecked())
        {
            intent.putExtra("language","Hindi,English");
        }
        else if(hindi.isChecked())
        {
            intent.putExtra("language","Hindi");
        }
        else if(english.isChecked())
        {
            intent.putExtra("language","English");
        }
        else
        {
            intent.putExtra("language","None");
        }
        startActivity(intent);
    }
}