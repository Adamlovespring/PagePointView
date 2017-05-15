package com.adam.library.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.adam.library.R;

/**
 * Created by Adam on 2017/5/8.
 */

public class PagePointView extends LinearLayout {

    private static final int DEFAULT_POINT_COUNT = 3;
    private static final int DEFAULT_POINT_SPACE = 10;
    private static final int DEFAULT_INDEX = 0;
    private static final float SELECTED_ALPHA = 1f;
    private static final float UNSELECTED_ALPHA = 0.3f;
    private static final int DEFAULT_POINT_RADIUS = 12;
    private static final int DEFAULT_POINT_COLOR = 0xff000000;

    private int mLastIndex = DEFAULT_INDEX;
    private int mPointRadius = DEFAULT_POINT_RADIUS;
    private int mPointSpace = DEFAULT_POINT_SPACE;
    private int mPointColor = DEFAULT_POINT_COLOR;

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
        mPointSpace =  typedArray.getDimensionPixelOffset(R.styleable.PagePointView_pointSpace,DEFAULT_POINT_SPACE);
        mPointColor = typedArray.getColor(R.styleable.PagePointView_pointColor,DEFAULT_POINT_COLOR);
    }

    private void setLayoutProperty() {
        setOrientation(HORIZONTAL);
    }

    private void initView() {
        for (int i = 0; i < DEFAULT_POINT_COUNT; i++) {
            LinearLayout.LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            if (i != 0) {
                params.leftMargin = mPointSpace;
            }
            PointView pointView = new PointView(getContext());
            if (i != DEFAULT_INDEX) {
                pointView.setAlpha(UNSELECTED_ALPHA);
            }
            pointView.setPointColor(mPointColor);
            pointView.setPointRadius(mPointRadius);
            addView(pointView, params);
        }
    }

    public void setItemSelect(int index) {
        if (!(getChildAt(index) instanceof PointView || getChildAt(mLastIndex) instanceof PointView)) {
            return;
        }
        PointView currentView = (PointView) getChildAt(index);
        currentView.setAlpha(SELECTED_ALPHA);
        PointView lastView = (PointView) getChildAt(mLastIndex);
        lastView.setAlpha(UNSELECTED_ALPHA);
        mLastIndex = index;
    }

    public void setPointRadius(int radius) {
        mPointRadius = radius;
        for(int i = 0; i < DEFAULT_POINT_COUNT; i++){
            PointView currentView = (PointView) getChildAt(i);
            currentView.setPointRadius(mPointRadius);
        }
    }

    public void setPointSpace(int pointSpace){
        mPointSpace = pointSpace;
        for (int i = 0; i < DEFAULT_POINT_COUNT; i++){
            PointView currentView = (PointView) getChildAt(i);
            LinearLayout.LayoutParams params = (LayoutParams) currentView.getLayoutParams();
            if (i != 0) {
                params.leftMargin = mPointSpace;
            }
        }
    }

    public void setPointColor(int pointColor){
        mPointColor = pointColor;
        for(int i = 0; i < DEFAULT_POINT_COUNT; i++){
            PointView currentView = (PointView) getChildAt(i);
            currentView.setPointColor(mPointColor);
        }
    }
}
