package com.example.linst.spantest;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.style.ImageSpan;

public class MyBackgroundSpan extends ImageSpan {

	public MyBackgroundSpan(@NonNull Drawable drawable) {
		super(drawable);
	}

	@Override
	public void draw(@NonNull Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, @NonNull Paint paint) {
		super.draw(canvas, text, start, end, x, top, y, bottom, paint);
	}
}
