package com.example.face;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.CheckBox;

public class LoginActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_login);
		Button btn_man = (Button) findViewById(R.id.btn_man);
		Button btn_women = (Button) findViewById(R.id.btn_women);
		btn_man.setOnClickListener(this);
		btn_women.setOnClickListener(this);

		// 动画
		TranslateAnimation ta = new TranslateAnimation(-100f, // 动画开始的点离当前View
																// X坐标上的差值
				0, // 动画结束的点离当前View X坐标上的差值
				0, // 动画开始的点离当前View Y坐标上的差值
				0);// 动画开始的点离当前View Y坐标上的差值
		ta.setDuration(1000);
		btn_man.startAnimation(ta);
	}

	// 声明一个音频播放器
	private SoundPool sp;
	// 存放资源变量
	private int res;

	@Override
	public void onClick(View v) {
		
		sp = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
		boolean sex = true;//选择性别
		switch (v.getId()) {
		case R.id.btn_man:
			res = sp.load(this, R.raw.boy, 1);
			sex = true;
			break;
		case R.id.btn_women:
			// 从资源文件中加载音频文件
			res = sp.load(this, R.raw.girl, 1);
			sex = false;
			break;
		// 从sdcard加载音频文件
		// res =
		// sp.load(Environment.getExternalStorageDirectory()+"/boy.wav", 1);
		default:
			break;
		}
		
		CheckBox sound = (CheckBox) findViewById(R.id.sound);
		if (sound.isChecked()) {
			sp.setOnLoadCompleteListener(new OnLoadCompleteListener() {
				@Override
				public void onLoadComplete(SoundPool soundPool, int sampleId,
						int status) {
					sp.play(res, // 资源ID
							1, // 左声道声音
							1, // 右声道声音
							1, // 优先级
							0, // 是否循环播放
							1);// 品质0~2，1为正常
				}
			});
		}

		Intent intent = new Intent(this, MainActivity.class);
		intent.putExtra("sex", sex);
		startActivity(intent);
	}
}
