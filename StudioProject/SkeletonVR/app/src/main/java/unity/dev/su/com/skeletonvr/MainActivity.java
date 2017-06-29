package unity.dev.su.com.skeletonvr;

import android.opengl.GLES20;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.vrtoolkit.cardboard.CardboardActivity;
import com.google.vrtoolkit.cardboard.CardboardView;
import com.google.vrtoolkit.cardboard.CardboardViewApi;
import com.google.vrtoolkit.cardboard.Eye;
import com.google.vrtoolkit.cardboard.HeadTransform;
import com.google.vrtoolkit.cardboard.Viewport;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL;

public class MainActivity extends CardboardActivity implements CardboardView.StereoRenderer {

    private static final String TAG = "MainActivity";
    private static final int COORDS_PER_VERTEX = 3;
    private static float triCoords[] = {
            0.0f, 0.6f, -1.0f, // 상단
            -0.5f, -0.3f, -1.0f, // 하단 왼쪽
            0.5f, -0.3f, -1.0f // 하단 오른쪽
    };
    private final int triVertexCount = triCoords.length / COORDS_PER_VERTEX;

    // 노르스름한 색
    private float triColor[] = {0.8f, 0.6f, 0.2f, 0.0f};
    private FloatBuffer triVerticesBuffer;

    private int simpleVertexShader;
    private int simpleFragmentShader;

    private int triProgram;
    private int triPositionParam;
    private int triColorParam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardboardView cardboardView = (CardboardView)findViewById(R.id.cardboard_view);
        cardboardView.setRenderer(this);
        setCardboardView(cardboardView);
    }

    @Override
    public void onNewFrame(HeadTransform headTransform) {

    }

    @Override
    public void onDrawEye(Eye eye) {
        drawTriangle();
    }

    private void drawTriangle() {
        GLES20.glUseProgram(triProgram);
        GLES20.glVertexAttribPointer(triPositionParam, COORDS_PER_VERTEX, GLES20.GL_FLOAT, false, 0, triVerticesBuffer);

        GLES20.glUniform4fv(triColorParam, 1, triColor, 0);
        GLES20.glDrawArrays(GLES20.GL_TRIANGLES, 0, triVertexCount);
    }

    @Override
    public void onFinishFrame(Viewport viewport) {

    }

    @Override
    public void onSurfaceChanged(int i, int i1) {

    }

    @Override
    public void onSurfaceCreated(EGLConfig eglConfig) {
        initializeScene();
        comfileShaders();
        prepareRenderingTriangle();
    }



    @Override
    public void onRendererShutdown() {

    }

    private void initializeScene() {
    }
    private void comfileShaders() {
        simpleVertexShader = loadShader(GLES20.GL_VERTEX_SHADER, R.raw.simple_vertex);
        simpleFragmentShader = loadShader(GLES20.GL_FRAGMENT_SHADER, R.raw.simple_fragment);
    }
    private void prepareRenderingTriangle() {
        // 버퍼 할당
        ByteBuffer bb = ByteBuffer.allocateDirect(triCoords.length*4);
        bb.order(ByteOrder.nativeOrder());

        triVerticesBuffer = bb.asFloatBuffer();
        triVerticesBuffer.put(triCoords);
        triVerticesBuffer.position(0);

        // GL 프로그램 생성
        triProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(triProgram, simpleVertexShader);
        GLES20.glAttachShader(triProgram, simpleFragmentShader);
        GLES20.glLinkProgram(triProgram);
        GLES20.glUseProgram(triProgram);

        // 셰이더 파라미터 얻기
        triPositionParam = GLES20.glGetAttribLocation(triProgram, "a_Position");
        GLES20.glEnableVertexAttribArray(triPositionParam);
        triColorParam = GLES20.glGetUniformLocation(triProgram, "u_Color");
    }


    private int loadShader(int type, int resId) {
        String code = readRawTextFile(resId);
        int shader = GLES20.glCreateShader(type);

        GLES20.glShaderSource(shader, code);
        GLES20.glCompileShader(shader);

        return shader;
    }

    private String readRawTextFile(int resId) {
        InputStream inputStream = getResources().openRawResource(resId);
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line=reader.readLine())!=null) {
                sb.append(line).append("\n");
            }
            reader.close();

            return  sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


}
