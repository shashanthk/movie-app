package com.shashanth.retrofit;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.shashanth.retrofit.movie.Movie;
import com.shashanth.retrofit.movie.MovieAdapter;
import com.shashanth.retrofit.movie.MovieResponse;
import com.shashanth.retrofit.network.APICall;
import com.shashanth.retrofit.network.Constants;
import com.shashanth.retrofit.network.HttpResponseListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Response;

public class MainActivity extends AppBaseActivity {

    private static final String TAG = "MainActivity";

    @BindView(R.id.recycler_view)
    RecyclerView rvMovies;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    private Activity getActivity() {
        return MainActivity.this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(getActivity());

        if (Constants.API_KEY.isEmpty()) {
            showShortToast(MainActivity.this, "Please obtain API Key");
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        APICall.getMovieList(
                new HttpResponseListener<MovieResponse>() {
                    @Override
                    public void onResponse(Response<MovieResponse> response) {

                        progressBar.setVisibility(View.GONE);

                        List<Movie> movieList = response.body().getMovieList();

                        MovieAdapter adapter = new MovieAdapter(
                                getBaseContext(),
                                movieList,
                                null
                        );

                        rvMovies.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Throwable t) {

                        progressBar.setVisibility(View.GONE);

                        loge(TAG, t);
                    }
                });
    }
}
