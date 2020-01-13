package com.example.whatsappclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private EditText mPhoneNo,Code;
    private Button verificationBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(this);
        mPhoneNo=findViewById(R.id.phoneNo);
        Code=findViewById(R.id.code);
        verificationBtn=findViewById(R.id.verificationBtn);
        verificationBtn.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view)
            {
                sendVerificationCode();
            }
        });
    }
    private void sendVerificationCode()
    {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                mPhoneNo.getText().toString(),60
                , TimeUnit.SECONDS
                ,this, 
        );
    }
}
