package com.shashanth.retrofit.movie;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.shashanth.retrofit.R;
import com.shashanth.retrofit.network.NetworkUtil;
import com.shashanth.retrofit.ui.RVClickListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by shashanth on 9/7/17.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {

    private Context context;
    private List<Movie> movieList;
    private RVClickListener<Movie> listener;

    public MovieAdapter(Context context, List<Movie> movieList, @Nullable RVClickListener<Movie> listener) {
        this.context = context;
        this.movieList = movieList;
        this.listener = listener;
    }

    @Override
    public MovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_row, parent, false);
        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieHolder holder, int position) {
        bind(movieList.get(position), holder);
    }


    @Override
    public int getItemCount() {
        return movieList == null ? 0 : movieList.size();
    }

    static class MovieHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_movie)
        ImageView imgMovie;
        @BindView(R.id.lbl_movie_name)
        TextView lblMovieName;
        @BindView(R.id.lbl_year)
        TextView lblYear;
        @BindView(R.id.lbl_stars)
        TextView lblStars;
        @BindView(R.id.lbl_movie_description)
        TextView lblDesc;

        private MovieHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    private void bind(final Movie movie, final MovieHolder holder) {

        NetworkUtil.loadImage(context, movie.getPosterPath(), holder.imgMovie);
        holder.lblMovieName.setText(movie.getTitle());
        holder.lblYear.setText(movie.getReleaseDate());
        holder.lblStars.setText(movie.getAvgString());
        holder.lblDesc.setText(movie.getOverview());
        holder.itemView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (listener != null)
                            listener.onItemClick(movie, holder.getAdapterPosition());
                    }
                }
        );
    }
}
