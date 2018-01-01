package com.sl.mytitle;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MyTitle extends RelativeLayout {

    // 供布局文件中自定义属性使用
    private float titleHeight;
    private Drawable titleBackground;
    private String text;
    private float textSize;
    private int textColor;
    private int backIcon;

    // 布局控件
    private RelativeLayout lytTitle;
    private TextView tvText;
    private ImageView ivBackIcon;

    public MyTitle(Context context, AttributeSet attrs) {
        super(context);

        // 动态加载布局
        LayoutInflater.from(context).inflate(R.layout.activity_my_title, this);

        // 绑定页面控件
        lytTitle = findViewById(R.id.rlyt_title);
        tvText = findViewById(R.id.tv_text);
        ivBackIcon = findViewById(R.id.iv_backIcon);

        // 可以读取自定义属性值，并设置到控件的属性中
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.Title);
        titleHeight = ta.getDimension(R.styleable.Title_titleHeight, 50);
        titleBackground = ta.getDrawable(R.styleable.Title_titleBackground);

        text = ta.getString(R.styleable.Title_text);
        textSize = ta.getDimension(R.styleable.Title_textSize, 0);
        textColor = ta.getInt(R.styleable.Title_textColor, 0XFFFFFFFF);

        backIcon = ta.getInt(R.styleable.Title_backIcon, 0);

        // 设置自定义属性
        lytTitle.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, (int) titleHeight));
        lytTitle.setBackground(titleBackground != null ? titleBackground : getResources().getDrawable(R.color.colorPrimary));

        tvText.setText(text);
        tvText.setTextSize(textSize);
        tvText.setTextColor(textColor);

        ivBackIcon.setImageResource(backIcon != 0 ? backIcon : R.drawable.ic_back);
    }
}
