package writing.devsu.su.com.paintboard;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.googlecode.tesseract.android.TessBaseAPI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends Activity implements View.OnClickListener {

    public static final String DATA_PATH = Environment
            .getExternalStorageDirectory().toString() + "/SimpleAndroidOCR/";
    private static final String TAG = "SimpleAndroidOCR.java";

    protected String _path;
    protected boolean _taken;

    PaintBoard board;
    Button colorBtn, penBtn, eraserBtn, undoBtn, deleteBtn, readBtn;
    int mColor = 0xff000000;
    int mSize = 2;
    int oldColor;
    int oldSize;
    boolean eraserSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getTrainedData("eng");
        getTrainedData("kor");
        _path = DATA_PATH + "/ocr.jpg";


        final LinearLayout boardLayout = (LinearLayout) findViewById(R.id.boardLayout);
        colorBtn = (Button) findViewById(R.id.colorBtn);
        colorBtn.setOnClickListener(this);
        penBtn = (Button) findViewById(R.id.penBtn);
        penBtn.setOnClickListener(this);
        eraserBtn = (Button) findViewById(R.id.eraserBtn);
        eraserBtn.setOnClickListener(this);
        undoBtn = (Button) findViewById(R.id.undoBtn);
        undoBtn.setOnClickListener(this);
        readBtn = (Button) findViewById(R.id.readBtn);
        readBtn.setOnClickListener(this);
        deleteBtn = (Button) findViewById(R.id.deleteBtn);
        deleteBtn.setOnClickListener(this);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT);
        board = new PaintBoard(this);
        board.setLayoutParams(params);
        board.setPadding(2, 2, 2, 2);
        boardLayout.addView(board);


    }

    private void enable(Boolean b) {
        colorBtn.setEnabled(b);
        penBtn.setEnabled(b);
        undoBtn.setEnabled(b);
        deleteBtn.setEnabled(b);
        readBtn.setEnabled(b);

        colorBtn.invalidate();
        penBtn.invalidate();
        undoBtn.invalidate();
        deleteBtn.invalidate();
        readBtn.invalidate();
    }

    public int getChosenColor() {
        return mColor;
    }

    public int getPenThinckness() {
        return mSize;
    }

    private void getTrainedData( String strlang ) {

        String[] paths = new String[] { DATA_PATH, DATA_PATH + "tessdata/"};

        for (String path : paths) {
            File dir = new File(path);
            if (!dir.exists()) {
                if (!dir.mkdirs()) {
                    Log.v(TAG, "ERROR: Creation of directory " + path + " on sdcard failed");
                    return;
                } else {
                    Log.v(TAG, "Created directory " + path + " on sdcard");
                }
            }

        }

        if (!(new File(DATA_PATH + "tessdata/" + strlang + ".traineddata")).exists()) {
            try {

                AssetManager assetManager = getAssets();
                InputStream in = assetManager.open("tessdata/" + strlang + ".traineddata");
                OutputStream out = new FileOutputStream(DATA_PATH
                        + "tessdata/" + strlang + ".traineddata");

                // Transfer bytes from in to out
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                in.close();
                out.close();

                Log.v(TAG, "Copied " + strlang + " traineddata");
            } catch (IOException e) {
                Log.e(TAG, "Was unable to copy " + strlang + " traineddata " + e.toString());
            }
        }


    }


    protected void readText( String strlang ) {
        _taken = true;

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 4;

        Bitmap bitmap = BitmapFactory.decodeFile(_path, options);

        try {
            ExifInterface exif = new ExifInterface(_path);
            int exifOrientation = exif.getAttributeInt(
                    ExifInterface.TAG_ORIENTATION,
                    ExifInterface.ORIENTATION_NORMAL);

            Log.v(TAG, "Orient: " + exifOrientation);

            int rotate = 0;

            switch (exifOrientation) {
                case ExifInterface.ORIENTATION_ROTATE_90:
                    rotate = 90;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    rotate = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_270:
                    rotate = 270;
                    break;
            }

            Log.v(TAG, "Rotation: " + rotate);

            if (rotate != 0) {
                int w = bitmap.getWidth();
                int h = bitmap.getHeight();

                Matrix mtx = new Matrix();
                mtx.preRotate(rotate);

                bitmap = Bitmap.createBitmap(bitmap, 0, 0, w, h, mtx, false);
            }

            bitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true);

        } catch (IOException e) {
            Log.e(TAG, "Couldn't correct orientation: " + e.toString());
        }

        Log.v(TAG, "Before baseApi");

        TessBaseAPI baseApi = new TessBaseAPI();
        baseApi.setDebug(true);
        baseApi.init(DATA_PATH, strlang);
        baseApi.setImage(bitmap);

        String recognizedText = baseApi.getUTF8Text();

        baseApi.end();

        Log.v(TAG, "OCRED TEXT: " + recognizedText);

        if ( strlang.equalsIgnoreCase("eng") ) {
            recognizedText = recognizedText.replaceAll("[^a-zA-Z0-9]+", " ");
        }
        else if ( strlang.equalsIgnoreCase("kor") ) {
            recognizedText = recognizedText.replaceAll("[^가-힣0-9]+", " ");
        }

        recognizedText = recognizedText.trim();

        board.clean();
        Toast.makeText(getApplicationContext(), recognizedText, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onClick(View v) {

        Intent intent = null;

        switch (v.getId()) {
            case R.id.colorBtn :

                ColorPaletteDialog.listener = new OnColorSelectedListener() {
                    @Override
                    public void onColorSelected(int pen) {
                        mColor = pen;
                        board.updatePaintProperty(mColor, mSize);
                    }
                };

                intent = new Intent(getApplicationContext(), ColorPaletteDialog.class);
                startActivity(intent);

                break;
            case R.id.penBtn :

                PenPaletteDialog.listener = new OnPenSelectedListener() {
                    @Override
                    public void onPenSelected(int pen) {
                        mSize = pen;
                        board.updatePaintProperty(mColor, mSize);
                    }
                };

                intent = new Intent(getApplicationContext(), PenPaletteDialog.class);
                startActivity(intent);

                break;
            case R.id.eraserBtn :

                eraserSelected = !eraserSelected;

                if (eraserSelected) {
                    enable(false);

                    oldColor = mColor;
                    oldSize = mSize;

                    mColor = Color.WHITE;
                    mSize = 15;

                    board.updatePaintProperty(mColor, mSize);

                } else {
                    enable(true);

                    mColor = oldColor;
                    mSize = oldSize;

                    board.updatePaintProperty(mColor, mSize);
                }

                break;

            case R.id.undoBtn :
                board.undo();
                break;

            case R.id.readBtn :

                board.setDrawingCacheEnabled(true);
                board.buildDrawingCache();
                Bitmap captureView = board.getDrawingCache();
                FileOutputStream fos;
                try {
                    fos = new FileOutputStream(DATA_PATH + "/ocr.jpg");
                    captureView.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                    board.setDrawingCacheEnabled(false);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                readText("kor");
                break;
            case R.id.deleteBtn :
                board.clean();
                break;


        }
    }
}
