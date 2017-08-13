package com.d.candy.f.mydesignpatterntest.domain.service;

/**
 * Created by daichi on 8/13/17.
 */

abstract public class Service {

    public Service() {}

    abstract protected boolean isReady();

    /**
     * TODO; Call this method before any service start
     */
    protected void onServiceStart() {
        if (!isReady()) {
            throw new IllegalStateException("This service is not ready");
        }
    }
}
