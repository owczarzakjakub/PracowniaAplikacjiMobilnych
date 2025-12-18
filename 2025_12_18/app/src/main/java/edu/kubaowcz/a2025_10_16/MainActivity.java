package edu.kubaowcz.a2025_10_16;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView output;
    private EditText password;
    private EditText password2;

    private EditText email;


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

        button =findViewById(R.id.button);
        output = findViewById(R.id.textView4);
        password = findViewById(R.id.editTextTextPassword2);
        password2 = findViewById(R.id.editTextTextPassword3);
        email = findViewById(R.id.editEmail);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password1Value = password.getText().toString();
                String password2Value = password2.getText().toString();
                String message = "";

                if(!password1Value.equals(password2Value)){
                    message += "Hasła sie roznia";
                }
                else if(!email.getText().toString().contains("@")){
                    message += " Niepoprawny email";
                }
                else{
                    message = "Witaj " + email.getText().toString() + "!";
                }
                output.setText(message);

            }
        });
    }
}