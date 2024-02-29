package com.example.aes_visualisation;// ShiftRowsActivity.java
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ShiftRowsActivity extends AppCompatActivity {

    private String[][] originalMatrix = {
            {"c3", "07", "c3", "4d"},
            {"18", "96", "c3", "c3"},
            {"33", "c3", "12", "04"},
            {"ef", "07", "ef", "c3"}
    };

    private String[][] shiftedMatrix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shift_rows);

        GridLayout gridLayoutOriginalMatrix = findViewById(R.id.gridLayoutOriginalMatrix);
        GridLayout gridLayoutShiftedMatrix = findViewById(R.id.gridLayoutShiftedMatrix);
        Button buttonNext = findViewById(R.id.buttonNext);

        displayOriginalMatrix(gridLayoutOriginalMatrix);
        performShiftRows();
        displayShiftedMatrix(gridLayoutShiftedMatrix);

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShiftRowsActivity.this, MixColumnsActivity.class));
            }
        });
    }

    private void displayOriginalMatrix(GridLayout gridLayout) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                TextView textView = new TextView(this);
                textView.setText(originalMatrix[i][j]);
                textView.setTextSize(18);
                textView.setTextColor(getResources().getColor(android.R.color.white));
                GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                params.rowSpec = GridLayout.spec(i);
                params.columnSpec = GridLayout.spec(j);
                textView.setLayoutParams(params);
                gridLayout.addView(textView);
            }
        }
    }

    private void performShiftRows() {
        // Perform circular shifts on each row
        shiftedMatrix = new String[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                shiftedMatrix[i][j] = originalMatrix[i][(j + i) % 4];
            }
        }
    }

    private void displayShiftedMatrix(GridLayout gridLayout) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                TextView textView = new TextView(this);
                textView.setText(shiftedMatrix[i][j]);
                textView.setTextSize(18);
                textView.setTextColor(getResources().getColor(android.R.color.white));
                GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                params.rowSpec = GridLayout.spec(i);
                params.columnSpec = GridLayout.spec(j);
                textView.setLayoutParams(params);
                gridLayout.addView(textView);
            }
        }
    }
}
