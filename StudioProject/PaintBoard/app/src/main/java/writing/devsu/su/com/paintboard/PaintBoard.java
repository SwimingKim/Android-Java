package writing.devsu.su.com.paintboard;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.io.OutputStream;
import java.util.Stack;

/**
 * Created by suyoung on 2017. 8. 16..
 */

public class PaintBoard extends View{

    Stack undos = new Stack();
    public static int maxUndos = 10;
    public boolean changed = false;

    Canvas mCanvas;
    Bitmap mBitmap;
    final Paint mPaint;
    int lastX, lastY;

    public PaintBoard(Context context) {
        super(context);

        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(2);

        lastX = -1;
        lastY = -1;
    }

    public void clearUndo() {
        while (true) {
            Bitmap prev = (Bitmap)undos.pop();
            if (prev == null) return;

            prev.recycle();
        }
    }

    public void saveUndo() {
        if (mBitmap == null) return;

        while (undos.size() >= maxUndos) {
            Bitmap i = (Bitmap)undos.get(undos.size()-1);
            i.recycle();
            undos.remove(i);
        }

        Bitmap img = Bitmap.createBitmap(mBitmap.getWidth(), mBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas();
        canvas.setBitmap(img);
        canvas.drawBitmap(mBitmap, 0, 0, mPaint);

        undos.push(img);
    }

    public void clean() {

        drawBackground(mCanvas);
        invalidate();
    }

    public void undo() {

        Bitmap prev = null;
        try {
            prev = (Bitmap) undos.pop();
        } catch (Exception ex) {
            Log.e("GoodPaintBoard", "Exception : " + ex.getMessage());
        }

        if (prev != null) {
            drawBackground(mCanvas);
            mCanvas.drawBitmap(prev, 0, 0, mPaint);
            invalidate();

            prev.recycle();
        }
    }

    public void drawBackground(Canvas canvas) {

        if (canvas != null) {
            canvas.drawColor(Color.WHITE);
        }
    }


    public void updatePaintProperty(int color, int size) {

        mPaint.setColor(color);
        mPaint.setStrokeWidth(size);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
//        mPaint.setStrokeJoin(Paint.Join.ROUND);
    }

    public void newImage(int width, int height) {

        Bitmap img = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas();
        canvas.setBitmap(img);

        mBitmap = img;
        mCanvas = canvas;

        drawBackground(mCanvas);

        changed = false;
        invalidate();
    }

    public void setImage(Bitmap newImage) {

        changed = false;

        setImageSize(newImage.getWidth(), newImage.getHeight(), newImage);
        invalidate();
    }

    public void setImageSize(int width, int height, Bitmap newImage) {

        if (mBitmap != null) {
            if (width < mBitmap.getWidth()) width = mBitmap.getWidth();
            if (height < mBitmap.getHeight()) height = mBitmap.getHeight();
        }

        if (width < 1 || height < 1) return;

        Bitmap img = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas();
        drawBackground(canvas);

        if (newImage != null) {
            canvas.setBitmap(newImage);
        }

        if (mBitmap != null) {
            mBitmap.recycle();
            mCanvas.restore();
        }

        mBitmap = img;
        mCanvas = canvas;

        clearUndo();

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        if (w > 0 && h > 0) {
            newImage(w, h);
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (mBitmap != null) {
            canvas.drawBitmap(mBitmap, 0, 0, null);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();

        int x = (int) event.getX();
        int y = (int) event.getY();

        switch (action) {
            case MotionEvent.ACTION_UP :
                changed = true;

                lastX = lastY = -1;
                break;

            case MotionEvent.ACTION_DOWN :
                saveUndo();

                if (lastX != -1) {

                    if (x != lastX || y != lastY) {
                        mCanvas.drawLine(lastX, lastY, x, y, mPaint);
                    }
                }

                lastX = x;
                lastY = y;

                break;

            case MotionEvent.ACTION_MOVE :
                if (lastX != -1) {
                    mCanvas.drawLine(lastX, lastY, x, y, mPaint);
                }

                lastX = x;
                lastY = y;

                break;
        }

        invalidate();

        return true;
    }


    public boolean save(OutputStream outputstream) {

        try {
            mBitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputstream);
            invalidate();

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
