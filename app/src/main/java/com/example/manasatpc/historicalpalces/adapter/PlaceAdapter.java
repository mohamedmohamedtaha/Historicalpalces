package com.example.manasatpc.historicalpalces.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.manasatpc.historicalpalces.R;
import com.example.manasatpc.historicalpalces.model.Places;

import java.util.ArrayList;

/**
 * Created by ManasatPC on 21/09/18.
 */

public class PlaceAdapter extends BaseAdapter {
    public static final String PREF_FILE = "com.example.manasatpc.historicalpalces.adapter";

    ArrayList<Places>places = new ArrayList<>();
    Context context;

    public PlaceAdapter(ArrayList<Places> places, Context context) {
        this.places = places;
        this.context = context;
    }

    @Override
    public int getCount() {
        return places.size();
    }

    @Override
    public Object getItem(int position) {
        return places.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
        View item_view =convertView;
        if (convertView ==null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            item_view =inflater.from(context).inflate(R.layout.custom_historical_places,parent,false);
        }
        ((ImageView)item_view.findViewById(R.id.image_view)).setImageResource(places.get(position).getImage());
                ((TextView)item_view.findViewById(R.id.title_text_view)).setText(places.get(position).getName());
        ((TextView)item_view.findViewById(R.id.rateing_text_view)).setText(String.format("%s: %d",context.getString(R.string.app_name)
                ,places.get(position).getRate()));
        final Places current_place =places.get(position);
        final TextView ratingTextView = ((TextView)item_view.findViewById(R.id.rateing_text_view));
        item_view.findViewById(R.id.rate_button).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                current_place.setRate(current_place.getRate()+1);
                ratingTextView.setText(String.format("%s: %d",context.getString(R.string.app_name)
                        ,current_place.getRate()));

                SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE,Context.MODE_PRIVATE);
                sharedPreferences.edit().putInt(current_place.getName(),current_place.getRate()).apply();

            }
        });

        return item_view;
    }
}
