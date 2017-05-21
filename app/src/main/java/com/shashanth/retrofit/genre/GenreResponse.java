package com.shashanth.retrofit.genre;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by shashanth
 */

public class GenreResponse {

    @SerializedName("status_message")
    private String statusMessage;
    @SerializedName("success")
    private boolean success;
    @SerializedName("status_code")
    private int statusCode;
    @SerializedName("genres")
    private List<Genre> genreList;

    public String getStatusMessage() {
        return statusMessage;
    }

    public boolean isSuccess() {
        return success;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public List<Genre> getGenreList() {
        return genreList;
    }
}
