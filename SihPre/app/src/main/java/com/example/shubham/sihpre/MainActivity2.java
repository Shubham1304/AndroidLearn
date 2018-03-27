package com.example.shubham.sihpre;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

/**
 * Created by shubham on 20/3/18.
 */

public class MainActivity2 extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    }

    public void showGreetings(View view)
    {
        String button_text;
        button_text = ((Button)view).getText().toString();
        if(button_text.equals("PwD"))
        {
            Intent intent =new Intent(this,SecondActivity.class);
            startActivity(intent);
        }
        else if(button_text.equals("Nonpwd"))
        {
            Intent intent = new Intent (this,ThirdActivity.class);
            startActivity(intent);
        }
    }

}

