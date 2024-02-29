package com.example.aes_visualisation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RConstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rconst);

        // Perform XOR operation
        String result = performXOR("8a84cb01", "01000000");

        // Display the result
        TextView textViewResult = findViewById(R.id.textViewResult);
        textViewResult.setText("Result: " + result.toUpperCase());

        // Initialize the next button
        Button buttonNext = findViewById(R.id.buttonNext);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Proceed to XORinputActivity
                startActivity(new Intent(RConstActivity.this, XORInputActivity.class));
            }
        });
    }

    private String performXOR(String hex1, String hex2) {
        // Convert hex strings to long integers
        long num1 = Long.parseLong(hex1, 16);
        long num2 = Long.parseLong(hex2, 16);

        // Perform XOR operation
        long result = num1 ^ num2;

        // Convert result back to hex string
        return String.format("%08X", result);
    }
}
