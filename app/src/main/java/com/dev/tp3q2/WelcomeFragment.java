package com.dev.tp3q2;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.Random;

public class WelcomeFragment extends Fragment {

    private int[] randomColors = new int[]{Color.GREEN, Color.DKGRAY, Color.YELLOW,
            Color.BLUE, Color.CYAN, Color.MAGENTA, Color.LTGRAY, Color.GRAY};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_welcome, container, false);
        TextView textView = rootView.findViewById(R.id.textview);

        if (getArguments() != null && getArguments().getString("email") != null && getArguments().getString("password") != null) {
            String welcomeString = "Email : " + getArguments().getString("email") + "\nMot de passe est : " + getArguments().getString("password");
            textView.setText(welcomeString);
            LinearLayout frameLayout = rootView.findViewById(R.id.welcom_layout);
            frameLayout.setBackgroundColor(randomColors[new Random().nextInt(randomColors.length)]);
        }

        return rootView;
    }
}
