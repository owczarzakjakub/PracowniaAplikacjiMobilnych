package edu.kubaowcz.a2026_04_16;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

    int clickCounter = 0;
    EditText name;
    EditText email;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("clickCounter", clickCounter);
        outState.putString("name", name.getText().toString());
        outState.putString("email", email.getText().toString());
    }

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

        Button increase = findViewById(R.id.increase);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        TextView txt1 = findViewById(R.id.txt1);
        TextView txt2 = findViewById(R.id.txt2);


        if(savedInstanceState != null){
            clickCounter = savedInstanceState.getInt("clickCounter");
            name.setText(savedInstanceState.getString("name"));
            email.setText(savedInstanceState.getString("email"));
        }
        updateUI(txt1, txt2);


        increase.setOnClickListener(v -> {
            String nameValue = name.getText().toString();
            String emailValue = email.getText().toString();
            if (nameValue.isEmpty() || emailValue.isEmpty()){
                Toast.makeText(this, "Najpierw uzupelnij swoje dane", Toast.LENGTH_SHORT).show();
            }
            clickCounter += 1;
            updateUI(txt1, txt2);
        });
    }
    private void updateUI(TextView txt1, TextView txt2){
        String nameValue = name.getText().toString();
        String emailValue = email.getText().toString();

        txt2.setText("Kliknales przycisk " + clickCounter + " razy");
        txt1.setText("Imie: " + nameValue + "\nEmail: " + emailValue);

    }
}