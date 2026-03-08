package edu.kubaowcz.a2026_02_09;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class ReportedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_reported);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView reportedName = findViewById(R.id.reported_name);
        TextView reportedLastname = findViewById(R.id.reported_lastname);
        TextView reportedClassName = findViewById(R.id.reported_className);

        Intent intent = getIntent();

        reportedName.setText(intent.getStringExtra("name"));
        reportedLastname.setText(intent.getStringExtra("lastname"));
        reportedClassName.setText(intent.getStringExtra("className"));

        Button button = findViewById(R.id.buttonReported);

        button.setOnClickListener(v -> {
            finish();
        });




    }
}