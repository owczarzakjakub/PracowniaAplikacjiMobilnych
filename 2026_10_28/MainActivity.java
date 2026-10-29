package com.example.a2026_10_28;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class MainActivity extends AppCompatActivity {

    String result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText keyView = findViewById(R.id.keyView);
        EditText preCodeTextView = findViewById(R.id.preCodeText);
        Button codeButton = findViewById(R.id.code);
        TextView resultView = findViewById(R.id.resultView);

        GradientDrawable border = new GradientDrawable();
        border.setShape(GradientDrawable.RECTANGLE);
        border.setCornerRadius(20f);
        border.setStroke(5, Color.WHITE);
        resultView.setBackground(border);

        Button saveToFileButton = findViewById(R.id.saveToFile);


        codeButton.setOnClickListener( v -> {
            int key = Integer.parseInt(keyView.getText().toString());
            String preCodeText = preCodeTextView.getText().toString();
            for (char character:preCodeText.toCharArray()) {
                if(character != ' ') {
                    int asciiLetter = ((character - 'a') + key) % 26;
                    result += (char)(asciiLetter + 'a');
                }
            }
            resultView.setText(result);
        });
        saveToFileButton.setOnClickListener(v -> {
            String fileName = "plik_" + System.currentTimeMillis() + ".txt";
            try (FileOutputStream fos = openFileOutput(fileName, MODE_PRIVATE)) {
                fos.write(result.getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}