package com.word.search;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.googlecode.tesseract.android.TessBaseAPI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Administrator on 2016-11-15.
 */

public class RealTab3 extends Activity{

    private static final String TAG = "....";
    private static String DATA_PATH = "";
    final int PICK_FROM_CAMERA = 0;
    final int PICK_FROM_ALBUM = 1;
    final int CROP_FROM_CAMERA = 2;
    private Uri mImageCaptureUri;
    private ImageView iv;
    private String lang = "eng";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab3);


        Button btnLoad = (Button) findViewById(R.id.btn_load);
        Button btnGallery = (Button) findViewById(R.id.btn_gallery);
        Button btnCamera = (Button) findViewById(R.id.btn_camera);

        iv = (ImageView) findViewById(R.id.imageView2);

        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
                startActivityForResult(intent, PICK_FROM_ALBUM);
            }
        });
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                String url = "tmp_" + String.valueOf(System.currentTimeMillis() + ".jpg");
                mImageCaptureUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), url));

                intent.putExtra(MediaStore.EXTRA_OUTPUT, mImageCaptureUri);
                startActivityForResult(intent, PICK_FROM_CAMERA);
            }
        });

        File dirs = new File(DATA_PATH);

        if (!dirs.exists()) { // 원하는 경로에 폴더가 있는지 확인
            dirs.mkdirs(); // Test 폴더 생성
            Log.d("CAMERA_TEST", "Directory Created");
        }

        String[] paths = new String[] { DATA_PATH, DATA_PATH + "tessdata/" };

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


        if (!(new File(DATA_PATH + "tessdata/" + lang + ".traineddata")).exists()) {
            try {

                AssetManager assetManager = getAssets();
                InputStream in = assetManager.open("tessdata/" + lang + ".traineddata");
                OutputStream out = new FileOutputStream(DATA_PATH
                        + "tessdata/" + lang + ".traineddata");

                // Transfer bytes from in to out
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                in.close();
                out.close();

                Log.v(TAG, "Copied " + lang + " traineddata");
            } catch (IOException e) {
                Log.v(TAG, "Was unable to copy " + lang + " traineddata " + e.toString());
            }
        }

        DATA_PATH = Environment.getExternalStorageDirectory().toString() + "/SimpleAndroidOCR/";

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv.setDrawingCacheEnabled(true);
                iv.buildDrawingCache();
                Bitmap captureView = iv.getDrawingCache();
                FileOutputStream fos;
                try {
                    fos = new FileOutputStream(DATA_PATH + "/ocr.jpg");
                    captureView.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                    iv.setDrawingCacheEnabled(false);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 4;

                String _path = DATA_PATH + "/ocr.jpg";;
                Bitmap bitmap = BitmapFactory.decodeFile(_path, options);

                try {
                    ExifInterface exif = new ExifInterface(_path);
                    int exifOrientation = exif.getAttributeInt(
                            ExifInterface.TAG_ORIENTATION,
                            ExifInterface.ORIENTATION_NORMAL);

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

                    if (rotate != 0) {

                        // Getting width & height of the given image.
                        int w = bitmap.getWidth();
                        int h = bitmap.getHeight();

                        // Setting pre rotate
                        Matrix mtx = new Matrix();
                        mtx.preRotate(rotate);

                        // Rotating Bitmap
                        bitmap = Bitmap.createBitmap(bitmap, 0, 0, w, h, mtx, false);
                    }

                    // Convert to ARGB_8888, required by tess
//                    bitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true);


                } catch (IOException e) {
                    Log.e("....", "Couldn't correct orientation: " + e.toString());
                }

                // _image.setImageBitmap( bitmap );

                Log.v("....", "Before baseApi");

                TessBaseAPI baseApi = new TessBaseAPI();
                baseApi.setDebug(true);
                baseApi.init(DATA_PATH, lang);
                baseApi.setImage(bitmap);

                String recognizedText = baseApi.getUTF8Text();

                Log.v("....", "OCRED TEXT_Before: " + recognizedText);
                baseApi.end();
            }
        });


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode != RESULT_OK) {
            return;
        }


        switch (requestCode) {
            case CROP_FROM_CAMERA:
                final Bundle extras = data.getExtras();

                if (extras != null) {
                    Bitmap photo = extras.getParcelable("data");
                    iv.setImageBitmap(photo);
                }

                File f = new File(mImageCaptureUri.getPath());
                if (f.exists()) {
                    f.delete();
                }

                break;


            case PICK_FROM_ALBUM:
                mImageCaptureUri = data.getData();


            case PICK_FROM_CAMERA:
                Intent intent = new Intent("com.android.camera.action.CROP");
                intent.setDataAndType(mImageCaptureUri, "image/*");

                intent.putExtra("outputX", 300);
                intent.putExtra("outputY", 500);
                intent.putExtra("aspectX", 3);
                intent.putExtra("aspectY", 5);

                intent.putExtra("scale", true);
                intent.putExtra("return-data", true);
                startActivityForResult(intent, CROP_FROM_CAMERA);

                break;

        }


    }

    private void doTakePhotoAction() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        // 임시로 사용할 파일의 경로를 생성
        String url = "tmp_" + String.valueOf(System.currentTimeMillis()) + ".jpg";
        mImageCaptureUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), url));

        intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, mImageCaptureUri);
        startActivityForResult(intent, PICK_FROM_CAMERA);
    }

    private void doTakeAlbumAction() {
        // 앨범 호출
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(android.provider.MediaStore.Images.Media.CONTENT_TYPE);
        startActivityForResult(intent, PICK_FROM_ALBUM);
    }


}
