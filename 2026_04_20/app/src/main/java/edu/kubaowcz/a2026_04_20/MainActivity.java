package edu.kubaowcz.a2026_04_20;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class MainActivity extends AppCompatActivity {

    private final int[] photos = {
            R.drawable.photo1,
            R.drawable.photo2,
            R.drawable.photo3,
            R.drawable.photo4,
            R.drawable.photo5,
            R.drawable.photo6,
            R.drawable.photo7,
            R.drawable.photo8,
            R.drawable.photo9,
            R.drawable.photo10,
            R.drawable.photo11,
            R.drawable.photo12,
            R.drawable.photo13,
            R.drawable.photo14,
            R.drawable.photo15
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout container = findViewById(R.id.photoContainer);

        for (int photoResId : photos) {
            ImageView imageView = new ImageView(this);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(300, 300);
            params.setMargins(8, 8, 8, 8);
            imageView.setLayoutParams(params);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setImageResource(photoResId);

            final int resId = photoResId;
            imageView.setOnClickListener(v -> {
                PhotoDialogFragment dialog = PhotoDialogFragment.newInstance(resId);
                dialog.show(getSupportFragmentManager(), "photo_dialog");
            });

            container.addView(imageView);
        }
    }
}