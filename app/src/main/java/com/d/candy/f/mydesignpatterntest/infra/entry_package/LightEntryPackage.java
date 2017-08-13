package com.d.candy.f.mydesignpatterntest.infra.entry_package;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by daichi on 8/13/17.
 */

public class LightEntryPackage {

    @Nullable private Map<String, Boolean> mBooleanMap = null;
    @Nullable private Map<String, Float> mFloatMap = null;
    @Nullable private Map<String, Long> mLongMap = null;
    @Nullable private Map<String, Integer> mIntMap = null;
    @Nullable private Map<String, String> mStringMap = null;
    private boolean mDefaultBoolean = false;
    private float mDefaultFloat = 0F;
    private long mDefaultLong = 0L;
    private int mDefaultInt = 0;
    private String mDefaultString = null;

    public LightEntryPackage() {}

    public void put(@NonNull String key, boolean value) {
        if (mBooleanMap == null) {
            mBooleanMap = new HashMap<>();
        }
        mBooleanMap.put(key, value);
    }

    public void put(@NonNull String key, float value) {
        if (mFloatMap == null) {
            mFloatMap = new HashMap<>();
        }
        mFloatMap.put(key, value);
    }

    public void put(@NonNull String key, long value) {
        if (mLongMap == null) {
            mLongMap = new HashMap<>();
        }
        mLongMap.put(key, value);
    }

    public void put(@NonNull String key, int value) {
        if (mIntMap == null) {
            mIntMap = new HashMap<>();
        }
        mIntMap.put(key, value);
    }

    public void put(@NonNull String key, String value) {
        if (mStringMap == null) {
            mStringMap = new HashMap<>();
        }
        mStringMap.put(key, value);
    }

    public boolean getBoolean(@NonNull String key, boolean def) {
        if (mBooleanMap != null && mBooleanMap.containsKey(key)) {
            return mBooleanMap.get(key);
        }
        return def;
    }

    public float getFloat(@NonNull String key, Float def) {
        if (mFloatMap != null && mFloatMap.containsKey(key)) {
            return mFloatMap.get(key);
        }
        return def;
    }

    public long getLong(@NonNull String key, long def) {
        if (mLongMap != null && mLongMap.containsKey(key)) {
            return mLongMap.get(key);
        }
        return def;
    }

    public int getInt(@NonNull String key, int def) {
        if (mIntMap != null && mIntMap.containsKey(key)) {
            return mIntMap.get(key);
        }
        return def;
    }

    public String getString(@NonNull String key, String def) {
        if (mStringMap != null && mStringMap.containsKey(key)) {
            return mStringMap.get(key);
        }
        return def;
    }

    public boolean getBoolean(@NonNull String key) {
        if (mBooleanMap != null) {
            return mBooleanMap.get(key);
        }
        return mDefaultBoolean;
    }

    public float getFloat(@NonNull String key) {
        if (mFloatMap != null) {
            return mFloatMap.get(key);
        }
        return mDefaultFloat;
    }

    public long getLong(@NonNull String key) {
        if (mLongMap != null) {
            return mLongMap.get(key);
        }
        return mDefaultLong;
    }

    public int getInt(@NonNull String key) {
        if (mIntMap != null) {
            return mIntMap.get(key);
        }
        return mDefaultInt;
    }

    public String getString(@NonNull String key) {
        if (mStringMap != null) {
            return mStringMap.get(key);
        }
        return mDefaultString;
    }

    public Set<String> keySetForBooleanValues() {
        if (mBooleanMap != null) {
            return mBooleanMap.keySet();
        }
        return null;
    }

    public Set<String> keySetForLongValues() {
        if (mLongMap != null) {
            return mLongMap.keySet();
        }
        return null;
    }

    public Set<String> keySetForFloatValues() {
        if (mFloatMap != null) {
            return mFloatMap.keySet();
        }
        return null;
    }

    public Set<String> keySetForIntValues() {
        if (mIntMap != null) {
            return mIntMap.keySet();
        }
        return null;
    }

    public Set<String> keySetForStringValues() {
        if (mStringMap != null) {
            return mStringMap.keySet();
        }
        return null;
    }

    public boolean getDefaultBoolean() {
        return mDefaultBoolean;
    }

    public void setDefaultBoolean(boolean defaultBoolean) {
        mDefaultBoolean = defaultBoolean;
    }

    public float getDefaultFloat() {
        return mDefaultFloat;
    }

    public void setDefaultFloat(float defaultFloat) {
        mDefaultFloat = defaultFloat;
    }

    public long getDefaultLong() {
        return mDefaultLong;
    }

    public void setDefaultLong(long defaultLong) {
        mDefaultLong = defaultLong;
    }

    public int getDefaultInt() {
        return mDefaultInt;
    }

    public void setDefaultInt(int defaultInt) {
        mDefaultInt = defaultInt;
    }

    public String getDefaultString() {
        return mDefaultString;
    }

    public void setDefaultString(String defaultString) {
        mDefaultString = defaultString;
    }

    public void addKeyForLongValue(@NonNull String key) {
        if (mLongMap == null) {
            mLongMap = new HashMap<>();
        }
        mLongMap.put(key, mDefaultLong);
    }

    public void addKeyForIntValue(@NonNull String key) {
        if (mIntMap == null) {
            mIntMap = new HashMap<>();
        }
        mIntMap.put(key, mDefaultInt);
    }

    public void addKeyForFloatValue(@NonNull String key) {
        if (mFloatMap == null) {
            mFloatMap = new HashMap<>();
        }
        mFloatMap.put(key, mDefaultFloat);
    }

    public void addKeyForBooleanValue(@NonNull String key) {
        if (mBooleanMap == null) {
            mBooleanMap = new HashMap<>();
        }
        mBooleanMap.put(key, mDefaultBoolean);
    }

    public void addKeyForStringValue(@NonNull String key) {
        if (mStringMap == null) {
            mStringMap = new HashMap<>();
        }
        mStringMap.put(key, mDefaultString);
    }
}
