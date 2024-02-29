package com.example.aes_visualisation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText plainTextField, keyField;
    Button keyExpansionButton, roundFunctionButton, playButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize EditText fields
        plainTextField = findViewById(R.id.plain_text_field);
        keyField = findViewById(R.id.key_field);

        // Set default values for plaintext and key
        plainTextField.setText("3243f6a8885a308d313198a2e0370734");
        keyField.setText("2b7e151628aed2a6abf7158809cf4f3c");

        // Initialize Buttons
        keyExpansionButton = findViewById(R.id.key_expansion_button);
        roundFunctionButton = findViewById(R.id.round_function_button);
        playButton = findViewById(R.id.play_button);

        // Set onClickListener for keyExpansionButton
        keyExpansionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key = keyField.getText().toString();

                // Create intent to open KeyExpansionActivity
                Intent intent = new Intent(MainActivity.this, StateWordActivity.class);
                intent.putExtra("key", key);
                startActivity(intent);
            }
        });

        // Set onClickListener for roundFunctionButton
        roundFunctionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create intent to open SubByteActivity
                Intent intent = new Intent(MainActivity.this, SubBoxActivity.class);
                startActivity(intent);
            }
        });

        // Set onClickListener for playButton
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create intent to open ExActivity
                Intent intent = new Intent(MainActivity.this, ExActivity.class);
                startActivity(intent);
            }
        });
    }
}
