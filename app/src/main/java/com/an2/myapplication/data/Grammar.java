package com.an2.myapplication.data;

import android.graphics.drawable.Drawable;

public class Grammar {
    private String mMain;
    private Drawable mColorMain;

    public Drawable getColorMain() { return mColorMain; }
    public String getString() {
        return mMain;
    }

    public Grammar(String s, Drawable color) {
        switch (s) {
            case "first": {
                mMain = "1.Особисті займенники";
                this.mColorMain = color;
                break;
            }
            case "second": {
                mMain = "2.Множина іменників";
                this.mColorMain = color;
                break;
            }
            case "third": {
                mMain = "3.Дієслово \"to be\".\n Базова інформація";
                this.mColorMain = color;
                break;
            }
            case "fourth": {
                mMain = "4. Особисті займенники. \n Частина 2";
                this.mColorMain = color;
                break;
            }
            case "fifth": {
                mMain = "5.Порядкові чисельники";
                this.mColorMain = color;
                break;
            }
            case "sixth": {
                mMain = "6.Множина. \n Слова виключення";
                this.mColorMain = color;
                break;
            }
        }
    }
}
