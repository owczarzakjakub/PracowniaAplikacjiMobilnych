package edu.kubaowcz.a2026_02_02;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UserResult#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserResult extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_NAME = "name";
    private static final String ARG_LASTNAME = "lastName";
    private static final String ARG_EMAIL = "email";

    // TODO: Rename and change types of parameters
    private String name;
    private String lastName;
    private String email;

    public UserResult() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param name Parameter 1.
     * @param lastName Parameter 2.
     * @param email Parameter 3.
     * @return A new instance of fragment UserResult.
     */
    // TODO: Rename and change types and number of parameters
    public static UserResult newInstance(String name, String lastName, String email) {
        UserResult fragment = new UserResult();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);
        args.putString(ARG_LASTNAME, lastName);
        args.putString(ARG_EMAIL, email);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString(ARG_NAME);
            lastName = getArguments().getString(ARG_LASTNAME);
            email = getArguments().getString(ARG_EMAIL);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_result, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView nameTextView = view.findViewById(R.id.nameTextView);
        TextView lastNameTextView = view.findViewById(R.id.lastNameTextView);
        TextView emailTextView = view.findViewById(R.id.emailTextView);

        nameTextView.setText(name);
        lastNameTextView.setText(lastName);
        emailTextView.setText(email);

    }
}