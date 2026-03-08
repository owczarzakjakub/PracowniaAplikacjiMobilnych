package edu.kubaowcz.a2026_02_09;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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

        EditText nameInput = findViewById(R.id.nameInput);
        EditText lastnameInput = findViewById(R.id.lastnameInput);
        EditText classNameInput = findViewById(R.id.classNameInput);
        Button button = findViewById(R.id.buttonMain);

        button.setOnClickListener(v -> {
            String name = nameInput.getText().toString();
            String lastname = lastnameInput.getText().toString();
            String className = classNameInput.getText().toString();

            if(name.isEmpty() || lastname.isEmpty() ||className.isEmpty()){
                Toast.makeText(this, "Wypelnij wszystkie pola!", Toast.LENGTH_SHORT).show();
            }
            else{

                Intent intent = new Intent(this, ReportedActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("lastname", lastname);
                intent.putExtra("className", className);

                ProgressDialog dialog = new ProgressDialog(this);
                dialog.setTitle("Dodaje uwage....");
                dialog.setMessage("Prosze czekac.");
                dialog.show();

                nameInput.setText("");
                lastnameInput.setText("");
                classNameInput.setText("");

                new Handler().postDelayed(() -> {
                    dialog.dismiss();
                    startActivity(intent);
                }, 2000);

            }
        });

    }





}