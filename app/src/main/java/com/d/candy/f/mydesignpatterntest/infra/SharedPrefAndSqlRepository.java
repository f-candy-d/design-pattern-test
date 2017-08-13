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

    public SharedPrefAndSqlRepository(@NonNull Context context) {
        mContext = context;
    }

    private SharedPreferences getPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(mContext.getApplicationContext());
    }

    /**
     * Save to SharedPreferences
     */
    @Override
    public void saveLightValueWithKey(@NonNull String key, int value) {
        SharedPreferences preferences = getPreferences();
        final SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    @Override
    public void saveLightValueWithKey(@NonNull String key, long value) {
        SharedPreferences preferences = getPreferences();
        final SharedPreferences.Editor editor = preferences.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    @Override
    public void saveLightValueWithKey(@NonNull String key, float value) {
        SharedPreferences preferences = getPreferences();
        final SharedPreferences.Editor editor = preferences.edit();
        editor.putFloat(key, value);
        editor.apply();
    }

    @Override
    public void saveLightValueWithKey(@NonNull String key, String value) {
        SharedPreferences preferences = getPreferences();
        final SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    @Override
    public void saveLightValueWithKey(@NonNull String key, boolean value) {
        SharedPreferences preferences = getPreferences();
        final SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    @Override
    public void saveLightValuesWithKeys(@NonNull LightEntryPackage entryPackage) {
        SharedPreferences preferences = getPreferences();
        final SharedPreferences.Editor editor = preferences.edit();

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
        SharedPreferences preferences = getPreferences();
        return preferences.getInt(key, def);
    }

    @Override
    public long loadLongValueWithKey(@NonNull String key, long def) {
        SharedPreferences preferences = getPreferences();
        return preferences.getLong(key, def);
    }

    @Override
    public float loadFloatValueWithKey(@NonNull String key, float def) {
        SharedPreferences preferences = getPreferences();
        return preferences.getFloat(key, def);
    }

    @Override
    public String loadStringValueWithKey(@NonNull String key, String def) {
        SharedPreferences preferences = getPreferences();
        return preferences.getString(key, def);
    }

    @Override
    public boolean loadBooleanValueWithKey(@NonNull String key, boolean def) {
        SharedPreferences preferences = getPreferences();
        return preferences.getBoolean(key, def);
    }

    @Override
    public LightEntryPackage loadIntValuesWithKeys(@NonNull Collection<String> keys) {
        SharedPreferences preferences = getPreferences();
        final LightEntryPackage entryPackage = new LightEntryPackage();
        for (String key : keys) {
            entryPackage.put(key, preferences.getLong(key, entryPackage.getDefaultLong()));
        }

        return entryPackage;
    }

    @Override
    public LightEntryPackage loadLongValueWithKeys(@NonNull Collection<String> keys) {
        SharedPreferences preferences = getPreferences();
        final LightEntryPackage entryPackage = new LightEntryPackage();
        for (String key : keys) {
            entryPackage.put(key, preferences.getInt(key, entryPackage.getDefaultInt()));
        }

        return entryPackage;
    }

    @Override
    public LightEntryPackage loadFloatValuesWithKeys(@NonNull Collection<String> keys) {
        SharedPreferences preferences = getPreferences();
        final LightEntryPackage entryPackage = new LightEntryPackage();
        for (String key : keys) {
            entryPackage.put(key, preferences.getFloat(key, entryPackage.getDefaultFloat()));
        }

        return entryPackage;
    }

    @Override
    public LightEntryPackage loadStringValuesWithKeys(@NonNull Collection<String> keys) {
        SharedPreferences preferences = getPreferences();
        final LightEntryPackage entryPackage = new LightEntryPackage();
        for (String key : keys) {
            entryPackage.put(key, preferences.getBoolean(key, entryPackage.getDefaultBoolean()));
        }

        return entryPackage;
    }

    @Override
    public LightEntryPackage loadBooleanValuesWithKeys(@NonNull Collection<String> keys) {
        SharedPreferences preferences = getPreferences();
        final LightEntryPackage entryPackage = new LightEntryPackage();
        for (String key : keys) {
            entryPackage.put(key, preferences.getString(key, entryPackage.getDefaultString()));
        }

        return entryPackage;
    }

    @Override
    public LightEntryPackage loadValuesForExistKeys(@NonNull LightEntryPackage entryPackage) {
        SharedPreferences preferences = getPreferences();
        // boolean
        Set<String> keySet = entryPackage.keySetForBooleanValues();
        if (keySet != null) {
            for (String key : keySet) {
                entryPackage.put(key, preferences.getBoolean(key, entryPackage.getDefaultBoolean()));
            }
        }

        // long
        // boolean
        keySet = entryPackage.keySetForLongValues();
        if (keySet != null) {
            for (String key : keySet) {
                entryPackage.put(key, preferences.getLong(key, entryPackage.getDefaultLong()));
            }
        }

        // int
        keySet = entryPackage.keySetForIntValues();
        if (keySet != null) {
            for (String key : keySet) {
                entryPackage.put(key, preferences.getInt(key, entryPackage.getDefaultInt()));
            }
        }

        // float
        keySet = entryPackage.keySetForFloatValues();
        if (keySet != null) {
            for (String key : keySet) {
                entryPackage.put(key, preferences.getFloat(key, entryPackage.getDefaultFloat()));
            }
        }

        // String
        keySet = entryPackage.keySetForStringValues();
        if (keySet != null) {
            for (String key : keySet) {
                entryPackage.put(key, preferences.getString(key, entryPackage.getDefaultString()));
            }
        }

        return entryPackage;
    }
}
