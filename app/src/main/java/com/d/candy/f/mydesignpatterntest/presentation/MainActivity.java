package com.d.candy.f.mydesignpatterntest.presentation;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.d.candy.f.mydesignpatterntest.R;
import com.d.candy.f.mydesignpatterntest.domain.DomainDirector;
import com.d.candy.f.mydesignpatterntest.domain.service.ViewStylesService;

public class MainActivity extends AppCompatActivity  {

    private enum RequiredService {
        GET_VIEW_STYLE
    }

    private DomainDirector<RequiredService> mDomainDirector;
    private View mBgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initUI();
    }

    private void init() {
        mDomainDirector = new DomainDirector<>(this);
        mDomainDirector.addService(RequiredService.GET_VIEW_STYLE, new ViewStylesService());
    }

    private void initUI() {
        final Button selectBgButton = (Button) findViewById(R.id.select_bg_color_button);
        selectBgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorPickerFragment pickerFragment =
                        new ColorPickerFragment();
                pickerFragment.setEventListener(new ColorPickerFragment.EventListener() {
                    @Override
                    public void onColorSelected(int color) {
                        updateGbColor(color);
                    }
                });
                pickerFragment.show(getSupportFragmentManager(), null);
            }
        });

        mBgView = findViewById(R.id.background_view);
        mBgView.setBackgroundColor(ContextCompat.getColor(this, getViewStylesService().getViewStylesBgColor()));
    }

    private void updateGbColor(int color) {
        mBgView.setBackgroundColor(ContextCompat.getColor(this, color));
        getViewStylesService().updateViewStylesBgColor(color, true);
    }

    // Helper method
    private ViewStylesService getViewStylesService() {
        return mDomainDirector.getAndCastService(RequiredService.GET_VIEW_STYLE, ViewStylesService.class);
    }
}
