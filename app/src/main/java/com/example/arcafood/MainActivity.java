package com.example.arcafood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_TEXT = "com.example.arcafood";
    // TODO: 12/14/2019 Replace with the right edit text names from XML file
    private EditText username,email,password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: 12/14/2019 Initialize the edittext defined above with findViewById()
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        Button button = findViewById(R.id.login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: 12/14/2019 use the isEmpty() function on username and email to check if they are not empty
                //if they are not open home else show a Toast saying "Please fill the form to proceed"
                if ((username.getText().toString().isEmpty() && email.getText().toString().isEmpty() && password.getText().toString().isEmpty())) {
                    Toast.makeText(getApplicationContext(), "Please fill the form to proceed", Toast.LENGTH_SHORT).show();
                } else if (email.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter Email ", Toast.LENGTH_SHORT).show();
                } else if (username.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter username ", Toast.LENGTH_SHORT).show();
                } else if (password.getText().toString().isEmpty() || !(password.getText().length() > 3 && password.getText().length() < 11)) {
                    Toast.makeText(getApplicationContext(), "Enter password ", Toast.LENGTH_SHORT).show();

                } else openhome();
            }

        });
    }

    public void openhome() {
        EditText myName = findViewById(R.id.username);
        String text = myName.getText().toString();
        Intent intent = new Intent(this, home.class);
        intent.putExtra(EXTRA_TEXT, text);
        startActivity(intent);
    }
}
