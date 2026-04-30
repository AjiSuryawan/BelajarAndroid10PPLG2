package com.example.belajarandroid10pplg2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterListSiswa extends RecyclerView.Adapter<AdapterListSiswa.ViewHolder> {

    private List<SiswaModel> listSiswa;

    // ini object listener untuk menyambungkan ke activity
    OnItemClickListener listener;

    // interface class yang dipakai nanti di activity
    public interface OnItemClickListener{
        void onItemClick(SiswaModel siswa);
    }

    // constructor
    // ditambahkan listener untuk menyambungkan ke activity
    public AdapterListSiswa(List<SiswaModel> listSiswa , OnItemClickListener listener) {
        this.listSiswa = listSiswa;
        this.listener = listener;
    }

    // ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvnamasiswa);
            tvNama.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int posisi = getAdapterPosition();
                    listener.onItemClick(listSiswa.get(posisi));
                }
            });
        }
    }

    @NonNull
    @Override
    public AdapterListSiswa.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_siswa_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterListSiswa.ViewHolder holder, int position) {
        String nama = listSiswa.get(position).getNama();
        holder.tvNama.setText(nama);
    }

    @Override
    public int getItemCount() {
        return listSiswa.size();
    }
}