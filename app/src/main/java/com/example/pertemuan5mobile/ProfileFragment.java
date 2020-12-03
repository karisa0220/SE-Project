package com.example.pertemuan5mobile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ProfileFragment extends Fragment {

    // Method onCreateView dipanggil saat Fragment harus menampilkan layoutnya      // dengan membuat layout tersebut secara manual lewat objek View
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String photo = "https://scontent-cgk1-1.cdninstagram.com/v/t51.2885-19/s150x150/121502569_351737289247255_9071479452668502951_n.jpg?_nc_ht=scontent-cgk1-1.cdninstagram.com&_nc_cat=107&_nc_ohc=uQ3NLbFi008AX9c0s2C&tp=1&oh=6e5a8d92763403163db3e60da30c9916&oe=5FED7CD1";
        // Layout tampilan untuk fragment ini
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        ImageView image = (ImageView) view.findViewById(R.id.imageProfile);
        Glide.with(this)
                .asBitmap()
                .load(photo)
                .into(image);
        return view;
    }

}