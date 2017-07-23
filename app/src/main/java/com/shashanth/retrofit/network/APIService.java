package com.shashanth.retrofit.network;

import com.shashanth.retrofit.genre.GenreResponse;
import com.shashanth.retrofit.movie.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by shashanth
 */

public interface APIService {
    /**
     * @param type   = movie or tv
     * @param apiKey = imdb api key
     * @return = list of genre obtained from api
     */
    @GET("genre/{type}/list")
    Call<GenreResponse> getGenreLists(@Path("type") String type, @Query("api_key") String apiKey);

    /**
     * @param apiKey = imdb api key
     * @return = list of movie list obtained from api
     */
    @GET("movie/top_rated")
    Call<MovieResponse> getMovieList(@Query("api_key") String apiKey);
}
