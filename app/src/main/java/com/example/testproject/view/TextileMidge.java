package com.example.testproject.view;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;

import com.example.testproject.R;

public class TextileMidge extends androidx.appcompat.widget.AppCompatTextView {
    boolean flag = false;
    private String text = "你好世界";
    private Paint mTextViewPaint;

    public TextileMidge(Context context) {
        super(context);
    }

    public TextileMidge(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TextileMidge(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (flag) {
            //4.设置画笔属性
            mTextViewPaint = new Paint();
            mTextViewPaint.setColor(getResources().getColor(R.color.purple_200));//每次画的时候需要设置颜色
            //5.设置画布的宽高
            Rect mTextViewBoubd = new Rect();
            //getTextBounds 由调用者返回在边界(分配)的最小矩形包含所有的字符,以隐含原点(0,0)
            mTextViewPaint.getTextBounds(text, 0, text.length(), mTextViewBoubd);//String text, int start, int end, Rect bounds

            // 设置直线的颜色
            mTextViewPaint.setColor(getResources().getColor(R.color.purple_200));
            // 设置直线没有锯齿
            mTextViewPaint.setAntiAlias(true);
            // 设置线宽
            mTextViewPaint.setStrokeWidth((float) 2.0);
            mTextViewPaint.setTextSize(45.0f);
            int x = getPaddingLeft();
            //dy 代表的是：高度的一半到 baseLine的距离
            Paint.FontMetricsInt fontMetrics = mTextViewPaint.getFontMetricsInt();
            // top 是一个负值 bottom 是一个正值 top，bttom的值代表是 bottom是baseLine到文字底部的距离（正值）
            // 必须要清楚的，可以自己打印就好
            int dy = (fontMetrics.bottom - fontMetrics.top) / 2 - fontMetrics.bottom;
            int baseLine = getHeight() / 2 + dy;

            canvas.drawText(text, x, baseLine, mTextViewPaint);
            // 设置直线位置
            canvas.drawLine(0, this.getHeight() / 2, this.getWidth(),
                    this.getHeight() / 2, mTextViewPaint);

        }
    }

    /**
     * true显示删除线     false不显示删除线
     *
     * @param flag
     * @return flag
     */
    public boolean setTv(boolean flag, String data) {
        this.flag = flag;
        this.text = data;
        return flag;
    }
}
