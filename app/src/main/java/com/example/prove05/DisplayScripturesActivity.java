package com.example.prove05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayScripturesActivity extends AppCompatActivity {

    private static final String DEBUG = "DEBUG";
    String book;
    String chapter;
    String verse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_scriptures);

        Log.d(DEBUG, "Received intent with John 3:16");

        //get the intent and extract the strings
        Intent intent = getIntent();
        book = intent.getStringExtra(MainActivity.SCRIPTURE_BOOK);
        chapter = intent.getStringExtra(MainActivity.BOOK_CHAPTER);
        verse = intent.getStringExtra(MainActivity.CHAPTER_VERSE);

        //Capture the textViews and set the strings as their text
        TextView bookTextView = findViewById(R.id.display_book);
        bookTextView.setText(book);

        TextView chapterTextView = findViewById(R.id.display_chapter);
        chapterTextView.setText(chapter);

        TextView verseTextView = findViewById(R.id.display_verse);
        verseTextView.setText(verse);
    }

    public void saveScripture(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.MY_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(MainActivity.PREF_BOOK, book);
        editor.putString(MainActivity.PREF_CHAPTER, chapter);
        editor.putString(MainActivity.PREF_VERSE, verse);
        editor.apply();

        Toast.makeText(this, "Scripture has been saved.", Toast.LENGTH_SHORT).show();

    }
}