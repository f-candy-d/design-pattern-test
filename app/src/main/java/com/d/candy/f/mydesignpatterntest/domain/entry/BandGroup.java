package com.d.candy.f.mydesignpatterntest.domain.entry;

/**
 * Created by daichi on 8/13/17.
 */

public class BandGroup {

    private String mGroupName;
    private String mVocal;
    private String mGuitar;
    private String mBase;
    private String mDrums;
    private long mSince;

    public BandGroup() {
        mGroupName = null;
        mVocal = null;
        mGuitar = null;
        mBase = null;
        mDrums = null;
        mSince = 0;
    }

    public String getGroupName() {
        return mGroupName;
    }

    public void setGroupName(String groupName) {
        mGroupName = groupName;
    }

    public String getVocal() {
        return mVocal;
    }

    public void setVocal(String vocal) {
        mVocal = vocal;
    }

    public String getGuitar() {
        return mGuitar;
    }

    public void setGuitar(String guitar) {
        mGuitar = guitar;
    }

    public String getBase() {
        return mBase;
    }

    public void setBase(String base) {
        mBase = base;
    }

    public String getDrums() {
        return mDrums;
    }

    public void setDrums(String drums) {
        mDrums = drums;
    }

    public long getSince() {
        return mSince;
    }

    public void setSince(long since) {
        mSince = since;
    }
}
