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
		if (sex) {// ��ȡ�к�Ĭ�ϵ�ͼƬ��Դ
			person = Resource.getBoy();
			bitMaps = new Bitmap[person.length];
		} else {// ��ȡŮ��Ĭ�ϵ�ͼƬ��Դ
			person = Resource.getGirl();
			bitMaps = new Bitmap[person.length];
		}
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// ��ȡ�����ֵĿ��
		int width = getWidth();
		// ��ȡ�����ֵĸ߶�
		int height = getHeight();

		// ͨ��BitmapFactory��ת����Դ�ļ��µ�ͼƬ
		for (int i = 0; i < person.length; i++) {
			bitmap = BitmapFactory.decodeResource(getResources(),// ����Դ�ļ��л�ȡ
					person[i]);
			bitMaps[i] = bitmap;
		}
		// �õ�����ͼƬ
		bitMaps[0] = Bitmap.createScaledBitmap(bitMaps[0], 2 * width / 3,
				2 * width / 3, true);
		// �õ�����ͼƬ
		bitMaps[1] = Bitmap.createScaledBitmap(bitMaps[1], 2 * width / 3,
				2 * width / 3, true);
		// �õ�üëͼƬ
		bitMaps[2] = Bitmap.createScaledBitmap(bitMaps[2], width / 2,
				width / 2, true);
		// �õ��۾�ͼƬ
		bitMaps[3] = Bitmap.createScaledBitmap(bitMaps[3], width / 3,
				width / 3, true);
		// �õ�����ͼƬ
		bitMaps[4] = Bitmap.createScaledBitmap(bitMaps[4], width / 4,
				width / 4, true);
		// �õ����ͼƬ
		bitMaps[5] = Bitmap.createScaledBitmap(bitMaps[5], width / 3,
				width / 3, true);
		// �õ�����ͼƬ
		bitMaps[6] = Bitmap.createScaledBitmap(bitMaps[6], width / 3,
				width / 3, true);
		// �õ��۾�ͼƬ
		bitMaps[7] = Bitmap.createScaledBitmap(bitMaps[7], width / 3,
				width / 3, true);
		// �õ��·�ͼƬ
		bitMaps[8] = Bitmap.createScaledBitmap(bitMaps[8], width / 2,
				width / 2, true);
		// �õ�ñ��ͼƬ
		bitMaps[9] = Bitmap.createScaledBitmap(bitMaps[9], width / 2,
				width / 2, true);
		// �õ�����ͼƬ 
		bitMaps[10] = Bitmap.createScaledBitmap(bitMaps[10], width / 3,
				width / 3, true);
		// �õ�����ͼƬ
		bitMaps[11] = Bitmap.createScaledBitmap(bitMaps[11], width, height,
				true);
		// �õ�����ͼƬ 
		bitMaps[12] = Bitmap.createScaledBitmap(bitMaps[12], width / 3,
				width / 3, true);

		// ������
		canvas.drawBitmap(bitMaps[11], 0, 0, null);
		// ������
		canvas.drawBitmap(bitMaps[1], (width - bitMaps[1].getWidth()) / 2,
				(height - bitMaps[1].getHeight()) / 2 - 20, null);
		// ��üë
		canvas.drawBitmap(bitMaps[2], (width - bitMaps[2].getWidth()) / 2,
				(height - bitMaps[2].getHeight()) / 2 - bitMaps[2].getHeight() / 7, null);
		// ���۾�
		canvas.drawBitmap(bitMaps[3], (width - bitMaps[3].getWidth()) / 2,
				(height - bitMaps[3].getHeight()) / 2 - 20, null);
		// ������
		canvas.drawBitmap(bitMaps[4], (width - bitMaps[4].getWidth()) / 2,
				(height - bitMaps[4].getHeight()) / 2 + 20, null);
		// �����
		canvas.drawBitmap(bitMaps[5], (width - bitMaps[5].getWidth()) / 2,
				(height - bitMaps[5].getHeight()) / 2 + bitMaps[5].getHeight() / 3, null);
		// ������
		canvas.drawBitmap(bitMaps[0], // ͼƬ
				(width - bitMaps[0].getWidth()) / 2, // ������ߵ�ƫ����
				(height - bitMaps[0].getHeight()) / 2 - 20, // ���붥����ƫ����
				null);// ���ʣ�û�о���Ϊnull
		// ������
		canvas.drawBitmap(bitMaps[6], (width - bitMaps[6].getWidth()) / 2,
				(height - bitMaps[6].getHeight()) / 2 + 20, null);
		// ���۾�
		canvas.drawBitmap(bitMaps[7], (width - bitMaps[7].getWidth()) / 2,
				(height - bitMaps[7].getHeight()) / 2 - 20, null);
		// ���·�
		canvas.drawBitmap(bitMaps[8], (width - bitMaps[8].getWidth()) / 2,
				(height - bitMaps[8].getHeight()) / 2 + bitMaps[8].getHeight() / 5  , null);
		// ��ñ��
		canvas.drawBitmap(bitMaps[9], (width - bitMaps[9].getWidth()) / 2,
				-(bitMaps[9].getHeight()) / 4, null);
		// ������
		canvas.drawBitmap(bitMaps[10], 0,
				(height - bitMaps[10].getHeight()) / 2, null);
		// ������
		canvas.drawBitmap(bitMaps[12], (width - bitMaps[12].getWidth()) / 2
				+ bitMaps[12].getWidth(),
				(height - bitMaps[12].getHeight()) / 2 - bitMaps[12].getWidth()
						* 2 / 5, null);

		// //����һ������
		// Paint paint = new Paint();
		// paint.setColor(Color.RED);
		// paint.setTextSize(20);
		// //������
		// canvas.drawText("��ȣ�"+width, 200, 50, paint);
		// canvas.drawText("�߶ȣ�"+height, 200, 100, paint);

		super.onDraw(canvas);
	}

	// �滻ͼƬ
	public void changer(int index, int res) {
		person[index] = res;
		// ���½���
		invalidate();
	}
}
