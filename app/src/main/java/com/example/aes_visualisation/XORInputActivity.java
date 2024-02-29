package com.example.aes_visualisation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class XORInputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xorinput);

        // Initialize views
        TextView textViewInput1 = findViewById(R.id.textViewInput1);
        TextView textViewInput2 = findViewById(R.id.textViewInput2);
        TextView textViewResult = findViewById(R.id.textViewResult);
        Button buttonCalculate = findViewById(R.id.buttonCalculate);
        Button buttonNext = findViewById(R.id.buttonNext);

        // Set input values
        String input1 = "8b 84 cb 01";
        String input2 = "2b 7e 15 16";
        textViewInput1.setText("Input 1: " + input1);
        textViewInput2.setText("Input 2: " + input2);

        // Set calculate button click listener
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform XOR operation
                String result = performXOR(input1, input2);

                // Display the result
                textViewResult.setText("Result: " + result.toUpperCase());
            }
        });

        // Set next button click listener
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Proceed to the next activity
                startActivity(new Intent(XORInputActivity.this, ResKeyActivity.class));
            }
        });
    }

    private String performXOR(String hex1, String hex2) {
        // Convert hex strings to long integers
        long num1 = Long.parseLong(hex1.replace(" ", ""), 16);
        long num2 = Long.parseLong(hex2.replace(" ", ""), 16);

        // Perform XOR operation
        long result = num1 ^ num2;

        // Convert result back to hex string
        return String.format("%08X", result);
    }
}
