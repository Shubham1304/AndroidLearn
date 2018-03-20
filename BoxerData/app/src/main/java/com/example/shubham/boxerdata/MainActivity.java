package com.example.shubham.boxerdata;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.R.attr.data;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText edtValue = (EditText)findViewById(R.id.edtValue);
        final Button btnSendDataToServer=(Button)findViewById(R.id.btnSendValueToServer);
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReferenceFromUrl("https://boxerdata-4cf53.firebaseio.com/");


        btnSendDataToServer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("Name").setValue(edtValue.getText().toString());
            }
        });
    }

}
