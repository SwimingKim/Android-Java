package dev.su.com.zipproject;

import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class MainActivity extends AppCompatActivity {

    private String[] strPermissions = new String[] {android.Manifest.permission.READ_EXTERNAL_STORAGE, android.Manifest.permission.WRITE_EXTERNAL_STORAGE};
    private String tag = "ziptag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            for (int i=0; i < strPermissions.length; i++) {
                int permissionResult = checkSelfPermission(strPermissions[i]);
                if (permissionResult == PackageManager.PERMISSION_GRANTED) continue;

                ActivityCompat.requestPermissions(this, strPermissions, 0);
                break;
            }
        }

        try {
            decompress(Environment.getExternalStorageDirectory().getAbsolutePath()+"/test/mytest.zip", Environment.getExternalStorageDirectory().getAbsolutePath()+"/test/arr");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }


    } // end of onCreate

    /**
     * 압축 풀기
     * @param strFileName       파일 이름
     * @param strDirectory      압축 해제 경로
     * @throws Throwable
     */
    public void decompress(String strFileName, String strDirectory) throws Throwable {

        File zipFile = new File(strFileName);
        FileInputStream fis = null;
        ZipInputStream zis = null;
        ZipEntry zipEntry = null;

        try {
            fis = new FileInputStream(zipFile);
            zis = new ZipInputStream(fis);

            while ( (zipEntry = zis.getNextEntry()) != null ) {

                String strName = zipEntry.getName();
                File file = new File(strDirectory, strName);

                if (zipEntry.isDirectory()) {
                    file.mkdirs();
                } else {
                    createFile(file, zis);
                }
            }
        } catch (Throwable e) {
            throw e;

        } finally {
            if (zis != null)
                zis.close();
            if (fis != null)
                fis.close();

            Log.d(tag, "완료");

        }
    }

    /**
     * 파일 만들기 메소드
     * @param file          파일
     * @param zis           Zip 스트림
     * @throws Throwable
     */
    public void createFile(File file, ZipInputStream zis) throws Throwable {

        // 디렉토리 확인
        File parentDir = new File(file.getParent());
        if (!parentDir.exists()) {
            parentDir.mkdirs();
        }

        // 파일 스트림 선언
        try (FileOutputStream fos = new FileOutputStream(file)) {

            byte[] buffer = new byte[256];
            int size = 0;

            while ((size = zis.read(buffer)) > 0) {
                fos.write(buffer, 0, size);
            }
        } catch (Throwable e) {
            throw e;
        }
    }


} // end of class
