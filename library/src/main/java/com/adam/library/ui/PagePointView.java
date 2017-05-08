package com.adam.library.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.adam.library.util.DimenUtil;

/**
 * Created by Adam on 2017/5/8.
 */

public class PagePointView extends LinearLayout{

    private static final int DEFAULT_POINT_COUNT = 2;
    private static final int DEFAULT_POINT_SIZE = 6;
    private static final int DEFAULT_POINT_SPACE = 5;
    private static final int DEFAULT_INDEX = 0;
    private static final float SELECTED_ALPHA = 1f;
    private static final float UNSELECTED_ALPHA = 0.3f;

    private int mLastIndex = DEFAULT_INDEX;

    public PagePointView(Context context) {
        super(context);
        init(context);
    }

    public PagePointView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public PagePointView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){
        setProperty();
        initView();
    }

    private void setProperty(){
        setOrientation(HORIZONTAL);
    }

    private void initView(){
        LinearLayout.LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        for (int i = 0; i < DEFAULT_POINT_COUNT; i++) {
            if(i != 0){
                params.leftMargin = DimenUtil.dp2px(getContext(),DEFAULT_POINT_SPACE);
            }
            PointView imageView = new PointView(getContext());
            if(i != DEFAULT_INDEX){
                imageView.setAlpha(UNSELECTED_ALPHA);
            }
            addView(imageView,params);
        }
    }

    public void setItemSelect(int index){
        if(!(getChildAt(index) instanceof PointView || getChildAt(mLastIndex) instanceof PointView)){
            return;
        }
        PointView currentView = (PointView)getChildAt(index) ;
        currentView.setAlpha(UNSELECTED_ALPHA);
        PointView lastView = (PointView)getChildAt(mLastIndex) ;
        lastView.setAlpha(SELECTED_ALPHA);
        mLastIndex = index;
    }
}
