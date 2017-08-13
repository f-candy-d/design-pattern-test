package com.d.candy.f.mydesignpatterntest.domain.service;

import android.support.annotation.NonNull;

import com.d.candy.f.mydesignpatterntest.R;
import com.d.candy.f.mydesignpatterntest.domain.RepositoryUser;
import com.d.candy.f.mydesignpatterntest.domain.entry.ViewStyles;
import com.d.candy.f.mydesignpatterntest.infra.Repository;

/**
 * Created by daichi on 8/13/17.
 */

public class ViewStylesService extends Service implements RepositoryUser {

    private Repository mRepository = null;
    private ViewStyles mViewStyles = null;

    @Override
    protected boolean isReady() {
        return (mRepository != null && mViewStyles != null);
    }

    @Override
    public void setRepository(@NonNull Repository repository) {
        mRepository = repository;
        mViewStyles = loadViewStylesFromRepository();
    }

    public int getViewStylesBgColor() {
        super.onServiceStart();
        return mViewStyles.getBackgroundColor();
    }

    private ViewStyles loadViewStylesFromRepository() {
        mViewStyles = new ViewStyles();
        final int bgColor = mRepository.loadIntValueWithKey(
                ViewStyles.ATTRIBUTE_KEY_BG_COLOR, R.color.colorAccent);
        mViewStyles.setBackgroundColor(bgColor);
        return mViewStyles;
    }

    public void updateViewStylesBgColor(int color, boolean updateRepository) {
        super.onServiceStart();
        mViewStyles.setBackgroundColor(color);
        if (updateRepository) {
            updateViewStylesOnRepository(mViewStyles);
        }
    }

    private void updateViewStylesOnRepository(@NonNull ViewStyles viewStyles) {
        mRepository.saveLightValueWithKey(
                ViewStyles.ATTRIBUTE_KEY_BG_COLOR, viewStyles.getBackgroundColor());
    }
}
