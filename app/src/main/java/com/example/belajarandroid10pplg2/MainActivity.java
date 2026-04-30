package com.example.belajarandroid10pplg2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edUsername;
    EditText edPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        // menyambungkan objek ke widget di layout xml
        edUsername = (EditText) findViewById(R.id.edUsername);
        edPassword = (EditText) findViewById(R.id.edPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // cek apakah username dan passwordnya admin
                String username = edUsername.getText().toString();
                String password = edPassword.getText().toString();
                if(username.equals("admin") && password.equals("admin")){
                    //sukses
                    Toast.makeText(MainActivity.this, "sukses login", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, ListSiswa.class));
                }else{
                    //gagal
                    Toast.makeText(MainActivity.this, "gagal login", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}