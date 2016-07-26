package com.example.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.example.adapter.GridAdapter;
import com.example.face.MainActivity;
import com.example.face.R;
import com.example.util.Resource;

public class MyFragment extends Fragment {
	private int[] resImg;
	private boolean sex;

	public MyFragment(boolean sex) {
		this.sex = sex;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_layout, null);
		// 初始化图片资源
		int[] res;
		if (sex) {
			res = initBoyRes();
			// 绘制图像使用的发型
			resImg = Resource.getBoyFaxingImg();
		} else {
			res = initGirlRes();
			// 绘制图像使用的发型
			resImg = Resource.getGirlFaxingImg();
		}

		// 初始化网格控件
		initGridView(v, res);

		return v;
	}

	// 初始化网格控件
	private void initGridView(View v, final int[] res) {
		// 控件初始化
		GridView gv = (GridView) v.findViewById(R.id.gv);
		// 实例化自定义适配器
		GridAdapter adapter = new GridAdapter(res, // 获取脸型的数据源
				getActivity());// 获取上下文
		// 绑定适配器
		gv.setAdapter(adapter);
		// 获取图片资源
		// final int[] faxing = Resource.getFaxing();
		// 获取网格中元素的点击事件
		gv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				int index = ((MainActivity) getActivity()).vp.getCurrentItem();

				/*
				 * Toast.makeText(getActivity(), "类型为：" + index + "位置为：" + arg2
				 * + "，图片为：" + res[arg2], 0) .show();
				 */

				int part;
				switch (index) {
				case 0:
					part = resImg[arg2];
					break;
				case 6:
					part = Resource.getTezhengImg()[arg2];
					break;

				default:
					part = res[arg2];
					break;
				}
				if (index == 4 && arg2 == 0 || index == 7 && arg2 == 0
						|| index == 9 && arg2 == 0 || index == 10 && arg2 == 0
						|| index == 12 && arg2 == 0) {
					part = Resource.getEmpty()[0];
				}
				// 解决选择发型的问题 上边是发型下边是发型加脸
				((MainActivity) getActivity()).myView.changer(index, part);
			}
		});
	}

	// 初始化男生图片资源
	private int[] initBoyRes() {
		Bundle bundle = getArguments();
		int index = bundle.getInt("index");
		int[] res = null;
		switch (index) {
		case 0:
			res = Resource.getBoyFaxing();
			break;
		case 1:
			res = Resource.getLianxing();
			break;
		case 2:
			res = Resource.getMeimao();
			break;
		case 3:
			res = Resource.getYanjing();
			break;
		case 4:
			res = Resource.getBizi();
			break;
		case 5:
			res = Resource.getZuiba();
			break;
		case 6:
			res = Resource.getTezheng();
			break;
		case 7:
			res = Resource.getYanjing2();
			break;
		case 8:
			res = Resource.getYifu();
			break;
		case 9:
			res = Resource.getMaozi();
			break;
		case 10:
			res = Resource.getAihao();
			break;
		case 11:
			res = Resource.getBeijing();
			break;
		case 12:
			res = Resource.getQipao();
			break;
		default:
			break;
		}
		return res;
	}

	// 初始化女生图片资源
	private int[] initGirlRes() {
		Bundle bundle = getArguments();
		int index = bundle.getInt("index");
		int[] res = null;
		switch (index) {
		case 0:
			res = Resource.getGirlFaxing();
			break;
		case 1:
			res = Resource.getLianxing();
			break;
		case 2:
			res = Resource.getMeimao();
			break;
		case 3:
			res = Resource.getYanjing();
			break;
		case 4:
			res = Resource.getBizi();
			break;
		case 5:
			res = Resource.getZuiba();
			break;
		case 6:
			res = Resource.getTezheng();
			break;
		case 7:
			res = Resource.getYanjing2();
			break;
		case 8:
			res = Resource.getYifu();
			break;
		case 9:
			res = Resource.getMaozi();
			break;
		case 10:
			res = Resource.getAihao();
			break;
		case 11:
			res = Resource.getBeijing();
			break;
		case 12:
			res = Resource.getQipao();
			break;
		default:
			break;
		}
		return res;
	}

}
