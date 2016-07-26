package com.example.face;

import java.io.FileOutputStream;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adapter.FragmentAdapter;
import com.example.view.MyView;

//v4����Ҫ��Activity�ĳ�FragmentActivity
public class MainActivity extends FragmentActivity implements OnClickListener {

	public ViewPager vp;
	public MyView myView;
	private RadioButton rb;
	private HorizontalScrollView hs;
	private TextView line;
	private RadioGroup rg;
	private boolean sex;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// ȥ����������Ҫд��setContentViewǰ��
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		Intent intent = getIntent();
		sex = intent.getBooleanExtra("sex", true);
		
		// ��ʼ��ViewPager
		initViewPager();
		// ��ʼ��RadioGroup
		initRadioGroup();

		// ������һҳ
		Button btn_back = (Button) findViewById(R.id.btn_back);
		btn_back.setOnClickListener(this);

		// ʵ�����Զ���View
		myView = new MyView(this, sex);
		// ����myView���Խ�ͼ
		// ��д�˷����������ȡ����ͼƬ
		myView.setDrawingCacheEnabled(true);
		// �ҵ�ҪView�Ĳ���
		RelativeLayout rl = (RelativeLayout) findViewById(R.id.rl);
		// ��ӵ�������
		rl.addView(myView);

		// ����ͼƬ
		Button btn_save = (Button) findViewById(R.id.btn_save);
		btn_save.setOnClickListener(this);

		// ��ȡһ��Button���û��õ����
		rb = (RadioButton) findViewById(R.id.rb_faxing);
		// ��ȡ��ֱ������
		hs = (HorizontalScrollView) findViewById(R.id.hs);
		// ��ȡ�Զ��������
		line = (TextView) findViewById(R.id.line);
		// ��ȡRadioGroup
		rg = (RadioGroup) findViewById(R.id.rg_type);
		vp.setOnPageChangeListener(new OnPageChangeListener() {

			private float fromX;

			// ��ҳ�汻ѡ��ʱ
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub

			}

			// ��ҳ�滬��ʱ
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// ҳ���±� �ƶ��İٷֱ� �ƶ���λ��
				// Log.i("project", "arg0:"+arg0+",arg1:"+arg1+",arg2:"+arg2);

				// ��RadioGroup��������
				// ��ȡ��������ǰλ��
				int total = (int) ((arg0 + arg1) * rb.getWidth());
				// ��ȡ���а�ť��X����
				int green = (vp.getWidth() - rb.getWidth()) / 2;
				// ����ˮƽ�������ƶ��ľ���
				int scroll = total - green;
				// ������ֱ������
				hs.scrollTo(scroll, 0);

				// ���Զ����������������
				// ���ݻ����±꣬��ȡRadioGroup����Ԫ��RadioButton
				RadioButton button = (RadioButton) rg.getChildAt(arg0);
				// ����һ�����飬���ڱ���button��X��Y����
				int[] location = new int[2];
				// ��ȡbutton����Ļ�еľ�������
				button.getLocationInWindow(location);
				// ����һ��λ�ƶ���
				TranslateAnimation ta = new TranslateAnimation(fromX,
						location[0] + arg1 * rb.getWidth(), 0, 0);
				// ���ö���ʱ��
				ta.setDuration(50);
				// ���ֶ�����ɺ��״̬
				ta.setFillAfter(true);
				// �����ζ�������λ������Ϊ�´ζ�����ʼλ��
				fromX = (int) (location[0] + arg1 * rb.getWidth());
				// ��ʼ����
				line.startAnimation(ta);

			}

			// ��ҳ�滬��״̬�ı�ʱ
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});

	}

	// ��ʼ��RadioGroup������ѡ��
	private void initRadioGroup() {
		RadioGroup rg_type = (RadioGroup) findViewById(R.id.rg_type);
		// ��ѡ��ĸı��¼�
		rg_type.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.rb_faxing:
					// toast("����");
					vp.setCurrentItem(0);// ����ViewPager�ĵ�ǰҳ��
					break;
				case R.id.rb_lianxing:
					// toast("����");
					vp.setCurrentItem(1);
					break;
				case R.id.rb_meimao:
					// toast("üë");
					vp.setCurrentItem(2);
					break;
				case R.id.rb_yanjing:
					// toast("�۾�");
					vp.setCurrentItem(3);
					break;
				case R.id.rb_bizi:
					// toast("����");
					vp.setCurrentItem(4);
					break;
				case R.id.rb_zuiba:
					// toast("���");
					vp.setCurrentItem(5);
					break;
				case R.id.rb_tezheng:
					// toast("����");
					vp.setCurrentItem(6);
					break;
				case R.id.rb_yanjing2:
					// toast("�۾�");
					vp.setCurrentItem(7);
					break;
				case R.id.rb_yifu:
					// toast("�·�");
					vp.setCurrentItem(8);
					break;
				case R.id.rb_maozi:
					// toast("ñ��");
					vp.setCurrentItem(9);
					break;
				case R.id.rb_aihao:
					// toast("����");
					vp.setCurrentItem(10);
					break;
				case R.id.rb_beijing:
					// toast("����");
					vp.setCurrentItem(11);
					break;
				case R.id.rb_qipao:
					// toast("����");
					vp.setCurrentItem(12);
					break;
				default:
					break;
				}
			}
		});
	}

	// ��ʼ��ViewPager
	private void initViewPager() {
		vp = (ViewPager) findViewById(R.id.vp);
		// ʵ�����Զ����������
		// ��Ҫ�Ѽ̳�Activity�ĳɼ̳�FragmentActivity
		FragmentAdapter fa = new FragmentAdapter(getSupportFragmentManager(), sex);
		// ��������
		vp.setAdapter(fa);
	}

	public void toast(String text) {
		Toast.makeText(this, text, 0).show();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_back:
			// �رյ�ǰҳ��
			finish();
			break;
		case R.id.btn_save:
			// ��ȡͼƬ
			Bitmap bitmap = myView.getDrawingCache();
			System.out.println(bitmap);
			// �����ļ�����
			String name = System.currentTimeMillis() + ".png";
			// ����ͼƬ�ı���·��
			String path = Environment.getExternalStorageDirectory() + "/"
					+ name;
			try {
				// ����һ���ļ������
				FileOutputStream fos = new FileOutputStream(path);
				// ѹ��ͼƬ�������ֱ�ΪͼƬ��ʽ��ѹ���ʣ��ļ����������
				bitmap.compress(CompressFormat.PNG, 100, fos);
				// �ر���
				fos.close();
				Toast.makeText(this, "ͼƬ������" + path, 0).show();
			} catch (Exception e) {
				Toast.makeText(this, "ͼƬ����ʧ��", 0).show();
				e.printStackTrace();
			}

			break;
		default:
			break;
		}
	}

}
