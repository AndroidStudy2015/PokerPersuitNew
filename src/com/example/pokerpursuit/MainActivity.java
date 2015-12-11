package com.example.pokerpursuit;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private ImageView iv_qian;
	private ImageView iv_hou;
	Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
		};
	};
	private Button bt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		iv_qian = (ImageView) findViewById(R.id.iv_qian);
		iv_hou = (ImageView) findViewById(R.id.iv_hou);
		bt = (Button) findViewById(R.id.bt);
		bt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,
						MainActivity1.class);
				startActivity(intent);
			}
		});

		iv_qian.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				float rotationY = iv_qian.getRotationY();
				float translationY = iv_qian.getTranslationY();
				float translationX = iv_qian.getTranslationX();
				ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(iv_hou,
						"alpha", 0, 1);
				ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(iv_hou,
						"scaleX", 0f, 1f);
				ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(iv_hou,
						"scaleY", 0f, 1f);
				ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(iv_qian,
						"scaleY", 1f, 0.3f);
				ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(iv_qian,
						"scaleX", 1f, 0.3f);
				ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(iv_qian,
						"alpha", 1, 0);
				ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(iv_qian,
						"rotationY", rotationY + 180);
				ObjectAnimator ofFloat = ObjectAnimator.ofFloat(iv_qian,
						"translationX", translationX - 500);
				ObjectAnimator ofFloat1 = ObjectAnimator.ofFloat(iv_qian,
						"translationY", translationY - 500);
				AnimatorSet animatorSet = new AnimatorSet();
				animatorSet.play(ofFloat).with(ofFloat1).with(ofFloat2)
						.with(ofFloat3).with(ofFloat4).with(ofFloat5)
						.with(ofFloat6).with(ofFloat7);
				animatorSet.setDuration(1000);
				animatorSet.start();

			}
		});
	}

}
