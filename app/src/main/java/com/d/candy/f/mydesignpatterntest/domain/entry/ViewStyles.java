package com.d.candy.f.mydesignpatterntest.domain.entry;

/**
 * Created by daichi on 8/13/17.
 */

public class ViewStyles {

    public static final String ATTRIBUTE_KEY_BG_COLOR = "attr_key_bg_color";

    private int mBackgroundColor;

    public ViewStyles() {}

    public int getBackgroundColor() {
        return mBackgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        mBackgroundColor = backgroundColor;
    }
}
