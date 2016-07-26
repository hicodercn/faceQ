package com.example.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

import com.example.util.Resource;

public class MyView extends View {
	Bitmap[] bitMaps;
	private int[] person;
	private Bitmap bitmap;

	public MyView(Context context, boolean sex) {
		super(context);
		if (sex) {// 获取男孩默认的图片资源
			person = Resource.getBoy();
			bitMaps = new Bitmap[person.length];
		} else {// 获取女孩默认的图片资源
			person = Resource.getGirl();
			bitMaps = new Bitmap[person.length];
		}
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// 获取父布局的宽度
		int width = getWidth();
		// 获取父布局的高度
		int height = getHeight();

		// 通过BitmapFactory来转化资源文件下的图片
		for (int i = 0; i < person.length; i++) {
			bitmap = BitmapFactory.decodeResource(getResources(),// 从资源文件中获取
					person[i]);
			bitMaps[i] = bitmap;
		}
		// 得到发型图片
		bitMaps[0] = Bitmap.createScaledBitmap(bitMaps[0], 2 * width / 3,
				2 * width / 3, true);
		// 得到脸型图片
		bitMaps[1] = Bitmap.createScaledBitmap(bitMaps[1], 2 * width / 3,
				2 * width / 3, true);
		// 得到眉毛图片
		bitMaps[2] = Bitmap.createScaledBitmap(bitMaps[2], width / 2,
				width / 2, true);
		// 得到眼睛图片
		bitMaps[3] = Bitmap.createScaledBitmap(bitMaps[3], width / 3,
				width / 3, true);
		// 得到鼻子图片
		bitMaps[4] = Bitmap.createScaledBitmap(bitMaps[4], width / 4,
				width / 4, true);
		// 得到嘴巴图片
		bitMaps[5] = Bitmap.createScaledBitmap(bitMaps[5], width / 3,
				width / 3, true);
		// 得到特征图片
		bitMaps[6] = Bitmap.createScaledBitmap(bitMaps[6], width / 3,
				width / 3, true);
		// 得到眼镜图片
		bitMaps[7] = Bitmap.createScaledBitmap(bitMaps[7], width / 3,
				width / 3, true);
		// 得到衣服图片
		bitMaps[8] = Bitmap.createScaledBitmap(bitMaps[8], width / 2,
				width / 2, true);
		// 得到帽子图片
		bitMaps[9] = Bitmap.createScaledBitmap(bitMaps[9], width / 2,
				width / 2, true);
		// 得到爱好图片 
		bitMaps[10] = Bitmap.createScaledBitmap(bitMaps[10], width / 3,
				width / 3, true);
		// 得到背景图片
		bitMaps[11] = Bitmap.createScaledBitmap(bitMaps[11], width, height,
				true);
		// 得到气泡图片 
		bitMaps[12] = Bitmap.createScaledBitmap(bitMaps[12], width / 3,
				width / 3, true);

		// 画背景
		canvas.drawBitmap(bitMaps[11], 0, 0, null);
		// 画脸型
		canvas.drawBitmap(bitMaps[1], (width - bitMaps[1].getWidth()) / 2,
				(height - bitMaps[1].getHeight()) / 2 - 20, null);
		// 画眉毛
		canvas.drawBitmap(bitMaps[2], (width - bitMaps[2].getWidth()) / 2,
				(height - bitMaps[2].getHeight()) / 2 - bitMaps[2].getHeight() / 7, null);
		// 画眼睛
		canvas.drawBitmap(bitMaps[3], (width - bitMaps[3].getWidth()) / 2,
				(height - bitMaps[3].getHeight()) / 2 - 20, null);
		// 画鼻子
		canvas.drawBitmap(bitMaps[4], (width - bitMaps[4].getWidth()) / 2,
				(height - bitMaps[4].getHeight()) / 2 + 20, null);
		// 画嘴巴
		canvas.drawBitmap(bitMaps[5], (width - bitMaps[5].getWidth()) / 2,
				(height - bitMaps[5].getHeight()) / 2 + bitMaps[5].getHeight() / 3, null);
		// 画发型
		canvas.drawBitmap(bitMaps[0], // 图片
				(width - bitMaps[0].getWidth()) / 2, // 距离左边的偏移量
				(height - bitMaps[0].getHeight()) / 2 - 20, // 距离顶部的偏移量
				null);// 画笔，没有就设为null
		// 画特征
		canvas.drawBitmap(bitMaps[6], (width - bitMaps[6].getWidth()) / 2,
				(height - bitMaps[6].getHeight()) / 2 + 20, null);
		// 画眼镜
		canvas.drawBitmap(bitMaps[7], (width - bitMaps[7].getWidth()) / 2,
				(height - bitMaps[7].getHeight()) / 2 - 20, null);
		// 画衣服
		canvas.drawBitmap(bitMaps[8], (width - bitMaps[8].getWidth()) / 2,
				(height - bitMaps[8].getHeight()) / 2 + bitMaps[8].getHeight() / 5  , null);
		// 画帽子
		canvas.drawBitmap(bitMaps[9], (width - bitMaps[9].getWidth()) / 2,
				-(bitMaps[9].getHeight()) / 4, null);
		// 画爱好
		canvas.drawBitmap(bitMaps[10], 0,
				(height - bitMaps[10].getHeight()) / 2, null);
		// 画气泡
		canvas.drawBitmap(bitMaps[12], (width - bitMaps[12].getWidth()) / 2
				+ bitMaps[12].getWidth(),
				(height - bitMaps[12].getHeight()) / 2 - bitMaps[12].getWidth()
						* 2 / 5, null);

		// //创建一个画笔
		// Paint paint = new Paint();
		// paint.setColor(Color.RED);
		// paint.setTextSize(20);
		// //画文字
		// canvas.drawText("宽度："+width, 200, 50, paint);
		// canvas.drawText("高度："+height, 200, 100, paint);

		super.onDraw(canvas);
	}

	// 替换图片
	public void changer(int index, int res) {
		person[index] = res;
		// 更新界面
		invalidate();
	}
}
