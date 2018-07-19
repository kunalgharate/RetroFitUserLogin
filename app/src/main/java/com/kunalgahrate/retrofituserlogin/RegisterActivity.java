package com.kunalgahrate.retrofituserlogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final AutoCompleteTextView username,phone,email;
        final EditText password;

        username = findViewById(R.id.name);
        password = findViewById(R.id.password);
        phone = findViewById(R.id.phone_no);
        email = findViewById(R.id.email_id);

        Button register = findViewById(R.id.register);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData(username.getText().toString(), password.getText().toString(),Integer.parseInt(phone.getText().toString()),email.getText().toString());
            }
        });

    }

    private void insertData(String name, String password, int phone,String email) {
        ILoginRetrofit apiService = RetrofitClient.getClient().create(ILoginRetrofit.class);
        Call<User> call = apiService.insertFood(name,password,phone,email);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.body().getStatus().equals("Success")) {
                    Toast.makeText(RegisterActivity.this, "Register Successfully", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
