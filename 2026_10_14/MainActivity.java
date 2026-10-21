package com.example.a2026_10_14;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    int counter = 0;

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
        TextView counterTv = findViewById(R.id.counterTv);
        Button likeButton = findViewById(R.id.likeButton);
        Button dislikeButton = findViewById(R.id.dislikeButton);

        likeButton.setOnClickListener(v -> {
            counter++;
            counterTv.setText(counter + " polubien");
        });
        dislikeButton.setOnClickListener(v -> {
            if(counter > 0){
                counter--;
                counterTv.setText(counter + " polubien");
            }
        });
    }
}