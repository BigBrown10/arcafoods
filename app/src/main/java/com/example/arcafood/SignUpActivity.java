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

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    EditText Editemail, Editpassword;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        mAuth = FirebaseAuth.getInstance();

        Editemail = (EditText) findViewById(R.id.newemail);
        Editpassword = (EditText) findViewById(R.id.newpassword);

        findViewById(R.id.SignUp).setOnClickListener(this);
        findViewById(R.id.buttonlogin).setOnClickListener(this);

    }

    private void userLogin() {
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


        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    finish();
                    Intent intent = new Intent(SignUpActivity.this, ProfileActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (mAuth.getCurrentUser() != null) {
            finish();
            startActivity(new Intent(this, ProfileActivity.class));
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.SignUp:
                finish();
                startActivity(new Intent(this, MainActivity.class));
                break;

            case R.id.buttonlogin:
                userLogin();
                break;
        }
    }
}
