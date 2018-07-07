package com.example.logan1436.mmmo;

/*
 * the class is for cards written by friends
 * _img: the image of the card
 * _name: the name who wrote the card
 * _preview: preview text of the card
 */

import android.graphics.Bitmap;

class Card {
    private Bitmap _img;
    private String _name;
    private String _preview;

    Card(Bitmap img, String name, String preview) {
        this._img = img;
        this._name = name;
        this._preview = preview;
    }

    Bitmap getImg() {
        return this._img;
    }

    String getName() {
        return this._name;
    }

    String getPreview() {
        return this._preview;
    }
}