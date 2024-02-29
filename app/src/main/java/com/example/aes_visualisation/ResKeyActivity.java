package com.example.aes_visualisation;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResKeyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reskey);

        // Initialize GridLayouts
        GridLayout key1GridLayout = findViewById(R.id.key1GridLayout);
        GridLayout key2GridLayout = findViewById(R.id.key2GridLayout);
        GridLayout key3GridLayout = findViewById(R.id.key3GridLayout);
        GridLayout key4GridLayout = findViewById(R.id.key4GridLayout);
        GridLayout key5GridLayout = findViewById(R.id.key5GridLayout);
        GridLayout key6GridLayout = findViewById(R.id.key6GridLayout);
        GridLayout key7GridLayout = findViewById(R.id.key7GridLayout);
        GridLayout key8GridLayout = findViewById(R.id.key8GridLayout);
        GridLayout key9GridLayout = findViewById(R.id.key9GridLayout);
        GridLayout key10GridLayout = findViewById(R.id.key10GridLayout);

        // Initialize TextViews for key titles
        TextView key1TextView = findViewById(R.id.key1TextView);
        TextView key2TextView = findViewById(R.id.key2TextView);
        TextView key3TextView = findViewById(R.id.key3TextView);
        TextView key4TextView = findViewById(R.id.key4TextView);
        TextView key5TextView = findViewById(R.id.key5TextView);
        TextView key6TextView = findViewById(R.id.key6TextView);
        TextView key7TextView = findViewById(R.id.key7TextView);
        TextView key8TextView = findViewById(R.id.key8TextView);
        TextView key9TextView = findViewById(R.id.key9TextView);
        TextView key10TextView = findViewById(R.id.key10TextView);

        // Set text color to white
        key1TextView.setTextColor(getResources().getColor(android.R.color.white));
        key2TextView.setTextColor(getResources().getColor(android.R.color.white));
        key3TextView.setTextColor(getResources().getColor(android.R.color.white));
        key4TextView.setTextColor(getResources().getColor(android.R.color.white));
        key5TextView.setTextColor(getResources().getColor(android.R.color.white));
        key6TextView.setTextColor(getResources().getColor(android.R.color.white));
        key7TextView.setTextColor(getResources().getColor(android.R.color.white));
        key8TextView.setTextColor(getResources().getColor(android.R.color.white));
        key9TextView.setTextColor(getResources().getColor(android.R.color.white));
        key10TextView.setTextColor(getResources().getColor(android.R.color.white));

        // Populate GridLayouts with keys
        populateKeyMatrix(key1GridLayout, getKey1());
        populateKeyMatrix(key2GridLayout, getKey2());
        populateKeyMatrix(key3GridLayout, getKey3());
        populateKeyMatrix(key4GridLayout, getKey4());
        populateKeyMatrix(key5GridLayout, getKey5());
        populateKeyMatrix(key6GridLayout, getKey6());
        populateKeyMatrix(key7GridLayout, getKey7());
        populateKeyMatrix(key8GridLayout, getKey8());
        populateKeyMatrix(key9GridLayout, getKey9());
        populateKeyMatrix(key10GridLayout, getKey10());

        // Initialize Next Button
        Button nextButton = findViewById(R.id.nextButton);
        // Set text color to white
        nextButton.setTextColor(getResources().getColor(android.R.color.white));
        // Set onClickListener for Next Button
        nextButton.setOnClickListener(view -> {
            // Start XORinputActivity
            startActivity(new Intent(ResKeyActivity.this, MainActivity.class));
        });
    }

    // Method to populate a GridLayout with key values
    private void populateKeyMatrix(GridLayout gridLayout, String key) {
        // Clear existing views from GridLayout
        gridLayout.removeAllViews();

        // Split key string into 2-character substrings
        for (int i = 0; i < key.length(); i += 2) {
            // Create TextView for each key value
            TextView textView = new TextView(this);
            textView.setText(key.substring(i, i + 2)); // Get 2-character substring
            textView.setTextSize(18); // Set text size
            textView.setTextColor(getResources().getColor(android.R.color.white)); // Set text color to white

            // Add TextView to GridLayout
            gridLayout.addView(textView);
        }
    }

    // Method to get key values
    private String getKey1() {
        return "a0fafe1788542cb123a339392a6c7605";
    }

    private String getKey2() {
        return "f2c295f27a96b9435935807a7359f67f";
    }

    private String getKey3() {
        return "3d80477d4716fe3e1e237e446d7a883b";
    }

    private String getKey4() {
        return "ef44a541a8525b7fb671253bdb0bad00";
    }

    private String getKey5() {
        return "d4d1cff87c839d87caf2b8bc11f915bc";
    }

    private String getKey6() {
        return "6d88a37a110b3efd9bf98641ca0093fd";
    }

    private String getKey7() {
        return "4e54f70e5f5fc9f384a64fb24ea6dc4f";
    }

    private String getKey8() {
        return "ead27321b58dbad2312bf5607f8d292f";
    }

    private String getKey9() {
        return "ac7766f319fadc2128d12941575c006e";
    }

    private String getKey10() {
        return "d014f9a8c9ee2589e13f0cc8b6630ca6";
    }

}
