package com.d.candy.f.mydesignpatterntest.infra;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;

import com.d.candy.f.mydesignpatterntest.infra.entry_package.TableEntryPackage;
import com.d.candy.f.mydesignpatterntest.infra.entry_package.LightEntryPackage;

import java.util.Collection;
import java.util.Set;

/**
 * Created by daichi on 8/13/17.
 */

public class SharedPrefAndSqlRepository implements Repository {

    @NonNull final private Context mContext;
    @NonNull final private SharedPreferences mPreferences;

    /**
     * Save to SharedPreferences
     */
    public SharedPrefAndSqlRepository(@NonNull Context context) {
        mContext = context;
        mPreferences = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
    }

    @Override
    public void saveLightValueWithKey(@NonNull String key, int value) {
        final SharedPreferences.Editor editor = mPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    @Override
    public void saveLightValueWithKey(@NonNull String key, long value) {
        final SharedPreferences.Editor editor = mPreferences.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    @Override
    public void saveLightValueWithKey(@NonNull String key, float value) {
        final SharedPreferences.Editor editor = mPreferences.edit();
        editor.putFloat(key, value);
        editor.apply();
    }

    @Override
    public void saveLightValueWithKey(@NonNull String key, String value) {
        final SharedPreferences.Editor editor = mPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    @Override
    public void saveLightValueWithKey(@NonNull String key, boolean value) {
        final SharedPreferences.Editor editor = mPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    @Override
    public void saveLightValuesWithKeys(@NonNull LightEntryPackage entryPackage) {
        final SharedPreferences.Editor editor = mPreferences.edit();

        // boolean
        Set<String> keySet = entryPackage.keySetForBooleanValues();
        if (keySet != null) {
            for (String key : keySet) {
                editor.putBoolean(key, entryPackage.getBoolean(key));
            }
        }

        // long
        // boolean
        keySet = entryPackage.keySetForLongValues();
        if (keySet != null) {
            for (String key : keySet) {
                editor.putLong(key, entryPackage.getLong(key));
            }
        }

        // int
        keySet = entryPackage.keySetForIntValues();
        if (keySet != null) {
            for (String key : keySet) {
                editor.putInt(key, entryPackage.getInt(key));
            }
        }

        // float
        keySet = entryPackage.keySetForFloatValues();
        if (keySet != null) {
            for (String key : keySet) {
                editor.putFloat(key, entryPackage.getFloat(key));
            }
        }

        // String
        keySet = entryPackage.keySetForStringValues();
        if (keySet != null) {
            for (String key : keySet) {
                editor.putString(key, entryPackage.getString(key));
            }
        }

        editor.apply();
    }

    /**
     * Save to SQLite DB
     */
    @Override
    public void saveTableEntry(@NonNull TableEntryPackage.TableEntry tableEntry) {

    }

    @Override
    public void saveTableEntries(@NonNull TableEntryPackage entryPackage) {

    }

    /**
     * Load from SharedPreferences
     */
    @Override
    public int loadIntValueWithKey(@NonNull String key, int def) {
        return mPreferences.getInt(key, def);
    }

    @Override
    public long loadLongValueWithKey(@NonNull String key, long def) {
        return mPreferences.getLong(key, def);
    }

    @Override
    public float loadFloatValueWithKey(@NonNull String key, float def) {
        return mPreferences.getFloat(key, def);
    }

    @Override
    public String loadStringValueWithKey(@NonNull String key, String def) {
        return mPreferences.getString(key, def);
    }

    @Override
    public boolean loadBooleanValueWithKey(@NonNull String key, boolean def) {
        return mPreferences.getBoolean(key, def);
    }

    @Override
    public LightEntryPackage loadIntValuesWithKeys(@NonNull Collection<String> keys) {
        final LightEntryPackage entryPackage = new LightEntryPackage();
        for (String key : keys) {
            entryPackage.put(key, mPreferences.getLong(key, entryPackage.getDefaultLong()));
        }

        return entryPackage;
    }

    @Override
    public LightEntryPackage loadLongValueWithKeys(@NonNull Collection<String> keys) {
        final LightEntryPackage entryPackage = new LightEntryPackage();
        for (String key : keys) {
            entryPackage.put(key, mPreferences.getInt(key, entryPackage.getDefaultInt()));
        }

        return entryPackage;
    }

    @Override
    public LightEntryPackage loadFloatValuesWithKeys(@NonNull Collection<String> keys) {
        final LightEntryPackage entryPackage = new LightEntryPackage();
        for (String key : keys) {
            entryPackage.put(key, mPreferences.getFloat(key, entryPackage.getDefaultFloat()));
        }

        return entryPackage;
    }

    @Override
    public LightEntryPackage loadStringValuesWithKeys(@NonNull Collection<String> keys) {
        final LightEntryPackage entryPackage = new LightEntryPackage();
        for (String key : keys) {
            entryPackage.put(key, mPreferences.getBoolean(key, entryPackage.getDefaultBoolean()));
        }

        return entryPackage;
    }

    @Override
    public LightEntryPackage loadBooleanValuesWithKeys(@NonNull Collection<String> keys) {
        final LightEntryPackage entryPackage = new LightEntryPackage();
        for (String key : keys) {
            entryPackage.put(key, mPreferences.getString(key, entryPackage.getDefaultString()));
        }

        return entryPackage;
    }

    @Override
    public LightEntryPackage loadValuesForExistKeys(@NonNull LightEntryPackage entryPackage) {
        // boolean
        Set<String> keySet = entryPackage.keySetForBooleanValues();
        if (keySet != null) {
            for (String key : keySet) {
                entryPackage.put(key, mPreferences.getBoolean(key, entryPackage.getDefaultBoolean()));
            }
        }

        // long
        // boolean
        keySet = entryPackage.keySetForLongValues();
        if (keySet != null) {
            for (String key : keySet) {
                entryPackage.put(key, mPreferences.getLong(key, entryPackage.getDefaultLong()));
            }
        }

        // int
        keySet = entryPackage.keySetForIntValues();
        if (keySet != null) {
            for (String key : keySet) {
                entryPackage.put(key, mPreferences.getInt(key, entryPackage.getDefaultInt()));
            }
        }

        // float
        keySet = entryPackage.keySetForFloatValues();
        if (keySet != null) {
            for (String key : keySet) {
                entryPackage.put(key, mPreferences.getFloat(key, entryPackage.getDefaultFloat()));
            }
        }

        // String
        keySet = entryPackage.keySetForStringValues();
        if (keySet != null) {
            for (String key : keySet) {
                entryPackage.put(key, mPreferences.getString(key, entryPackage.getDefaultString()));
            }
        }

        return entryPackage;
    }
}
