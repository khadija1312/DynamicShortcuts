package com.example.dynamicshortcutexample;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String s;
    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ShortcutManager shortcutManager = (ShortcutManager) getSystemService(Context.SHORTCUT_SERVICE);

        List<ShortcutInfo> shortcutInfoList = new ArrayList<>();

        ShortcutInfo shortcut = new ShortcutInfo.Builder(this, "website")
                .setShortLabel("Website")
                .setLongLabel("Open the Website")
                .setIcon(Icon.createWithResource(this, R.drawable.ic_web))
                .setIntent(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.apple.com")))
                .build();

        shortcutInfoList.add(shortcut);

        shortcut = new ShortcutInfo.Builder(this, "Website")
                .setShortLabel("Open")
                .setLongLabel("Open the Activity")
                .setIcon(Icon.createWithResource(this, R.drawable.ic_android))
                .setIntent(new Intent(MainActivity.this, MainActivity2.class).setAction("open")
                        .putExtra("Hello_world","Hello World: This is Second Activity"))
                .build();

        Intent intent = new Intent();
        intent.putExtra("hello world","hello");


        shortcutInfoList.add(shortcut);

        shortcutManager.setDynamicShortcuts(shortcutInfoList);

    }
}