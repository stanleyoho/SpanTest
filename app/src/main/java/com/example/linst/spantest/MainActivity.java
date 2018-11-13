package com.example.linst.spantest;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.apmem.tools.layouts.FlowLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

	int count = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		WordWrapView linearLayout = findViewById(R.id.layout);
//		final TextView textView = findViewById(R.id.text);
//		Button button = findViewById(R.id.btn);

		String context = "我国南部一些岛屿，<_>大自然的勃勃生机，还有美丽的海景与宁静的<_>。/n 政府准许发展商在岛上建造度假胜地或住宅，但<_>不可建造太高的建筑物，建筑物的数目也有限制，以避免<_>到岛上的树木与自然生态。/n 政府也将要求发展商在建造的时候，应该在水里加上过滤网，减少对邻近海域的<_>。\n据了解，发展项目建成后，岛上也不<_>开车。为减少空气和噪音污染，岛上只能骑脚踏车和开高尔夫球车。\n";
		context.replace("\\n","");
		context.replace("/n","");
		final String[] contents = context.split("<_>");
		ArrayList<String> contentList = new ArrayList<>();
 		for(String ss : contents){
 			if(ss.length() > 5){
 				for(int i = 0 ; i <= ss.length()/5 ; i ++){
 					if( i != ss.length()/5){
 						contentList.add(ss.substring(i*5 , ((i+1)*5) -1));
				    }else {
					    contentList.add(ss.substring(i*5 , ss.length()-1));
				    }
			    }
		    }else {
 				contentList.add(ss);
		    }
	    }

		for(int i = 0 ; i < contents.length ; i++){

			//text words
			LinearLayout.LayoutParams wordParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
			TextView textViewWords = new TextView(this);
			textViewWords.setLayoutParams(wordParams);
			textViewWords.setText(contents[i]);
			textViewWords.setTextSize(16);
			textViewWords.setGravity(Gravity.CENTER_VERTICAL);

			linearLayout.addView(textViewWords);

			//badge
			BadgeView badgeView = new BadgeView(this);
			LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(50,50);
			layoutParams.setMarginStart(10);
			layoutParams.gravity = Gravity.CENTER_VERTICAL;
			badgeView.setLayoutParams(layoutParams);
			badgeView.setBadgeCount(i+1);
			linearLayout.addView(badgeView);

			//answer
			LinearLayout.LayoutParams answerParams = new LinearLayout.LayoutParams(150,50);
			TextView textViewAnswer = new TextView(this);
			answerParams.setMarginStart(10);
			textViewAnswer.setLayoutParams(answerParams);
			textViewAnswer.setTextSize(16);
			textViewAnswer.setGravity(Gravity.CENTER_VERTICAL);
			textViewAnswer.setBackground(ContextCompat.getDrawable(this,R.drawable.bg_text));
			linearLayout.addView(textViewAnswer);
		}
	}

	private void initTextView(TextView textView){
		avoidHintColor(textView);
		textView.setMovementMethod(LinkMovementMethod.getInstance());
	}

	private void avoidHintColor(View view){
		if(view instanceof TextView)
			((TextView)view).setHighlightColor(getResources().getColor(android.R.color.transparent));
	}

	private Spannable.Factory factory = new Spannable.Factory(){
		@Override
		public Spannable newSpannable(CharSequence source) {
			return (Spannable)source;
		}
	} ;

}
