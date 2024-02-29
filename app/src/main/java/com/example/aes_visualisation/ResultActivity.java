package com.example.aes_visualisation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Display the encrypted text
        String[][] encryptedText = {
                {"39", "02", "dc", "19"},
                {"25", "dc", "11", "6a"},
                {"84", "09", "85", "0b"},
                {"1d", "fb", "97", "32"}
        };
        displayEncryptedText(encryptedText);
    }

    private void displayEncryptedText(String[][] encryptedText) {
        GridLayout gridLayoutEncryptedText = findViewById(R.id.gridLayoutEncryptedText);
        for (int i = 0; i < encryptedText.length; i++) {
            for (int j = 0; j < encryptedText[0].length; j++) {
                TextView textView = new TextView(this);
                textView.setText(encryptedText[i][j]);
                textView.setTextColor(getResources().getColor(android.R.color.white));
                textView.setTextSize(18);
                GridLayout.Spec rowSpec = GridLayout.spec(i);
                GridLayout.Spec colSpec = GridLayout.spec(j);
                GridLayout.LayoutParams params = new GridLayout.LayoutParams(rowSpec, colSpec);
                gridLayoutEncryptedText.addView(textView, params);
            }
        }
    }

    public void onDecryptButtonClick(View view) {
        // Define the decrypted text matrix
        String[][] decryptedText = {
                {"32", "88", "31", "e0"},
                {"43", "5a", "31", "37"},
                {"f6", "30", "98", "07"},
                {"a8", "8d", "a2", "34"}
        };

        // Display the decrypted text matrix
        displayDecryptedText(decryptedText);
    }

    private void displayDecryptedText(String[][] decryptedText) {
        GridLayout gridLayoutDecryptedText = findViewById(R.id.gridLayoutDecryptedText);
        gridLayoutDecryptedText.removeAllViews(); // Clear any existing views

        for (int i = 0; i < decryptedText.length; i++) {
            for (int j = 0; j < decryptedText[0].length; j++) {
                TextView textView = new TextView(this);
                textView.setText(decryptedText[i][j]);
                textView.setTextColor(getResources().getColor(android.R.color.white));
                textView.setTextSize(18);
                GridLayout.Spec rowSpec = GridLayout.spec(i);
                GridLayout.Spec colSpec = GridLayout.spec(j);
                GridLayout.LayoutParams params = new GridLayout.LayoutParams(rowSpec, colSpec);
                gridLayoutDecryptedText.addView(textView, params);
            }
        }
    }

    public void onNextButtonClick(View view) {
        // Navigate to MainActivity
        startActivity(new Intent(ResultActivity.this, MainActivity.class));
    }
}
