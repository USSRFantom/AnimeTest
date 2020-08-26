package ussrfantom.com.example.animetest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText editTextMail;
    private EditText editTextPassword;
    private TextView textViewRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        textViewRegister = findViewById(R.id.textViewRegister);
        editTextMail = findViewById(R.id.editTextEmailAddress);
        editTextPassword = findViewById(R.id.editTextPassword);

        textViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent (LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onClickLogin(View view) {
        String email = editTextMail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        if (email.isEmpty() || password.isEmpty()){
            return;
        }
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Intent intent = new Intent(LoginActivity.this, LevelsActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this, "Ошибка: " + task.getException(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}