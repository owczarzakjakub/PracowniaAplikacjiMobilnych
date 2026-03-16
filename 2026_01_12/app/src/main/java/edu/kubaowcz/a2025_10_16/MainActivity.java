package edu.kubaowcz.a2025_10_16;

import android.content.Intent;
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
import android.widget.Toast;

import java.util.regex.Pattern;
import java.util.regex.Matcher;



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

        button = findViewById(R.id.button);
        output = findViewById(R.id.textView4);
        password = findViewById(R.id.editTextTextPassword2);
        password2 = findViewById(R.id.editTextTextPassword3);
        email = findViewById(R.id.editEmail);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password1Value = password.getText().toString();
                String password2Value = password2.getText().toString();
                String emaialValue = email.getText().toString();

                if (!isValidEmail(emaialValue)) {
                    output.setTextColor(getResources().getColor(R.color.red));
                    output.setText("Podaj poprawny email");
                } else if (!password1Value.equals(password2Value)) {
                    output.setTextColor(getResources().getColor(R.color.red));
                    output.setText("Podane hasła nie są takie same");
                } else if (password1Value.length() < 8) {
                    output.setTextColor(getResources().getColor(R.color.red));
                    output.setText("Hasło musi miec co najmniej 8 znakow");
                } else if (!containsDigit(emaialValue)) {
                    output.setTextColor(getResources().getColor(R.color.red));
                    output.setText("Hasło musi zawierac co najmniej jedna cyfre");
                } else if (!containsUpperCase(password1Value)) {
                    output.setTextColor(getResources().getColor(R.color.red));
                    output.setText("Hasło musi zawierac co najmniej jedna wielka litere");
                }
                else if(!containsLowerCase(password1Value)){
                    output.setTextColor(getResources().getColor(R.color.red));
                    output.setText("Hasło musi zawierac co najmniej jedna mala litere");
                }
                else{
                    Intent intent = new Intent(MainActivity.this, loggedActivity.class);
                    intent.putExtra("email", emaialValue);
                    startActivity(intent);
                }

            }
        });
    }

    public boolean isValidEmail(String email) {
        String Regex = "^[\\w.]+@[a-zA-Z]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(Regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean containsDigit(String email) {
        for (char c : email.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsUpperCase(String email) {
        for (char c : email.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsLowerCase(String email) {
        for (char c : email.toCharArray()) {
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }
}