package com.dev.tp3q2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.dev.tp3q2.Constants.EMAIL_1;
import static com.dev.tp3q2.Constants.EMAIL_2;
import static com.dev.tp3q2.Constants.PASSWORD_1;
import static com.dev.tp3q2.Constants.PASSWORD_2;
import static com.dev.tp3q2.Constants.YES;

public class LoginFragment extends Fragment implements View.OnClickListener {

    private View rootView;
    private EditText emailEdt, passwordEdt;
    private Button signInBtn;
    private String regexReponse;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_login, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
    }

    private void initViews() {
        emailEdt = rootView.findViewById(R.id.email_edt);
        passwordEdt = rootView.findViewById(R.id.password_edt);
        signInBtn = rootView.findViewById(R.id.sign_in_btn);
        signInBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.sign_in_btn) {
            if (isFieldEmpty(emailEdt) || isFieldEmpty(passwordEdt))
                return;

            regexReponse = Utilities.isEmailValid(emailEdt.getText().toString());
            if (!regexReponse.equals(YES)) {
                emailEdt.requestFocus();
                emailEdt.setError(regexReponse);
                return;
            }

            regexReponse = Utilities.isPasswordStrong(passwordEdt.getText().toString());
            if (!regexReponse.equals(YES)) {
                passwordEdt.requestFocus();
                passwordEdt.setError(regexReponse);
                return;
            }

            if ((emailEdt.getText().toString().equals(EMAIL_1) && passwordEdt.getText().toString().equals(PASSWORD_1))
                    || (emailEdt.getText().toString().equals(EMAIL_2) && passwordEdt.getText().toString().equals(PASSWORD_2)))
                sendDataToWelcomeFragment();
            else
                Toast.makeText(getActivity(), "Email ou mot de passe incorrect", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isFieldEmpty(EditText editText) {
        if (editText.getText().toString().trim().isEmpty()) {
            editText.requestFocus();
            editText.setError("Champ obligatoire !");
            return true;
        }
        return false;
    }

    private void sendDataToWelcomeFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("email", emailEdt.getText().toString());
        bundle.putString("password", passwordEdt.getText().toString());
        WelcomeFragment welcomeFragment = new WelcomeFragment();
        welcomeFragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.welcome_fragment_layout, welcomeFragment);
        fragmentTransaction.commit();
    }
}
