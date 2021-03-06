package com.example.arcafood;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String EXTRA_TEXT = "com.example.arcafood";


    private EditText Editemail,Editpassword;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Editemail = findViewById(R.id.email);
        Editpassword = findViewById(R.id.password);


        mAuth = FirebaseAuth.getInstance();
        findViewById(R.id.login).setOnClickListener(this);
        findViewById(R.id.textSignUp).setOnClickListener(this);

    }

    private void registerUser() {
        String email = Editemail.getText().toString().trim();
        String password = Editpassword.getText().toString().trim();



        if (email.isEmpty()) {
            Editemail.setError("Email is required");
            Editemail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Editemail.setError("Please enter a valid email");
            Editemail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            Editpassword.setError("Password is required");
            Editpassword.requestFocus();
            return;
        }

        if (password.length() < 6) {
            Editpassword.setError("Minimum lenght of password should be 6");
            Editpassword.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    finish();
                    Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);

                } else {

                    if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                        finish();
                        Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);

                    } else {
                        Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login:
                registerUser();
                break;

            case R.id.textSignUp:
                finish();
                startActivity(new Intent(this,SignUpActivity.class));
                break;
        }
    }
}