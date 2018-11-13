package com.example.linst.spantest;

import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.view.View;

public abstract class MyClickableSpan extends ClickableSpan {


	@Override
	public void updateDrawState(@NonNull TextPaint ds) {
	}
}
