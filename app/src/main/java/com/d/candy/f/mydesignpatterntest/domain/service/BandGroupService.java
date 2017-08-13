package com.d.candy.f.mydesignpatterntest.domain.service;

import android.support.annotation.NonNull;

import com.d.candy.f.mydesignpatterntest.domain.RepositoryUser;
import com.d.candy.f.mydesignpatterntest.infra.Repository;

/**
 * Created by daichi on 8/13/17.
 */

public class BandGroupService extends Service implements RepositoryUser {

    private Repository mRepository;

    public BandGroupService() {
        mRepository = null;
    }

    @Override
    protected boolean isReady() {
        return (mRepository != null);
    }

    /**
     * region; RepositoryUser implementation
     */
    @Override
    public void setRepository(@NonNull Repository repository) {
        mRepository = repository;
    }
}
