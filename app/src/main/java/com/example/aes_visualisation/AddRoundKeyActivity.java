package com.example.aes_visualisation;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AddRoundKeyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_round_key);

        // Perform XOR operation and display the result
        performXOR();
    }

    private void performXOR() {
        // Define the mixed matrix data
        String[][] mixedMatrix = {
                {"2b", "28", "ab", "09"},
                {"7e", "ae", "f6", "30"},
                {"d2", "0b", "b1", "da"},
                {"e9", "22", "ea", "28"}
        };

        // Define the key matrices data for XOR operation
        String[][] keyMatrix1 = {
                {"2b", "7e", "15", "16"},
                {"28", "ae", "d2", "a6"},
                {"ab", "f7", "15", "88"},
                {"09", "cf", "4f", "3c"}
        };

        String[][] keyMatrix2 = {
                {"2b", "7e", "15", "16"},
                {"28", "ae", "d2", "a6"},
                {"ab", "f7", "15", "88"},
                {"09", "cf", "4f", "3c"}
        };

        // Define the result matrix data
        String[][] resultMatrix = new String[4][4];

        // Perform XOR operation and populate the result matrix
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int mixedValue = Integer.parseInt(mixedMatrix[i][j], 16);
                int key1Value = Integer.parseInt(keyMatrix1[i][j], 16);
                int key2Value = Integer.parseInt(keyMatrix2[i][j], 16);
                int result = mixedValue ^ key1Value ^ key2Value;
                resultMatrix[i][j] = String.format("%02x", result);
            }
        }

        // Display the result matrix
        displayResultMatrix(resultMatrix);
    }

    private void displayResultMatrix(String[][] resultMatrix) {
        // Retrieve the GridLayout for the result matrix
        GridLayout gridLayoutResultMatrix = findViewById(R.id.gridLayoutResultMatrix);

        // Populate the GridLayout with the result matrix data
        for (int i = 0; i < gridLayoutResultMatrix.getRowCount(); i++) {
            for (int j = 0; j < gridLayoutResultMatrix.getColumnCount(); j++) {
                TextView textView = new TextView(this);
                textView.setText(resultMatrix[i][j]);
                textView.setTextColor(Color.WHITE);
                textView.setTextSize(18);
                GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                params.rowSpec = GridLayout.spec(i);
                params.columnSpec = GridLayout.spec(j);
                textView.setLayoutParams(params);
                gridLayoutResultMatrix.addView(textView);
            }
        }
    }

    public void onNextButtonClick(View view) {
        Intent intent = new Intent(AddRoundKeyActivity.this, ResultActivity.class);
        startActivity(intent);
    }
}

