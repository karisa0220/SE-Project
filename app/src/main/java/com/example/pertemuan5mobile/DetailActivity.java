package com.example.pertemuan5mobile;

import android.app.Activity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.ArrayList;

public class DetailActivity extends Activity {

    private ArrayList<Food> foodieslist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        foodieslist.addAll(FoodData.getListData());

        getIncomingIntent();
    }

    private void getIncomingIntent(){

        if(getIntent().hasExtra("index")){

            int index = getIntent().getIntExtra("index", 0);

            setFood(index);
        }
    }


    private void setFood(int position){
        Food food = foodieslist.get(position);
        String name = food.getName();
        String desc = food.getDesc();
        String photo = food.getPhoto();

        TextView tvname = findViewById(R.id.image_name);
        tvname.setText(name);

        TextView tvdesc = findViewById(R.id.image_description);
        tvdesc.setText(desc);

        ImageView image = findViewById(R.id.image);
        Glide.with(this)
                .asBitmap()
                .load(photo)
                .into(image);
    }
}
