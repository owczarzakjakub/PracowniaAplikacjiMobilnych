package edu.kubaowcz.a2026_03_16;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
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

        SeekBar seekBar = findViewById(R.id.seekBar);
        TextView ageInfo = findViewById(R.id.age);
        TextView result = findViewById(R.id.result);
        EditText owner = findViewById(R.id.owner);
        EditText visitGoal = findViewById(R.id.visitGoal);
        EditText visitTime = findViewById(R.id.visitTime);
        ListView list = findViewById(R.id.speciesList);
        Button button = findViewById(R.id.submit);


        String ownerInfo = owner.getText().toString();
        String visitGoalInfo = visitGoal.getText().toString();
        String visitTimeInfo = visitTime.getText().toString();
        String age = seekBar.getProgress() + "";
        String species = list.getSelectedItem().toString();

        String[] dane = {
                getString(R.string.dog),
                getString(R.string.cat),
                getString(R.string.guineaPig)
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dane);
        list.setAdapter(adapter);

        list.setOnItemClickListener((parent, view, position, id) -> {
            String item = (String) parent.getItemAtPosition(position);
            switch (item){
                case "Pies":
                    seekBar.setMax(18);
                    break;
                case "Kot":
                    seekBar.setMax(20);
                    break;

                    case "Swinka morska":
                    seekBar.setMax(9);
                    break;
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ageInfo.setText("Ile ma lat? " + String.valueOf(progress));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar){}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar){}
        });





        CharSequence channelName = "main";
        String description = "main channel for notifications";
        int importance = NotificationManager.IMPORTANCE_DEFAULT;

        NotificationChannel channel = new NotificationChannel("channel_id", channelName, importance);
        channel.setDescription(description);

        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);
        
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "channel_id")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
        .setContentTitle("Wizyta u weterynarza")
                .setContentText(ownerInfo + " " + species + " " + age + " " + visitGoalInfo + " " + visitTimeInfo);

        //dok. powiadomiania

        button.setOnClickListener(v -> {
            result.setText(ownerInfo + "" + species + "" + age + "" + visitGoalInfo + "" + visitTimeInfo);
            builder.build();
        });

    }
}
