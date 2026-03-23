package edu.kubaowcz.a2026_03_23;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.app.NotificationManagerCompat;

import java.nio.file.attribute.FileTime;

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

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);

        if (Build.VERSION.SDK_INT >= 33 &&
                checkSelfPermission(Manifest.permission.POST_NOTIFICATIONS)
                        != PackageManager.PERMISSION_GRANTED) {

            requestPermissions(new String[]{Manifest.permission.POST_NOTIFICATIONS}, 1);
            return;
        }

        button1.setOnClickListener(v -> {

           if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
               NotificationChannel highPriorityNotificationChannel = new NotificationChannel(
                       "high_priority_channel",
                       "High Priority Notifications",
                       NotificationManager.IMPORTANCE_HIGH
               );

               highPriorityNotificationChannel.setDescription("Channel for important notifs");
               highPriorityNotificationChannel.enableLights(true);
               highPriorityNotificationChannel.enableVibration(true);

               NotificationManager manager = getSystemService(NotificationManager.class);
               manager.createNotificationChannel(highPriorityNotificationChannel);

               Intent intent = new Intent(this, SecondActivity.class);
               PendingIntent pendingIntent = PendingIntent.getActivity(
                    this,
                       0,
                       intent,
                       PendingIntent.FLAG_IMMUTABLE | PendingIntent.FLAG_UPDATE_CURRENT
               );


               NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "high_priority_channel")
                       .setSmallIcon(R.drawable.ic_launcher_foreground)
                       .setContentTitle("Wazne powiadomienie")
                       .setContentText("Powiadomienie przenoszace do SecondActivity")
                       .setContentIntent(pendingIntent)
                       .setPriority(NotificationCompat.PRIORITY_HIGH)
                       .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                       .setAutoCancel(true);

               NotificationManagerCompat.from(this)
                       .notify(1, builder.build());
           }
        });

        button2.setOnClickListener(v -> {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel lowPriorityNotificationChannel = new NotificationChannel(
                    "low-priority-channel",
                        "Low Priority Notifications",
                        NotificationManager.IMPORTANCE_LOW
                );

                lowPriorityNotificationChannel.setDescription("Channel for low priority notifications");

                NotificationManager manager = getSystemService(NotificationManager.class);
                manager.createNotificationChannel(lowPriorityNotificationChannel);

                Intent intent = new Intent(this, ThirdActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(
                        this,
                        0,
                        intent,
                        PendingIntent.FLAG_IMMUTABLE | PendingIntent.FLAG_UPDATE_CURRENT
                );

                NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "low-priority-channel")
                        .setSmallIcon(R.drawable.ic_launcher_foreground)
                        .setContentTitle("Niewazne powiadomienie")
                        .setContentText("Powiadomienie przenoszace do ThirdActivity")
                        .setContentIntent(pendingIntent)
                        .setPriority(NotificationCompat.PRIORITY_LOW)
                        .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                        .setAutoCancel(true);

                NotificationManagerCompat.from(this).notify(2, builder.build());
            }
        });
    }
}