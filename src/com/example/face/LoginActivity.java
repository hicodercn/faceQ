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

		// ����
		TranslateAnimation ta = new TranslateAnimation(-100f, // ������ʼ�ĵ��뵱ǰView
																// X�����ϵĲ�ֵ
				0, // ���������ĵ��뵱ǰView X�����ϵĲ�ֵ
				0, // ������ʼ�ĵ��뵱ǰView Y�����ϵĲ�ֵ
				0);// ������ʼ�ĵ��뵱ǰView Y�����ϵĲ�ֵ
		ta.setDuration(1000);
		btn_man.startAnimation(ta);
	}

	// ����һ����Ƶ������
	private SoundPool sp;
	// �����Դ����
	private int res;

	@Override
	public void onClick(View v) {
		
		sp = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
		boolean sex = true;//ѡ���Ա�
		switch (v.getId()) {
		case R.id.btn_man:
			res = sp.load(this, R.raw.boy, 1);
			sex = true;
			break;
		case R.id.btn_women:
			// ����Դ�ļ��м�����Ƶ�ļ�
			res = sp.load(this, R.raw.girl, 1);
			sex = false;
			break;
		// ��sdcard������Ƶ�ļ�
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
					sp.play(res, // ��ԴID
							1, // ����������
							1, // ����������
							1, // ���ȼ�
							0, // �Ƿ�ѭ������
							1);// Ʒ��0~2��1Ϊ����
				}
			});
		}

		Intent intent = new Intent(this, MainActivity.class);
		intent.putExtra("sex", sex);
		startActivity(intent);
	}
}
