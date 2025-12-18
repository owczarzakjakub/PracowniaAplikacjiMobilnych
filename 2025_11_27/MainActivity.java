package edu.kubaowcz.a2025_11_27;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView textView;

    private EditText editText2;

    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextText);
        textView = findViewById(R.id.textView);

        editText2 = findViewById(R.id.editTextText2);
        button2 = findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = editText2.getText().toString();
                Toast.makeText(MainActivity.this, inputText, Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void wyswietlTekst(View view) {
        String text = editText.getText().toString();
        textView.setText(text);

        editText.requestFocus();
        editText.setSelection(editText.getText().length());

    }
}