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

//v4包需要把Activity改成FragmentActivity
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
		// 去掉标题栏，要写在setContentView前面
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		Intent intent = getIntent();
		sex = intent.getBooleanExtra("sex", true);
		
		// 初始化ViewPager
		initViewPager();
		// 初始化RadioGroup
		initRadioGroup();

		// 返回上一页
		Button btn_back = (Button) findViewById(R.id.btn_back);
		btn_back.setOnClickListener(this);

		// 实例化自定义View
		myView = new MyView(this, sex);
		// 设置myView可以截图
		// 不写此方法，后面截取不了图片
		myView.setDrawingCacheEnabled(true);
		// 找到要View的布局
		RelativeLayout rl = (RelativeLayout) findViewById(R.id.rl);
		// 添加到布局中
		rl.addView(myView);

		// 保存图片
		Button btn_save = (Button) findViewById(R.id.btn_save);
		btn_save.setOnClickListener(this);

		// 获取一个Button，用户得到宽度
		rb = (RadioButton) findViewById(R.id.rb_faxing);
		// 获取垂直滚动条
		hs = (HorizontalScrollView) findViewById(R.id.hs);
		// 获取自定义滚动条
		line = (TextView) findViewById(R.id.line);
		// 获取RadioGroup
		rg = (RadioGroup) findViewById(R.id.rg_type);
		vp.setOnPageChangeListener(new OnPageChangeListener() {

			private float fromX;

			// 当页面被选中时
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub

			}

			// 当页面滑动时
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// 页面下标 移动的百分比 移动的位置
				// Log.i("project", "arg0:"+arg0+",arg1:"+arg1+",arg2:"+arg2);

				// 让RadioGroup滚动起来
				// 获取滚动条当前位置
				int total = (int) ((arg0 + arg1) * rb.getWidth());
				// 获取居中按钮的X坐标
				int green = (vp.getWidth() - rb.getWidth()) / 2;
				// 计算水平滚动条移动的距离
				int scroll = total - green;
				// 滑动垂直滚动条
				hs.scrollTo(scroll, 0);

				// 让自定义滚动条滚动起来
				// 根据滑动下标，获取RadioGroup中子元素RadioButton
				RadioButton button = (RadioButton) rg.getChildAt(arg0);
				// 创建一个数组，用于保存button的X、Y坐标
				int[] location = new int[2];
				// 获取button在屏幕中的绝对坐标
				button.getLocationInWindow(location);
				// 创建一个位移动画
				TranslateAnimation ta = new TranslateAnimation(fromX,
						location[0] + arg1 * rb.getWidth(), 0, 0);
				// 设置动画时间
				ta.setDuration(50);
				// 保持动画完成后的状态
				ta.setFillAfter(true);
				// 将本次动画结束位置设置为下次动画开始位置
				fromX = (int) (location[0] + arg1 * rb.getWidth());
				// 开始动画
				line.startAnimation(ta);

			}

			// 当页面滑动状态改变时
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});

	}

	// 初始化RadioGroup，类型选择
	private void initRadioGroup() {
		RadioGroup rg_type = (RadioGroup) findViewById(R.id.rg_type);
		// 单选框的改变事件
		rg_type.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.rb_faxing:
					// toast("发型");
					vp.setCurrentItem(0);// 设置ViewPager的当前页面
					break;
				case R.id.rb_lianxing:
					// toast("脸型");
					vp.setCurrentItem(1);
					break;
				case R.id.rb_meimao:
					// toast("眉毛");
					vp.setCurrentItem(2);
					break;
				case R.id.rb_yanjing:
					// toast("眼睛");
					vp.setCurrentItem(3);
					break;
				case R.id.rb_bizi:
					// toast("鼻子");
					vp.setCurrentItem(4);
					break;
				case R.id.rb_zuiba:
					// toast("嘴巴");
					vp.setCurrentItem(5);
					break;
				case R.id.rb_tezheng:
					// toast("特征");
					vp.setCurrentItem(6);
					break;
				case R.id.rb_yanjing2:
					// toast("眼镜");
					vp.setCurrentItem(7);
					break;
				case R.id.rb_yifu:
					// toast("衣服");
					vp.setCurrentItem(8);
					break;
				case R.id.rb_maozi:
					// toast("帽子");
					vp.setCurrentItem(9);
					break;
				case R.id.rb_aihao:
					// toast("爱好");
					vp.setCurrentItem(10);
					break;
				case R.id.rb_beijing:
					// toast("背景");
					vp.setCurrentItem(11);
					break;
				case R.id.rb_qipao:
					// toast("气泡");
					vp.setCurrentItem(12);
					break;
				default:
					break;
				}
			}
		});
	}

	// 初始化ViewPager
	private void initViewPager() {
		vp = (ViewPager) findViewById(R.id.vp);
		// 实例化自定义的适配器
		// 需要把继承Activity改成继承FragmentActivity
		FragmentAdapter fa = new FragmentAdapter(getSupportFragmentManager(), sex);
		// 绑定适配器
		vp.setAdapter(fa);
	}

	public void toast(String text) {
		Toast.makeText(this, text, 0).show();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_back:
			// 关闭当前页面
			finish();
			break;
		case R.id.btn_save:
			// 截取图片
			Bitmap bitmap = myView.getDrawingCache();
			System.out.println(bitmap);
			// 定义文件名称
			String name = System.currentTimeMillis() + ".png";
			// 设置图片的保存路径
			String path = Environment.getExternalStorageDirectory() + "/"
					+ name;
			try {
				// 创建一个文件输出流
				FileOutputStream fos = new FileOutputStream(path);
				// 压缩图片，参数分别为图片格式，压缩率，文件输出流对象
				bitmap.compress(CompressFormat.PNG, 100, fos);
				// 关闭流
				fos.close();
				Toast.makeText(this, "图片保存在" + path, 0).show();
			} catch (Exception e) {
				Toast.makeText(this, "图片保存失败", 0).show();
				e.printStackTrace();
			}

			break;
		default:
			break;
		}
	}

}
