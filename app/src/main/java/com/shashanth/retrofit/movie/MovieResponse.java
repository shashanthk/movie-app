package com.shashanth.retrofit.movie;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by shashanth on 20/5/17.
 */

public class MovieResponse {

    @SerializedName("id")
    private int id;
    @SerializedName("page")
    private int page;
    @SerializedName("results")
    private List<Movie> movieList = null;
    @SerializedName("total_pages")
    private int totalPages;
    @SerializedName("total_results")
    private int totalResults;

    public int getId() {
        return id;
    }

    public int getPage() {
        return page;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getTotalResults() {
        return totalResults;
    }
}
