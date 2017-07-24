package com.blogspot.blogsetyaaji.kumpulanappbasic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HewanListActivity extends AppCompatActivity {

    String[] hewan = {"Anjing", "Ayam", "Babi", "Bebek", "Burung Hantu"};
    Integer[] gambar_hewan = {
            R.drawable.anjing
            , R.drawable.ayam
            , R.drawable.babi
            , R.drawable.bebek
            , R.drawable.burung_hantu
    };
    @BindView(R.id.lvhewan)
    ListView lvhewan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hewan_list);
        ButterKnife.bind(this);
        // memasukkan data ke dalam listview menggunakan adapter
        HewanAdapter adapter = new HewanAdapter(this, hewan, gambar_hewan);
        // atur adapter le lvhewan
        lvhewan.setAdapter(adapter);
        final DeskripsiHewan deskripsiHewan = new DeskripsiHewan();
        // aksi ketika item diklik
        lvhewan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(HewanListActivity.this, DetailHewan.class);
                intent.putExtra("namahewan", hewan[position]);
                intent.putExtra("gambarhewan", gambar_hewan[position]);
                intent.putExtra("deskripsihewan", deskripsiHewan.deskripsi[position]);
                startActivity(intent);
            }
        });
    }
}
