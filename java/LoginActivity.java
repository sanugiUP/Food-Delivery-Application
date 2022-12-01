package com.example.mad_assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    private EditText username_text;
    private EditText text_password;
    private Button register;
    private ImageView arrow;
    private ArrayList<Customer> customerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);

        FragmentManager frag = getSupportFragmentManager();
        FragmentTransaction transaction = frag.beginTransaction();
        LoginFormFragment login_form_fragment = new LoginFormFragment();
        transaction.add(R.id.frag_container_two, login_form_fragment).commit();
    }
}
