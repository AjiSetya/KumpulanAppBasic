package com.blogspot.blogsetyaaji.kumpulanappbasic;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GaleriHewanActivity extends AppCompatActivity {

    String[] hewan = {"Anjing", "Ayam", "Babi", "Bebek", "Burung Hantu"};
    Integer[] gambar_hewan = {
            R.drawable.anjing
            , R.drawable.ayam
            , R.drawable.babi
            , R.drawable.bebek
            , R.drawable.burung_hantu
    };
    @BindView(R.id.vphewan)
    ViewPager vphewan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeri_hewan);
        ButterKnife.bind(this);
        DeskripsiHewan deskripsiHewan = new DeskripsiHewan();
        HewanPagerAdapter hewanPagerAdapter =
                new HewanPagerAdapter(this, hewan, gambar_hewan, deskripsiHewan.deskripsi);
        vphewan.setAdapter(hewanPagerAdapter);
    }
}
