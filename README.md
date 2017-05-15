# PagePointView
A View to tell you which page you are now¡£

## ScreenShot
![image](https://github.com/Adamlovespring/PagePointView/blob/master/screenshot/GIF.gif)

## Usage
```xml
    //in xml
    <com.adam.library.ui.PagePointView
        android:id="@+id/pagePointView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>
```
```java
        //of course you can create it in java code
        PagePointView view  = new PagePointView(context);
        
        //if you use ViewPager,just add this code in onPageSelected.
        @Override
        public void onPageSelected(int position) {
            mPagePointView.setItemSelect(position);
        }
```
        
## Properties
```xml
adam:pointColor="#ffffff" // point color
adam:pointSpace="5dp" //Spacing between two points
adam:pointRadius="3dp" //Size of point
```

## Option
```java
//This method is used to change the size of the unselected point,
//if you want the same size point,just add this code.but this will
//lose animation ,looks not very cool
mPagePointView.setUnSelectPointSize(1f);
```

