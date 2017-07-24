package com.blogspot.blogsetyaaji.kumpulanappbasic;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.zip.Inflater;

/**
 * Created by DELL on 22/07/2017.
 */

class HewanPagerAdapter extends PagerAdapter {
    Context context;
    String[] hewan;
    String[] deskripsihewan;
    Integer[] gambar_hewan;

    public HewanPagerAdapter(GaleriHewanActivity galeriHewanActivity, String[] hewan, Integer[] gambar_hewan, String[] deskripsi) {
        context = galeriHewanActivity;
        this.hewan = hewan;
        deskripsihewan = deskripsi;
        this.gambar_hewan = gambar_hewan;
    }

    @Override
    public int getCount() {
        return hewan.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.pager_list_hewan, null);

        TextView txtpghewan = (TextView) v.findViewById(R.id.txtpghewan);
        TextView txtdpghewan = (TextView) v.findViewById(R.id.txtdpghewan);
        ImageView imgpghewan = (ImageView) v.findViewById(R.id.imgpghewan);

        txtpghewan.setText(hewan[position]);
        txtdpghewan.setText(deskripsihewan[position]);
        imgpghewan.setImageResource(gambar_hewan[position]);

        ((ViewPager) container).addView(v);
        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((RelativeLayout) object);
    }
}
