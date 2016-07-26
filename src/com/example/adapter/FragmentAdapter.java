package com.example.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.fragment.MyFragment;

public class FragmentAdapter extends FragmentPagerAdapter{

	private boolean sex;
	
	public FragmentAdapter(FragmentManager fm, boolean sex) {
		super(fm);
		this.sex = sex;
	}

	//��ü����е�Ԫ��
	@Override
	public Fragment getItem(int arg0) {
		MyFragment mf = new MyFragment(sex);
		Bundle bundle = new Bundle();
		bundle.putInt("index", arg0);
		mf.setArguments(bundle);
		return mf;
	}

	//��ü��ϵĸ���
	@Override
	public int getCount() {
		return 13;
	}

}
