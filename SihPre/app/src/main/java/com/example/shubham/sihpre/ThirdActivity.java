package com.example.shubham.sihpre;


import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.speech.RecognizerIntent;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by shubham on 15/3/18.
 */

public class ThirdActivity extends MainActivity implements OnClickListener{

public ListView mList;
public Button speakButton;

public static final int VOICE_RECOGNITION_REQUEST_CODE = 1234;

@Override
public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.third_layout);

        speakButton = (Button) findViewById(R.id.bttn);
        speakButton.setOnClickListener(this);
        voiceinputbuttons();
        }

public void informationMenu() {
        startActivity(new Intent("android.intent.action.INFOSCREEN"));
        }

public void voiceinputbuttons() {
        speakButton = (Button) findViewById(R.id.bttn);
        mList = (ListView) findViewById(R.id.list);
        }

public void startVoiceRecognitionActivity() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
        RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
        "Speech recognition demo");
        startActivityForResult(intent, VOICE_RECOGNITION_REQUEST_CODE);
        }

public void onClick(View v) {
        // TODO Auto-generated method stub
        startVoiceRecognitionActivity();
        }

@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == VOICE_RECOGNITION_REQUEST_CODE && resultCode == RESULT_OK) {
        // Fill the list view with the strings the recognizer thought it
        // could have heard
        ArrayList matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
        mList.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, matches));
        // matches is the result of voice input. It is a list of what the
        // user possibly said.
        // Using an if statement for the keyword you want to use allows the
        // use of any activity if keywords match
        // it is possible to set up multiple keywords to use the same
        // activity so more than one word will allow the user
        // to use the activity (makes it so the user doesn't have to
        // memorize words from a list)
        // to use an activity from the voice input information simply use
        // the following format;
        // if (matches.contains("keyword here") { startActivity(new
        // Intent("name.of.manifest.ACTIVITY")

        if (matches.contains("information")) {
        informationMenu();
        }
        }
        }
        }