package com.blogspot.blogsetyaaji.kumpulanappbasic;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

//    deklarasi variabel
    Button btnpertama, btndua, btntiga, btnempat, btnlima
            , btnenam, btntujuh, btndelapan, btnsembilan, btnsepuluh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_utama);

        /*inisialisasi
                varable*/
        btnpertama = (Button) findViewById(R.id.btnpertama);
        btndua = (Button) findViewById(R.id.btndua);
        btntiga = (Button) findViewById(R.id.btntiga);
        btnempat = (Button) findViewById(R.id.btnempat);
        btnlima = (Button) findViewById(R.id.btnlima);
        btnenam = (Button) findViewById(R.id.btnenam);
        btntujuh = (Button) findViewById(R.id.btntujuh);
        btndelapan = (Button) findViewById(R.id.btndelapan);
        btnsembilan = (Button) findViewById(R.id.btnsembilan);
        btnsepuluh = (Button) findViewById(R.id.btnsepuluh);

//        aksi pd button ketika di klik
        btnpertama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Ini lho toast", Toast.LENGTH_SHORT).show();
            }
        });

        btndua.setOnClickListener(this);
        btntiga.setOnClickListener(this);
        btnempat.setOnClickListener(this);
        btnlima.setOnClickListener(this);
        btnenam.setOnClickListener(this);
        btntujuh.setOnClickListener(this);
        btndelapan.setOnClickListener(this);
        btnsembilan.setOnClickListener(this);
        btnsepuluh.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btndua){
            // aksi btndua
            Toast.makeText(this, "btn 2", Toast.LENGTH_SHORT).show();
            // menampilkan alert
            new AlertDialog.Builder(MainActivity.this).setTitle("Exit")
                    .setMessage("Yakin keluar aplikasi ?")
                    .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // perintah positif dari user
                            finish();
                        }
                    })
                    .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // perintah negative
                        }
                    })
                    .show();
        } else if (v == btntiga){
            //perintah utk btntiga
            // pindah activity
            startActivity(new Intent(
                    MainActivity.this,
                    SpinnerActivity.class));
        } else if (v == btnempat){
            //perintah utk btntiga
            // menampilkan menu
            PopupMenu popupMenu = new PopupMenu(MainActivity.this, v);
            // terapkan menu ke popupMenu
            popupMenu.inflate(R.menu.popup_menu);
            // aksi ketika item popupMenu di click
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    // menjalankan perintah sesuai urutan menu
                    switch (item.getItemId()){
                        case R.id.item1:
                            // menjalankan perintah utk item1
                            Toast.makeText(MainActivity.this, "item1", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.item2:
                            Toast.makeText(MainActivity.this, "item2", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.item3:
                            // share something
                            Toast.makeText(MainActivity.this, "Share something", Toast.LENGTH_LONG).show();
                            Intent inten = new Intent(Intent.ACTION_SEND);
                            inten.setType("text/plain");
                            inten.putExtra(Intent.EXTRA_SUBJECT, "Judul Share");
                            inten.putExtra(Intent.EXTRA_TEXT, "http://blogsetyaaji.blogspot.com");
                            startActivity(Intent.createChooser(inten, "Share Ma Blog Link !"));
                            break;
                    }
                    return true;
                }
            });
            // tampilkan popupMenu
            popupMenu.show();
        } else if (v == btnlima){
            //perintah utk btntiga
            // pindah activity
            startActivity(new Intent(MainActivity.this, SegitigaActivity.class));
        } else if (v == btnenam){
            //perintah utk btntiga
            startActivity(new Intent(MainActivity.this, SimpleListActivity.class));
        } else if (v == btntujuh){
            startActivity(new Intent(MainActivity.this, HewanListActivity.class));
            //perintah utk btntiga
        } else if (v == btndelapan){
            //perintah utk btntiga
            startActivity(new Intent(MainActivity.this, VideoActivity.class));
        } else if (v == btnsembilan){
            //perintah utk btntiga
            startActivity(new Intent(MainActivity.this, MiniBrowserActivity.class));
        } else if (v == btnsepuluh){
            //perintah utk btntiga
            startActivity(new Intent(MainActivity.this, GaleriHewanActivity.class));
        }
    }
}
