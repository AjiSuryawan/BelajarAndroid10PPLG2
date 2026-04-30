package com.example.belajarandroid10pplg2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListSiswa extends AppCompatActivity {

    RecyclerView rvListSiswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_siswa);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rvListSiswa= (RecyclerView) findViewById(R.id.rvListSiswa);
        // membuat arraylist menggunakan  SiswaModel
        ArrayList<SiswaModel> listDataSiswa = new ArrayList<>();

        SiswaModel siswa1 = new SiswaModel("Albay","1","Jati",R.drawable.logotim,"ini profil lengakpnya Albay");
        SiswaModel siswa2 = new SiswaModel("Abdillah","2","Ngembal",R.drawable.logotim,"ini profil lengakpnya Abdil");
        // pakai dummy untuk parameter user image
        // sampai 10 siswa

        listDataSiswa.add(siswa1);
        listDataSiswa.add(siswa2);

        //tambahin ini
        AdapterListSiswa adapter = new AdapterListSiswa(listDataSiswa, siswa -> {
            Toast.makeText(this, "hello "+siswa.getNama(), Toast.LENGTH_SHORT).show();
            // pindah ke detail siswa
            Intent in = new Intent(ListSiswa.this, DetailListSiswa.class);
            in.putExtra("nama" , siswa.getNama());
            in.putExtra("detail" , siswa.getDetailInfo());
            startActivity(in);
            // lanjut menangkap getExtras di DetailListSiswa

        });

        rvListSiswa.setLayoutManager(new LinearLayoutManager(this));
        rvListSiswa.setAdapter(adapter);

    }
}