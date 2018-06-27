package com.example.orionstark.barberros.models;

import com.example.orionstark.barberros.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * Created by evan on 20/06/18.
 */

public class favorite {
    public String namaBarber;
    private int iconBarber;
    private int iconFav;
    public static ArrayList<favorite> fav = new ArrayList<favorite>(){{
        add(new favorite("Next Sparman 1", R.drawable.next_salon_logo));
        //add(new favorite("Cut Express", R.drawable.cut_express_logo));
    }};
    public favorite(String namaBarber, int imgID){
        this.iconFav = 0;
        this.namaBarber = namaBarber;
        this.iconBarber = imgID;
    }
    public int getImgID() {
        return this.iconBarber;
    }

    public int getLove() {
        return this.iconFav;
    }
}
