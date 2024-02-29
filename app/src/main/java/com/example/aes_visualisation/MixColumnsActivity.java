package com.example.aes_visualisation;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MixColumnsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mix_columns);

        // Display original shifted matrix
        displayOriginalShiftedMatrix();

        // Perform MixColumns transformation and display the result
        performMixColumns();
    }

    private void displayOriginalShiftedMatrix() {
        // Retrieve the GridLayout for the original shifted matrix
        GridLayout gridLayoutOriginalShiftedMatrix = findViewById(R.id.gridLayoutOriginalShiftedMatrix);

        // Define the original shifted matrix data
        String[][] originalShiftedMatrixData = {
                {"c3", "07", "c3", "4d"},
                {"18", "96", "c3", "c3"},
                {"33", "c3", "12", "04"},
                {"ef", "07", "ef", "c3"}
        };

        // Populate the GridLayout with the original shifted matrix data
        for (int i = 0; i < gridLayoutOriginalShiftedMatrix.getRowCount(); i++) {
            for (int j = 0; j < gridLayoutOriginalShiftedMatrix.getColumnCount(); j++) {
                TextView textView = new TextView(this);
                textView.setText(originalShiftedMatrixData[i][j]);
                textView.setTextColor(Color.WHITE);
                textView.setTextSize(18);
                GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                params.rowSpec = GridLayout.spec(i);
                params.columnSpec = GridLayout.spec(j);
                textView.setLayoutParams(params);
                gridLayoutOriginalShiftedMatrix.addView(textView);
            }
        }
    }

    private void performMixColumns() {
        // Retrieve the GridLayout for the mixed column matrix
        GridLayout gridLayoutMixedMatrix = findViewById(R.id.gridLayoutMixedMatrix);

        // Define the mixed column matrix data
        String[][] mixedMatrixData = {
                {"2b", "28", "ab", "09"},
                {"7e", "ae", "f6", "30"},
                {"d2", "0b", "b1", "da"},
                {"e9", "22", "ea", "28"}
        };


        // Populate the GridLayout with the mixed column matrix data
        for (int i = 0; i < gridLayoutMixedMatrix.getRowCount(); i++) {
            for (int j = 0; j < gridLayoutMixedMatrix.getColumnCount(); j++) {
                TextView textView = new TextView(this);
                textView.setText(mixedMatrixData[i][j]);
                textView.setTextColor(Color.WHITE);
                textView.setTextSize(18);
                GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                params.rowSpec = GridLayout.spec(i);
                params.columnSpec = GridLayout.spec(j);
                textView.setLayoutParams(params);
                gridLayoutMixedMatrix.addView(textView);
            }
        }
    }

    public void onNextButtonClick(View view) {
        Intent intent = new Intent(MixColumnsActivity.this, AddRoundKeyActivity.class);
        startActivity(intent);
    }
}
