package com.shashanth.retrofit;

import android.os.Bundle;
import android.widget.TextView;

import com.shashanth.retrofit.genre.Genre;
import com.shashanth.retrofit.genre.GenreResponse;
import com.shashanth.retrofit.service.APICall;
import com.shashanth.retrofit.service.Constants;
import com.shashanth.retrofit.service.HttpResponseListener;

import java.util.List;

import retrofit2.Response;

public class MainActivity extends AppBaseActivity {

    private static final String TAG = "MainActivity";
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (TextView) findViewById(R.id.simple_txt);

        if (Constants.API_KEY.isEmpty()) {
            showShortToast(MainActivity.this, "Please obtain API Key");
            return;
        }

       /* Call<GenreResponse> call = APIService.getGenreLists("movie", Constants.API_KEY);
        call.enqueue(new Callback<GenreResponse>() {
            @Override
            public void onResponse(Call<GenreResponse> call, Response<GenreResponse> response) {
                List<Genre> responseList = response.body().getGenreList();
                showLongToast(MainActivity.this, "List size is " + responseList.size());

                String s = "";
                for (int i = 0; i < responseList.size(); i++) {
                    s += responseList.get(i).getGenreName() + "\n";
                }

                txt.setText(s);

            }

            @Override
            public void onFailure(Call<GenreResponse> call, Throwable t) {
                loge(TAG, t);
            }
        }); */

        APICall.getGenreList("", new HttpResponseListener<GenreResponse>() {
            @Override
            public void onResponse(Response<GenreResponse> response) {
                if (response.isSuccessful()) {
                    List<Genre> genreList = response.body().getGenreList();

                }
            }

            @Override
            public void onFailure(Throwable t) {
                loge(TAG, t);
            }
        });

    }
}
