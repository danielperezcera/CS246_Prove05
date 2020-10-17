package com.example.prove05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String SCRIPTURE_BOOK = "com.example.myfirstapp.BOOK";
    public static final String BOOK_CHAPTER = "com.example.myfirstapp.CHAPTER";
    public static final String CHAPTER_VERSE = "com.example.myfirstapp.VERSE";
    private static final String DEBUG = "DEBUG";

    public static final String MY_PREFERENCES = "com.example.myfirstapp.PREFERENCES";
    public static final String PREF_BOOK = "PREF_BOOK";
    public static final String PREF_CHAPTER = "PREF_CHAPTER";
    public static final String PREF_VERSE = "PREF_VERSE";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {

        Log.d(DEBUG, "About to create intent with John 3:16");

        Intent intent = new Intent(this, DisplayScripturesActivity.class);

        EditText editText1 = (EditText) findViewById(R.id.book);
        String bookValue = editText1.getText().toString();

        EditText editText2 = (EditText) findViewById(R.id.chapter);
        String chapterValue = editText2.getText().toString();

        EditText editText3 = (EditText) findViewById(R.id.verse);
        String verseValue = editText3.getText().toString();

        //put all extra info in the intent
        intent.putExtra(SCRIPTURE_BOOK, bookValue);
        intent.putExtra(BOOK_CHAPTER, chapterValue);
        intent.putExtra(CHAPTER_VERSE, verseValue);
        startActivity(intent);
    }

    public void loadScripture(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);


        EditText editText1 = (EditText) findViewById(R.id.book);
        String bookValue = sharedPreferences.getString(PREF_BOOK, null);
        editText1.setText(bookValue);

        EditText editText2 = (EditText) findViewById(R.id.chapter);
        String chapterValue = sharedPreferences.getString(PREF_CHAPTER, null);
        editText2.setText(chapterValue);

        EditText editText3 = (EditText) findViewById(R.id.verse);
        String verseValue = sharedPreferences.getString(PREF_VERSE, null);
        editText3.setText(verseValue);
    }
}