package com.shashanth.retrofit.ui;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

/**
 * Created by shashanth
 */

/**
 * source : http://stackoverflow.com/documentation/android/169/recyclerview/3155/smoother-loading-of-items#t=201705211544039311111
 */

public class PreLoadingLinearLayoutManager extends LinearLayoutManager {

    private int mPages = 1;
    private OrientationHelper mOrientationHelper;

    public PreLoadingLinearLayoutManager(final Context context) {
        super(context);
    }

    public PreLoadingLinearLayoutManager(final Context context, final int pages) {
        super(context);
        this.mPages = pages;
    }

    public PreLoadingLinearLayoutManager(final Context context, final int orientation,
                                         final boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    @Override
    public void setOrientation(final int orientation) {
        super.setOrientation(orientation);
        mOrientationHelper = null;
    }

    /**
     * Set the number of pages of layout that will be pre-loaded off-screen,
     * a page being a pixel measure equivalent to the on-screen size of the
     * recycler view.
     *
     * @param pages the number of pages; can be {@code 0} to disable pre-loading
     */
    public void setPages(final int pages) {
        this.mPages = pages;
    }

    @Override
    protected int getExtraLayoutSpace(final RecyclerView.State state) {
        if (mOrientationHelper == null) {
            mOrientationHelper = OrientationHelper.createOrientationHelper(this, getOrientation());
        }
        return mOrientationHelper.getTotalSpace() * mPages;
    }
}
