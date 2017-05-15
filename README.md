# PagePointView
A View to tell you which page you are now°£

## ScreenShot
![’‚¿Ô–¥Õº∆¨√Ë ˆ](http://img.blog.csdn.net/20170515181225337?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvdTAxMzU3ODQxMw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

## Usage
    //in xml
    <com.adam.library.ui.PagePointView
        android:id="@+id/pagePointView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>
        
        //of course you can create it in java code
        PagePointView view  = new PagePointView(context);
        
        //if you use ViewPager,just add this code in onPageSelected.
        @Override
        public void onPageSelected(int position) {
            mPagePointView.setItemSelect(position);
        }
        
## Properties
```
adam:pointColor="#ffffff" // point color
adam:pointSpace="5dp" //Spacing between two points
adam:pointRadius="3dp" //Size of point
```

## Option
```
//This method is used to change the size of the unselected point,
//if you want the same size point,just add this code.but this will
//lose animation ,looks not very cool
mPagePointView.setUnSelectPointSize(1f);
```

