package com.adam.library.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.adam.library.R;
import com.adam.library.util.DimenUtil;

/**
 * Created by Adam on 2017/5/8.
 */

public class PagePointView extends LinearLayout {

    private static final int DEFAULT_POINT_COUNT = 2;
    private static final int DEFAULT_POINT_SPACE = 5;
    private static final int DEFAULT_INDEX = 0;
    private static final float SELECTED_ALPHA = 1f;
    private static final float UNSELECTED_ALPHA = 0.3f;
    private static final int DEFAULT_POINT_RADIUS = 5;


    private int mLastIndex = DEFAULT_INDEX;
    private int mPointRadius = DEFAULT_POINT_RADIUS;

    public PagePointView(Context context) {
        super(context);
        init();
    }

    public PagePointView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public PagePointView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init() {
        setLayoutProperty();
        initView();
    }

    private void init(AttributeSet attrs) {
        setLayoutProperty();
        initProperty(attrs);
        initView();
    }

    private void initProperty(AttributeSet attrs) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.PagePointView);
        mPointRadius = typedArray.getDimensionPixelOffset(R.styleable.PagePointView_pointRadius,DEFAULT_POINT_RADIUS);
    }

    private void setLayoutProperty() {
        setOrientation(HORIZONTAL);
    }

    private void initView() {
        LinearLayout.LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        for (int i = 0; i < DEFAULT_POINT_COUNT; i++) {
            if (i != 0) {
                params.leftMargin = DEFAULT_POINT_SPACE;
            }
            PointView pointView = new PointView(getContext());
            if (i != DEFAULT_INDEX) {
                pointView.setAlpha(UNSELECTED_ALPHA);
            }
            pointView.setPointRadius(mPointRadius);
            addView(pointView, params);
        }
    }

    public void setItemSelect(int index) {
        if (!(getChildAt(index) instanceof PointView || getChildAt(mLastIndex) instanceof PointView)) {
            return;
        }
        PointView currentView = (PointView) getChildAt(index);
        currentView.setAlpha(UNSELECTED_ALPHA);
        PointView lastView = (PointView) getChildAt(mLastIndex);
        lastView.setAlpha(SELECTED_ALPHA);
        mLastIndex = index;
    }

    public void setPointRadius(int radius) {
        mPointRadius = radius;
        removeAllViews();
        initView();
    }
}
