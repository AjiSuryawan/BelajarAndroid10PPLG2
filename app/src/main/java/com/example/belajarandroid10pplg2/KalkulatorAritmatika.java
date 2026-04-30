package com.example.belajarandroid10pplg2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class KalkulatorAritmatika extends AppCompatActivity {

    EditText edAngka1;
    EditText edAngka2;
    Button btnTambah;
    Button btnKurang;
    Button btnKali;
    Button btnBagi;
    TextView txtHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_kalkulator_aritmatika);
        edAngka1 = (EditText) findViewById(R.id.edAngka1);
        edAngka2 = (EditText) findViewById(R.id.edAngka2);
        btnTambah = (Button) findViewById(R.id.btnTambah);
        btnKurang = (Button) findViewById(R.id.btnKurang);
        btnKali = (Button) findViewById(R.id.btnKali);
        btnBagi = (Button) findViewById(R.id.btnBagi);
        txtHasil = (TextView) findViewById(R.id.txtHasil);
        // 5 + 5 = 10
        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int angka1 = Integer.parseInt(edAngka1.getText().toString());
                int angka2 = Integer.parseInt(edAngka2.getText().toString());
                int hasil = angka1 + angka2;
                txtHasil.setText("Hasil :" + hasil);
            }
        });

    }
}