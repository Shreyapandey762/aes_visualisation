package com.example.aes_visualisation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class ExActivity extends AppCompatActivity {

    EditText plainTextField, keyField, encryptedTextField;
    Button encryptButton, decryptButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex);

        // Initialize EditText fields
        plainTextField = findViewById(R.id.plainTextField);
        keyField = findViewById(R.id.keyField);
        encryptedTextField = findViewById(R.id.encryptedTextField);

        // Initialize Buttons
        encryptButton = findViewById(R.id.encryptButton);
        decryptButton = findViewById(R.id.decryptButton);

        // Set onClickListener for encryptButton
        encryptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onEncryptButtonClick(v);
            }
        });

        // Set onClickListener for decryptButton
        decryptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add logic for decryption if needed
                // For now, just show a toast message
                Toast.makeText(ExActivity.this, "Decryption logic will be implemented later", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onEncryptButtonClick(View view) {
        try {
            // Get the plain text and key entered by the user
            String plainText = plainTextField.getText().toString();
            String key = keyField.getText().toString();

            // Encrypt the plain text using AES 128-bit algorithm
            byte[] encryptedBytes = AES.encrypt(plainText, key);

            // Convert the encrypted bytes to a hexadecimal string for display
            String encryptedText = bytesToHex(encryptedBytes);

            // Display the encrypted text
            encryptedTextField.setText(encryptedText);
        } catch (Exception e) {
            e.printStackTrace();
            // Handle encryption error
            Toast.makeText(this, "Encryption failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    // Method to convert byte array to hexadecimal string
    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }
}
