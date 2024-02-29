package com.example.aes_visualisation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CircularShiftActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circular_shift);

        // Original string
        String originalString = "09cf4f3c";

        // Perform circular shift
        String shiftedString = circularShift(originalString);

        // Display original and shifted strings in the UI
        TextView textViewOriginal = findViewById(R.id.textViewOriginal);
        TextView textViewShifted = findViewById(R.id.textViewShifted);
        textViewOriginal.setText(originalString);
        textViewShifted.setText(shiftedString);

        // Next button click listener
        Button buttonNext = findViewById(R.id.buttonNext);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to SBox activity
                Intent intent = new Intent(CircularShiftActivity.this, SBoxActivity.class);
                startActivity(intent);
            }
        });
    }

    private String circularShift(String originalString) {
        // Perform circular shift by shifting the characters of the string
        return originalString.substring(2) + originalString.substring(0, 2);
    }
}
