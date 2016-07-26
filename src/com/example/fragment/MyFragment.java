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
		// ��ʼ��ͼƬ��Դ
		int[] res;
		if (sex) {
			res = initBoyRes();
			// ����ͼ��ʹ�õķ���
			resImg = Resource.getBoyFaxingImg();
		} else {
			res = initGirlRes();
			// ����ͼ��ʹ�õķ���
			resImg = Resource.getGirlFaxingImg();
		}

		// ��ʼ������ؼ�
		initGridView(v, res);

		return v;
	}

	// ��ʼ������ؼ�
	private void initGridView(View v, final int[] res) {
		// �ؼ���ʼ��
		GridView gv = (GridView) v.findViewById(R.id.gv);
		// ʵ�����Զ���������
		GridAdapter adapter = new GridAdapter(res, // ��ȡ���͵�����Դ
				getActivity());// ��ȡ������
		// ��������
		gv.setAdapter(adapter);
		// ��ȡͼƬ��Դ
		// final int[] faxing = Resource.getFaxing();
		// ��ȡ������Ԫ�صĵ���¼�
		gv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				int index = ((MainActivity) getActivity()).vp.getCurrentItem();

				/*
				 * Toast.makeText(getActivity(), "����Ϊ��" + index + "λ��Ϊ��" + arg2
				 * + "��ͼƬΪ��" + res[arg2], 0) .show();
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
				// ���ѡ���͵����� �ϱ��Ƿ����±��Ƿ��ͼ���
				((MainActivity) getActivity()).myView.changer(index, part);
			}
		});
	}

	// ��ʼ������ͼƬ��Դ
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

	// ��ʼ��Ů��ͼƬ��Դ
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
