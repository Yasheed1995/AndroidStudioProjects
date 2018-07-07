package com.example.logan1436.mmmo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

class CardsAdapter extends ArrayAdapter<Card> {
    private Context _context;

    // constructor
    // NOTE: there is no default constructor in ArrayAdapter<?>

    CardsAdapter(Context context, int resourceId, List<Card> items)
    {
        super(context, resourceId, items);
        this._context = context;
    }

    // need a ViewHolder to hold things in xml to card!

    private class ViewHolder
    {
        ImageView card_img;
        TextView card_author;
        TextView card_preview;
    }

    // TODO:
    // implement getView
    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent)
    {

        return convertView;
    }

}
