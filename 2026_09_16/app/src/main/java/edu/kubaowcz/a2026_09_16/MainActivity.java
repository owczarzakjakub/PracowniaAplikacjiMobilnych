package edu.kubaowcz.a2026_09_16;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

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

        EditText washingNumberV = findViewById(R.id.washingNumberInput);
        Button submitButton = findViewById(R.id.submitButton);
        TextView washingStatusTv = findViewById(R.id.washingStatusTv);
        Button powerButton = findViewById(R.id.powerButton);
        TextView vacuumStatusTv = findViewById(R.id.vacuumStatusTv);

        submitButton.setOnClickListener(v -> {
            int washingNumber = Integer.parseInt(washingNumberV.getText().toString());
            if(washingNumber >= 1 && washingNumber <= 12){
                washingStatusTv.setText("Numer prania: " + washingNumber);
            }
        });
        powerButton.setOnClickListener(v -> {
            String vacuumStatus = vacuumStatusTv.getText().toString();
            if(vacuumStatus.equals("Odkurzacz wylaczony")){
                powerButton.setText("Wylacz");
                vacuumStatusTv.setText("Odkurzacz wlaczony");
            }
            else {
                powerButton.setText("Wlacz");
                vacuumStatusTv.setText("Odkurzacz wylaczony");
            }
        });
    }
}