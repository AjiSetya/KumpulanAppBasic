package com.blogspot.blogsetyaaji.kumpulanappbasic;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by DELL on 22/07/2017.
 */

class HewanAdapter extends BaseAdapter {
    // penampung data yang dikirim dari activity hewanlistactivity
    Activity activity;
    String[] hewan;
    Integer[] gmb_hewan;

    public HewanAdapter(HewanListActivity hewanListActivity, String[] hewan, Integer[] gambar_hewan) {
        // masukkan data ke variable dalam adapter
        this.hewan = hewan;
        gmb_hewan = gambar_hewan;
        activity = hewanListActivity;
    }

    @Override
    public int getCount() {
        return hewan.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // LETAKKAN LAYOUT LIST_HEWAN ke lvhewan MENGUNAKAN INFLATER
        LayoutInflater inflater = (LayoutInflater)
                activity.getSystemService(activity.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.list_hewan, null);
        // deklarasi inisialisasi komponen yang ada pada list_hewan
        TextView txtlvhewan = (TextView) v.findViewById(R.id.txtlvhewan);
        ImageView imglvhewan = (ImageView) v.findViewById(R.id.imglvhewan);
        // menampilkan data pd masing2 komponen
        txtlvhewan.setText(hewan[position]);
        imglvhewan.setImageResource(gmb_hewan[position]);
        return v;
    }
}
