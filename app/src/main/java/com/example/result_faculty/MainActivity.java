package com.example.result_faculty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton btnlogin;
    String mail;
    EditText ed;
    EditText ed2;
    String password;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnlogin = findViewById(R.id.btnlogin);
        ed = findViewById(R.id.in);
        ed2 = findViewById(R.id.pass);
        mAuth = FirebaseAuth.getInstance();
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vi) {
                mail = ed.getText().toString().trim();
                password = ed2.getText().toString().trim();

                if (TextUtils.isEmpty(mail)) {
                    ed.setError("Enter The E-mail First");
                    return;
                }  else if (TextUtils.isEmpty(password)) {
                    ed2.setError("Please Enter Your Password ");
                    return;
                } else if (ed2.length() != 14) {
                    ed2.setError("Must Be 14 Numbers");
                    return;
                }

                mAuth.signInWithEmailAndPassword(mail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            Snackbar mySnackbar = Snackbar.make(findViewById(R.id.cc),
                                    "Signed In", Snackbar.LENGTH_SHORT);
                            mySnackbar.show();
                            Intent i = new Intent(MainActivity.this,DashBoard_activity.class);
                            startActivity(i);
                        }
                        else {

                            Snackbar mySnackbar = Snackbar.make(findViewById(R.id.cc),
                                    "Wrong E-Mail Or Password", Snackbar.LENGTH_SHORT);
                            mySnackbar.show();
                        }
                    }
                });
            }
        });

    }
}