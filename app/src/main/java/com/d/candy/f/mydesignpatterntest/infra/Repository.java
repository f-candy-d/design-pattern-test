package com.d.candy.f.mydesignpatterntest.infra;

import android.support.annotation.NonNull;

import com.d.candy.f.mydesignpatterntest.infra.entry_package.LightEntryPackage;
import com.d.candy.f.mydesignpatterntest.infra.entry_package.TableEntryPackage;

import java.util.Collection;

/**
 * Created by daichi on 8/13/17.
 */

public interface Repository {

    /**
     * Save
     */
    void saveLightValueWithKey(@NonNull String key, int value);
    void saveLightValueWithKey(@NonNull String key, long value);
    void saveLightValueWithKey(@NonNull String key, float value);
    void saveLightValueWithKey(@NonNull String key, String value);
    void saveLightValueWithKey(@NonNull String key, boolean value);
    void saveLightValuesWithKeys(@NonNull LightEntryPackage entryPackage);

    void saveTableEntry(@NonNull TableEntryPackage.TableEntry tableEntry);
    void saveTableEntries(@NonNull TableEntryPackage entryPackage);

    /**
     * Load
     */
    int loadIntValueWithKey(@NonNull String key, int def);
    long loadLongValueWithKey(@NonNull String key, long def);
    float loadFloatValueWithKey(@NonNull String key, float def);
    String loadStringValueWithKey(@NonNull String key, String def);
    boolean loadBooleanValueWithKey(@NonNull String key, boolean def);
    LightEntryPackage loadIntValuesWithKeys(@NonNull Collection<String> keys);
    LightEntryPackage loadLongValueWithKeys(@NonNull Collection<String> keys);
    LightEntryPackage loadFloatValuesWithKeys(@NonNull Collection<String> keys);
    LightEntryPackage loadStringValuesWithKeys(@NonNull Collection<String> keys);
    LightEntryPackage loadBooleanValuesWithKeys(@NonNull Collection<String> keys);
    LightEntryPackage loadValuesForExistKeys(@NonNull LightEntryPackage entryPackage);
}
