package com.brandonang.view2024;

import android.app.Activity;
import android.content.Context;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.AndroidViewComponent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.Button;
import android.widget.TextView;
import android.graphics.Color;

public class View2024 extends AndroidNonvisibleComponent {
    private Activity activity;
    private Context context;
    private int score = 0;
    private int defaultColor;
    private int defaultColor2;
    private boolean addNewYear = false;

    public View2024(ComponentContainer container) {
        super(container.$form());
        this.activity = container.$context();
        this.context = container.$context();
    }

    @SimpleFunction
    public void SetupButton1(AndroidViewComponent layout) {
        View view = layout.getView();
        FrameLayout frameLayout = (FrameLayout) view;

        Button button1 = new Button(this.context);
        button1.setBackgroundColor(defaultColor);
        button1.setTextColor(Color.WHITE);
        frameLayout.addView(button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setText("2");
                score = score + 1;
                HasWon(score);
            }
        });
    }

    @SimpleFunction
    public void SetupButton2(AndroidViewComponent layout) {
        View view = layout.getView();
        FrameLayout frameLayout = (FrameLayout) view;

        Button button2 = new Button(this.context);
        button2.setBackgroundColor(defaultColor2);
        button2.setTextColor(Color.BLACK);

        frameLayout.addView(button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button2.setText("0");
                score = score + 1;
                HasWon(score);
            }
        });
    }

    @SimpleFunction
    public void SetupButton3(AndroidViewComponent layout) {
        View view = layout.getView();
        FrameLayout frameLayout = (FrameLayout) view;

        Button button3 = new Button(this.context);
        button3.setBackgroundColor(defaultColor);
        button3.setTextColor(Color.WHITE);

        frameLayout.addView(button3);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button3.setText("2");
                score = score + 1;
                HasWon(score);
            }
        });
    }

    @SimpleFunction
    public void SetupButton4(AndroidViewComponent layout) {
        View view = layout.getView();
        FrameLayout frameLayout = (FrameLayout) view;

        Button button4 = new Button(this.context);
        button4.setBackgroundColor(defaultColor2);
        button4.setTextColor(Color.BLACK);

        frameLayout.addView(button4);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button4.setText("4");
                score = score + 1;
                HasWon(score);
                Complete();
            }
        });
    }
    
    @DesignerProperty(defaultValue = DEFAULT_VALUE_COLOR_RED, editorType = PropertyTypeConstants.PROPERTY_TYPE_COLOR)
    @SimpleProperty
    public void CustomButtonColor(int color){
       defaultColor = color;
    }

    @DesignerProperty(defaultValue = DEFAULT_VALUE_COLOR_GREEN, editorType = PropertyTypeConstants.PROPERTY_TYPE_COLOR)
    @SimpleProperty
    public void CustomButtonColor2(int color){
       defaultColor2 = color;
    }

    @DesignerProperty(defaultValue = "False", editorType = PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN)
    @SimpleProperty
    public void AddNewYear(boolean isAddChecked){
       addNewYear = isAddChecked;
    }

    @SimpleFunction
    public void SetupGameTitle(AndroidViewComponent layout){
        if (addNewYear = false){
        View view = layout.getView();
        FrameLayout frameLayout = (FrameLayout) view;
        TextView textView = new TextView(this.context);
        textView.setText("2024 Game");
        frameLayout.addView(textView);
    } 
       else {
        View view = layout.getView();
        FrameLayout frameLayout = (FrameLayout) view;
        TextView textView = new TextView(this.context);
        textView.setText("2024 Game: New Year");
        frameLayout.addView(textView);
       }
    }

    @SimpleEvent
    public void CheckedNewYearColor(){
        EventDispatcher.dispatchEvent(this, "CheckedNewYearColor");
    }

    @SimpleEvent
    public void Complete(){
        EventDispatcher.dispatchEvent(this, "Complete");
    }

    @SimpleEvent
    public void HasWon(int score){
        EventDispatcher.dispatchEvent(this, "HasWon", score);
    }
}