package edu.kubaowcz.a2026_09_23;

import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

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
        SeekBar seekBar = findViewById(R.id.seekBar);
        TextView quoteTv = findViewById(R.id.quote);
        Button submit = findViewById(R.id.submit);
        TextView currentSize = findViewById(R.id.currentSize);
        String[] quoteArray = {"dzien dobry", "buenos dias", "good morning"};

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentSize.setText("Rozmiar: " + progress);
                quoteTv.setTextSize(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        submit.setOnClickListener(v -> {
            switch (quoteTv.getText().toString()){
                case "dzien dobry":
                    quoteTv.setText(quoteArray[1]);
                    break;

                case "buenos dias":
                    quoteTv.setText(quoteArray[2]);
                    break;
                case "good morning":
                    quoteTv.setText(quoteArray[0]);
                    break;
            }
        });
    }
}