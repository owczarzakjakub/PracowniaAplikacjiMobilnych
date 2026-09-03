package edu.kubaowcz.a2026_09_03;

import android.media.Image;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int finalResult = 0;

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
        TextView resultView = findViewById(R.id.result);
        TextView currentThrowView = findViewById(R.id.currentThrow);
        Button throwButton = findViewById(R.id.throwButton);
        Button resetButton = findViewById(R.id.resetButton);
        int[] numbers = new int[6];
        ImageView[] images = {findViewById(R.id.image1), findViewById(R.id.image2),findViewById(R.id.image3),findViewById(R.id.image4),findViewById(R.id.image5)};
        throwButton.setOnClickListener(v->{
            currentThrowView.setText(R.string.throwResult);
            int i = 0;
            while(i<=4){
                int randomNumber = new Random().nextInt(6) + 1;
                numbers[i] = randomNumber;
                switch(randomNumber) {
                    case 1:
                        images[i].setImageResource(R.drawable.k1);
                        break;
                    case 2:
                        images[i].setImageResource(R.drawable.k2);
                        break;
                    case 3:
                        images[i].setImageResource(R.drawable.k3);
                        break;
                    case 4:
                        images[i].setImageResource(R.drawable.k4);
                        break;
                    case 5:
                        images[i].setImageResource(R.drawable.k5);
                        break;
                    case 6:
                        images[i].setImageResource(R.drawable.k6);
                        break;
                }
                i++;
            }
            int currentThrow = 0;
            boolean checker = false;
            for(int j = 0; j < numbers.length; j++) {
                if(checker == true){
                    currentThrow += numbers[j - 1];
                    checker = false;
                }
                for (int k = j + 1; k < numbers.length; k++) {
                    if (numbers[j] == numbers[k]) {
                        currentThrow += numbers[k];
                        checker = true;
                    }
                }
            }
            finalResult += currentThrow;
            currentThrowView.setText(currentThrowView.getText() + " " + currentThrow);
            resultView.setText(getString(R.string.result) + " " + finalResult);
        });
        resetButton.setOnClickListener(v -> {
            for(int i = 0; i<5; i++){
                images[i].setImageResource(R.drawable.question);
            }
            finalResult =  0;
            currentThrowView.setText(getString(R.string.throwResult) + " " + 0);
            resultView.setText(getString(R.string.result) + " " + 0);
        });
    }
}