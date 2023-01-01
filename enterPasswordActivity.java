package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class enterPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_password);
    }

    public void submitPassword(View v){
        TextView t = findViewById(R.id.passSource);
        String input = t.getText().toString();
        Button b = (Button) v;
        StokeDatabase DB = StokeDatabase.getInstance(this);

        Collection collection = new Collection(DB);
        Log.e("Pastword","bloop");
        Boolean isValid = collection.isValidPassword(DB,input);
        Log.e("Pastword",""+input.hashCode());

        if (isValid){
            Intent i = new Intent(this,adminActivity.class);
            startActivity(i);
        }
        else{
            b.setText("Incorrect Password");
        }

    }
}