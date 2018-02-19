package skim.dev.kr.androidwebview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.util.DisplayMetrics;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;

import java.io.IOException;

/**
 * Created by suyoung on 2018. 2. 20..
 */

public class CJCameraPreview  extends SurfaceView implements SurfaceHolder.Callback {

    private static SurfaceHolder m_holder;
    private static Camera m_camera;
    private static int m_cameraFacing;
    private static int m_x, m_y, m_width, m_height;

    public CJCameraPreview(Context context, String strCameraFacing, int x, int y, int width, int height, float dpi) {
        super(context);

        m_holder = getHolder();
        m_holder.addCallback(this);
        m_holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        m_cameraFacing = "back".equals( strCameraFacing ) ? 0 : 1;
        m_x = x;
        m_y = y;
        m_width = width;
        m_height = height;
    }

    public void changePreview(String cameraFacing, int x, int y) {
        if(m_camera != null) {
            stop();
        }

        m_cameraFacing = "back".equals( cameraFacing.toLowerCase() ) ? 0 : 1;
        m_camera = Camera.open(m_cameraFacing);

        Camera.Parameters parameters = m_camera.getParameters();
        settingCamera( parameters );

        try {
            m_camera.setPreviewDisplay(m_holder);
        } catch (IOException e) {
            m_camera.release();
            m_camera = null;
        }

        if( m_camera != null )
            m_camera.startPreview();

    }

    @Override
    public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
        Camera.Parameters parameters = m_camera.getParameters();
        settingCamera( parameters );
        m_camera.startPreview();
    }

    @Override
    public void surfaceCreated(SurfaceHolder arg0) {

        try {
            m_camera = Camera.open(m_cameraFacing);
            Camera.Parameters parameters = m_camera.getParameters();
            settingCamera( parameters );
            parameters.set("jpeg-quality", 70);
            parameters.setPictureFormat(PixelFormat.JPEG);
            parameters.set("orientation", "landscape");

            m_camera.setPreviewDisplay(m_holder);
            m_camera.setParameters(parameters);

        } catch (IOException e) {
            m_camera.release();
            m_camera = null;

            e.printStackTrace(System.out);
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        stop();
    }

    public Bitmap viewToBitmap() {
        Bitmap bitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        if (this instanceof SurfaceView) {
            SurfaceView surfaceView = (SurfaceView) this;
            surfaceView.setZOrderOnTop(true);
            surfaceView.draw(canvas);
            surfaceView.setZOrderOnTop(false);
            return bitmap;
        } else {
            //For ViewGroup & View
            draw(canvas);
            return bitmap;
        }
    }

    public void stop() {
        if ( m_camera != null ) {
            m_camera.stopPreview();
            m_camera.release();
            m_camera = null;
        }
    }

    private void settingCamera( Camera.Parameters parameters ) {

        WindowManager windowManager = (WindowManager)getContext().getSystemService(Context.WINDOW_SERVICE);
        int rotation = windowManager.getDefaultDisplay().getRotation();
        if (rotation == Surface.ROTATION_0) {
            m_camera.setDisplayOrientation(0);
            parameters.setRotation(0);
        } if (rotation == Surface.ROTATION_90) {
            m_camera.setDisplayOrientation(0);
            parameters.setRotation(0);
        } if (rotation == Surface.ROTATION_180) {
            m_camera.setDisplayOrientation(180);
            parameters.setRotation(180);
        } else if(rotation == Surface.ROTATION_270){
            m_camera.setDisplayOrientation(180);
            parameters.setRotation(180);
        }

        Resources resources = getContext().getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        setX( m_x * (metrics.densityDpi / 160f) );
        setY( m_y * (metrics.densityDpi / 160f) );
        m_holder.setFixedSize( (int)(m_width * (metrics.densityDpi / 160f)), (int)(m_height * (metrics.densityDpi / 160f)) );
    }
}
