package com.slam5.androidapplicationlivraison;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class DrawView extends View implements OnTouchListener {
	private static final String TAG = "DrawView";

	List<Point> points = new ArrayList<Point>();
	List<Point> pointsUp = new ArrayList<Point>();
	Paint paint = new Paint();	

	public DrawView(Context context) {
		super(context);
		setFocusable(true);
		setFocusableInTouchMode(true);

		this.setOnTouchListener(this);

		paint.setColor(Color.BLACK);
		paint.setAntiAlias(true);
	}
	
	@Override
	public void onDraw(Canvas canvas) {
		int i = 0;
		//for (Point point : points) {
		//	canvas.drawCircle(point.x, point.y, 3, paint);
		for (i = 0; i < points.size(); i++) {
			if ((!pointsUp.contains(pointsUp.get(i))) && (i-1 >= 0)) {
				canvas.drawLine(points.get(i-1).x, points.get(i-1).y, points.get(i).x, points.get(i).y, paint);
			}			
		}
			// Log.d(TAG, "Painting: "+point);
		//}
	}
	
	public void refresh(){
		invalidate();
	}
	
	public boolean onTouch(View view, MotionEvent event) {
		// if(event.getAction() != MotionEvent.ACTION_DOWN)
		// return super.onTouchEvent(event);
		switch (event.getAction()) {
		case MotionEvent.ACTION_POINTER_UP:
		Point unPoint = new Point();
		pointsUp.add(unPoint);
		points.add(unPoint);	
		break;
		case MotionEvent.ACTION_POINTER_DOWN:
		Point point = new Point();
		point.x = event.getX();
		point.y = event.getY();
		points.add(point);
		invalidate();
		Log.d(TAG, "point: " + point);
		break;
		}
		return true;
	}
}

class Point {
	float x, y;

	@Override
	public String toString() {
		return x + ", " + y;
	}
}
