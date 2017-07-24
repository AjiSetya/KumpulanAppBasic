package com.blogspot.blogsetyaaji.kumpulanappbasic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SegitigaActivity extends AppCompatActivity {

    @BindView(R.id.numalas)
    EditText numalas;
    @BindView(R.id.numtinggi)
    EditText numtinggi;
    @BindView(R.id.btnhitung)
    Button btnhitung;
    @BindView(R.id.numhasil)
    EditText numhasil;

    String alas;
    String tinggi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segitiga);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnhitung)
    public void onViewClicked() {
        // ambil data
        alas = numalas.getText().toString();
        tinggi = numtinggi.getText().toString();
        // validasi keberadaan data
        if (TextUtils.isEmpty(alas)) {
            numalas.setError("Alas tidak boleh kosong");
            numalas.requestFocus();
        } else if (TextUtils.isEmpty(tinggi)) {
            numtinggi.setError("Tinggi tidak boleh kosong");
            numtinggi.requestFocus();
        } else {
            // jika data ada maka proses data
            hitungSegitiga();
        }
    }

    private void hitungSegitiga() {
        // ubah tipe data string ke double
        double nilaialas = Double.parseDouble(alas);
        double nilaitinggi = Double.parseDouble(tinggi);
        // hitung
        double hasil = (nilaialas * nilaitinggi) / 2;
        // tampilkan data di komponen hasil
        numhasil.setText(String.valueOf(hasil));
    }
}
