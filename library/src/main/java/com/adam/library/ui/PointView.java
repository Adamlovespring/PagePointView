package com.adam.library.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.adam.library.util.DimenUtil;

/**
 * Created by Adam on 2017/5/8.
 */

public class PointView extends View {

    private static final int DEFAULT_POINT_COLOR = 0xffffffff;
    private static final int DEFAULT_POINT_RADIUS = 5;

    private int mPointColor = DEFAULT_POINT_COLOR;
    private int mPointRadius = DEFAULT_POINT_RADIUS;

    public PointView(Context context) {
        super(context);
    }

    public PointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public PointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int width;
        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else {
            width = getPaddingLeft() + DimenUtil.dp2px(getContext(), mPointRadius * 2) + getPaddingRight();
        }
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int height;
        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            height = getPaddingTop() + DimenUtil.dp2px(getContext(), mPointRadius * 2) + getPaddingBottom();
        }
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(mPointColor);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        float radius = DimenUtil.dp2px(getContext(), mPointRadius);
        canvas.drawCircle(radius, radius, radius, paint);
    }

    public void setPointRadius(int radius) {
        mPointRadius = radius;
    }

    public void setPointColor(int color) {
        mPointColor = color;
    }
}
