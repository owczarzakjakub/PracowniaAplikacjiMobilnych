package edu.kubaowcz.a2026_04_20;

import android.app.Dialog;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.fragment.app.DialogFragment;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import org.jspecify.annotations.NonNull;

public class PhotoDialogFragment extends DialogFragment {

    private static final String ARG_PHOTO_ID = "photo_id";

    public static PhotoDialogFragment newInstance(int photoId) {
        PhotoDialogFragment fragment = new PhotoDialogFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PHOTO_ID, photoId);
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        int photoId = getArguments().getInt(ARG_PHOTO_ID);

        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(photoId);
        imageView.setAdjustViewBounds(true);
        imageView.setPadding(16, 16, 16, 16);

        return new MaterialAlertDialogBuilder(requireContext())
            .setView(imageView)
            .setNegativeButton("Zamknij", (dialog, which) -> dialog.dismiss())
                .create();
    }

}
