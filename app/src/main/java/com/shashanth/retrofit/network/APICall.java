package com.shashanth.retrofit.network;

import com.shashanth.retrofit.genre.GenreResponse;
import com.shashanth.retrofit.movie.MovieResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.shashanth.retrofit.network.Constants.API_KEY;

/**
 * Created by shashanth
 */

public final class APICall {

    /**
     * @param type     = movie or tv
     * @param listener = HTTP response callback listener
     */
    public static void getGenreList(String type, final HttpResponseListener<GenreResponse> listener) {
        Call<GenreResponse> call = ApiClient.getService().getGenreLists(type, API_KEY);
        call.enqueue(new Callback<GenreResponse>() {
            @Override
            public void onResponse(Call<GenreResponse> call, Response<GenreResponse> response) {
                listener.onResponse(response);
            }

            @Override
            public void onFailure(Call<GenreResponse> call, Throwable t) {
                listener.onFailure(t);
            }
        });
    }

    public static void getMovieList(final HttpResponseListener<MovieResponse> listener) {
        Call<MovieResponse> call = ApiClient.getService().getMovieList(API_KEY);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                listener.onResponse(response);
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                listener.onFailure(t);
            }
        });
    }
}
