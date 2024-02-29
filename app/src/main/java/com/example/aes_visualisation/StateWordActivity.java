package com.example.aes_visualisation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class StateWordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_word);

        // Get the string representing the matrix
        String inputString = "2b7e151628aed2a6abf7158809cf4f3c";
        char[] chars = inputString.toCharArray();

        // Create a 4x4 matrix from the string

        char[][] matrix = new char[4][4];
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                int index = (j * 4 + i) * 2;
                String hexPair = String.valueOf(chars[index]) + String.valueOf(chars[index + 1]);
                matrix[i][j] = (char) Integer.parseInt(hexPair, 16);
            }
        }



        // Display the matrix in the UI
        TableLayout tableLayout = findViewById(R.id.tableLayout);
        for (int i = 0; i < 4; i++) {
            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
            for (int j = 0; j < 4; j++) {
                TextView textView = new TextView(this);
                textView.setText(String.format("%02X", (int) matrix[i][j])); // Format each element to display as hexadecimal
                textView.setPadding(16, 16, 16, 16);
                textView.setTextColor(getResources().getColor(android.R.color.white)); // Set text color to white
                tableRow.addView(textView);
            }
            tableLayout.addView(tableRow);
        }


        // Next Button Click Listener
        Button nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StateWordActivity.this, CircularShiftActivity.class);
                startActivity(intent);
            }
        });
    }
}


