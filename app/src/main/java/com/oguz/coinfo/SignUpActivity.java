package com.oguz.coinfo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.oguz.coinfo.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {

    private ActivitySignUpBinding binding;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        auth = FirebaseAuth.getInstance();

        binding.logInTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToSignUp = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intentToSignUp);
                finish();
            }
        });
    }

    public void signUpClicked(View view){

        String email = binding.registerEmail.getText().toString();
        String password = binding.registerPassword.getText().toString();
        String passwordAgain = binding.registerPasswordAgain.getText().toString();

        if(email.equals("") || password.equals("") || passwordAgain.equals("")){
            Toast.makeText(this, "Fill in the required fields!", Toast.LENGTH_LONG).show();
        }
        else if(!(password.equals(passwordAgain))){
            Toast.makeText(this, "Passwords do not match!",Toast.LENGTH_LONG).show();
        }
        else{
            auth.createUserWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(SignUpActivity.this, e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    public void toLoginPage(View view){
        Intent intent2 = new Intent(SignUpActivity.this, LoginActivity.class);
        startActivity(intent2);
        finish();
    }
}