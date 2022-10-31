package com.example.dynamicshortcutexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String intent = getIntent().getStringExtra("Hello_world");
        System.out.println(intent);

        TextView textView = findViewById(R.id.textView);
        textView.setText(intent);
    }


}
