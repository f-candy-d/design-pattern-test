package com.d.candy.f.mydesignpatterntest.presentation;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.util.TypedValue;

import com.d.candy.f.mydesignpatterntest.R;

/**
 * Created by daichi on 8/13/17.
 */

public class ColorPickerFragment extends DialogFragment {

    public interface EventListener {
        void onColorSelected(int color);
    }

    private EventListener mEventListener;
    private int mSelectedColorId;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final int[] colorList;
        TypedArray colors = getActivity().getResources().obtainTypedArray(R.array.selectable_color_ids);

        colorList = new int[colors.length()];
        for (int ii=0; ii<colors.length(); ii++) {
            TypedValue colorValue = new TypedValue();
            if (colors.getValue(ii, colorValue)){
                colorList[ii] = colorValue.resourceId;
            }
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Pick a BG. color!");

        if (colorList.length == 0) {
            builder.setMessage("No item.");
            builder.setPositiveButton("OK", null);
            return builder.create();
        }

        builder.setSingleChoiceItems(R.array.selectable_colors, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mSelectedColorId = colorList[which];
                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (mEventListener != null) {
                            mEventListener.onColorSelected(mSelectedColorId);
                        }
                    }
                });

        return builder.create();
    }

    public void setEventListener(EventListener eventListener) {
        mEventListener = eventListener;
    }
}
