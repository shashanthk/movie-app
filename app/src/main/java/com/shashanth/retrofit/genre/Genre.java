package com.shashanth.retrofit.genre;

import com.google.gson.annotations.SerializedName;

/**
 * Created by shashanth
 */

public class Genre {

    @SerializedName("id")
    private int genreId;
    @SerializedName("name")
    private String genreName;

    public int getGenreId() {
        return genreId;
    }

    public String getGenreName() {
        return genreName;
    }
}
