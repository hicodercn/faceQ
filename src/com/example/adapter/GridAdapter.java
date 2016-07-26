package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.face.R;

public class GridAdapter extends BaseAdapter {
	
	private LayoutInflater inflater;
	private int[] rs;
	
	public GridAdapter(int[] rs, Context context) {
		this.rs = rs;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return rs.length;
	}

	@Override
	public Object getItem(int position) {
		return rs[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.item_layout, null);
			holder.iv = (ImageView) convertView.findViewById(R.id.iv_item);
			convertView.setTag(holder);
		}
		else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.iv.setImageResource(rs[position]);
		return convertView;
	}

	private class ViewHolder{
		ImageView iv;
	}
}
