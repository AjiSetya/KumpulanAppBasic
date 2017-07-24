package com.blogspot.blogsetyaaji.kumpulanappbasic;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;

public class SpinnerActivity extends AppCompatActivity {

    Spinner spinner;
    //    String[] buah = {"Apel", "Pisang", "Jeruk", "Durian"};
    public String[] hewan = {"Anjing", "Ayam", "Babi", "Bebek", "Burung Hantu"};
    public Integer[] gambar_hewan = {
            R.drawable.anjing
            , R.drawable.ayam
            , R.drawable.babi
            , R.drawable.bebek
            , R.drawable.burung_hantu
    };
    Integer[] suara_hewan = {
            R.raw.anjing
            , R.raw.ayam
            , R.raw.babi
            , R.raw.bebek
            , R.raw.burung_hantu
    };
    ImageView imghewan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        // inisialisasi
        spinner = (Spinner) findViewById(R.id.spinner);
        imghewan = (ImageView) findViewById(R.id.imghewan);
        // gabungkan data dan spinner dgn adapter
        /*ArrayAdapter adapter = new ArrayAdapter(
                getApplicationContext()
                , android.R.layout.simple_spinner_item
                , buah);*/
        /*ArrayAdapter adapter = new ArrayAdapter(
                getApplicationContext()
                , android.R.layout.simple_spinner_item
                , hewan);*/
        // buat tampilan dropdown
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // masukkan pengaturan ke spinner
//        spinner.setAdapter(adapter);
        // aksi ketika spinner dipilih
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {
                // aksi sesuai posisi data yang di simpan di variable position
//                Toast.makeText(SpinnerActivity.this, buah[position], Toast.LENGTH_SHORT).show();
                Toast.makeText(SpinnerActivity.this, hewan[position], Toast.LENGTH_SHORT).show();
                // menampilkan gambar sesuai posisi data gambar_hewan
                imghewan.setImageResource(gambar_hewan[position]);
                // aksi ketika gambar diklik
                imghewan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // jalankan suara hewan sesuai posiis data suara
                        MediaPlayer mediaPlayer = new MediaPlayer();
                        // letak suara
                        Uri uri = Uri.parse("android.resource://" + getPackageName()
                                + "/" + suara_hewan[position]
                        );
                        // tipe media player
                        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                        // set lokasi untuk mediaPlayer
                        try {
                            mediaPlayer.setDataSource(SpinnerActivity.this, uri);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        // persiapan mediaPlayer
                        try {
                            mediaPlayer.prepare();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        // jalankan suara
                        mediaPlayer.start();
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
