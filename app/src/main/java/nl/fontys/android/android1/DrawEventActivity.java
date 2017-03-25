package nl.fontys.android.android1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;


/**
 * Created by Stefan on 23-Feb-17.
 */

public class DrawEventActivity extends View {
    private Paint paint = new Paint();
    private Paint paintCircle = new Paint();
    private Path path = new Path();
    private Path pathSave = new Path();
    Context context;
    GestureDetector gestureDetector;

    public DrawEventActivity(Context context, AttributeSet attrs) {
        super(context, attrs);
        gestureDetector = new GestureDetector(context, new GestureListener());
        this.context = context;

        paint.setAntiAlias(true);
        paint.setStrokeWidth(6f);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paintCircle.setAntiAlias(true);
        paintCircle.setStrokeWidth(20);
        paintCircle.setColor(Color.LTGRAY);
        paintCircle.setStyle(Paint.Style.STROKE);
        paintCircle.setStrokeJoin(Paint.Join.ROUND);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPath(path, paint);
        canvas.drawPath(pathSave, paintCircle);
    }

    private class GestureListener extends GestureDetector.SimpleOnGestureListener {
        // event when double tap occurs
        @Override
        public boolean onDoubleTap(MotionEvent e) {
            float x = e.getX();
            float y = e.getY();
            Log.d("Double Tap", "Tapped at: (" + x + "," + y + ")");

            // clean drawing area on double tap
            path.reset();
            pathSave.reset();

            return true;
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float eventX = event.getX();
        float eventY = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(eventX, eventY);
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(eventX, eventY);
                pathSave.reset();
                pathSave.addCircle(eventX, eventY, 50, Path.Direction.CW);
                break;
            case MotionEvent.ACTION_UP:
                pathSave.reset();
                break;
            default:
                return false;
        }

        gestureDetector.onTouchEvent(event);
        // Schedules a repaint.
        invalidate();
        return true;

    }
}