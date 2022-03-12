package com.example.adp_29_authnew;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity {
    private EditText name, email, password;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        register = findViewById(R.id.register);

        final String nameVal = name.getText().toString().trim();
        final String emailVal = email.getText().toString().trim();
        final String passVal = password.getText().toString().trim();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewAccount(nameVal, emailVal, passVal);
            }
        });
    }

    private void createNewAccount(String nameVal, String emailVal, String passVal) {
        if(TextUtils.isEmpty(nameVal)) {
            name.setError("please enter name");
            name.requestFocus();
            return;
        }
        if(TextUtils.isEmpty(emailVal)) {
            email.setError("please Enter Email");
            email.requestFocus();
            return;
        }
        if(TextUtils.isEmpty(passVal)) {
            password.setError("please enter password");
            password.requestFocus();
            return;
        }

        Call<ResponseBody>call= MyRetrofit.getInstance().getMyApi().createNewAccount(name, email, password);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try{
                    String hi = response.body().string();
                    Toast.makeText(getApplicationContext(), hi, Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
