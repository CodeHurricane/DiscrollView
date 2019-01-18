package com.example.administrator.discrollview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class DiscrollViewContent extends LinearLayout {

	public DiscrollViewContent(Context context, AttributeSet attrs) {
		super(context, attrs);
		setOrientation(VERTICAL);
	}
	
	@Override
	public LayoutParams generateLayoutParams(AttributeSet attrs) {
		return new MyLayoutParams(getContext(),attrs);
	}
	
	@Override
	public void addView(View child, int index,
			android.view.ViewGroup.LayoutParams params) {
		MyLayoutParams p = (MyLayoutParams) params;
		if(!isDiscrollvable(p)){
			super.addView(child, index, params);
		}else{
			DiscrollvableView discrollvableView = new DiscrollvableView(getContext());
			discrollvableView.setmDiscrollveAlpha(p.mDiscrollveAlpha);
			discrollvableView.setmDisCrollveTranslation(p.mDisCrollveTranslation);
			discrollvableView.setmDiscrollveScaleX(p.mDiscrollveScaleX);
			discrollvableView.setmDiscrollveScaleY(p.mDiscrollveScaleY);
			discrollvableView.setmDiscrollveFromBgColor(p.mDiscrollveFromBgColor);
			discrollvableView.setmDiscrollveToBgColor(p.mDiscrollveToBgColor);
			
			discrollvableView.addView(child);
			super.addView(discrollvableView, index, params);
		}
	}

	private boolean isDiscrollvable(MyLayoutParams p) {
		// TODO Auto-generated method stub
		return p.mDiscrollveAlpha||
				p.mDiscrollveScaleX||
				p.mDiscrollveScaleY||
				p.mDisCrollveTranslation!=-1||
				(p.mDiscrollveFromBgColor!=-1&&
				p.mDiscrollveToBgColor!=-1);
	}

	public static class MyLayoutParams extends LayoutParams{
		public int mDiscrollveFromBgColor;
		public int mDiscrollveToBgColor;
		public boolean mDiscrollveAlpha;
		public int mDisCrollveTranslation;
		public boolean mDiscrollveScaleX;
		public boolean mDiscrollveScaleY;

		public MyLayoutParams(Context context, AttributeSet attrs) {
			super(context, attrs);
			TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.DiscrollView_LayoutParams);
			mDiscrollveAlpha = a.getBoolean(R.styleable.DiscrollView_LayoutParams_discrollve_alpha, false);
			mDiscrollveScaleX = a.getBoolean(R.styleable.DiscrollView_LayoutParams_discrollve_scaleX, false);
			mDiscrollveScaleY = a.getBoolean(R.styleable.DiscrollView_LayoutParams_discrollve_scaleY, false);
			mDisCrollveTranslation = a.getInt(R.styleable.DiscrollView_LayoutParams_discrollve_translation, -1);
			mDiscrollveFromBgColor = a.getColor(R.styleable.DiscrollView_LayoutParams_discrollve_fromBgColor, -1);
			mDiscrollveToBgColor = a.getColor(R.styleable.DiscrollView_LayoutParams_discrollve_toBgColor, -1);
			a.recycle();
		}
		
	}
	

}
