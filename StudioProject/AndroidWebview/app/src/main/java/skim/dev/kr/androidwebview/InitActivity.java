package skim.dev.kr.androidwebview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static android.content.ContentValues.TAG;

public class InitActivity extends Activity implements View.OnClickListener {

    private static final int RECORDER_SAMPLERATE = 8000;
    private static final int RECORDER_CHANNELS = AudioFormat.CHANNEL_IN_MONO;
    private static final int RECORDER_AUDIO_ENCODING = AudioFormat.ENCODING_PCM_16BIT;

    private AudioRecord recorder;
    private Thread recordingThread;
    private boolean isRecording;

    int BufferElements2Rec = 1024; // want to play 2048 (2K) since 2 bytes we use only 1024
    int BytesPerElement = 2; // 2 bytes in 16bit format
    String filePath = "/sdcard/voice8K16bitmono.pcm";
    String fileWAVPath = "/sdcard/record.wav";
    String filePicturePath = "/sdcard/test.png";

    private WebView webview;
    private CJCameraPreview preview;

//    @Override
//    protected void onXWalkReady() {
//
//        webview = (WebView) findViewById(R.id.xwalk);
//        webview.getSettings().setJavaScriptEnabled(true);
//        webview.getSettings().setBuiltInZoomControls(false);
//        webview.getSettings().setAllowFileAccessFromFileURLs(true);
//        webview.getSettings().setAllowUniversalAccessFromFileURLs(true);
//        webview.getSettings().setSupportZoom(false);
//        webview.setBackgroundColor(Color.TRANSPARENT);
//        webview.loadUrl("http://www.google.com");
//
//        TextView tv = (TextView)findViewById(R.id.tv);
//        tv.bringToFront();
//        tv.buildLayer();

//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init);

        findViewById(R.id.btnStart).setOnClickListener(this);
        findViewById(R.id.btnStop).setOnClickListener(this);
        findViewById(R.id.btnPCM).setOnClickListener(this);
        findViewById(R.id.btnWAV).setOnClickListener(this);
        findViewById(R.id.btnCapture).setOnClickListener(this);
        findViewById(R.id.btnCamera).setOnClickListener(this);

        webview = (WebView) findViewById(R.id.xwalk);
        webview.setWebViewClient(new WebViewClient());
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setBuiltInZoomControls(false);
        webview.getSettings().setAllowFileAccessFromFileURLs(true);
        webview.getSettings().setAllowUniversalAccessFromFileURLs(true);
        webview.getSettings().setSupportZoom(false);
        webview.setBackgroundColor(Color.TRANSPARENT);
        webview.loadUrl("http://www.google.com");

    }

    private void startRecord() {

        recorder = new AudioRecord(MediaRecorder.AudioSource.MIC, RECORDER_SAMPLERATE, RECORDER_CHANNELS, RECORDER_AUDIO_ENCODING, BufferElements2Rec * BytesPerElement);
        recorder.startRecording();

        isRecording = true;
        recordingThread = new Thread(new Runnable() {

            public void run() {

                // Write the output audio in byte
                short sData[] = new short[BufferElements2Rec];

                FileOutputStream os = null;

                try {
                    os = new FileOutputStream(filePath);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                while (isRecording) {
                    // gets the voice output from microphone to byte format
                    recorder.read(sData, 0, BufferElements2Rec);
                    System.out.println("Short wirting to file" + sData.toString());

                    try {
                        // // writes the data to file from buffer
                        // // stores the voice buffer
                        byte bData[] = short2byte(sData);
                        os.write(bData, 0, BufferElements2Rec * BytesPerElement);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }, "AudioRecorder Thread");

        recordingThread.start();


    }

    //convert short to byte

    private byte[] short2byte(short[] sData) {
        int shortArrsize = sData.length;
        byte[] bytes = new byte[shortArrsize * 2];
        for (int i = 0; i < shortArrsize; i++) {
            bytes[i * 2] = (byte) (sData[i] & 0x00FF);
            bytes[(i * 2) + 1] = (byte) (sData[i] >> 8);
            sData[i] = 0;
        }

        return bytes;
    }

    private void rawToWave(final File rawFile, final File waveFile) throws IOException {

        byte[] rawData = new byte[(int) rawFile.length()];
        DataInputStream input = null;
        try {
            input = new DataInputStream(new FileInputStream(rawFile));
            input.read(rawData);
        } finally {
            if (input != null) {
                input.close();
            }
        }

        DataOutputStream output = null;
        try {
            int myBitsPerSample = 2;
            int myFormat = 1;
            long myChannels = 1;
            long mySampleRate = 8000;
            long myByteRate = mySampleRate * myChannels * myBitsPerSample / 8;
            int myBlockAlign = (int) (myChannels * myBitsPerSample / 8);

            output = new DataOutputStream(new FileOutputStream(waveFile));
            // WAVE header
            // see http://ccrma.stanford.edu/courses/422/projects/WaveFormat/
            writeString(output, "RIFF"); // chunk id
            writeInt(output, 36 + rawData.length); // chunk size
            writeString(output, "WAVE"); // format
            writeString(output, "fmt "); // subchunk 1 id
            writeInt(output, 16); // subchunk 1 size
            writeShort(output, (short) 1); // audio format (1 = PCM)
            writeShort(output, (short) 1); // number of channels
            writeInt(output, (int) mySampleRate); // sample ratemySampleRate
            writeInt(output, (int) (myByteRate)); // byte rate
            writeShort(output, (short) myBlockAlign); // block align
            writeShort(output, (short) 16); // bits per sample
            writeString(output, "data"); // subchunk 2 id
            writeInt(output, rawData.length); // subchunk 2 size
            // Audio data (conversion big endian -> little endian)
            short[] shorts = new short[rawData.length / 2];
            ByteBuffer.wrap(rawData).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get(shorts);
            ByteBuffer bytes = ByteBuffer.allocate(shorts.length * 2);


            for (short s : shorts) {
                bytes.putShort(s);
            }


            output.write(bytes.array());
        } finally {
            if (output != null) {
                output.close();
            }
        }
    }

    public void writeShortLE(DataOutputStream out, short value) throws IOException {
        out.writeByte(value & 0xFF);
        out.writeByte((value >> 8) & 0xFF);
    }


    private void writeInt(final DataOutputStream output, final int value) throws IOException {
        output.write(value >> 0);
        output.write(value >> 8);
        output.write(value >> 16);
        output.write(value >> 24);
    }

    private void writeShort(final DataOutputStream output, final short value) throws IOException {
        output.write(value >> 0);
        output.write(value >> 8);
    }

    private void writeString(final DataOutputStream output, final String value) throws IOException {
        for (int i = 0; i < value.length(); i++) {
            output.write(value.charAt(i));
        }
    }


    private void stopRecord() {
        // stops the recording activity

        if (null != recorder) {
            isRecording = false;
            recorder.stop();
            recorder.release();
            recorder = null;
            recordingThread = null;

            File f1 = new File(filePath); // The location of your PCM file
            File f2 = new File(fileWAVPath); // The location where you want your WAV file
            try {
                rawToWave(f1, f2);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void PlayShortAudioFileViaAudioTrack(String filePath) throws IOException {
        // We keep temporarily filePath globally as we have only two sample sounds now..
        if (filePath == null)
            return;

        //Reading the file..
        File file = new File(filePath); // for ex. path= "/sdcard/samplesound.pcm" or "/sdcard/samplesound.wav"
        byte[] byteData = new byte[(int) file.length()];
        Log.d(TAG, (int) file.length() + "");

        FileInputStream in = null;
        try {
            in = new FileInputStream(file);
            in.read(byteData);
            in.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // Set and push to audio track..
        int intSize = AudioTrack.getMinBufferSize(RECORDER_SAMPLERATE, AudioFormat.CHANNEL_OUT_MONO, RECORDER_AUDIO_ENCODING);
        Log.d(TAG, intSize + "");

        AudioTrack at = new AudioTrack(AudioManager.STREAM_MUSIC, RECORDER_SAMPLERATE, AudioFormat.CHANNEL_OUT_MONO, RECORDER_AUDIO_ENCODING, intSize, AudioTrack.MODE_STREAM);
        if (at != null) {
            at.play();
            // Write the byte array to the track
            at.write(byteData, 0, byteData.length);
            at.stop();
            at.release();
        } else
            Log.d(TAG, "audio track is not initialised ");

    }

    private void playWAV() {
        MediaPlayer background = new MediaPlayer();

        try {
            background.setDataSource(fileWAVPath);
            background.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }

        background.setLooping(false);
        background.setVolume(1, 1);
        background.start();
    }

    private void capture() {

        if (preview != null) {
            ImageView iv = (ImageView) findViewById(R.id.iv);
            iv.setVisibility(View.VISIBLE);
            iv.setImageDrawable(new BitmapDrawable(getResources(), preview.viewToBitmap()));
//            preview.drawBitmap();
        }

//        webview.captureBitmapAsync(new XWalkGetBitmapCallback() {
//            @Override
//            public void onFinishGetBitmap(Bitmap bitmap, int i) {
//
//                DisplayMetrics metrics = new DisplayMetrics();
//                ((WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(metrics);
//                float dpi = metrics.density;
//                bitmap = Bitmap.createScaledBitmap(bitmap, (int) (webview.getMeasuredWidth() / dpi), (int) (webview.getMeasuredHeight() / dpi), true);
//
//                String strPath = filePicturePath;
//                File file = new File(strPath);
//                try {
//                    FileOutputStream stream = new FileOutputStream(file);
//                    if (strPath.substring(strPath.lastIndexOf(".") + 1).toLowerCase().equals("png"))
//                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
//                    else bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
//                    stream.flush();
//                    stream.close();
//
//                    MediaScannerConnection.scanFile(getApplicationContext(),
//                            new String[]{strPath}, null,
//                            new MediaScannerConnection.OnScanCompletedListener() {
//                                @Override
//                                public void onScanCompleted(String s, Uri uri) {
//
//                                }
//                            });
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        });

        View root = getWindow().getDecorView().getRootView();
        root.setDrawingCacheEnabled(true);
        root.buildDrawingCache();
// 루트뷰의 캐시를 가져옴
        Bitmap screenshot = root.getDrawingCache();

// get view coordinates
        int[] location = new int[2];
        root.getLocationInWindow(location);

// 이미지를 자를 수 있으나 전체 화면을 캡쳐 하도록 함
        Bitmap bmp = Bitmap.createBitmap(screenshot, location[0], location[1], root.getWidth(), root.getHeight(), null, false);
        bmp = Bitmap.createBitmap(preview.viewToBitmap());
        File fileCacheItem = new File(filePicturePath);
        OutputStream out = null;
        try {
            fileCacheItem.createNewFile();
            out = new FileOutputStream(fileCacheItem);
            bmp.compress(Bitmap.CompressFormat.PNG, 100, out);
            out.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void startCameraPreview() {
        final RelativeLayout layoutCamera = new RelativeLayout(getApplicationContext());
        layoutCamera.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));
        DisplayMetrics metrics = new DisplayMetrics();
        ((WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(metrics);
        float dpi = metrics.density;
        preview = new CJCameraPreview(this, "front", 0, 0, 500, 500, dpi);

        final ImageView iv = new ImageView(this);
        iv.setBackgroundResource(R.mipmap.ic_launcher);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                webview.addView( layoutCamera );
                layoutCamera.addView( preview );
//                webview.addView(iv, new FrameLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStart:
                startRecord();
                break;
            case R.id.btnStop:
                stopRecord();
                break;
            case R.id.btnPCM:
                try {
                    PlayShortAudioFileViaAudioTrack(filePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btnWAV:
                playWAV();
                break;
            case R.id.btnCapture:
                capture();
                break;
            case R.id.btnCamera:
                startCameraPreview();
                break;
        }
    }
}
