package com.adam.pagepointview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

import com.adam.library.ui.PagePointView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private View view1, view2, view3;
    private ViewPager mViewPager;
    private PagePointView mPagePointView;

    private List<View> viewList;//view数组

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewPager();
        mPagePointView = (PagePointView) findViewById(R.id.pagePointView);
        mPagePointView.setUnSelectPointSize(0.5f);
    }

    private void initViewPager() {
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        LayoutInflater inflater = getLayoutInflater();
        view1 = inflater.inflate(R.layout.layout1, null);
        view2 = inflater.inflate(R.layout.layout2, null);
        view3 = inflater.inflate(R.layout.layout3, null);

        viewList = new ArrayList<View>();// 将要分页显示的View装入数组中
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        mViewPager.setAdapter(new MyPageAdapter());
        mViewPager.setOnPageChangeListener(onPageChangeListener);
    }

    class MyPageAdapter extends PagerAdapter {


        @Override
        public int getCount() {
            return viewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(viewList.get(position));
            return viewList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(viewList.get(position));
        }
    }

    private ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            mPagePointView.setItemSelect(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}
